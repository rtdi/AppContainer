package io.rtdi.appcontainer.plugins.database;

import java.nio.file.Path;
import java.sql.SQLException;

import org.antlr.v4.runtime.CodePointCharStream;

import io.rtdi.appcontainer.db.rest.entity.sql.SqlStatement;
import io.rtdi.appcontainer.dbactivationbase.JDBCDataTypeConversion;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

public interface IDatabaseProvider {
	
	String getJDBCDriverName();
	ActivationServiceDirectory getActivationServices(Path rootpath);
	ICatalogService getCatalogService();
	IStoredProcedure getProcedureService();
	JDBCDataTypeConversion getConversionClass();
	ActivationResult activateSQL(CodePointCharStream fromReader, SQLParserContext ctx) throws SQLException;
	String createSql(SqlStatement sql) throws SQLException;
	String[] getAggregationFunctions();
	boolean isAggregationExpression(String text);
	
}
