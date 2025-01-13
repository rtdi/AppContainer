package io.rtdi.appcontainer.plugins.databaseabap;

import java.nio.file.Path;
import java.sql.SQLException;

import org.antlr.v4.runtime.CodePointCharStream;

import io.rtdi.appcontainer.db.rest.entity.sql.SqlStatement;
import io.rtdi.appcontainer.dbactivationbase.JDBCDataTypeConversion;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.IStoredProcedure;

public class AbapProvider implements IDatabaseProvider {
	public static final String JDBC_DRIVER = "io.rtdi.jdbcabap.AbapDriver";
	private static ActivationServiceDirectory activationservice;
	private static ICatalogService catalogservice;
	private static IStoredProcedure procedureservice;
	private static JDBCDataTypeConversion conv;
	
	public AbapProvider() {
		conv = new JDBCDataTypeConversion();
	}
	
	@Override
	public ActivationServiceDirectory getActivationServices(Path rootpath) {
		if (activationservice == null) {
			activationservice = new AbapActivationServiceDirectory(rootpath);
		}
		return activationservice;
	}

	@Override
	public ICatalogService getCatalogService() {
		if (catalogservice == null) {
			catalogservice = new AbapCatalogService();
		}
		return catalogservice;
	}
	
	public IStoredProcedure getProcedureService() {
		if (procedureservice == null) {
			procedureservice = new AbapStoredProcedure();
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
		return null;
	}

	@Override
	public String createSql(SqlStatement sql) throws SQLException {
		/*
		 * The SQLApp produces a Json in the form of
		 * 
		 * <pre>
		 * - with
		 *   - alias
		 *   - subquery
		 * - subquery
		 *   - projections
		 *     - value
		 *     - alias
		 *     - order
		 *   - from
		 *     - jointype
		 *     - value
		 *     - on
		 *       - left
		 *       - right
		 *   - where
		 *     - left
		 *     - op
		 *     - right
		 * - limit
		 * </pre>
		 * 
		 * Note that this is the UI tree, so it will have empty elements.
		 *
		 */
		String sqltext = sql.toString(0, this);
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
		return null;
	}

	@Override
	public boolean isAggregationExpression(String text) {
		return false;
	}

	@Override
	public String addLimitClause(String sql, Integer limit, Integer offset) {
		return sql + (limit != null?" limit " + String.valueOf(limit):"") + (offset != null?" offset " + String.valueOf(offset):"");
	}

	@Override
	public StringBuilder addLimitClause(StringBuilder sql, Integer limit, Integer offset) {
		if (limit != null) {
			sql.append(" limit ").append(limit);
		}
		if (offset != null) {
			sql.append(" offset ").append(offset);
		}
		return sql;
	}

}
