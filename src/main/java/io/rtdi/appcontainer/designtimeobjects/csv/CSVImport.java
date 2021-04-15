package io.rtdi.appcontainer.designtimeobjects.csv;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.univocity.parsers.common.DataProcessingException;
import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.RowProcessorErrorHandler;
import com.univocity.parsers.common.processor.ObjectRowProcessor;
import com.univocity.parsers.conversions.Conversions;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.activationapp.ActivationStyle;
import io.rtdi.appcontainer.activationapp.ActivationSuccess;
import io.rtdi.appcontainer.utils.Describe;
import io.rtdi.appcontainer.utils.HanaSQLException;
import io.rtdi.appcontainer.utils.Describe.ColumnDefinition;

public class CSVImport {

	private ActivationResult result;
	private Connection conn;
	private String owner;
	private String tablename;

	public CSVImport(ActivationResult result, Connection conn, ActivationStyle style) {
		this.result = result;
		this.conn = conn;
	}

	public void csvImport(File file, String owner, String tablename) {
		try {
			this.owner = owner;
			this.tablename = tablename;
			CsvParserSettings settings = new CsvParserSettings();
			settings.getFormat().setQuoteEscape('\\');
			settings.getFormat().setCharToEscapeQuoteEscaping('\\');
			settings.getFormat().setDelimiter(',');
			settings.getFormat().setQuote('"');
			// settings.getFormat().setLineSeparator("\n");
			settings.setLineSeparatorDetectionEnabled(true);
			settings.setHeaderExtractionEnabled(true);
			// settings.detectFormatAutomatically();
			settings.setProcessorErrorHandler(new RowProcessorErrorHandler() {
				int warningcount = 0;
	
				@Override
			    public void handleError(DataProcessingException error, Object[] inputRow, ParsingContext context) {
			    	result.addResult(error.getMessage(), null, ActivationSuccess.WARNING, null);
			    	warningcount++;
			    	if (warningcount > 20) {
				    	result.addResult("Too many input errors, stopping", null, ActivationSuccess.FAILED, null);
			    		context.stop();
			    	}
			    }
			});
			
			HanaImportRowProcessor rowprocessor = new HanaImportRowProcessor();
			settings.setProcessor(rowprocessor);
			CsvParser parser = new CsvParser(settings);
			parser.parse(file);
			conn.commit();
		} catch (SQLException e) {
			result.addResult("SQLException when executing commit", null, ActivationSuccess.FAILED, null);
		} finally {
			try {
				conn.rollback();
			} catch (SQLException e) {
				result.addResult("SQLException when executing rollback", null, ActivationSuccess.FAILED, null);
			}
		}
	}
	
	public class HanaImportRowProcessor extends ObjectRowProcessor {
		private PreparedStatement insert;
		private PreparedStatement upsert;
		private PreparedStatement delete;
		private int indexChangeType = -1;
		private List<Integer> keyindexes; 
		private List<Integer> columnindexes; 
		
	    @Override
	    public void rowProcessed(Object[] row, ParsingContext context) {
			try {
				if (indexChangeType == -1 || row[indexChangeType].equals("I")) {
					for (int i=0; i<columnindexes.size(); i++) {
						insert.setObject(i+1, row[columnindexes.get(i)]);
					}
					insert.execute();
				} else {
					switch (row[indexChangeType].toString()) {
					case "U":
					case "A":
						/*
						 * Update and upserts can share the same code. Not 100% correct but neither is an
						 * update row for a non-existing key.
						 */
						for (int i=0; i<columnindexes.size(); i++) {
							upsert.setObject(i+1, row[columnindexes.get(i)]);
						}
						upsert.execute();
						break;
					case "D":
					case "X":
						/*
						 * Delete and eXterminate both delete the record based on the PK.
						 */
						for (int i=0; i<keyindexes.size(); i++) {
							int index = keyindexes.get(i);
							delete.setObject(i+1, row[index]);
						}
						delete.execute();
						break;
					case "T":
						/*
						 * A truncate means all records are to be deleted matching the not-null columns.
						 * For example from the table ID, FIRSTNAME, REGION all REGION='US' records are deleted 
						 * if the input line in the file has _CHANGE_TYPE = 'T' and REGION='US' and all other columns are null.
						 */
						StringBuffer deletesegment = new StringBuffer();
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
							del.setObject(i+1, row[deleteindex.get(i)]);
						}
						del.execute();
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
						throw new HanaSQLException(e, sql, "Failed to truncate the table");
					}
				}
			} catch (HanaSQLException e) {
				DataProcessingException ex = new DataProcessingException("Generating the SQL DML statements failed with SQLException: \"" + e.getMessage() + "\"", e);
				throw ex;
			}
		}

		@Override
		public void processEnded(ParsingContext context) {
		}
		
	
		private void setStatements(List<String> headers, String owner, String tablename) throws HanaSQLException {
			StringBuffer sqlinsert = new StringBuffer();
			StringBuffer sqlupsert = new StringBuffer();
			StringBuffer sqldelete = new StringBuffer();
			StringBuffer columnlist = new StringBuffer();
			StringBuffer paramlist = new StringBuffer();
			List<ColumnDefinition> collist = Describe.getTableColumns(conn, owner, tablename);
			try {
				columnindexes = new ArrayList<>();
				for (int i=0; i<headers.size(); i++) {
					String columnname = headers.get(i);
					if (columnlist.length() != 0) {
						columnlist.append(", ");
						paramlist.append(", ");
					}
					if (!columnname.equals("_CHANGE_TYPE")) {
						columnlist.append("\"").append(columnname).append("\"");
						paramlist.append("?");
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
				insert = conn.prepareStatement(sqlinsert.toString());
			} catch (SQLException e) {
				throw new HanaSQLException(e, "Failed creating the insert statement for this table", sqlinsert.toString());
			}

				/*
				 * When there is a change type column also add the upsert/delete statements. Truncates are generated on demand.
				 */
				if (indexChangeType != -1) {
					sqlupsert.append("upsert ")
						.append("\"")
						.append(owner)
						.append("\".\"")
						.append(tablename)
						.append("\" (")
						.append(columnlist)
						.append(") values (")
						.append(paramlist)
						.append(") with primary key");
					
					sqldelete.append("delete from ")
						.append("\"")
						.append(owner)
						.append("\".\"")
						.append(tablename)
						.append("\" where ");
					keyindexes = new ArrayList<>();
					for (int i=0; i<collist.size(); i++) {
						ColumnDefinition columndef = collist.get(i);
						if (columndef.isKey()) {
							if (keyindexes.size() != 0) {
								sqldelete.append("AND ");
							}
							keyindexes.add(i);
							sqldelete.append("\"")
								.append(columndef.getColumnname())
								.append("\" = ? ");
						}
					}
					if (keyindexes.size() == 0) {
						throw new HanaSQLException("The CSV files has a _CHANGE_TYPE column but the database table does not have a primary key", null);
					}
					try {
						upsert = conn.prepareStatement(sqlupsert.toString());
					} catch (SQLException e) {
						throw new HanaSQLException(e, "Failed creating the upsert statement for this table", sqlupsert.toString());
					}
					try {
						delete = conn.prepareStatement(sqldelete.toString());
					} catch (SQLException e) {
						throw new HanaSQLException(e, "Failed creating the delete statement for this table", sqldelete.toString());
					}
				}
				
			
			/*
			 * Add datatype converters
			 */
			for (int i=0; i<collist.size(); i++) {
				ColumnDefinition columndef = collist.get(i);
				switch (columndef.getDatatype()) {
				case ALPHANUM:
					break;
				case BIGINT:
					convertIndexes(Conversions.toBigInteger()).set(i);
					break;
				case BINARY:
					break;
				case BINTEXT:
					break;
				case BLOB:
					break;
				case BOOLEAN:
					break;
				case CHAR:
					break;
				case CLOB:
					break;
				case DATE:
					convertIndexes(Conversions.toDate(TimeZone.getTimeZone("UTC"), Locale.ENGLISH, null, null, "MM/dd/yyyy", "yyyy.MM.dd")).set(i);
					break;
				case DECIMAL:
					break;
				case DOUBLE:
					convertIndexes(Conversions.toDouble()).set(i);
					break;
				case IGNORE:
					break;
				case INTEGER:
					break;
				case NCHAR:
					break;
				case NCLOB:
					break;
				case NVARCHAR:
					break;
				case REAL:
				case SMALLDECIMAL:
					convertIndexes(Conversions.toFloat()).set(i);
					break;
				case SECONDDATE:
					convertIndexes(Conversions.toDate(TimeZone.getTimeZone("UTC"), Locale.ENGLISH, null, null, "MM/dd/yyyy HH:mm:ss", "yyyy.MM.dd HH:mm:ss")).set(i);
					break;
				case SHORTTEXT:
					break;
				case SMALLINT:
					break;
				case ST_GEOMETRY:
					break;
				case ST_POINT:
					break;
				case TEXT:
					break;
				case TIME:
					convertIndexes(Conversions.toDate(TimeZone.getTimeZone("UTC"), Locale.ENGLISH, null, null, "HH:mm:ss", "HH:mm:ss.SSS")).set(i);
					break;
				case TIMESTAMP:
					convertIndexes(Conversions.toDate(TimeZone.getTimeZone("UTC"), Locale.ENGLISH, null, null, "MM/dd/yyyy HH:mm:ss.SSS", "yyyy.MM.dd HH:mm:ss.SSS")).set(i);
					break;
				case TINYINT:
					break;
				case VARBINARY:
					break;
				case VARCHAR:
					break;
				default:
					break;
				}
			}
		}

	}

}
