package io.rtdi.appcontainer.plugins.activation;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.univocity.parsers.common.ArgumentUtils;
import com.univocity.parsers.common.DataProcessingException;
import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.RowProcessorErrorHandler;
import com.univocity.parsers.common.processor.ObjectRowProcessor;
import com.univocity.parsers.conversions.Conversions;
import com.univocity.parsers.conversions.FormattedConversion;
import com.univocity.parsers.conversions.ObjectConversion;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.rtdi.appcontainer.dbactivationbase.DatabaseObjectIdentifier;
import io.rtdi.appcontainer.plugins.database.IActivationService;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

public abstract class CSVImport implements IActivationService {

	@Override
	public ActivationResult activate(File file, Connection conn, GlobalSchemaMapping gm, SQLVariables variables,
			IDatabaseProvider provider) throws IOException, SQLException {
		ActivationResult result = new ActivationResult(file.toPath(), "CSV file parser");
		String name = file.getName();
		int pos = name.lastIndexOf('.');
		name = name.substring(0, pos);
		CsvParserSettings settings = new CsvParserSettings();
		settings.getFormat().setQuoteEscape('\\');
		settings.getFormat().setCharToEscapeQuoteEscaping('\\');
		settings.getFormat().setDelimiter(',');
		settings.getFormat().setQuote('"');
		// settings.getFormat().setLineSeparator("\n");
		settings.setLineSeparatorDetectionEnabled(true);
		settings.setHeaderExtractionEnabled(true);
		// settings.detectFormatAutomatically();
		SQLRowProcessorErrorHandler errorhandler = new SQLRowProcessorErrorHandler(result, file.toPath());
		settings.setProcessorErrorHandler(errorhandler);
		DatabaseObjectIdentifier identifier = new DatabaseObjectIdentifier(name, gm);
		DBImportRowProcessor rowprocessor = new DBImportRowProcessor(conn, identifier.getSchemaName(), identifier.getObjectName(name));
		settings.setProcessor(rowprocessor);
		CsvParser parser = new CsvParser(settings);
		parser.parse(file);
		if (errorhandler.getWarningCount() != 0) {
			conn.rollback();
		} else {
			conn.commit();
			result.setActivationSuccess(ActivationSuccess.SUCCESS);
	    	result.addResult("CSV data loaded", null, ActivationSuccess.SUCCESS);
		}
		return result;
	}
	
	public static class SQLRowProcessorErrorHandler implements RowProcessorErrorHandler {
		private int warningcount = 0;
		private ActivationResult result;
		
		public SQLRowProcessorErrorHandler(ActivationResult result, Path path) {
			this.result = result;
		}
		
		@Override
	    public void handleError(DataProcessingException error, Object[] inputRow, ParsingContext context) {
	    	result.addResult(error.getMessage(), null, ActivationSuccess.FAILED);
	    	warningcount++;
	    	if (warningcount > 20) {
	    		context.stop();
	    	}
	    }
		
		public int getWarningCount() {
			return warningcount;
		}
	}
	
	/**
	 * Because the upsert/merge/replace syntax is a bit different for various databases, this is an extension point.
	 * A class might leave it untouched, might return a different SQL syntax or null, if it is not supported at all.
	 * In the latter case the upsert is simulated by first deleting all records with this primary key and second insert all rows.
	 * 
	 * @param owner
	 * @param tablename
	 * @param columnlist
	 * @param paramlist
	 * @param databaseMetaData 
	 * @return a valid SQL or null
	 */
	public abstract StringBuilder getUpsertStatement(String owner, String tablename, StringBuilder columnlist, StringBuilder paramlist, DatabaseMetaData databaseMetaData);
	
	public boolean supportsBigInt() {
		return true;
	}
	
	public void setColumnValue(PreparedStatement stmt, int pos, Object value) throws SQLException {
		stmt.setObject(pos, value);
	}
	
	public class DBImportRowProcessor extends ObjectRowProcessor {
		private PreparedStatement insert;
		private PreparedStatement upsert;
		private PreparedStatement update;
		private PreparedStatement delete;
		private int indexChangeType = -1;
		private List<Integer> keyindexes; 
		private List<Integer> columnindexes;
		private Connection conn;
		private String owner;
		private String tablename;
		private int batchrowcount = 0;
		
	    public DBImportRowProcessor(Connection conn, String owner, String tablename) {
			this.conn = conn;
			this.owner = owner;
			this.tablename = tablename;
		}
	    
	    private void executeBatch() throws SQLException {
	    	/*
	    	 * delete and upserts are optional
	    	 */
	    	if (delete != null) {
	    		delete.executeBatch();
	    	}
	    	insert.executeBatch();
	    	if (upsert != null) {
	    		upsert.executeBatch();
	    	}
	    	if (update != null) {
	    		update.executeBatch();
	    	}
	    	batchrowcount = 0;
	    }

		@Override
	    public void rowProcessed(Object[] row, ParsingContext context) {
			try {
				batchrowcount++;
				if (batchrowcount > 1000) {
					executeBatch();
				}
				if (indexChangeType == -1 || row[indexChangeType].equals("I")) {
					for (int i=0; i<columnindexes.size(); i++) {
						setColumnValue(insert, i+1, row[columnindexes.get(i)]);
					}
					insert.addBatch();
				} else {
					switch (row[indexChangeType].toString()) {
					case "U": {
						/*
						 * update row
						 */
						int i;
						for (i=0; i<columnindexes.size(); i++) {
							setColumnValue(update, i+1, row[columnindexes.get(i)]);
						}
						for (int j=i; j<keyindexes.size()+i; j++) {
							int index = keyindexes.get(j);
							setColumnValue(delete, j+1, row[index]);
						}
						update.addBatch();
						break;
					}
					case "A":
						if (upsert != null) {
							/*
							 * upsert row
							 */
							for (int i=0; i<columnindexes.size(); i++) {
								setColumnValue(upsert, i+1, row[columnindexes.get(i)]);
							}
							upsert.addBatch();
						} else {
							// simulate upsert with delete-insert
							for (int i=0; i<columnindexes.size(); i++) {
								setColumnValue(insert, i+1, row[columnindexes.get(i)]);
							}
							insert.addBatch();
							for (int i=0; i<keyindexes.size(); i++) {
								int index = keyindexes.get(i);
								setColumnValue(delete, i+1, row[index]);
							}
							delete.addBatch();
						}
						break;
					case "D":
					case "X":
						/*
						 * Delete and eXterminate both delete the record based on the PK.
						 */
						for (int i=0; i<keyindexes.size(); i++) {
							int index = keyindexes.get(i);
							setColumnValue(delete, i+1, row[index]);
						}
						delete.addBatch();
						break;
					case "T":
						/*
						 * A truncate means all records are to be deleted matching the not-null columns.
						 * For example from the table ID, FIRSTNAME, REGION all REGION='US' records are deleted 
						 * if the input line in the file has _CHANGE_TYPE = 'T' and REGION='US' and all other columns are null.
						 */
						StringBuilder deletesegment = new StringBuilder();
						deletesegment.append("delete from ")
							.append("\"")
							.append(owner)
							.append("\".\"")
							.append(tablename)
							.append("\" where ");

						boolean first = true;
						List<Integer> deleteindex = new ArrayList<>();
						for (int i=0; i<context.parsedHeaders().length; i++) {
							String columnname = context.parsedHeaders()[i];
							if (!columnname.equals("_CHANGE_TYPE") && row.length > i && row[i] != null) {
								if (first) {
									first = false;
								} else {
									deletesegment.append("AND ");
								}
								deleteindex.add(i);
								deletesegment
									.append("\"")
									.append(columnname)
									.append("\" = ? ");
							}
						}
						PreparedStatement del = conn.prepareStatement(deletesegment.toString());
						for (int i=0; i<deleteindex.size(); i++) {
							setColumnValue(del, i+1, row[deleteindex.get(i)]);
						}
						del.execute(); // must be executed immediately
						break;
					}
				}
			} catch (SQLException e) {
				DataProcessingException ex = new DataProcessingException("Loading a row failed with SQLException: \"" + e.getMessage() + "\"", e);
				ex.markAsNonFatal();
				throw ex;
			}
	    }

		@Override
		public void processStarted(ParsingContext context) {
			indexChangeType = -1;
			String sql = "truncate table \"" + owner + "\".\"" + tablename + "\"";
			try {
				setStatements(Arrays.asList(context.parsedHeaders()), owner, tablename);
				/*
				 * In case above #setStatements() finds there is no _CHANGE_DATE column in the file, the
				 * only option is to truncate an load the table.
				 */
				if (indexChangeType == -1) {
					try {
						PreparedStatement stmt = conn.prepareStatement(sql);
						stmt.execute();
					} catch (SQLException e) {
						throw AppContainerSQLException.cloneFrom("Failed to truncate the table", e, sql, null);
					}
				}
			} catch (SQLException e) {
				DataProcessingException ex = new DataProcessingException("Generating the SQL DML statements failed with SQLException: \"" + e.getMessage() + "\"", e);
				throw ex;
			}
		}

		@Override
		public void processEnded(ParsingContext context) {
			try {
				executeBatch(); // send the last few rows as well
			} catch (SQLException e) {
				DataProcessingException ex = new DataProcessingException("SQLException when sending the last batch of records \"" + e.getMessage() + "\"", e);
				throw ex;
			}
		}
		
	
		private void setStatements(List<String> headers, String owner, String tablename) throws SQLException {
			StringBuilder sqlinsert = new StringBuilder();
			StringBuilder sqlupsert = null;
			StringBuilder sqlupdate = new StringBuilder();
			StringBuilder sqlupdateprojection = new StringBuilder();
			StringBuilder sqldelete = new StringBuilder();
			StringBuilder sqlwhere = new StringBuilder();
			StringBuilder columnlist = new StringBuilder();
			StringBuilder paramlist = new StringBuilder();
			Map<String, JDBCType> datatypes = new HashMap<>();
			try (ResultSet rs = conn.getMetaData().getColumns(null, owner, tablename, null);) {
				while (rs.next()) {
					datatypes.put(rs.getString(4), JDBCType.valueOf(rs.getInt(5)));
				}
			}
			if (datatypes.size() == 0) {
				throw new AppContainerSQLException("The CSV file is for table \"" + owner + "\".\"" + tablename + "\" but no such table exists in the database", null, null);
			}
			/*
			 * Create a list with all PK column names
			 */
			Set<String> pks = new HashSet<>();
			try (ResultSet rs = conn.getMetaData().getPrimaryKeys(null, owner, tablename);) {
				while (rs.next()) {
					pks.add(rs.getString(4)); // add the primary key column name
				}
			}

			try {
				columnindexes = new ArrayList<>();
				keyindexes = new ArrayList<>();
				for (int i=0; i<headers.size(); i++) {
					String columnname = headers.get(i).trim(); // trim leading and trailing spaces
					if (columnlist.length() != 0) {
						columnlist.append(", ");
						paramlist.append(", ");
						sqlupdateprojection.append(", ");
					}
					if (!columnname.equals("_CHANGE_TYPE")) {
						columnlist.append("\"").append(columnname).append("\"");
						paramlist.append("?");
						sqlupdateprojection.append("\"").append(columnname).append("\" = ?");
						if (pks.contains(columnname)) {
							if (sqlwhere.length() != 0) {
								sqlwhere.append("AND ");
							}
							sqlwhere.append("\"").append(columnname).append("\" = ? ");
							keyindexes.add(i);
						}
						JDBCType datatype = datatypes.get(columnname);
						if (datatype == null) {
							throw new AppContainerSQLException("The CSV file has a header \"" + columnname + "\" but no table column matches that name.", null, null);
						}
						setConverter(datatype, i);
						columnindexes.add(i);
					} else {
						indexChangeType = i;
					}
				}
				sqlinsert.append("insert into ")
					.append("\"")
					.append(owner)
					.append("\".\"")
					.append(tablename)
					.append("\" (")
					.append(columnlist)
					.append(") values (")
					.append(paramlist)
					.append(")");
				sqldelete.append("delete from ")
					.append("\"")
					.append(owner)
					.append("\".\"")
					.append(tablename)
					.append("\" where ")
					.append(sqlwhere);
				sqlupdate.append("update ")
					.append("\"")
					.append(owner)
					.append("\".\"")
					.append(tablename)
					.append("\" set ")
					.append(sqlupdateprojection)
					.append(" where ")
					.append(sqlwhere);
				sqlupsert = getUpsertStatement(owner, tablename, columnlist, paramlist, conn.getMetaData());
				insert = conn.prepareStatement(sqlinsert.toString());
			} catch (SQLException e) {
				throw AppContainerSQLException.cloneFrom("Failed creating the insert statement for this table", e, sqlinsert.toString(), "Are the CSV file headers correct?");
			}

			/*
			 * When there is a change type column also add the upsert/delete statements. Truncates are generated on demand.
			 */
			if (indexChangeType != -1) {
				
				if (keyindexes.size() == 0) {
					throw new AppContainerSQLException("The CSV file has a _CHANGE_TYPE column but the database table does not have a primary key", null, null);
				}
				if (sqlupsert != null) {
					/*
					 * It is okay if a database does not support an upsert statement.
					 */
					try {
						upsert = conn.prepareStatement(sqlupsert.toString());
					} catch (SQLException e) {
						throw new AppContainerSQLException("Failed creating the upsert statement for this table", e, sqlupsert.toString(), null);
					}
				}
				try {
					update = conn.prepareStatement(sqlupdate.toString());
				} catch (SQLException e) {
					throw new AppContainerSQLException("Failed creating the update statement for this table", e, sqlupdate.toString(), null);
				}
				try {
					delete = conn.prepareStatement(sqldelete.toString());
				} catch (SQLException e) {
					throw new AppContainerSQLException("Failed creating the delete statement for this table", e, sqldelete.toString(), null);
				}
			}
		}

		private void setConverter(JDBCType type, int i) {
			switch (type) {
			case ARRAY:
				break;
			case BIGINT:
				if (supportsBigInt()) {
					convertIndexes(Conversions.toBigInteger()).set(i);
				} else {
					// No conversion, let the database convert the text
				}
				break;
			case BINARY:
				convertIndexes(new Base64Conversion()).set(i);
				break;
			case BIT:
				break;
			case BLOB:
				convertIndexes(new Base64Conversion()).set(i);
				break;
			case BOOLEAN:
				break;
			case CHAR:
				break;
			case CLOB:
				break;
			case DATALINK:
				break;
			case DATE:
				convertIndexes(new UnivocityDateFormatter(Locale.ENGLISH, null, null,
						"yyyy.MM.dd",
						"MM/dd/yyyy",
						"yyyy-MM-dd")).set(i);
				break;
			case DECIMAL:
				break;
			case DISTINCT:
				break;
			case DOUBLE:
				convertIndexes(Conversions.toDouble()).set(i);
				break;
			case FLOAT:
				convertIndexes(Conversions.toFloat()).set(i);
				break;
			case INTEGER:
				break;
			case JAVA_OBJECT:
				break;
			case LONGNVARCHAR:
				break;
			case LONGVARBINARY:
				break;
			case LONGVARCHAR:
				break;
			case NCHAR:
				break;
			case NCLOB:
				break;
			case NULL:
				break;
			case NUMERIC:
				break;
			case NVARCHAR:
				break;
			case OTHER:
				break;
			case REAL:
				break;
			case REF:
				break;
			case REF_CURSOR:
				break;
			case ROWID:
				break;
			case SMALLINT:
				break;
			case SQLXML:
				break;
			case STRUCT:
				break;
			case TIME:
				convertIndexes(new UnivocityTimeFormatter(Locale.ENGLISH, null, null,
						"HH:mm[:ss[.SSS]]")).set(i);
				break;
			case TIMESTAMP:
				convertIndexes(new UnivocityInstantFormatter(Locale.ENGLISH, null, null,
						"yyyy.MM.dd[ ]['T']HH:mm[:ss[.SSS]]",
						"MM/dd/yyyy[ ]['T']HH:mm[:ss[.SSS]]",
						"yyyy-MM-dd[ ]['T']HH:mm[:ss[.SSS]]")).set(i);
				break;
			case TIMESTAMP_WITH_TIMEZONE:
				convertIndexes(new UnivocityDateTimeFormatter(Locale.ENGLISH, null, null,
						"yyyy.MM.dd[ ]['T']HH:mm[:ss[.SSS]][XXX]",
						"MM/dd/yyyy[ ]['T']HH:mm[:ss[.SSS]][XXX]",
						"yyyy-MM-dd[ ]['T']HH:mm[:ss[.SSS]][XXX]")).set(i);
				break;
			case TIME_WITH_TIMEZONE:
				break;
			case TINYINT:
				break;
			case VARBINARY:
				convertIndexes(new Base64Conversion()).set(i);
				break;
			case VARCHAR:
				break;
			default:
				break;
			}
		}

	}

	public static class Base64Conversion extends ObjectConversion<ByteBuffer> {

		public Base64Conversion() {
			super();
		}

		public Base64Conversion(ByteBuffer valueIfStringIsNull, String valueIfObjectIsNull) {
			super(valueIfStringIsNull, valueIfObjectIsNull);
		}

		/**
		 * Converts a Base64 encoded String to a ByteBuffer.
		 */
		@Override
		protected ByteBuffer fromString(String input) {
			byte[] result = Base64.getDecoder().decode(input.getBytes(StandardCharsets.UTF_8));
			return ByteBuffer.wrap(result);
		}
	}
	
	public static class UnivocityDateTimeFormatter extends ObjectConversion<ZonedDateTime> implements FormattedConversion<DateTimeFormatter> {

		private final Locale locale;
		private final DateTimeFormatter[] parsers;
		private final String[] formats;


	    public UnivocityDateTimeFormatter(Locale locale, ZonedDateTime valueIfStringIsNull, String valueIfObjectIsNull, String... dateFormats) {
			super(valueIfStringIsNull, valueIfObjectIsNull);
			ArgumentUtils.noNulls("Date formats", dateFormats);
			this.locale = locale == null ? Locale.getDefault() : locale;
			this.formats = dateFormats.clone();
			this.parsers = new DateTimeFormatter[dateFormats.length];
			for (int i = 0; i < dateFormats.length; i++) {
				String dateFormat = dateFormats[i];
				parsers[i] = DateTimeFormatter.ofPattern(dateFormat, this.locale).withZone(ZoneOffset.UTC);
			}
	    }

		@Override
		public String revert(ZonedDateTime input) {
			if (input == null) {
				return super.revert(null);
			}
			return parsers[0].format(input);
		}

		@Override
		protected ZonedDateTime fromString(String input) {
			for (DateTimeFormatter formatter : parsers) {
				try {
					synchronized (formatter) {
						TemporalAccessor dt = formatter.parseBest(input, ZonedDateTime::from, LocalDateTime::from);
						if (dt instanceof ZonedDateTime) {
							return (ZonedDateTime) dt;
						} else if (dt instanceof LocalDateTime) {
							LocalDateTime ld = (LocalDateTime) dt;
							return ZonedDateTime.of(ld, ZoneOffset.UTC);
						}
						return null; // cannot happen
					}
				} catch (DateTimeParseException ex) {
					//ignore and continue
				}
			}
			DataProcessingException exception = new DataProcessingException("Cannot parse '{value}' as a valid date of locale '" + locale + "'. Supported formats are: " + Arrays.toString(formats));
			exception.setValue(input);
			throw exception;
		}

		@Override
		public DateTimeFormatter[] getFormatterObjects() {
			return parsers;
		}
	}

	public static class UnivocityInstantFormatter extends ObjectConversion<Instant> implements FormattedConversion<DateTimeFormatter> {

		private final Locale locale;
		private final DateTimeFormatter[] parsers;
		private final String[] formats;


	    public UnivocityInstantFormatter(Locale locale, Instant valueIfStringIsNull, String valueIfObjectIsNull, String... dateFormats) {
			super(valueIfStringIsNull, valueIfObjectIsNull);
			ArgumentUtils.noNulls("Date formats", dateFormats);
			this.locale = locale == null ? Locale.getDefault() : locale;
			this.formats = dateFormats.clone();
			this.parsers = new DateTimeFormatter[dateFormats.length];
			for (int i = 0; i < dateFormats.length; i++) {
				String dateFormat = dateFormats[i];
				parsers[i] = DateTimeFormatter.ofPattern(dateFormat, this.locale).withZone(ZoneOffset.UTC);
			}
	    }

		@Override
		public String revert(Instant input) {
			if (input == null) {
				return super.revert(null);
			}
			return parsers[0].format(input);
		}

		@Override
		protected Instant fromString(String input) {
			for (DateTimeFormatter formatter : parsers) {
				try {
					synchronized (formatter) {
						TemporalAccessor dt = formatter.parseBest(input, ZonedDateTime::from, LocalDateTime::from);
						if (dt instanceof ZonedDateTime) {
							return ((ZonedDateTime) dt).toInstant();
						} else if (dt instanceof LocalDateTime) {
							LocalDateTime ld = (LocalDateTime) dt;
							return ZonedDateTime.of(ld, ZoneOffset.UTC).toInstant();
						}
						return null; // cannot happen
					}
				} catch (DateTimeParseException ex) {
					//ignore and continue
				}
			}
			DataProcessingException exception = new DataProcessingException("Cannot parse '{value}' as a valid date of locale '" + locale + "'. Supported formats are: " + Arrays.toString(formats));
			exception.setValue(input);
			throw exception;
		}

		@Override
		public DateTimeFormatter[] getFormatterObjects() {
			return parsers;
		}
	}

	public static class UnivocityDateFormatter extends ObjectConversion<LocalDate> implements FormattedConversion<DateTimeFormatter> {

		private final Locale locale;
		private final DateTimeFormatter[] parsers;
		private final String[] formats;


	    public UnivocityDateFormatter(Locale locale, LocalDate valueIfStringIsNull, String valueIfObjectIsNull, String... dateFormats) {
			super(valueIfStringIsNull, valueIfObjectIsNull);
			ArgumentUtils.noNulls("Date formats", dateFormats);
			this.locale = locale == null ? Locale.getDefault() : locale;
			this.formats = dateFormats.clone();
			this.parsers = new DateTimeFormatter[dateFormats.length];
			for (int i = 0; i < dateFormats.length; i++) {
				String dateFormat = dateFormats[i];
				parsers[i] = DateTimeFormatter.ofPattern(dateFormat, this.locale);
			}
	    }

		@Override
		public String revert(LocalDate input) {
			if (input == null) {
				return super.revert(null);
			}
			return parsers[0].format(input);
		}

		@Override
		protected LocalDate fromString(String input) {
			for (DateTimeFormatter formatter : parsers) {
				try {
					synchronized (formatter) {
						return LocalDate.parse(input, formatter);
					}
				} catch (DateTimeParseException ex) {
					//ignore and continue
				}
			}
			DataProcessingException exception = new DataProcessingException("Cannot parse '{value}' as a valid date of locale '" + locale + "'. Supported formats are: " + Arrays.toString(formats));
			exception.setValue(input);
			throw exception;
		}

		@Override
		public DateTimeFormatter[] getFormatterObjects() {
			return parsers;
		}
	}

	
	public static class UnivocityTimeFormatter extends ObjectConversion<LocalTime> implements FormattedConversion<DateTimeFormatter> {

		private final Locale locale;
		private final DateTimeFormatter[] parsers;
		private final String[] formats;


	    public UnivocityTimeFormatter(Locale locale, LocalTime valueIfStringIsNull, String valueIfObjectIsNull, String... dateFormats) {
			super(valueIfStringIsNull, valueIfObjectIsNull);
			ArgumentUtils.noNulls("Time formats", dateFormats);
			this.locale = locale == null ? Locale.getDefault() : locale;
			this.formats = dateFormats.clone();
			this.parsers = new DateTimeFormatter[dateFormats.length];
			for (int i = 0; i < dateFormats.length; i++) {
				String dateFormat = dateFormats[i];
				parsers[i] = DateTimeFormatter.ofPattern(dateFormat, this.locale);
			}
	    }

		@Override
		public String revert(LocalTime input) {
			if (input == null) {
				return super.revert(null);
			}
			return parsers[0].format(input);
		}

		@Override
		protected LocalTime fromString(String input) {
			for (DateTimeFormatter formatter : parsers) {
				try {
					synchronized (formatter) {
						return LocalTime.parse(input, formatter);
					}
				} catch (DateTimeParseException ex) {
					//ignore and continue
				}
			}
			DataProcessingException exception = new DataProcessingException("Cannot parse '{value}' as a valid date of locale '" + locale + "'. Supported formats are: " + Arrays.toString(formats));
			exception.setValue(input);
			throw exception;
		}

		@Override
		public DateTimeFormatter[] getFormatterObjects() {
			return parsers;
		}
	}

}
