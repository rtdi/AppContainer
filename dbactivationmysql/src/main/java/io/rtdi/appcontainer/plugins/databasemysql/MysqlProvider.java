package io.rtdi.appcontainer.plugins.databasemysql;

import java.nio.file.Path;
import java.sql.SQLException;

import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.rtdi.appcontainer.dbactivationbase.JDBCDataTypeConversion;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.IStoredProcedure;
import io.rtdi.appcontainer.plugins.databasemysql.activation.antlr.SqlScriptsAntlrListener;
import io.rtdi.appcontainer.plugins.databasemysql.activation.antlr.SqlscriptsLexer;
import io.rtdi.appcontainer.plugins.databasemysql.activation.antlr.SqlscriptsParser;

public class MysqlProvider implements IDatabaseProvider {
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static ActivationServiceDirectory activationservice;
	private static ICatalogService catalogservice;
	private static IStoredProcedure procedureservice;
	private static JDBCDataTypeConversion conv;
	
	public MysqlProvider() {
		conv = new JDBCDataTypeConversion();
	}

	@Override
	public ActivationServiceDirectory getActivationServices(Path rootpath) {
		if (activationservice == null) {
			activationservice = new MysqlActivationServiceDirectory(rootpath);
		}
		return activationservice;
	}

	@Override
	public ICatalogService getCatalogService() {
		if (catalogservice == null) {
			catalogservice = new MysqlCatalogService();
		}
		return catalogservice;
	}
	
	public IStoredProcedure getProcedureService() {
		if (procedureservice == null) {
			procedureservice = new MysqlStoredProcedure();
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

}
