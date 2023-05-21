package io.rtdi.appcontainer.dbactivationbase;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CodePointCharStream;

import io.rtdi.appcontainer.db.rest.entity.sql.SqlStatement;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.IStoredProcedure;

public class TestProvider implements IDatabaseProvider {

	public static final String[] AGGREGATION_FUNCTIONS = {"AVG", "COUNT", "MAX", "MIN", "SUM"};
	public static Pattern[] AGGREGATION_PATTERNS;
    final static String regex = ".*((%s\\s*\\(.*\\))).*";
    
    static {
    	AGGREGATION_PATTERNS = new Pattern[AGGREGATION_FUNCTIONS.length];
    	for (int i=0; i<AGGREGATION_FUNCTIONS.length; i++) {
    		AGGREGATION_PATTERNS[i] = Pattern.compile(String.format(regex, AGGREGATION_FUNCTIONS[i]), Pattern.DOTALL);
    	}
    }

	private TestCatalogService testcatalogservice = new TestCatalogService();

	@Override
	public String getJDBCDriverName() {
		return "testdriver";
	}

	@Override
	public ActivationServiceDirectory getActivationServices(Path rootpath) {
		return null;
	}

	@Override
	public ICatalogService getCatalogService() {
		return testcatalogservice;
	}

	@Override
	public IStoredProcedure getProcedureService() {
		return null;
	}

	@Override
	public JDBCDataTypeConversion getConversionClass() {
		return new JDBCDataTypeConversion();
	}

	@Override
	public ActivationResult activateSQL(CodePointCharStream fromReader, SQLParserContext ctx) throws SQLException {
		return null;
	}

	@Override
	public String createSql(SqlStatement sql) throws SQLException {
		throw new SQLException("not implemented");
	}

	@Override
	public String[] getAggregationFunctions() {
		return AGGREGATION_FUNCTIONS;
	}

	@Override
	public boolean isAggregationExpression(String text) {
		for(Pattern p : AGGREGATION_PATTERNS) {
			if (p.matcher(text).matches()) {
				return true;
			}
		}
		return false;
	}

}
