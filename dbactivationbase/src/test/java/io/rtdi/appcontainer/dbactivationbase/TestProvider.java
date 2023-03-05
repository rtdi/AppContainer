package io.rtdi.appcontainer.dbactivationbase;

import java.nio.file.Path;
import java.sql.SQLException;

import org.antlr.v4.runtime.CodePointCharStream;

import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;
import io.rtdi.appcontainer.plugins.database.ActivationServiceDirectory;
import io.rtdi.appcontainer.plugins.database.ICatalogService;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.IStoredProcedure;

public class TestProvider implements IDatabaseProvider {

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

}
