package io.rtdi.appcontainer.dbunittest;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

import org.graalvm.polyglot.HostAccess;

import io.rtdi.appcontainer.dbunittest.commands.ReadCSV;
import io.rtdi.appcontainer.dbunittest.commands.SQLQuery;
import io.rtdi.appcontainer.dbunittest.commands.SQLSingleValueSelect;
import io.rtdi.appcontainer.dbunittest.value.TableValue;

public class Commands {
	
	private Connection conn;
	private Path rootpath;

	public Commands(Connection conn, Path rootpath) {
		this.conn = conn;
		this.rootpath = rootpath;
	}
	
	@HostAccess.Export
	public TableValue readCSV(String filepath) throws SQLException {
		return ReadCSV.execute(filepath, rootpath, conn);
	}

	@HostAccess.Export
	public TableValue query(String sqltext, Object... parameters) throws SQLException {
		return SQLQuery.execute(sqltext, parameters, conn);
	}

	@HostAccess.Export
	public Object queryValue(String sqltext, Object... parameters) throws SQLException {
		return SQLSingleValueSelect.execute(sqltext, parameters, conn);
	}

}
