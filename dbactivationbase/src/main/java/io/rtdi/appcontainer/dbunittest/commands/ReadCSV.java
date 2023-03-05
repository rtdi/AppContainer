package io.rtdi.appcontainer.dbunittest.commands;

import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.univocity.parsers.common.DataProcessingException;
import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.RowProcessorErrorHandler;
import com.univocity.parsers.common.processor.ObjectRowProcessor;
import com.univocity.parsers.conversions.Conversions;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import io.rtdi.appcontainer.dbunittest.value.ColumnMetadata;
import io.rtdi.appcontainer.dbunittest.value.TableValue;
import io.rtdi.appcontainer.plugins.activation.CSVImport.Base64Conversion;
import io.rtdi.appcontainer.plugins.activation.CSVImport.UnivocityDateFormatter;
import io.rtdi.appcontainer.plugins.activation.CSVImport.UnivocityDateTimeFormatter;
import io.rtdi.appcontainer.plugins.activation.CSVImport.UnivocityInstantFormatter;
import io.rtdi.appcontainer.plugins.activation.CSVImport.UnivocityTimeFormatter;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

public class ReadCSV {

	public static TableValue execute(String filepathstring, Path basedir, Connection conn, IDatabaseProvider provider) throws SQLException {
		Path p = basedir.resolve(filepathstring);
		File file = p.toFile();
		CsvParserSettings settings = new CsvParserSettings();
		settings.getFormat().setQuoteEscape('\\');
		settings.getFormat().setCharToEscapeQuoteEscaping('\\');
		settings.getFormat().setDelimiter(',');
		settings.getFormat().setQuote('"');
		// settings.getFormat().setLineSeparator("\n");
		settings.setLineSeparatorDetectionEnabled(true);
		settings.setHeaderExtractionEnabled(true);
		// settings.detectFormatAutomatically();
		SQLRowProcessorErrorHandler errorhandler = new SQLRowProcessorErrorHandler();
		settings.setProcessorErrorHandler(errorhandler);
		TableValue table = new TableValue();
		TableRowProcessor rowprocessor = new TableRowProcessor(table);
		settings.setProcessor(rowprocessor);
		CsvParser parser = new CsvParser(settings);
		parser.parse(file);
		if (errorhandler.getError() != null) {
			throw new SQLException(errorhandler.getError().getMessage());
		}
		return table;
	}
	
	public static class SQLRowProcessorErrorHandler implements RowProcessorErrorHandler {
		private DataProcessingException error = null;
		
		public SQLRowProcessorErrorHandler() {
		}
		
		@Override
	    public void handleError(DataProcessingException error, Object[] inputRow, ParsingContext context) {
	    	this.error = error;
    		context.stop();
	    }
		
		public DataProcessingException getError() {
			return error;
		}
	}
	
	public static class TableRowProcessor extends ObjectRowProcessor {
		
	    private TableValue table;

		public TableRowProcessor(TableValue table) {
	    	this.table = table;
		}
	    
		@Override
	    public void rowProcessed(Object[] row, ParsingContext context) {
			table.addRow(row);
	    }

		@Override
		public void processStarted(ParsingContext context) {
			String regex = "([\\w$_\\/]*)(\\s*([\\w]*)(\\(\\s*(\\d*)(\\s*(,\\s*(\\d*)\\s*)?)\\))?)?";
	        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
	        
	        String[] headers = context.parsedHeaders();
			for (int i = 0; i<headers.length; i++) {
				String header = headers[i];
		        Matcher matcher = pattern.matcher(header);
		        if (matcher.find()) {
		        	String columnname = matcher.group(1);
		        	ColumnMetadata c = new ColumnMetadata(columnname, i);
		        	if (matcher.groupCount() > 3) {
		        		String datatype = matcher.group(3);
		        		try {
		        			JDBCType t = JDBCType.valueOf(datatype);
		        			c.setColumnDataType(t);
		        			setConverter(t, i);
		        		} catch (IllegalArgumentException e) {
		        			throw new DataProcessingException(
		        					String.format("The CSV file specifies a datatype \"%s\" for the column \"%s\" which is not understood",
		        					datatype, columnname));
		        		}
		        	}
		        	// String len = matcher.group(5);
		        	// String precision = matcher.group(8);
		        	table.addColumn(c);
		        } else {
        			throw new DataProcessingException(
        					String.format("The CSV file specifies a column header \"%s\" which is not of the correct format: <COLUMNNAME> [<JDBCTYPE>[(<LEN>[,<PRECISION>])]]",
        					header));
		        }
			}
		}

		@Override
		public void processEnded(ParsingContext context) {
		}
		
		private void setConverter(JDBCType type, int i) {
			switch (type) {
			case ARRAY:
				break;
			case BIGINT:
				convertIndexes(Conversions.toLong()).set(i);
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
						"yyyy.MM.dd[ ]['T']HH:mm[:ss[.SSS]][XXX]",
						"MM/dd/yyyy[ ]['T']HH:mm[:ss[.SSS]][XXX]",
						"yyyy-MM-dd[ ]['T']HH:mm[:ss[.SSS]][XXX]")).set(i);
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

}
