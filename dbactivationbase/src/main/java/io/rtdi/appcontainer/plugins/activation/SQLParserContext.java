package io.rtdi.appcontainer.plugins.activation;

import java.io.File;
import java.sql.Connection;

import io.rtdi.appcontainer.plugins.database.ICatalogService;

public class SQLParserContext {
	private GlobalSchemaMapping gm;
	private SQLVariables variables;
	private Connection conn;
	private File file;
	private ICatalogService catalogservice;

	public void setGlobalSchemaMapping(GlobalSchemaMapping gm) {
		this.gm = gm;
	}

	public void setVariables(SQLVariables variables) {
		this.variables = variables;
	}

	public SQLVariables getVariables() {
		return variables;
	}
	
	public GlobalSchemaMapping getGlobalSchemaMapping() {
		return gm;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public Connection getConnection() {
		return conn;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
	
	public String getFileName() {
		if (file != null) {
			return file.getName();
		} else {
			return null;
		}
	}

	public void setCatalogService(ICatalogService catalogservice) {
		this.catalogservice = catalogservice;
	}
	
	public ICatalogService getCatalogService() {
		return catalogservice;
	}

}
