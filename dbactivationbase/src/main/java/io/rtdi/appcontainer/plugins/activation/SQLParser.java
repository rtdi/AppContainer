package io.rtdi.appcontainer.plugins.activation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

import org.antlr.v4.runtime.CharStreams;

import io.rtdi.appcontainer.plugins.database.IActivationService;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;

public class SQLParser implements IActivationService {
	
	public SQLParser() {
		super();
	}
	
	@Override
	public ActivationResult activate(
			File file,
			Connection conn,
			GlobalSchemaMapping gm,
			SQLVariables variables,
			IDatabaseProvider provider) throws IOException, SQLException {
		SQLParserContext ctx = new SQLParserContext();
		ctx.setGlobalSchemaMapping(gm);
		ctx.setVariables(variables);
		ctx.setConnection(conn);
		ctx.setFile(file);
		ctx.setCatalogService(provider.getCatalogService());
		try (Reader reader = new FileReader(file);) {
			return provider.activateSQL(CharStreams.fromReader(reader), ctx);
		}
	}
	
}
