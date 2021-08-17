package io.rtdi.appcontainer.designtimeobjects.sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.utils.AppContainerSQLException;

public interface ISQLScriptActivation {

	void fireBlockComment(String comment);

	Boolean fireLineComment(String comment) throws AppContainerSQLException;

	boolean fireSQL(String sqltext) throws AppContainerSQLException;

	String fireAlias(String alias) throws ActivationException;

	String fireVariable(String variable) throws ActivationException;

	public void parse(File file, ActivationResult result) throws FileNotFoundException, IOException, ActivationException, AppContainerSQLException;
	
	public void parse(String text, ActivationResult result) throws IOException, ActivationException, AppContainerSQLException;

}
