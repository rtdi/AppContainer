package io.rtdi.appcontainer.designtimeobjects.sql;

import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.utils.AppContainerSQLException;

public interface ISQLScriptActivation {

	void fireBlockComment(String comment);

	void fireLineComment(String comment) throws AppContainerSQLException;

	void fireSQL(String sqltext) throws AppContainerSQLException;

	String fireAlias(String alias) throws ActivationException;

	String fireVariable(String variable) throws ActivationException;

}
