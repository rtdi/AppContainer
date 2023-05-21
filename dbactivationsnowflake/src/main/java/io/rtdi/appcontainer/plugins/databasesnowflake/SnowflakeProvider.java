package io.rtdi.appcontainer.plugins.databasesnowflake;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.rtdi.appcontainer.db.rest.entity.sql.SqlStatement;
import io.rtdi.appcontainer.dbactivationbase.JDBCDataTypeConversion;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.IStoredProcedure;
import io.rtdi.appcontainer.plugins.databasesnowflake.activation.antlr.SqlScriptsAntlrListener;
import io.rtdi.appcontainer.plugins.databasesnowflake.activation.antlr.SqlscriptsLexer;
import io.rtdi.appcontainer.plugins.databasesnowflake.activation.antlr.SqlscriptsParser;

public class SnowflakeProvider implements IDatabaseProvider {
	public static final String JDBC_DRIVER = "net.snowflake.client.jdbc.SnowflakeDriver";
	private static ActivationServiceDirectory activationservice;
	private static ICatalogService catalogservice;
	private static IStoredProcedure procedureservice;
	private static JDBCDataTypeConversion conv;
	
	public static final String[] AGGREGATION_FUNCTIONS = {"AVG", "COUNT", "MAX", "MIN", "SUM"};
	public static Pattern[] AGGREGATION_PATTERNS;
    final static String regex = ".*((%s\\s*\\(.*\\))).*";
    
    static {
    	AGGREGATION_PATTERNS = new Pattern[AGGREGATION_FUNCTIONS.length];
    	for (int i=0; i<AGGREGATION_FUNCTIONS.length; i++) {
    		AGGREGATION_PATTERNS[i] = Pattern.compile(String.format(regex, AGGREGATION_FUNCTIONS[i]), Pattern.DOTALL);
    	}
    }

	public SnowflakeProvider() {
		conv = new JDBCDataTypeConversion();
	}

	@Override
	public ActivationServiceDirectory getActivationServices(Path rootpath) {
		if (activationservice == null) {
			activationservice = new SnowflakeActivationServiceDirectory(rootpath);
		}
		return activationservice;
	}

	@Override
	public ICatalogService getCatalogService() {
		if (catalogservice == null) {
			catalogservice = new SnowflakeCatalogService();
		}
		return catalogservice;
	}
	
	public IStoredProcedure getProcedureService() {
		if (procedureservice == null) {
			procedureservice = new SnowflakeStoredProcedure();
		}
		return procedureservice;
	}

	@Override
	public String getJDBCDriverName() {
		return JDBC_DRIVER;
	}

	@Override
	public JDBCDataTypeConversion getConversionClass() {
		return conv;
	}

	@Override
	public ActivationResult activateSQL(CodePointCharStream reader, SQLParserContext ctx) throws SQLException {
		SqlscriptsLexer lexer = new SqlscriptsLexer(reader);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SqlscriptsParser parser = new SqlscriptsParser(tokens);
		ParseTreeWalker walker = new ParseTreeWalker();
		SqlScriptsAntlrListener listener = new SqlScriptsAntlrListener(ctx);
		ParseTree tree = parser.script();
		walker.walk(listener, tree);
		ctx.getConnection().commit();
		return listener.getResult();
	}

	@Override
	public String createSql(SqlStatement sql) throws SQLException {
		String sqltext = sql.toString();
		if (sql.getOffset() != null) {
			sqltext += " OFFSET " + sql.getOffset();
		}
		if (sql.getLimit() != null) {
			sqltext += " LIMIT " + sql.getLimit();
		}
		return sqltext;
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
