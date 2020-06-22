// Generated from HDBCDSParser.g4 by ANTLR 4.8
package io.rtdi.hanaappcontainer.antlr.sql;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HDBCDSParser}.
 */
public interface HDBCDSParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(HDBCDSParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(HDBCDSParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#NAMESPACE_SYMBOL}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(HDBCDSParser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#NAMESPACE_SYMBOL}.
	 * @param ctx the parse tree
	 */
	void exitNamespace(HDBCDSParser.NamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#context}.
	 * @param ctx the parse tree
	 */
	void enterContext(HDBCDSParser.ContextContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#context}.
	 * @param ctx the parse tree
	 */
	void exitContext(HDBCDSParser.ContextContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#primitivetype}.
	 * @param ctx the parse tree
	 */
	void enterPrimitivetype(HDBCDSParser.PrimitivetypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#primitivetype}.
	 * @param ctx the parse tree
	 */
	void exitPrimitivetype(HDBCDSParser.PrimitivetypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#complextype}.
	 * @param ctx the parse tree
	 */
	void enterComplextype(HDBCDSParser.ComplextypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#complextype}.
	 * @param ctx the parse tree
	 */
	void exitComplextype(HDBCDSParser.ComplextypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(HDBCDSParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(HDBCDSParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#typecolumn}.
	 * @param ctx the parse tree
	 */
	void enterTypecolumn(HDBCDSParser.TypecolumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#typecolumn}.
	 * @param ctx the parse tree
	 */
	void exitTypecolumn(HDBCDSParser.TypecolumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#columndefault}.
	 * @param ctx the parse tree
	 */
	void enterColumndefault(HDBCDSParser.ColumndefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#columndefault}.
	 * @param ctx the parse tree
	 */
	void exitColumndefault(HDBCDSParser.ColumndefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#columnnullable}.
	 * @param ctx the parse tree
	 */
	void enterColumnnullable(HDBCDSParser.ColumnnullableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#columnnullable}.
	 * @param ctx the parse tree
	 */
	void exitColumnnullable(HDBCDSParser.ColumnnullableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#typenameprimitive}.
	 * @param ctx the parse tree
	 */
	void enterTypenameprimitive(HDBCDSParser.TypenameprimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#typenameprimitive}.
	 * @param ctx the parse tree
	 */
	void exitTypenameprimitive(HDBCDSParser.TypenameprimitiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#typenamecomplex}.
	 * @param ctx the parse tree
	 */
	void enterTypenamecomplex(HDBCDSParser.TypenamecomplexContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#typenamecomplex}.
	 * @param ctx the parse tree
	 */
	void exitTypenamecomplex(HDBCDSParser.TypenamecomplexContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#typecolumnname}.
	 * @param ctx the parse tree
	 */
	void enterTypecolumnname(HDBCDSParser.TypecolumnnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#typecolumnname}.
	 * @param ctx the parse tree
	 */
	void exitTypecolumnname(HDBCDSParser.TypecolumnnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#contextname}.
	 * @param ctx the parse tree
	 */
	void enterContextname(HDBCDSParser.ContextnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#contextname}.
	 * @param ctx the parse tree
	 */
	void exitContextname(HDBCDSParser.ContextnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(HDBCDSParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(HDBCDSParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#constantname}.
	 * @param ctx the parse tree
	 */
	void enterConstantname(HDBCDSParser.ConstantnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#constantname}.
	 * @param ctx the parse tree
	 */
	void exitConstantname(HDBCDSParser.ConstantnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterDatatype(HDBCDSParser.DatatypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitDatatype(HDBCDSParser.DatatypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(HDBCDSParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(HDBCDSParser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#entityname}.
	 * @param ctx the parse tree
	 */
	void enterEntityname(HDBCDSParser.EntitynameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#entityname}.
	 * @param ctx the parse tree
	 */
	void exitEntityname(HDBCDSParser.EntitynameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tablecolumn}.
	 * @param ctx the parse tree
	 */
	void enterTablecolumn(HDBCDSParser.TablecolumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tablecolumn}.
	 * @param ctx the parse tree
	 */
	void exitTablecolumn(HDBCDSParser.TablecolumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#keycolumn}.
	 * @param ctx the parse tree
	 */
	void enterKeycolumn(HDBCDSParser.KeycolumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#keycolumn}.
	 * @param ctx the parse tree
	 */
	void exitKeycolumn(HDBCDSParser.KeycolumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#regularcolumn}.
	 * @param ctx the parse tree
	 */
	void enterRegularcolumn(HDBCDSParser.RegularcolumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#regularcolumn}.
	 * @param ctx the parse tree
	 */
	void exitRegularcolumn(HDBCDSParser.RegularcolumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#entitycolumnname}.
	 * @param ctx the parse tree
	 */
	void enterEntitycolumnname(HDBCDSParser.EntitycolumnnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#entitycolumnname}.
	 * @param ctx the parse tree
	 */
	void exitEntitycolumnname(HDBCDSParser.EntitycolumnnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#association}.
	 * @param ctx the parse tree
	 */
	void enterAssociation(HDBCDSParser.AssociationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#association}.
	 * @param ctx the parse tree
	 */
	void exitAssociation(HDBCDSParser.AssociationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#associationreferenceto}.
	 * @param ctx the parse tree
	 */
	void enterAssociationreferenceto(HDBCDSParser.AssociationreferencetoContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#associationreferenceto}.
	 * @param ctx the parse tree
	 */
	void exitAssociationreferenceto(HDBCDSParser.AssociationreferencetoContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#associationjoinexpr}.
	 * @param ctx the parse tree
	 */
	void enterAssociationjoinexpr(HDBCDSParser.AssociationjoinexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#associationjoinexpr}.
	 * @param ctx the parse tree
	 */
	void exitAssociationjoinexpr(HDBCDSParser.AssociationjoinexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#associationfromcardinality}.
	 * @param ctx the parse tree
	 */
	void enterAssociationfromcardinality(HDBCDSParser.AssociationfromcardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#associationfromcardinality}.
	 * @param ctx the parse tree
	 */
	void exitAssociationfromcardinality(HDBCDSParser.AssociationfromcardinalityContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#associationtocardinality}.
	 * @param ctx the parse tree
	 */
	void enterAssociationtocardinality(HDBCDSParser.AssociationtocardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#associationtocardinality}.
	 * @param ctx the parse tree
	 */
	void exitAssociationtocardinality(HDBCDSParser.AssociationtocardinalityContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#associatedcols}.
	 * @param ctx the parse tree
	 */
	void enterAssociatedcols(HDBCDSParser.AssociatedcolsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#associatedcols}.
	 * @param ctx the parse tree
	 */
	void exitAssociatedcols(HDBCDSParser.AssociatedcolsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#associatedcolname}.
	 * @param ctx the parse tree
	 */
	void enterAssociatedcolname(HDBCDSParser.AssociatedcolnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#associatedcolname}.
	 * @param ctx the parse tree
	 */
	void exitAssociatedcolname(HDBCDSParser.AssociatedcolnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#generated}.
	 * @param ctx the parse tree
	 */
	void enterGenerated(HDBCDSParser.GeneratedContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#generated}.
	 * @param ctx the parse tree
	 */
	void exitGenerated(HDBCDSParser.GeneratedContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#generatedalways}.
	 * @param ctx the parse tree
	 */
	void enterGeneratedalways(HDBCDSParser.GeneratedalwaysContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#generatedalways}.
	 * @param ctx the parse tree
	 */
	void exitGeneratedalways(HDBCDSParser.GeneratedalwaysContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#generatedbydefault}.
	 * @param ctx the parse tree
	 */
	void enterGeneratedbydefault(HDBCDSParser.GeneratedbydefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#generatedbydefault}.
	 * @param ctx the parse tree
	 */
	void exitGeneratedbydefault(HDBCDSParser.GeneratedbydefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identitystart}.
	 * @param ctx the parse tree
	 */
	void enterIdentitystart(HDBCDSParser.IdentitystartContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identitystart}.
	 * @param ctx the parse tree
	 */
	void exitIdentitystart(HDBCDSParser.IdentitystartContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identityincrement}.
	 * @param ctx the parse tree
	 */
	void enterIdentityincrement(HDBCDSParser.IdentityincrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identityincrement}.
	 * @param ctx the parse tree
	 */
	void exitIdentityincrement(HDBCDSParser.IdentityincrementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identityminclause}.
	 * @param ctx the parse tree
	 */
	void enterIdentityminclause(HDBCDSParser.IdentityminclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identityminclause}.
	 * @param ctx the parse tree
	 */
	void exitIdentityminclause(HDBCDSParser.IdentityminclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identitynomin}.
	 * @param ctx the parse tree
	 */
	void enterIdentitynomin(HDBCDSParser.IdentitynominContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identitynomin}.
	 * @param ctx the parse tree
	 */
	void exitIdentitynomin(HDBCDSParser.IdentitynominContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identitymin}.
	 * @param ctx the parse tree
	 */
	void enterIdentitymin(HDBCDSParser.IdentityminContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identitymin}.
	 * @param ctx the parse tree
	 */
	void exitIdentitymin(HDBCDSParser.IdentityminContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identitymaxclause}.
	 * @param ctx the parse tree
	 */
	void enterIdentitymaxclause(HDBCDSParser.IdentitymaxclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identitymaxclause}.
	 * @param ctx the parse tree
	 */
	void exitIdentitymaxclause(HDBCDSParser.IdentitymaxclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identitynomax}.
	 * @param ctx the parse tree
	 */
	void enterIdentitynomax(HDBCDSParser.IdentitynomaxContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identitynomax}.
	 * @param ctx the parse tree
	 */
	void exitIdentitynomax(HDBCDSParser.IdentitynomaxContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identitymax}.
	 * @param ctx the parse tree
	 */
	void enterIdentitymax(HDBCDSParser.IdentitymaxContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identitymax}.
	 * @param ctx the parse tree
	 */
	void exitIdentitymax(HDBCDSParser.IdentitymaxContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identitynochache}.
	 * @param ctx the parse tree
	 */
	void enterIdentitynochache(HDBCDSParser.IdentitynochacheContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identitynochache}.
	 * @param ctx the parse tree
	 */
	void exitIdentitynochache(HDBCDSParser.IdentitynochacheContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identitynocycle}.
	 * @param ctx the parse tree
	 */
	void enterIdentitynocycle(HDBCDSParser.IdentitynocycleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identitynocycle}.
	 * @param ctx the parse tree
	 */
	void exitIdentitynocycle(HDBCDSParser.IdentitynocycleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#techconfig}.
	 * @param ctx the parse tree
	 */
	void enterTechconfig(HDBCDSParser.TechconfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#techconfig}.
	 * @param ctx the parse tree
	 */
	void exitTechconfig(HDBCDSParser.TechconfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tabletype}.
	 * @param ctx the parse tree
	 */
	void enterTabletype(HDBCDSParser.TabletypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tabletype}.
	 * @param ctx the parse tree
	 */
	void exitTabletype(HDBCDSParser.TabletypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tabletype1}.
	 * @param ctx the parse tree
	 */
	void enterTabletype1(HDBCDSParser.Tabletype1Context ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tabletype1}.
	 * @param ctx the parse tree
	 */
	void exitTabletype1(HDBCDSParser.Tabletype1Context ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tabletype2}.
	 * @param ctx the parse tree
	 */
	void enterTabletype2(HDBCDSParser.Tabletype2Context ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tabletype2}.
	 * @param ctx the parse tree
	 */
	void exitTabletype2(HDBCDSParser.Tabletype2Context ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(HDBCDSParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(HDBCDSParser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#viewname}.
	 * @param ctx the parse tree
	 */
	void enterViewname(HDBCDSParser.ViewnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#viewname}.
	 * @param ctx the parse tree
	 */
	void exitViewname(HDBCDSParser.ViewnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#viewprojectionlist}.
	 * @param ctx the parse tree
	 */
	void enterViewprojectionlist(HDBCDSParser.ViewprojectionlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#viewprojectionlist}.
	 * @param ctx the parse tree
	 */
	void exitViewprojectionlist(HDBCDSParser.ViewprojectionlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#viewoptions}.
	 * @param ctx the parse tree
	 */
	void enterViewoptions(HDBCDSParser.ViewoptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#viewoptions}.
	 * @param ctx the parse tree
	 */
	void exitViewoptions(HDBCDSParser.ViewoptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#viewprivcheck}.
	 * @param ctx the parse tree
	 */
	void enterViewprivcheck(HDBCDSParser.ViewprivcheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#viewprivcheck}.
	 * @param ctx the parse tree
	 */
	void exitViewprivcheck(HDBCDSParser.ViewprivcheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#datatype1}.
	 * @param ctx the parse tree
	 */
	void enterDatatype1(HDBCDSParser.Datatype1Context ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#datatype1}.
	 * @param ctx the parse tree
	 */
	void exitDatatype1(HDBCDSParser.Datatype1Context ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#datatype2}.
	 * @param ctx the parse tree
	 */
	void enterDatatype2(HDBCDSParser.Datatype2Context ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#datatype2}.
	 * @param ctx the parse tree
	 */
	void exitDatatype2(HDBCDSParser.Datatype2Context ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#datatype3}.
	 * @param ctx the parse tree
	 */
	void enterDatatype3(HDBCDSParser.Datatype3Context ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#datatype3}.
	 * @param ctx the parse tree
	 */
	void exitDatatype3(HDBCDSParser.Datatype3Context ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(HDBCDSParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(HDBCDSParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpression(HDBCDSParser.QueryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpression(HDBCDSParser.QueryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#queryExpressionBody}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpressionBody(HDBCDSParser.QueryExpressionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#queryExpressionBody}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpressionBody(HDBCDSParser.QueryExpressionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#queryExpressionParens}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpressionParens(HDBCDSParser.QueryExpressionParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#queryExpressionParens}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpressionParens(HDBCDSParser.QueryExpressionParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(HDBCDSParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(HDBCDSParser.QuerySpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(HDBCDSParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(HDBCDSParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#querySpecOption}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecOption(HDBCDSParser.QuerySpecOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#querySpecOption}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecOption(HDBCDSParser.QuerySpecOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(HDBCDSParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(HDBCDSParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#simpleLimitClause}.
	 * @param ctx the parse tree
	 */
	void enterSimpleLimitClause(HDBCDSParser.SimpleLimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#simpleLimitClause}.
	 * @param ctx the parse tree
	 */
	void exitSimpleLimitClause(HDBCDSParser.SimpleLimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#limitOptions}.
	 * @param ctx the parse tree
	 */
	void enterLimitOptions(HDBCDSParser.LimitOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#limitOptions}.
	 * @param ctx the parse tree
	 */
	void exitLimitOptions(HDBCDSParser.LimitOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#limitOption}.
	 * @param ctx the parse tree
	 */
	void enterLimitOption(HDBCDSParser.LimitOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#limitOption}.
	 * @param ctx the parse tree
	 */
	void exitLimitOption(HDBCDSParser.LimitOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(HDBCDSParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(HDBCDSParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowClause(HDBCDSParser.WindowClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowClause(HDBCDSParser.WindowClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowDefinition}.
	 * @param ctx the parse tree
	 */
	void enterWindowDefinition(HDBCDSParser.WindowDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowDefinition}.
	 * @param ctx the parse tree
	 */
	void exitWindowDefinition(HDBCDSParser.WindowDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void enterWindowSpec(HDBCDSParser.WindowSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void exitWindowSpec(HDBCDSParser.WindowSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowSpecDetails}.
	 * @param ctx the parse tree
	 */
	void enterWindowSpecDetails(HDBCDSParser.WindowSpecDetailsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowSpecDetails}.
	 * @param ctx the parse tree
	 */
	void exitWindowSpecDetails(HDBCDSParser.WindowSpecDetailsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowFrameClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameClause(HDBCDSParser.WindowFrameClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowFrameClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameClause(HDBCDSParser.WindowFrameClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowFrameUnits}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameUnits(HDBCDSParser.WindowFrameUnitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowFrameUnits}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameUnits(HDBCDSParser.WindowFrameUnitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameExtent(HDBCDSParser.WindowFrameExtentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameExtent(HDBCDSParser.WindowFrameExtentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowFrameStart}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameStart(HDBCDSParser.WindowFrameStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowFrameStart}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameStart(HDBCDSParser.WindowFrameStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowFrameBetween}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameBetween(HDBCDSParser.WindowFrameBetweenContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowFrameBetween}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameBetween(HDBCDSParser.WindowFrameBetweenContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowFrameBound}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameBound(HDBCDSParser.WindowFrameBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowFrameBound}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameBound(HDBCDSParser.WindowFrameBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowFrameExclusion}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameExclusion(HDBCDSParser.WindowFrameExclusionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowFrameExclusion}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameExclusion(HDBCDSParser.WindowFrameExclusionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#withClause}.
	 * @param ctx the parse tree
	 */
	void enterWithClause(HDBCDSParser.WithClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#withClause}.
	 * @param ctx the parse tree
	 */
	void exitWithClause(HDBCDSParser.WithClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#commonTableExpression}.
	 * @param ctx the parse tree
	 */
	void enterCommonTableExpression(HDBCDSParser.CommonTableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#commonTableExpression}.
	 * @param ctx the parse tree
	 */
	void exitCommonTableExpression(HDBCDSParser.CommonTableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(HDBCDSParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(HDBCDSParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#orderClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderClause(HDBCDSParser.OrderClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#orderClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderClause(HDBCDSParser.OrderClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#direction}.
	 * @param ctx the parse tree
	 */
	void enterDirection(HDBCDSParser.DirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#direction}.
	 * @param ctx the parse tree
	 */
	void exitDirection(HDBCDSParser.DirectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(HDBCDSParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(HDBCDSParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tableReferenceList}.
	 * @param ctx the parse tree
	 */
	void enterTableReferenceList(HDBCDSParser.TableReferenceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tableReferenceList}.
	 * @param ctx the parse tree
	 */
	void exitTableReferenceList(HDBCDSParser.TableReferenceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#selectOption}.
	 * @param ctx the parse tree
	 */
	void enterSelectOption(HDBCDSParser.SelectOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#selectOption}.
	 * @param ctx the parse tree
	 */
	void exitSelectOption(HDBCDSParser.SelectOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#lockingClause}.
	 * @param ctx the parse tree
	 */
	void enterLockingClause(HDBCDSParser.LockingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#lockingClause}.
	 * @param ctx the parse tree
	 */
	void exitLockingClause(HDBCDSParser.LockingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#lockStrengh}.
	 * @param ctx the parse tree
	 */
	void enterLockStrengh(HDBCDSParser.LockStrenghContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#lockStrengh}.
	 * @param ctx the parse tree
	 */
	void exitLockStrengh(HDBCDSParser.LockStrenghContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#lockedRowAction}.
	 * @param ctx the parse tree
	 */
	void enterLockedRowAction(HDBCDSParser.LockedRowActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#lockedRowAction}.
	 * @param ctx the parse tree
	 */
	void exitLockedRowAction(HDBCDSParser.LockedRowActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#selectItemList}.
	 * @param ctx the parse tree
	 */
	void enterSelectItemList(HDBCDSParser.SelectItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#selectItemList}.
	 * @param ctx the parse tree
	 */
	void exitSelectItemList(HDBCDSParser.SelectItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void enterSelectItem(HDBCDSParser.SelectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void exitSelectItem(HDBCDSParser.SelectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#selectAlias}.
	 * @param ctx the parse tree
	 */
	void enterSelectAlias(HDBCDSParser.SelectAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#selectAlias}.
	 * @param ctx the parse tree
	 */
	void exitSelectAlias(HDBCDSParser.SelectAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(HDBCDSParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(HDBCDSParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tableReference}.
	 * @param ctx the parse tree
	 */
	void enterTableReference(HDBCDSParser.TableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tableReference}.
	 * @param ctx the parse tree
	 */
	void exitTableReference(HDBCDSParser.TableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#escapedTableReference}.
	 * @param ctx the parse tree
	 */
	void enterEscapedTableReference(HDBCDSParser.EscapedTableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#escapedTableReference}.
	 * @param ctx the parse tree
	 */
	void exitEscapedTableReference(HDBCDSParser.EscapedTableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#joinedTable}.
	 * @param ctx the parse tree
	 */
	void enterJoinedTable(HDBCDSParser.JoinedTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#joinedTable}.
	 * @param ctx the parse tree
	 */
	void exitJoinedTable(HDBCDSParser.JoinedTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#innerJoinType}.
	 * @param ctx the parse tree
	 */
	void enterInnerJoinType(HDBCDSParser.InnerJoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#innerJoinType}.
	 * @param ctx the parse tree
	 */
	void exitInnerJoinType(HDBCDSParser.InnerJoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#outerJoinType}.
	 * @param ctx the parse tree
	 */
	void enterOuterJoinType(HDBCDSParser.OuterJoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#outerJoinType}.
	 * @param ctx the parse tree
	 */
	void exitOuterJoinType(HDBCDSParser.OuterJoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tableFactor}.
	 * @param ctx the parse tree
	 */
	void enterTableFactor(HDBCDSParser.TableFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tableFactor}.
	 * @param ctx the parse tree
	 */
	void exitTableFactor(HDBCDSParser.TableFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#singleTable}.
	 * @param ctx the parse tree
	 */
	void enterSingleTable(HDBCDSParser.SingleTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#singleTable}.
	 * @param ctx the parse tree
	 */
	void exitSingleTable(HDBCDSParser.SingleTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#singleTableParens}.
	 * @param ctx the parse tree
	 */
	void enterSingleTableParens(HDBCDSParser.SingleTableParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#singleTableParens}.
	 * @param ctx the parse tree
	 */
	void exitSingleTableParens(HDBCDSParser.SingleTableParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#derivedTable}.
	 * @param ctx the parse tree
	 */
	void enterDerivedTable(HDBCDSParser.DerivedTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#derivedTable}.
	 * @param ctx the parse tree
	 */
	void exitDerivedTable(HDBCDSParser.DerivedTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tableReferenceListParens}.
	 * @param ctx the parse tree
	 */
	void enterTableReferenceListParens(HDBCDSParser.TableReferenceListParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tableReferenceListParens}.
	 * @param ctx the parse tree
	 */
	void exitTableReferenceListParens(HDBCDSParser.TableReferenceListParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#unionOption}.
	 * @param ctx the parse tree
	 */
	void enterUnionOption(HDBCDSParser.UnionOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#unionOption}.
	 * @param ctx the parse tree
	 */
	void exitUnionOption(HDBCDSParser.UnionOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void enterTableAlias(HDBCDSParser.TableAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void exitTableAlias(HDBCDSParser.TableAliasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link HDBCDSParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(HDBCDSParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link HDBCDSParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(HDBCDSParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNot}
	 * labeled alternative in {@link HDBCDSParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNot(HDBCDSParser.ExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNot}
	 * labeled alternative in {@link HDBCDSParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNot(HDBCDSParser.ExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIs}
	 * labeled alternative in {@link HDBCDSParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIs(HDBCDSParser.ExprIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIs}
	 * labeled alternative in {@link HDBCDSParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIs(HDBCDSParser.ExprIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link HDBCDSParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(HDBCDSParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link HDBCDSParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(HDBCDSParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprPredicate}
	 * labeled alternative in {@link HDBCDSParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprPredicate(HDBCDSParser.PrimaryExprPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprPredicate}
	 * labeled alternative in {@link HDBCDSParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprPredicate(HDBCDSParser.PrimaryExprPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprCompare}
	 * labeled alternative in {@link HDBCDSParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprCompare(HDBCDSParser.PrimaryExprCompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprCompare}
	 * labeled alternative in {@link HDBCDSParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprCompare(HDBCDSParser.PrimaryExprCompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprAllAny}
	 * labeled alternative in {@link HDBCDSParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprAllAny(HDBCDSParser.PrimaryExprAllAnyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprAllAny}
	 * labeled alternative in {@link HDBCDSParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprAllAny(HDBCDSParser.PrimaryExprAllAnyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprIsNull}
	 * labeled alternative in {@link HDBCDSParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprIsNull(HDBCDSParser.PrimaryExprIsNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprIsNull}
	 * labeled alternative in {@link HDBCDSParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprIsNull(HDBCDSParser.PrimaryExprIsNullContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(HDBCDSParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(HDBCDSParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(HDBCDSParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(HDBCDSParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExprIn}
	 * labeled alternative in {@link HDBCDSParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExprIn(HDBCDSParser.PredicateExprInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExprIn}
	 * labeled alternative in {@link HDBCDSParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExprIn(HDBCDSParser.PredicateExprInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExprBetween}
	 * labeled alternative in {@link HDBCDSParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExprBetween(HDBCDSParser.PredicateExprBetweenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExprBetween}
	 * labeled alternative in {@link HDBCDSParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExprBetween(HDBCDSParser.PredicateExprBetweenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExprLike}
	 * labeled alternative in {@link HDBCDSParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExprLike(HDBCDSParser.PredicateExprLikeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExprLike}
	 * labeled alternative in {@link HDBCDSParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExprLike(HDBCDSParser.PredicateExprLikeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#bitExpr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpr(HDBCDSParser.BitExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#bitExpr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpr(HDBCDSParser.BitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprColumnRef}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprColumnRef(HDBCDSParser.SimpleExprColumnRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprColumnRef}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprColumnRef(HDBCDSParser.SimpleExprColumnRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprParamMarker}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprParamMarker(HDBCDSParser.SimpleExprParamMarkerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprParamMarker}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprParamMarker(HDBCDSParser.SimpleExprParamMarkerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprSum}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprSum(HDBCDSParser.SimpleExprSumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprSum}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprSum(HDBCDSParser.SimpleExprSumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprCast}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprCast(HDBCDSParser.SimpleExprCastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprCast}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprCast(HDBCDSParser.SimpleExprCastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprUnary}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprUnary(HDBCDSParser.SimpleExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprUnary}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprUnary(HDBCDSParser.SimpleExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprSubQuery}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprSubQuery(HDBCDSParser.SimpleExprSubQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprSubQuery}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprSubQuery(HDBCDSParser.SimpleExprSubQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprGroupingOperation}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprGroupingOperation(HDBCDSParser.SimpleExprGroupingOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprGroupingOperation}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprGroupingOperation(HDBCDSParser.SimpleExprGroupingOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprNot}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprNot(HDBCDSParser.SimpleExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprNot}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprNot(HDBCDSParser.SimpleExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprOdbc}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprOdbc(HDBCDSParser.SimpleExprOdbcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprOdbc}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprOdbc(HDBCDSParser.SimpleExprOdbcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprRuntimeFunction}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprRuntimeFunction(HDBCDSParser.SimpleExprRuntimeFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprRuntimeFunction}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprRuntimeFunction(HDBCDSParser.SimpleExprRuntimeFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprFunction}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprFunction(HDBCDSParser.SimpleExprFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprFunction}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprFunction(HDBCDSParser.SimpleExprFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprList}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprList(HDBCDSParser.SimpleExprListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprList}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprList(HDBCDSParser.SimpleExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprCase}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprCase(HDBCDSParser.SimpleExprCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprCase}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprCase(HDBCDSParser.SimpleExprCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprConcat}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprConcat(HDBCDSParser.SimpleExprConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprConcat}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprConcat(HDBCDSParser.SimpleExprConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprLiteral}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprLiteral(HDBCDSParser.SimpleExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprLiteral}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprLiteral(HDBCDSParser.SimpleExprLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprWindowingFunction}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprWindowingFunction(HDBCDSParser.SimpleExprWindowingFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprWindowingFunction}
	 * labeled alternative in {@link HDBCDSParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprWindowingFunction(HDBCDSParser.SimpleExprWindowingFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#sumExpr}.
	 * @param ctx the parse tree
	 */
	void enterSumExpr(HDBCDSParser.SumExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#sumExpr}.
	 * @param ctx the parse tree
	 */
	void exitSumExpr(HDBCDSParser.SumExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#groupingOperation}.
	 * @param ctx the parse tree
	 */
	void enterGroupingOperation(HDBCDSParser.GroupingOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#groupingOperation}.
	 * @param ctx the parse tree
	 */
	void exitGroupingOperation(HDBCDSParser.GroupingOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterWindowFunctionCall(HDBCDSParser.WindowFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitWindowFunctionCall(HDBCDSParser.WindowFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowingClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowingClause(HDBCDSParser.WindowingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowingClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowingClause(HDBCDSParser.WindowingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#leadLagInfo}.
	 * @param ctx the parse tree
	 */
	void enterLeadLagInfo(HDBCDSParser.LeadLagInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#leadLagInfo}.
	 * @param ctx the parse tree
	 */
	void exitLeadLagInfo(HDBCDSParser.LeadLagInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#inSumExpr}.
	 * @param ctx the parse tree
	 */
	void enterInSumExpr(HDBCDSParser.InSumExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#inSumExpr}.
	 * @param ctx the parse tree
	 */
	void exitInSumExpr(HDBCDSParser.InSumExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identListArg}.
	 * @param ctx the parse tree
	 */
	void enterIdentListArg(HDBCDSParser.IdentListArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identListArg}.
	 * @param ctx the parse tree
	 */
	void exitIdentListArg(HDBCDSParser.IdentListArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identList}.
	 * @param ctx the parse tree
	 */
	void enterIdentList(HDBCDSParser.IdentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identList}.
	 * @param ctx the parse tree
	 */
	void exitIdentList(HDBCDSParser.IdentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#runtimeFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterRuntimeFunctionCall(HDBCDSParser.RuntimeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#runtimeFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitRuntimeFunctionCall(HDBCDSParser.RuntimeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#timeFunctionParameters}.
	 * @param ctx the parse tree
	 */
	void enterTimeFunctionParameters(HDBCDSParser.TimeFunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#timeFunctionParameters}.
	 * @param ctx the parse tree
	 */
	void exitTimeFunctionParameters(HDBCDSParser.TimeFunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#fractionalPrecision}.
	 * @param ctx the parse tree
	 */
	void enterFractionalPrecision(HDBCDSParser.FractionalPrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#fractionalPrecision}.
	 * @param ctx the parse tree
	 */
	void exitFractionalPrecision(HDBCDSParser.FractionalPrecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#substringFunction}.
	 * @param ctx the parse tree
	 */
	void enterSubstringFunction(HDBCDSParser.SubstringFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#substringFunction}.
	 * @param ctx the parse tree
	 */
	void exitSubstringFunction(HDBCDSParser.SubstringFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(HDBCDSParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(HDBCDSParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#udfExprList}.
	 * @param ctx the parse tree
	 */
	void enterUdfExprList(HDBCDSParser.UdfExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#udfExprList}.
	 * @param ctx the parse tree
	 */
	void exitUdfExprList(HDBCDSParser.UdfExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#udfExpr}.
	 * @param ctx the parse tree
	 */
	void enterUdfExpr(HDBCDSParser.UdfExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#udfExpr}.
	 * @param ctx the parse tree
	 */
	void exitUdfExpr(HDBCDSParser.UdfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#whenExpression}.
	 * @param ctx the parse tree
	 */
	void enterWhenExpression(HDBCDSParser.WhenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#whenExpression}.
	 * @param ctx the parse tree
	 */
	void exitWhenExpression(HDBCDSParser.WhenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#thenExpression}.
	 * @param ctx the parse tree
	 */
	void enterThenExpression(HDBCDSParser.ThenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#thenExpression}.
	 * @param ctx the parse tree
	 */
	void exitThenExpression(HDBCDSParser.ThenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#elseExpression}.
	 * @param ctx the parse tree
	 */
	void enterElseExpression(HDBCDSParser.ElseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#elseExpression}.
	 * @param ctx the parse tree
	 */
	void exitElseExpression(HDBCDSParser.ElseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#castType}.
	 * @param ctx the parse tree
	 */
	void enterCastType(HDBCDSParser.CastTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#castType}.
	 * @param ctx the parse tree
	 */
	void exitCastType(HDBCDSParser.CastTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(HDBCDSParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(HDBCDSParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#notRule}.
	 * @param ctx the parse tree
	 */
	void enterNotRule(HDBCDSParser.NotRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#notRule}.
	 * @param ctx the parse tree
	 */
	void exitNotRule(HDBCDSParser.NotRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#not2Rule}.
	 * @param ctx the parse tree
	 */
	void enterNot2Rule(HDBCDSParser.Not2RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#not2Rule}.
	 * @param ctx the parse tree
	 */
	void exitNot2Rule(HDBCDSParser.Not2RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#exprListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterExprListWithParentheses(HDBCDSParser.ExprListWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#exprListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitExprListWithParentheses(HDBCDSParser.ExprListWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#exprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterExprWithParentheses(HDBCDSParser.ExprWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#exprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitExprWithParentheses(HDBCDSParser.ExprWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#simpleExprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprWithParentheses(HDBCDSParser.SimpleExprWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#simpleExprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprWithParentheses(HDBCDSParser.SimpleExprWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#orderList}.
	 * @param ctx the parse tree
	 */
	void enterOrderList(HDBCDSParser.OrderListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#orderList}.
	 * @param ctx the parse tree
	 */
	void exitOrderList(HDBCDSParser.OrderListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#orderExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrderExpression(HDBCDSParser.OrderExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#orderExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrderExpression(HDBCDSParser.OrderExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#groupList}.
	 * @param ctx the parse tree
	 */
	void enterGroupList(HDBCDSParser.GroupListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#groupList}.
	 * @param ctx the parse tree
	 */
	void exitGroupList(HDBCDSParser.GroupListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#groupingExpression}.
	 * @param ctx the parse tree
	 */
	void enterGroupingExpression(HDBCDSParser.GroupingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#groupingExpression}.
	 * @param ctx the parse tree
	 */
	void exitGroupingExpression(HDBCDSParser.GroupingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#pureIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterPureIdentifier(HDBCDSParser.PureIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#pureIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitPureIdentifier(HDBCDSParser.PureIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(HDBCDSParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(HDBCDSParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(HDBCDSParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(HDBCDSParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identifierListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierListWithParentheses(HDBCDSParser.IdentifierListWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identifierListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierListWithParentheses(HDBCDSParser.IdentifierListWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedIdentifier(HDBCDSParser.QualifiedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedIdentifier(HDBCDSParser.QualifiedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#simpleIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSimpleIdentifier(HDBCDSParser.SimpleIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#simpleIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSimpleIdentifier(HDBCDSParser.SimpleIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#dotIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterDotIdentifier(HDBCDSParser.DotIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#dotIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitDotIdentifier(HDBCDSParser.DotIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#ulong_number}.
	 * @param ctx the parse tree
	 */
	void enterUlong_number(HDBCDSParser.Ulong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#ulong_number}.
	 * @param ctx the parse tree
	 */
	void exitUlong_number(HDBCDSParser.Ulong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#real_ulong_number}.
	 * @param ctx the parse tree
	 */
	void enterReal_ulong_number(HDBCDSParser.Real_ulong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#real_ulong_number}.
	 * @param ctx the parse tree
	 */
	void exitReal_ulong_number(HDBCDSParser.Real_ulong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void enterUlonglong_number(HDBCDSParser.Ulonglong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void exitUlonglong_number(HDBCDSParser.Ulonglong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#real_ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void enterReal_ulonglong_number(HDBCDSParser.Real_ulonglong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#real_ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void exitReal_ulonglong_number(HDBCDSParser.Real_ulonglong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(HDBCDSParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(HDBCDSParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#signedLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSignedLiteral(HDBCDSParser.SignedLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#signedLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSignedLiteral(HDBCDSParser.SignedLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#stringList}.
	 * @param ctx the parse tree
	 */
	void enterStringList(HDBCDSParser.StringListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#stringList}.
	 * @param ctx the parse tree
	 */
	void exitStringList(HDBCDSParser.StringListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#textStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTextStringLiteral(HDBCDSParser.TextStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#textStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTextStringLiteral(HDBCDSParser.TextStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#textString}.
	 * @param ctx the parse tree
	 */
	void enterTextString(HDBCDSParser.TextStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#textString}.
	 * @param ctx the parse tree
	 */
	void exitTextString(HDBCDSParser.TextStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#textStringHash}.
	 * @param ctx the parse tree
	 */
	void enterTextStringHash(HDBCDSParser.TextStringHashContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#textStringHash}.
	 * @param ctx the parse tree
	 */
	void exitTextStringHash(HDBCDSParser.TextStringHashContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#textLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTextLiteral(HDBCDSParser.TextLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#textLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTextLiteral(HDBCDSParser.TextLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#textStringNoLinebreak}.
	 * @param ctx the parse tree
	 */
	void enterTextStringNoLinebreak(HDBCDSParser.TextStringNoLinebreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#textStringNoLinebreak}.
	 * @param ctx the parse tree
	 */
	void exitTextStringNoLinebreak(HDBCDSParser.TextStringNoLinebreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#textStringLiteralList}.
	 * @param ctx the parse tree
	 */
	void enterTextStringLiteralList(HDBCDSParser.TextStringLiteralListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#textStringLiteralList}.
	 * @param ctx the parse tree
	 */
	void exitTextStringLiteralList(HDBCDSParser.TextStringLiteralListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#numLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumLiteral(HDBCDSParser.NumLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#numLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumLiteral(HDBCDSParser.NumLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(HDBCDSParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(HDBCDSParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(HDBCDSParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(HDBCDSParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#temporalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTemporalLiteral(HDBCDSParser.TemporalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#temporalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTemporalLiteral(HDBCDSParser.TemporalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#floatOptions}.
	 * @param ctx the parse tree
	 */
	void enterFloatOptions(HDBCDSParser.FloatOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#floatOptions}.
	 * @param ctx the parse tree
	 */
	void exitFloatOptions(HDBCDSParser.FloatOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#standardFloatOptions}.
	 * @param ctx the parse tree
	 */
	void enterStandardFloatOptions(HDBCDSParser.StandardFloatOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#standardFloatOptions}.
	 * @param ctx the parse tree
	 */
	void exitStandardFloatOptions(HDBCDSParser.StandardFloatOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#precision}.
	 * @param ctx the parse tree
	 */
	void enterPrecision(HDBCDSParser.PrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#precision}.
	 * @param ctx the parse tree
	 */
	void exitPrecision(HDBCDSParser.PrecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#textOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTextOrIdentifier(HDBCDSParser.TextOrIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#textOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTextOrIdentifier(HDBCDSParser.TextOrIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#sizeNumber}.
	 * @param ctx the parse tree
	 */
	void enterSizeNumber(HDBCDSParser.SizeNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#sizeNumber}.
	 * @param ctx the parse tree
	 */
	void exitSizeNumber(HDBCDSParser.SizeNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#parentheses}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(HDBCDSParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#parentheses}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(HDBCDSParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#equal}.
	 * @param ctx the parse tree
	 */
	void enterEqual(HDBCDSParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#equal}.
	 * @param ctx the parse tree
	 */
	void exitEqual(HDBCDSParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identifierKeyword}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierKeyword(HDBCDSParser.IdentifierKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identifierKeyword}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierKeyword(HDBCDSParser.IdentifierKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#identifierKeywordsUnambiguous}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierKeywordsUnambiguous(HDBCDSParser.IdentifierKeywordsUnambiguousContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#identifierKeywordsUnambiguous}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierKeywordsUnambiguous(HDBCDSParser.IdentifierKeywordsUnambiguousContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#windowName}.
	 * @param ctx the parse tree
	 */
	void enterWindowName(HDBCDSParser.WindowNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#windowName}.
	 * @param ctx the parse tree
	 */
	void exitWindowName(HDBCDSParser.WindowNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#fieldIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldIdentifier(HDBCDSParser.FieldIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#fieldIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldIdentifier(HDBCDSParser.FieldIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(HDBCDSParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(HDBCDSParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#columnInternalRef}.
	 * @param ctx the parse tree
	 */
	void enterColumnInternalRef(HDBCDSParser.ColumnInternalRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#columnInternalRef}.
	 * @param ctx the parse tree
	 */
	void exitColumnInternalRef(HDBCDSParser.ColumnInternalRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#columnInternalRefList}.
	 * @param ctx the parse tree
	 */
	void enterColumnInternalRefList(HDBCDSParser.ColumnInternalRefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#columnInternalRefList}.
	 * @param ctx the parse tree
	 */
	void exitColumnInternalRefList(HDBCDSParser.ColumnInternalRefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void enterColumnRef(HDBCDSParser.ColumnRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void exitColumnRef(HDBCDSParser.ColumnRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tableRefWithWildcard}.
	 * @param ctx the parse tree
	 */
	void enterTableRefWithWildcard(HDBCDSParser.TableRefWithWildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tableRefWithWildcard}.
	 * @param ctx the parse tree
	 */
	void exitTableRefWithWildcard(HDBCDSParser.TableRefWithWildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tableAliasRefList}.
	 * @param ctx the parse tree
	 */
	void enterTableAliasRefList(HDBCDSParser.TableAliasRefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tableAliasRefList}.
	 * @param ctx the parse tree
	 */
	void exitTableAliasRefList(HDBCDSParser.TableAliasRefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tableWild}.
	 * @param ctx the parse tree
	 */
	void enterTableWild(HDBCDSParser.TableWildContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tableWild}.
	 * @param ctx the parse tree
	 */
	void exitTableWild(HDBCDSParser.TableWildContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#tableRef}.
	 * @param ctx the parse tree
	 */
	void enterTableRef(HDBCDSParser.TableRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#tableRef}.
	 * @param ctx the parse tree
	 */
	void exitTableRef(HDBCDSParser.TableRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#fieldLength}.
	 * @param ctx the parse tree
	 */
	void enterFieldLength(HDBCDSParser.FieldLengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#fieldLength}.
	 * @param ctx the parse tree
	 */
	void exitFieldLength(HDBCDSParser.FieldLengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#typeDatetimePrecision}.
	 * @param ctx the parse tree
	 */
	void enterTypeDatetimePrecision(HDBCDSParser.TypeDatetimePrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#typeDatetimePrecision}.
	 * @param ctx the parse tree
	 */
	void exitTypeDatetimePrecision(HDBCDSParser.TypeDatetimePrecisionContext ctx);
}