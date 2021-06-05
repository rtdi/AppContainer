package io.rtdi.appcontainer.utils;

import java.sql.Connection;

import io.rtdi.appcontainer.designtimeobjects.GlobalSchemaMapping;

public interface IDDLStatements {

	boolean if_exists_object(Connection conn, String objectidentifier, GlobalSchemaMapping gm) throws AppContainerSQLException;

	boolean if_exists_column(Connection conn, String columnidentifier, GlobalSchemaMapping gm) throws AppContainerSQLException;

}
