package io.rtdi.appcontainer.plugins.database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.GlobalSchemaMapping;
import io.rtdi.appcontainer.plugins.activation.SQLVariables;

public interface IActivationService {
	
	ActivationResult activate(File file, Connection conn, GlobalSchemaMapping gm,
			SQLVariables variables, ICatalogService catalogservice) throws IOException, SQLException;

}
