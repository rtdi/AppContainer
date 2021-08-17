package io.rtdi.appcontainer.utils.hana;

import java.io.IOException;
import java.io.Reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.activationapp.ActivationSuccess;
import io.rtdi.appcontainer.designtimeobjects.ActivationException;
import io.rtdi.appcontainer.designtimeobjects.sql.ISQLScriptActivation;
import io.rtdi.appcontainer.utils.AppContainerSQLException;
import io.rtdi.appcontainer.utils.ISQLScriptParser;

public class HanaSQLScriptParser  implements ISQLScriptParser {
	protected static final Logger logger = LogManager.getLogger("SQLScriptParser");

	public void parse(Reader reader, ActivationResult result, ISQLScriptActivation callback) throws IOException, ActivationException, AppContainerSQLException {
		StringBuilder text = new StringBuilder();
		int r;
		int level = 0;
		while ((r = reader.read()) != -1) {
			char c = (char) r;
			switch (c) {
			case '/':
				parseComment(reader, text, result, callback, level, '/');
				break;
			case '-':
				parseComment(reader, text, result, callback, level, '-');
				break;
			case '"': 
				parseDoubleQuotedText(reader, text, result, callback);
				break;
			case '\'': 
				parseSingleQuotedText(reader, text, result, callback);
				break;
			case ';':
				logger.debug("Found ';'");
				if (text.length() >= 3) {
					// a begin-end block or a case-end block
					String s = text.substring(text.length()-3);
					if (s.equalsIgnoreCase("end")) {
						level--;
					}
				}
				text.append(c); // add the semicolon
				if (level == 0) {
					if (callback.fireSQL(text.toString())) { // the statement was skipped
						logger.debug("Execute statement {}", text.toString());
						result.addResult("ExecuteSQL", text.toString(), ActivationSuccess.SUCCESS);
					} else {
						logger.debug("Skip statement {}", text.toString());
						result.addResult("Skipped statement", text.toString(), ActivationSuccess.SUCCESS);
					}
					text = new StringBuilder();
				} else {
					// a semicolon as text inside a procedure
					logger.debug("';' is inside code block");
				}
				break;
			case '(': 
				logger.debug("Found '('");
				level++;
				text.append(c);
				break;
			case ')':
				logger.debug("Found ')'");
				level--;
				text.append(c);
				if (level < 0) {
					level = 0;
					throw new ActivationException("The number of brackets does not match, one more closing braket than open");
				}
				break;
			case '$':
				parseAlias(reader, text, result, callback);
				break;
			case '&':
				parseVariable(reader, text, result, callback);
				break;
			case '\r':
			case '\n':
			case ' ':
				/*
				 * A statement should never start with a \r or \n char 
				 */
				if (text.length() > 0) {
					if (text.length() >= 5) {
						// a begin-end block or a case-end block in Hana
						String s = text.substring(text.length()-5);
						if (s.equalsIgnoreCase("begin")) {
							logger.debug("Found 'begin'");
							level++;
						} else if (s.substring(1).equalsIgnoreCase("case")) {
							logger.debug("Found 'case'");
							level++;
						} else if (s.substring(3).equalsIgnoreCase("if")) {
							logger.debug("Found 'if'");
							level++;
						} else if (s.substring(2).equalsIgnoreCase("end")) {
							logger.debug("Found 'end'");
							level--;
						}
					}
					text.append(c);
				}
				break;
			default:
				text.append(c);
				break;
			}
		}
	}

	private static void parseDoubleQuotedText(Reader reader, StringBuilder text, ActivationResult result, ISQLScriptActivation callback) throws IOException, ActivationException {
		logger.debug("Found '\"'");
		StringBuilder quotedtext = new StringBuilder();
		text.append('"');
		int r;
		boolean escape = false;
		while ((r = reader.read()) != -1) {
			char c = (char) r;
			switch (c) {
			case '\\':
				escape = true;
				break;
			case '"':
				if (!escape) {
					logger.debug("Found closing '\"'");
					text.append(quotedtext);
					text.append('"');
				} else {
					escape = false;
					text.append(c);
				}
				return;
			case '$':
				if (!escape) {
					parseAlias(reader, quotedtext, result, callback);
				} else {
					escape = false;
					text.append(c);
				}
					
				break;
			case '&':
				if (!escape) {
					parseVariable(reader, quotedtext, result, callback);
				} else {
					escape = false;
					text.append(c);
				}
				break;
			default:
				quotedtext.append(c);
				break;
			}
		}
	}

	private static void parseSingleQuotedText(Reader reader, StringBuilder text, ActivationResult result, ISQLScriptActivation callback) throws IOException, ActivationException {
		logger.debug("Found '''");
		StringBuilder quotedtext = new StringBuilder();
		text.append('\'');
		int r;
		boolean escape = false;
		while ((r = reader.read()) != -1) {
			char c = (char) r;
			switch (c) {
			case '\\':
				escape = true;
				break;
			case '\'':
				if (!escape) {
					logger.debug("Found closing '''");
					text.append(quotedtext);
					text.append('\'');
				} else {
					escape = false;
					text.append(c);
				}
				return;
			case '$':
				if (!escape) {
					parseAlias(reader, quotedtext, result, callback);
				} else {
					escape = false;
					text.append(c);
				}
					
				break;
			case '&':
				if (!escape) {
					parseVariable(reader, quotedtext, result, callback);
				} else {
					escape = false;
					text.append(c);
				}
				break;
			default:
				quotedtext.append(c);
				break;
			}
		}
	}

	private static void parseAlias(Reader reader, StringBuilder text, ActivationResult result, ISQLScriptActivation callback) throws IOException, ActivationException {
		logger.debug("Found '$'");
		StringBuilder aliastext = new StringBuilder();
		reader.mark(1);
		int r = reader.read();
		if (r != -1) {
			char c = (char) r;
			boolean bracket = (c == '{');
			if (bracket) {
				while ((r = reader.read()) != -1) {
					c = (char) r;
					switch (c) {
					case '\r':
					case '\n':
						throw new ActivationException("Cannot parse the alias, found end of line after \"" + aliastext.toString() + "\"");
					case '}':
						logger.debug("Found alias is {}", aliastext.toString());
						text.append(callback.fireAlias(aliastext.toString()));
						return;
					default:
						aliastext.append(c);
					}
				}
			} else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == '_') {
				do {
					c = (char) r;
					switch (c) {
					case '\r':
					case '\n':
					case ' ':
						logger.debug("Found alias is {}", aliastext.toString());
						text.append(callback.fireAlias(aliastext.toString()));
						text.append(c);
						return;
					case ';': // an alias might be terminated with a ; char as well
						logger.debug("Found alias is {}", aliastext.toString());
						text.append(callback.fireAlias(aliastext.toString()));
						text.append(c);
						reader.reset();
						return;
					default:
						aliastext.append(c);
						break;
					}
					reader.mark(1); // required for the ; termination case
					r = reader.read();
				} while (r != -1);
			} else {
				logger.debug("Found '$' is no alias");
				reader.reset();
				text.append('$');
			}
		}
	}

	private static void parseVariable(Reader reader, StringBuilder text, ActivationResult result, ISQLScriptActivation callback) throws IOException, ActivationException {
		logger.debug("Found '&'");
		StringBuilder variabletext = new StringBuilder();
		reader.mark(1);
		int r = reader.read();
		if (r != -1) {
			char c = (char) r;
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == '_') {
				do {
					c = (char) r;
					switch (c) {
					case '\r':
					case '\n':
					case ' ':
						logger.debug("Found variable is {}", variabletext.toString());
						text.append(callback.fireAlias(variabletext.toString()));
						text.append(c);
						return;
					case ';':
						logger.debug("Found variable is {}", variabletext.toString());
						text.append(callback.fireAlias(variabletext.toString()));
						reader.reset();
						return;
					default:
						variabletext.append(c);
						break;
					}
					reader.mark(1);
					r = reader.read();
				} while (r != -1);
			} else {
				logger.debug("Found '&' is part of normal text");
				reader.reset();
				text.append('&');
			}
		}
	}

	private static void parseComment(Reader reader, StringBuilder text, ActivationResult result, ISQLScriptActivation callback, int level, char commentchar) throws IOException, ActivationException, AppContainerSQLException {
		logger.debug("Found '{}'", commentchar);
		StringBuilder commenttext = new StringBuilder();
		// look ahead if that truly is a // line comment
		reader.mark(1);
		int r = reader.read();
		if (r != -1) {
			char c = (char) r;
			if (commentchar == '/' && c == '/') {
				while ((r = reader.read()) != -1) {
					c = (char) r;
					switch (c) {
					case '\r':
					case '\n':
						logger.debug("Found comment is {}", commenttext.toString());
						if (level == 0) {
							callback.fireLineComment(commenttext.toString());
						} else {
							text.append("//").append(commenttext);
						}
						return;
					case '$':
						parseAlias(reader, commenttext, result, callback);
						break;
					default:
						commenttext.append(c);
					}
				}
			} else if (commentchar == '-' && c == '-') {
				while ((r = reader.read()) != -1) {
					c = (char) r;
					switch (c) {
					case '\r':
					case '\n':
						logger.debug("Found comment is {}", commenttext.toString());
						text.append("--").append(commenttext);
						return;
					case '$':
						parseAlias(reader, commenttext, result, callback);
						break;
					default:
						commenttext.append(c);
					}
				}
			} else if (commentchar == '/' && c == '*') {
				boolean star = false;
				while ((r = reader.read()) != -1) {
					c = (char) r;
					switch (c) {
					case '*':
						star = true;
						break;
					case '/':
						if (star) {
							logger.debug("Found comment is {}", commenttext.toString());
							if (level == 0) {
								callback.fireBlockComment(commenttext.toString());
							} else {
								text.append("/*").append(commenttext).append("*/");
							}
							return;
						} else {
							star = false;
							commenttext.append('*');
						}
						break;
					case '$':
						parseAlias(reader, commenttext, result, callback);
						break;
					default:
						star = false;
						commenttext.append(c);
					}
				}
			} else {
				logger.debug("Found '{}' is part of code", commentchar);
				// that is no comment
				text.append(commentchar);
				reader.reset();
			}
		} else {
			text.append(commentchar);
		}
	}
	
}
