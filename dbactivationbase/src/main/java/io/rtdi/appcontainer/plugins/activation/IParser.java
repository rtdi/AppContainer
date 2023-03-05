package io.rtdi.appcontainer.plugins.activation;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public interface IParser {

	StringBuilder read(StringBuilder sb, Reader reader, SQLParserContext ctx, ActivationResult result) throws IOException, ActivationException, SQLException;

	String getText();

}
