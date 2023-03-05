package io.rtdi.appcontainer.plugins.database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.GlobalSchemaMapping;
import io.rtdi.appcontainer.plugins.activation.SQLVariables;

public class Ignore implements IActivationService {

	public Ignore(Path rootpath) {
	}

	@Override
	public ActivationResult activate(File file, Connection conn, GlobalSchemaMapping gm, SQLVariables variables,
			IDatabaseProvider provider) throws IOException, SQLException {
		return null;
	}

}
