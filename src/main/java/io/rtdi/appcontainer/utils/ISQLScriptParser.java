package io.rtdi.appcontainer.utils;

import java.io.IOException;
import java.io.Reader;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.designtimeobjects.sql.ISQLScriptActivation;

public interface ISQLScriptParser {

	void parse(Reader reader, ActivationResult result, ISQLScriptActivation callback)
			throws IOException, ActivationException, AppContainerSQLException;

}