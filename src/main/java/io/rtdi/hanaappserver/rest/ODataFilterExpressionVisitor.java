package io.rtdi.hanaappserver.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.olingo.commons.api.edm.EdmEnumType;
import org.apache.olingo.commons.api.edm.EdmType;
import org.apache.olingo.commons.api.http.HttpStatusCode;
import org.apache.olingo.server.api.ODataApplicationException;
import org.apache.olingo.server.api.uri.UriResource;
import org.apache.olingo.server.api.uri.UriResourcePrimitiveProperty;
import org.apache.olingo.server.api.uri.queryoption.expression.BinaryOperatorKind;
import org.apache.olingo.server.api.uri.queryoption.expression.Expression;
import org.apache.olingo.server.api.uri.queryoption.expression.ExpressionVisitException;
import org.apache.olingo.server.api.uri.queryoption.expression.ExpressionVisitor;
import org.apache.olingo.server.api.uri.queryoption.expression.Literal;
import org.apache.olingo.server.api.uri.queryoption.expression.Member;
import org.apache.olingo.server.api.uri.queryoption.expression.MethodKind;
import org.apache.olingo.server.api.uri.queryoption.expression.UnaryOperatorKind;

public class ODataFilterExpressionVisitor implements ExpressionVisitor<String> {

	private static final Map<BinaryOperatorKind, String> BINARY_OPERATORS = new HashMap<BinaryOperatorKind, String>();
	static {
		BINARY_OPERATORS.put(BinaryOperatorKind.ADD, " + ");
		BINARY_OPERATORS.put(BinaryOperatorKind.AND, " AND ");
		BINARY_OPERATORS.put(BinaryOperatorKind.DIV, " / ");
		BINARY_OPERATORS.put(BinaryOperatorKind.EQ, " = ");
		BINARY_OPERATORS.put(BinaryOperatorKind.GE, " >= ");
		BINARY_OPERATORS.put(BinaryOperatorKind.GT, " > ");
		BINARY_OPERATORS.put(BinaryOperatorKind.LE, " =< ");
		BINARY_OPERATORS.put(BinaryOperatorKind.LT, " < ");
		BINARY_OPERATORS.put(BinaryOperatorKind.MOD, " % ");
		BINARY_OPERATORS.put(BinaryOperatorKind.MUL, " * ");
		BINARY_OPERATORS.put(BinaryOperatorKind.NE, " <> ");
		BINARY_OPERATORS.put(BinaryOperatorKind.OR, " OR ");
		BINARY_OPERATORS.put(BinaryOperatorKind.SUB, " - ");
	};

	public ODataFilterExpressionVisitor() {
	}

	@Override
	public String visitBinaryOperator(BinaryOperatorKind operator, String left, List<String> right)
			throws ExpressionVisitException, ODataApplicationException {
		throw new ODataApplicationException("Binary operator with list not implemented: " + operator,
				HttpStatusCode.NOT_IMPLEMENTED.getStatusCode(), Locale.ENGLISH);
	}


	@Override
	public String visitBinaryOperator(BinaryOperatorKind operator, String left, String right)
			throws ExpressionVisitException, ODataApplicationException {
		String strOperator = BINARY_OPERATORS.get(operator);

		if (strOperator == null) {
			throw new ODataApplicationException("Unsupported binary operation: " + operator.name(),
					operator == BinaryOperatorKind.HAS ?
							HttpStatusCode.NOT_IMPLEMENTED.getStatusCode() :
								HttpStatusCode.BAD_REQUEST.getStatusCode(), Locale.ENGLISH);
		}
		return "( " + left + strOperator + right + " )";
	}

	@Override
	public String visitUnaryOperator(UnaryOperatorKind operator, String operand)
			throws ExpressionVisitException, ODataApplicationException {
		switch (operator) {
		case NOT:
			return "NOT " + operand;
		case MINUS:
			return "-" + operand;
		}
		throw new ODataApplicationException("Wrong unary operator: " + operator,
				HttpStatusCode.BAD_REQUEST.getStatusCode(), Locale.ENGLISH);
	}

	@Override
	public String visitMethodCall(MethodKind methodCall, List<String> parameters)
			throws ExpressionVisitException, ODataApplicationException {
		if (parameters.isEmpty() && methodCall.equals(MethodKind.NOW)) {
			return "CURRENT_DATE";
		}
		String firsEntityParam = parameters.get(0);
		switch (methodCall) {
		case CONTAINS:
			return firsEntityParam + " LIKE '%" + extractFromStringValue(parameters.get(1)) + "%'";
		case STARTSWITH:
			return firsEntityParam + " LIKE '" + extractFromStringValue(parameters.get(1)) + "%'";
		case ENDSWITH:
			return firsEntityParam + " LIKE '%" + extractFromStringValue(parameters.get(1));
		case DAY:
			return "DAY(" + firsEntityParam + ")";
		case MONTH:
			return "MONTH(" + firsEntityParam + ")";
		case YEAR:
			return "YEAR(" + firsEntityParam + ")";
		default:
			throw new ODataApplicationException("Method call " + methodCall + " not implemented",
					HttpStatusCode.NOT_IMPLEMENTED.getStatusCode(), Locale.ENGLISH);
		}
	}

	@Override
	public String visitLiteral(Literal literal) throws ExpressionVisitException, ODataApplicationException {
		String literalAsString = literal.getText();
		if (literal.getType() == null) {
			literalAsString = "NULL";
		}
		return literalAsString;
	}

	@Override
	public String visitMember(Member member) throws ExpressionVisitException, ODataApplicationException {
		List<UriResource> resources = member.getResourcePath().getUriResourceParts();

		UriResource first = resources.get(0);

		// TODO: Enum and ComplexType; joins
		if (resources.size() == 1 && first instanceof UriResourcePrimitiveProperty) {
			UriResourcePrimitiveProperty primitiveProperty = (UriResourcePrimitiveProperty) first;
			return primitiveProperty.getProperty().getName();
		} else {
			throw new ODataApplicationException("Only primitive properties are implemented in filter expressions",
					HttpStatusCode.NOT_IMPLEMENTED.getStatusCode(), Locale.ENGLISH);
		}
	}

	@Override
	public String visitEnum(EdmEnumType type, List<String> enumValues)
			throws ExpressionVisitException, ODataApplicationException {
		throw new ODataApplicationException("Enums are not implemented", HttpStatusCode.NOT_IMPLEMENTED.getStatusCode(),
				Locale.ENGLISH);
	}

	@Override
	public String visitLambdaExpression(String lambdaFunction, String lambdaVariable, Expression expression)
			throws ExpressionVisitException, ODataApplicationException {
		throw new ODataApplicationException("Lambda expressions are not implemented",
				HttpStatusCode.NOT_IMPLEMENTED.getStatusCode(), Locale.ENGLISH);
	}

	@Override
	public String visitAlias(String aliasName) throws ExpressionVisitException, ODataApplicationException {
		throw new ODataApplicationException("Aliases are not implemented",
				HttpStatusCode.NOT_IMPLEMENTED.getStatusCode(), Locale.ENGLISH);
	}

	@Override
	public String visitTypeLiteral(EdmType type) throws ExpressionVisitException, ODataApplicationException {
		throw new ODataApplicationException("Type literals are not implemented",
				HttpStatusCode.NOT_IMPLEMENTED.getStatusCode(), Locale.ENGLISH);
	}

	@Override
	public String visitLambdaReference(String variableName) throws ExpressionVisitException, ODataApplicationException {
		throw new ODataApplicationException("Lambda references are not implemented",
				HttpStatusCode.NOT_IMPLEMENTED.getStatusCode(), Locale.ENGLISH);
	}

	private String extractFromStringValue(String val) {
		return val.substring(1, val.length() - 1);
	}

}