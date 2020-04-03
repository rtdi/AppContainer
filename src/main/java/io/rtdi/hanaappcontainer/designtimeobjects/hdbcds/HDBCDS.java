package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;

import java.sql.Connection;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import io.rtdi.hanaappcontainer.antlr.sql.HDBCDSLexer;
import io.rtdi.hanaappcontainer.antlr.sql.HDBCDSParser;
import io.rtdi.hanaappserver.ActivationResult;
import io.rtdi.hanaappserver.ActivationStyle;
import io.rtdi.hanaappserver.ActivationSuccess;
import io.rtdi.hanaappserver.HanaObject;
import io.rtdi.hanaappserver.HanaParsingException;
import io.rtdi.hanaappserver.utils.HanaSQLException;

public class HDBCDS {

	private Map<String, HanaObject> cdsobjects;
	private Map<String, HanaObject> cdstypes;

	public HDBCDS(Map<String, HanaObject> cdsobjects, Map<String, HanaObject> cdstypes) {
		this.cdsobjects = cdsobjects;
		this.cdstypes = cdstypes;
	}

	public static HDBCDS parseHBDCDSFile(String text, String schemaname) throws HanaParsingException {
		CharStream input = CharStreams.fromString(text);;
		HDBCDSLexer lexer = new HDBCDSLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		HDBCDSParser parser = new HDBCDSParser(tokens);
		ParseTree tree = parser.root(); // begin parsing at rule 'root'
		ParseTreeWalker walker = new ParseTreeWalker();
		ANTLRHDBCDSSetter listener = new ANTLRHDBCDSSetter(schemaname);
		walker.walk(listener, tree);
		if (listener.getParsingresult().getParsingErrors() != null) {
			throw new HanaParsingException(text, listener.getParsingresult());
		}
		HDBCDS cdsobject = new HDBCDS(listener.getObjects(), listener.getTypes());
		
		System.out.println(tree.toStringTree(parser));
		
		return cdsobject;
	}

	public void valid(ActivationResult result) throws HanaSQLException {
		if (cdstypes != null) {
			for (HanaObject o : cdstypes.values()) {
				o.valid(result.addResult("Validating Types " + o.getObjectName(), null, ActivationSuccess.SUCCESS, o));
			}
		}
		if (cdsobjects != null) {
			for (HanaObject o : cdsobjects.values()) {
				o.valid(result.addResult("Validating " + o.getObjectName(), null, ActivationSuccess.SUCCESS, o));
			}
		}
	}

	public void activate(ActivationResult result, Connection conn, ActivationStyle reconcile) throws HanaSQLException {
		if (cdsobjects != null) {
			for (HanaObject o : cdsobjects.values()) {
				o.activate(result.addResult("Activating " + o.getObjectName(), null, ActivationSuccess.SUCCESS, o), conn, reconcile);
			}
		}		
	}

}
