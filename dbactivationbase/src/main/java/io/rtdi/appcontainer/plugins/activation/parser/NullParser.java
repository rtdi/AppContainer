package io.rtdi.appcontainer.plugins.activation.parser;

import java.io.IOException;
import java.io.Reader;

import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.IParser;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

public class NullParser implements IParser {

	@Override
	public StringBuilder read(StringBuilder sb, Reader reader, SQLParserContext ctx, ActivationResult result) throws IOException {
		return new StringBuilder(); // ignore the char
	}

	@Override
	public String toString() {
		return "<ignore>";
	}
}
