// Generated from SQLBaseParser.g4 by ANTLR 4.8
package io.rtdi.hanaappcontainer.antlr.sql;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLBaseParser}.
 */
public interface SQLBaseParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(SQLBaseParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(SQLBaseParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpression(SQLBaseParser.QueryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpression(SQLBaseParser.QueryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#queryExpressionBody}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpressionBody(SQLBaseParser.QueryExpressionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#queryExpressionBody}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpressionBody(SQLBaseParser.QueryExpressionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#queryExpressionParens}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpressionParens(SQLBaseParser.QueryExpressionParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#queryExpressionParens}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpressionParens(SQLBaseParser.QueryExpressionParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(SQLBaseParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(SQLBaseParser.QuerySpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(SQLBaseParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(SQLBaseParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#querySpecOption}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecOption(SQLBaseParser.QuerySpecOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#querySpecOption}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecOption(SQLBaseParser.QuerySpecOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(SQLBaseParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(SQLBaseParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#simpleLimitClause}.
	 * @param ctx the parse tree
	 */
	void enterSimpleLimitClause(SQLBaseParser.SimpleLimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#simpleLimitClause}.
	 * @param ctx the parse tree
	 */
	void exitSimpleLimitClause(SQLBaseParser.SimpleLimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#limitOptions}.
	 * @param ctx the parse tree
	 */
	void enterLimitOptions(SQLBaseParser.LimitOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#limitOptions}.
	 * @param ctx the parse tree
	 */
	void exitLimitOptions(SQLBaseParser.LimitOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#limitOption}.
	 * @param ctx the parse tree
	 */
	void enterLimitOption(SQLBaseParser.LimitOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#limitOption}.
	 * @param ctx the parse tree
	 */
	void exitLimitOption(SQLBaseParser.LimitOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(SQLBaseParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(SQLBaseParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowClause(SQLBaseParser.WindowClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowClause(SQLBaseParser.WindowClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowDefinition}.
	 * @param ctx the parse tree
	 */
	void enterWindowDefinition(SQLBaseParser.WindowDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowDefinition}.
	 * @param ctx the parse tree
	 */
	void exitWindowDefinition(SQLBaseParser.WindowDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void enterWindowSpec(SQLBaseParser.WindowSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void exitWindowSpec(SQLBaseParser.WindowSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowSpecDetails}.
	 * @param ctx the parse tree
	 */
	void enterWindowSpecDetails(SQLBaseParser.WindowSpecDetailsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowSpecDetails}.
	 * @param ctx the parse tree
	 */
	void exitWindowSpecDetails(SQLBaseParser.WindowSpecDetailsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowFrameClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameClause(SQLBaseParser.WindowFrameClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowFrameClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameClause(SQLBaseParser.WindowFrameClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowFrameUnits}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameUnits(SQLBaseParser.WindowFrameUnitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowFrameUnits}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameUnits(SQLBaseParser.WindowFrameUnitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameExtent(SQLBaseParser.WindowFrameExtentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameExtent(SQLBaseParser.WindowFrameExtentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowFrameStart}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameStart(SQLBaseParser.WindowFrameStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowFrameStart}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameStart(SQLBaseParser.WindowFrameStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowFrameBetween}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameBetween(SQLBaseParser.WindowFrameBetweenContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowFrameBetween}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameBetween(SQLBaseParser.WindowFrameBetweenContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowFrameBound}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameBound(SQLBaseParser.WindowFrameBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowFrameBound}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameBound(SQLBaseParser.WindowFrameBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowFrameExclusion}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameExclusion(SQLBaseParser.WindowFrameExclusionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowFrameExclusion}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameExclusion(SQLBaseParser.WindowFrameExclusionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#withClause}.
	 * @param ctx the parse tree
	 */
	void enterWithClause(SQLBaseParser.WithClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#withClause}.
	 * @param ctx the parse tree
	 */
	void exitWithClause(SQLBaseParser.WithClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#commonTableExpression}.
	 * @param ctx the parse tree
	 */
	void enterCommonTableExpression(SQLBaseParser.CommonTableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#commonTableExpression}.
	 * @param ctx the parse tree
	 */
	void exitCommonTableExpression(SQLBaseParser.CommonTableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(SQLBaseParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(SQLBaseParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#orderClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderClause(SQLBaseParser.OrderClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#orderClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderClause(SQLBaseParser.OrderClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#direction}.
	 * @param ctx the parse tree
	 */
	void enterDirection(SQLBaseParser.DirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#direction}.
	 * @param ctx the parse tree
	 */
	void exitDirection(SQLBaseParser.DirectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(SQLBaseParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(SQLBaseParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#tableReferenceList}.
	 * @param ctx the parse tree
	 */
	void enterTableReferenceList(SQLBaseParser.TableReferenceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#tableReferenceList}.
	 * @param ctx the parse tree
	 */
	void exitTableReferenceList(SQLBaseParser.TableReferenceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#selectOption}.
	 * @param ctx the parse tree
	 */
	void enterSelectOption(SQLBaseParser.SelectOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#selectOption}.
	 * @param ctx the parse tree
	 */
	void exitSelectOption(SQLBaseParser.SelectOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#lockingClause}.
	 * @param ctx the parse tree
	 */
	void enterLockingClause(SQLBaseParser.LockingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#lockingClause}.
	 * @param ctx the parse tree
	 */
	void exitLockingClause(SQLBaseParser.LockingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#lockStrengh}.
	 * @param ctx the parse tree
	 */
	void enterLockStrengh(SQLBaseParser.LockStrenghContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#lockStrengh}.
	 * @param ctx the parse tree
	 */
	void exitLockStrengh(SQLBaseParser.LockStrenghContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#lockedRowAction}.
	 * @param ctx the parse tree
	 */
	void enterLockedRowAction(SQLBaseParser.LockedRowActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#lockedRowAction}.
	 * @param ctx the parse tree
	 */
	void exitLockedRowAction(SQLBaseParser.LockedRowActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#selectItemList}.
	 * @param ctx the parse tree
	 */
	void enterSelectItemList(SQLBaseParser.SelectItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#selectItemList}.
	 * @param ctx the parse tree
	 */
	void exitSelectItemList(SQLBaseParser.SelectItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void enterSelectItem(SQLBaseParser.SelectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void exitSelectItem(SQLBaseParser.SelectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#selectAlias}.
	 * @param ctx the parse tree
	 */
	void enterSelectAlias(SQLBaseParser.SelectAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#selectAlias}.
	 * @param ctx the parse tree
	 */
	void exitSelectAlias(SQLBaseParser.SelectAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(SQLBaseParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(SQLBaseParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#tableReference}.
	 * @param ctx the parse tree
	 */
	void enterTableReference(SQLBaseParser.TableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#tableReference}.
	 * @param ctx the parse tree
	 */
	void exitTableReference(SQLBaseParser.TableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#escapedTableReference}.
	 * @param ctx the parse tree
	 */
	void enterEscapedTableReference(SQLBaseParser.EscapedTableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#escapedTableReference}.
	 * @param ctx the parse tree
	 */
	void exitEscapedTableReference(SQLBaseParser.EscapedTableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#joinedTable}.
	 * @param ctx the parse tree
	 */
	void enterJoinedTable(SQLBaseParser.JoinedTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#joinedTable}.
	 * @param ctx the parse tree
	 */
	void exitJoinedTable(SQLBaseParser.JoinedTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#innerJoinType}.
	 * @param ctx the parse tree
	 */
	void enterInnerJoinType(SQLBaseParser.InnerJoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#innerJoinType}.
	 * @param ctx the parse tree
	 */
	void exitInnerJoinType(SQLBaseParser.InnerJoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#outerJoinType}.
	 * @param ctx the parse tree
	 */
	void enterOuterJoinType(SQLBaseParser.OuterJoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#outerJoinType}.
	 * @param ctx the parse tree
	 */
	void exitOuterJoinType(SQLBaseParser.OuterJoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#tableFactor}.
	 * @param ctx the parse tree
	 */
	void enterTableFactor(SQLBaseParser.TableFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#tableFactor}.
	 * @param ctx the parse tree
	 */
	void exitTableFactor(SQLBaseParser.TableFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#singleTable}.
	 * @param ctx the parse tree
	 */
	void enterSingleTable(SQLBaseParser.SingleTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#singleTable}.
	 * @param ctx the parse tree
	 */
	void exitSingleTable(SQLBaseParser.SingleTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#singleTableParens}.
	 * @param ctx the parse tree
	 */
	void enterSingleTableParens(SQLBaseParser.SingleTableParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#singleTableParens}.
	 * @param ctx the parse tree
	 */
	void exitSingleTableParens(SQLBaseParser.SingleTableParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#derivedTable}.
	 * @param ctx the parse tree
	 */
	void enterDerivedTable(SQLBaseParser.DerivedTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#derivedTable}.
	 * @param ctx the parse tree
	 */
	void exitDerivedTable(SQLBaseParser.DerivedTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#tableReferenceListParens}.
	 * @param ctx the parse tree
	 */
	void enterTableReferenceListParens(SQLBaseParser.TableReferenceListParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#tableReferenceListParens}.
	 * @param ctx the parse tree
	 */
	void exitTableReferenceListParens(SQLBaseParser.TableReferenceListParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#unionOption}.
	 * @param ctx the parse tree
	 */
	void enterUnionOption(SQLBaseParser.UnionOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#unionOption}.
	 * @param ctx the parse tree
	 */
	void exitUnionOption(SQLBaseParser.UnionOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void enterTableAlias(SQLBaseParser.TableAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void exitTableAlias(SQLBaseParser.TableAliasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link SQLBaseParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(SQLBaseParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link SQLBaseParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(SQLBaseParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNot}
	 * labeled alternative in {@link SQLBaseParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNot(SQLBaseParser.ExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNot}
	 * labeled alternative in {@link SQLBaseParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNot(SQLBaseParser.ExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIs}
	 * labeled alternative in {@link SQLBaseParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIs(SQLBaseParser.ExprIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIs}
	 * labeled alternative in {@link SQLBaseParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIs(SQLBaseParser.ExprIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link SQLBaseParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(SQLBaseParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link SQLBaseParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(SQLBaseParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprPredicate}
	 * labeled alternative in {@link SQLBaseParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprPredicate(SQLBaseParser.PrimaryExprPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprPredicate}
	 * labeled alternative in {@link SQLBaseParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprPredicate(SQLBaseParser.PrimaryExprPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprCompare}
	 * labeled alternative in {@link SQLBaseParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprCompare(SQLBaseParser.PrimaryExprCompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprCompare}
	 * labeled alternative in {@link SQLBaseParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprCompare(SQLBaseParser.PrimaryExprCompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprAllAny}
	 * labeled alternative in {@link SQLBaseParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprAllAny(SQLBaseParser.PrimaryExprAllAnyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprAllAny}
	 * labeled alternative in {@link SQLBaseParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprAllAny(SQLBaseParser.PrimaryExprAllAnyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprIsNull}
	 * labeled alternative in {@link SQLBaseParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprIsNull(SQLBaseParser.PrimaryExprIsNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprIsNull}
	 * labeled alternative in {@link SQLBaseParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprIsNull(SQLBaseParser.PrimaryExprIsNullContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(SQLBaseParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(SQLBaseParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(SQLBaseParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(SQLBaseParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExprIn}
	 * labeled alternative in {@link SQLBaseParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExprIn(SQLBaseParser.PredicateExprInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExprIn}
	 * labeled alternative in {@link SQLBaseParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExprIn(SQLBaseParser.PredicateExprInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExprBetween}
	 * labeled alternative in {@link SQLBaseParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExprBetween(SQLBaseParser.PredicateExprBetweenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExprBetween}
	 * labeled alternative in {@link SQLBaseParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExprBetween(SQLBaseParser.PredicateExprBetweenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExprLike}
	 * labeled alternative in {@link SQLBaseParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExprLike(SQLBaseParser.PredicateExprLikeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExprLike}
	 * labeled alternative in {@link SQLBaseParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExprLike(SQLBaseParser.PredicateExprLikeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#bitExpr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpr(SQLBaseParser.BitExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#bitExpr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpr(SQLBaseParser.BitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprColumnRef}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprColumnRef(SQLBaseParser.SimpleExprColumnRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprColumnRef}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprColumnRef(SQLBaseParser.SimpleExprColumnRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprParamMarker}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprParamMarker(SQLBaseParser.SimpleExprParamMarkerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprParamMarker}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprParamMarker(SQLBaseParser.SimpleExprParamMarkerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprSum}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprSum(SQLBaseParser.SimpleExprSumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprSum}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprSum(SQLBaseParser.SimpleExprSumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprCast}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprCast(SQLBaseParser.SimpleExprCastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprCast}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprCast(SQLBaseParser.SimpleExprCastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprUnary}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprUnary(SQLBaseParser.SimpleExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprUnary}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprUnary(SQLBaseParser.SimpleExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprSubQuery}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprSubQuery(SQLBaseParser.SimpleExprSubQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprSubQuery}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprSubQuery(SQLBaseParser.SimpleExprSubQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprGroupingOperation}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprGroupingOperation(SQLBaseParser.SimpleExprGroupingOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprGroupingOperation}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprGroupingOperation(SQLBaseParser.SimpleExprGroupingOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprNot}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprNot(SQLBaseParser.SimpleExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprNot}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprNot(SQLBaseParser.SimpleExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprOdbc}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprOdbc(SQLBaseParser.SimpleExprOdbcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprOdbc}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprOdbc(SQLBaseParser.SimpleExprOdbcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprRuntimeFunction}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprRuntimeFunction(SQLBaseParser.SimpleExprRuntimeFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprRuntimeFunction}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprRuntimeFunction(SQLBaseParser.SimpleExprRuntimeFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprFunction}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprFunction(SQLBaseParser.SimpleExprFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprFunction}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprFunction(SQLBaseParser.SimpleExprFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprList}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprList(SQLBaseParser.SimpleExprListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprList}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprList(SQLBaseParser.SimpleExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprCase}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprCase(SQLBaseParser.SimpleExprCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprCase}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprCase(SQLBaseParser.SimpleExprCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprConcat}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprConcat(SQLBaseParser.SimpleExprConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprConcat}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprConcat(SQLBaseParser.SimpleExprConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprLiteral}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprLiteral(SQLBaseParser.SimpleExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprLiteral}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprLiteral(SQLBaseParser.SimpleExprLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprWindowingFunction}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprWindowingFunction(SQLBaseParser.SimpleExprWindowingFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprWindowingFunction}
	 * labeled alternative in {@link SQLBaseParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprWindowingFunction(SQLBaseParser.SimpleExprWindowingFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#sumExpr}.
	 * @param ctx the parse tree
	 */
	void enterSumExpr(SQLBaseParser.SumExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#sumExpr}.
	 * @param ctx the parse tree
	 */
	void exitSumExpr(SQLBaseParser.SumExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#groupingOperation}.
	 * @param ctx the parse tree
	 */
	void enterGroupingOperation(SQLBaseParser.GroupingOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#groupingOperation}.
	 * @param ctx the parse tree
	 */
	void exitGroupingOperation(SQLBaseParser.GroupingOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterWindowFunctionCall(SQLBaseParser.WindowFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitWindowFunctionCall(SQLBaseParser.WindowFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowingClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowingClause(SQLBaseParser.WindowingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowingClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowingClause(SQLBaseParser.WindowingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#leadLagInfo}.
	 * @param ctx the parse tree
	 */
	void enterLeadLagInfo(SQLBaseParser.LeadLagInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#leadLagInfo}.
	 * @param ctx the parse tree
	 */
	void exitLeadLagInfo(SQLBaseParser.LeadLagInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#inSumExpr}.
	 * @param ctx the parse tree
	 */
	void enterInSumExpr(SQLBaseParser.InSumExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#inSumExpr}.
	 * @param ctx the parse tree
	 */
	void exitInSumExpr(SQLBaseParser.InSumExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#identListArg}.
	 * @param ctx the parse tree
	 */
	void enterIdentListArg(SQLBaseParser.IdentListArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#identListArg}.
	 * @param ctx the parse tree
	 */
	void exitIdentListArg(SQLBaseParser.IdentListArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#identList}.
	 * @param ctx the parse tree
	 */
	void enterIdentList(SQLBaseParser.IdentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#identList}.
	 * @param ctx the parse tree
	 */
	void exitIdentList(SQLBaseParser.IdentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#runtimeFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterRuntimeFunctionCall(SQLBaseParser.RuntimeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#runtimeFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitRuntimeFunctionCall(SQLBaseParser.RuntimeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#timeFunctionParameters}.
	 * @param ctx the parse tree
	 */
	void enterTimeFunctionParameters(SQLBaseParser.TimeFunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#timeFunctionParameters}.
	 * @param ctx the parse tree
	 */
	void exitTimeFunctionParameters(SQLBaseParser.TimeFunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#fractionalPrecision}.
	 * @param ctx the parse tree
	 */
	void enterFractionalPrecision(SQLBaseParser.FractionalPrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#fractionalPrecision}.
	 * @param ctx the parse tree
	 */
	void exitFractionalPrecision(SQLBaseParser.FractionalPrecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#substringFunction}.
	 * @param ctx the parse tree
	 */
	void enterSubstringFunction(SQLBaseParser.SubstringFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#substringFunction}.
	 * @param ctx the parse tree
	 */
	void exitSubstringFunction(SQLBaseParser.SubstringFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SQLBaseParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SQLBaseParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#udfExprList}.
	 * @param ctx the parse tree
	 */
	void enterUdfExprList(SQLBaseParser.UdfExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#udfExprList}.
	 * @param ctx the parse tree
	 */
	void exitUdfExprList(SQLBaseParser.UdfExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#udfExpr}.
	 * @param ctx the parse tree
	 */
	void enterUdfExpr(SQLBaseParser.UdfExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#udfExpr}.
	 * @param ctx the parse tree
	 */
	void exitUdfExpr(SQLBaseParser.UdfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#whenExpression}.
	 * @param ctx the parse tree
	 */
	void enterWhenExpression(SQLBaseParser.WhenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#whenExpression}.
	 * @param ctx the parse tree
	 */
	void exitWhenExpression(SQLBaseParser.WhenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#thenExpression}.
	 * @param ctx the parse tree
	 */
	void enterThenExpression(SQLBaseParser.ThenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#thenExpression}.
	 * @param ctx the parse tree
	 */
	void exitThenExpression(SQLBaseParser.ThenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#elseExpression}.
	 * @param ctx the parse tree
	 */
	void enterElseExpression(SQLBaseParser.ElseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#elseExpression}.
	 * @param ctx the parse tree
	 */
	void exitElseExpression(SQLBaseParser.ElseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#castType}.
	 * @param ctx the parse tree
	 */
	void enterCastType(SQLBaseParser.CastTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#castType}.
	 * @param ctx the parse tree
	 */
	void exitCastType(SQLBaseParser.CastTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(SQLBaseParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(SQLBaseParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#notRule}.
	 * @param ctx the parse tree
	 */
	void enterNotRule(SQLBaseParser.NotRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#notRule}.
	 * @param ctx the parse tree
	 */
	void exitNotRule(SQLBaseParser.NotRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#not2Rule}.
	 * @param ctx the parse tree
	 */
	void enterNot2Rule(SQLBaseParser.Not2RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#not2Rule}.
	 * @param ctx the parse tree
	 */
	void exitNot2Rule(SQLBaseParser.Not2RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#exprListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterExprListWithParentheses(SQLBaseParser.ExprListWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#exprListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitExprListWithParentheses(SQLBaseParser.ExprListWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#exprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterExprWithParentheses(SQLBaseParser.ExprWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#exprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitExprWithParentheses(SQLBaseParser.ExprWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#simpleExprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprWithParentheses(SQLBaseParser.SimpleExprWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#simpleExprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprWithParentheses(SQLBaseParser.SimpleExprWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#orderList}.
	 * @param ctx the parse tree
	 */
	void enterOrderList(SQLBaseParser.OrderListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#orderList}.
	 * @param ctx the parse tree
	 */
	void exitOrderList(SQLBaseParser.OrderListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#orderExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrderExpression(SQLBaseParser.OrderExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#orderExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrderExpression(SQLBaseParser.OrderExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#groupList}.
	 * @param ctx the parse tree
	 */
	void enterGroupList(SQLBaseParser.GroupListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#groupList}.
	 * @param ctx the parse tree
	 */
	void exitGroupList(SQLBaseParser.GroupListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#groupingExpression}.
	 * @param ctx the parse tree
	 */
	void enterGroupingExpression(SQLBaseParser.GroupingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#groupingExpression}.
	 * @param ctx the parse tree
	 */
	void exitGroupingExpression(SQLBaseParser.GroupingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#pureIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterPureIdentifier(SQLBaseParser.PureIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#pureIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitPureIdentifier(SQLBaseParser.PureIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SQLBaseParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SQLBaseParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(SQLBaseParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(SQLBaseParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#identifierListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierListWithParentheses(SQLBaseParser.IdentifierListWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#identifierListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierListWithParentheses(SQLBaseParser.IdentifierListWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedIdentifier(SQLBaseParser.QualifiedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedIdentifier(SQLBaseParser.QualifiedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#simpleIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSimpleIdentifier(SQLBaseParser.SimpleIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#simpleIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSimpleIdentifier(SQLBaseParser.SimpleIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#dotIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterDotIdentifier(SQLBaseParser.DotIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#dotIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitDotIdentifier(SQLBaseParser.DotIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#ulong_number}.
	 * @param ctx the parse tree
	 */
	void enterUlong_number(SQLBaseParser.Ulong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#ulong_number}.
	 * @param ctx the parse tree
	 */
	void exitUlong_number(SQLBaseParser.Ulong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#real_ulong_number}.
	 * @param ctx the parse tree
	 */
	void enterReal_ulong_number(SQLBaseParser.Real_ulong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#real_ulong_number}.
	 * @param ctx the parse tree
	 */
	void exitReal_ulong_number(SQLBaseParser.Real_ulong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void enterUlonglong_number(SQLBaseParser.Ulonglong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void exitUlonglong_number(SQLBaseParser.Ulonglong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#real_ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void enterReal_ulonglong_number(SQLBaseParser.Real_ulonglong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#real_ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void exitReal_ulonglong_number(SQLBaseParser.Real_ulonglong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SQLBaseParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SQLBaseParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#signedLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSignedLiteral(SQLBaseParser.SignedLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#signedLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSignedLiteral(SQLBaseParser.SignedLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#stringList}.
	 * @param ctx the parse tree
	 */
	void enterStringList(SQLBaseParser.StringListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#stringList}.
	 * @param ctx the parse tree
	 */
	void exitStringList(SQLBaseParser.StringListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#textStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTextStringLiteral(SQLBaseParser.TextStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#textStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTextStringLiteral(SQLBaseParser.TextStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#textString}.
	 * @param ctx the parse tree
	 */
	void enterTextString(SQLBaseParser.TextStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#textString}.
	 * @param ctx the parse tree
	 */
	void exitTextString(SQLBaseParser.TextStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#textStringHash}.
	 * @param ctx the parse tree
	 */
	void enterTextStringHash(SQLBaseParser.TextStringHashContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#textStringHash}.
	 * @param ctx the parse tree
	 */
	void exitTextStringHash(SQLBaseParser.TextStringHashContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#textLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTextLiteral(SQLBaseParser.TextLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#textLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTextLiteral(SQLBaseParser.TextLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#textStringNoLinebreak}.
	 * @param ctx the parse tree
	 */
	void enterTextStringNoLinebreak(SQLBaseParser.TextStringNoLinebreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#textStringNoLinebreak}.
	 * @param ctx the parse tree
	 */
	void exitTextStringNoLinebreak(SQLBaseParser.TextStringNoLinebreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#textStringLiteralList}.
	 * @param ctx the parse tree
	 */
	void enterTextStringLiteralList(SQLBaseParser.TextStringLiteralListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#textStringLiteralList}.
	 * @param ctx the parse tree
	 */
	void exitTextStringLiteralList(SQLBaseParser.TextStringLiteralListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#numLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumLiteral(SQLBaseParser.NumLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#numLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumLiteral(SQLBaseParser.NumLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(SQLBaseParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(SQLBaseParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(SQLBaseParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(SQLBaseParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#temporalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTemporalLiteral(SQLBaseParser.TemporalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#temporalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTemporalLiteral(SQLBaseParser.TemporalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#floatOptions}.
	 * @param ctx the parse tree
	 */
	void enterFloatOptions(SQLBaseParser.FloatOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#floatOptions}.
	 * @param ctx the parse tree
	 */
	void exitFloatOptions(SQLBaseParser.FloatOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#standardFloatOptions}.
	 * @param ctx the parse tree
	 */
	void enterStandardFloatOptions(SQLBaseParser.StandardFloatOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#standardFloatOptions}.
	 * @param ctx the parse tree
	 */
	void exitStandardFloatOptions(SQLBaseParser.StandardFloatOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#precision}.
	 * @param ctx the parse tree
	 */
	void enterPrecision(SQLBaseParser.PrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#precision}.
	 * @param ctx the parse tree
	 */
	void exitPrecision(SQLBaseParser.PrecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#textOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTextOrIdentifier(SQLBaseParser.TextOrIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#textOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTextOrIdentifier(SQLBaseParser.TextOrIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#sizeNumber}.
	 * @param ctx the parse tree
	 */
	void enterSizeNumber(SQLBaseParser.SizeNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#sizeNumber}.
	 * @param ctx the parse tree
	 */
	void exitSizeNumber(SQLBaseParser.SizeNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#parentheses}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(SQLBaseParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#parentheses}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(SQLBaseParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#equal}.
	 * @param ctx the parse tree
	 */
	void enterEqual(SQLBaseParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#equal}.
	 * @param ctx the parse tree
	 */
	void exitEqual(SQLBaseParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#identifierKeyword}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierKeyword(SQLBaseParser.IdentifierKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#identifierKeyword}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierKeyword(SQLBaseParser.IdentifierKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#identifierKeywordsUnambiguous}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierKeywordsUnambiguous(SQLBaseParser.IdentifierKeywordsUnambiguousContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#identifierKeywordsUnambiguous}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierKeywordsUnambiguous(SQLBaseParser.IdentifierKeywordsUnambiguousContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#windowName}.
	 * @param ctx the parse tree
	 */
	void enterWindowName(SQLBaseParser.WindowNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#windowName}.
	 * @param ctx the parse tree
	 */
	void exitWindowName(SQLBaseParser.WindowNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#fieldIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldIdentifier(SQLBaseParser.FieldIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#fieldIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldIdentifier(SQLBaseParser.FieldIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(SQLBaseParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(SQLBaseParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#columnInternalRef}.
	 * @param ctx the parse tree
	 */
	void enterColumnInternalRef(SQLBaseParser.ColumnInternalRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#columnInternalRef}.
	 * @param ctx the parse tree
	 */
	void exitColumnInternalRef(SQLBaseParser.ColumnInternalRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#columnInternalRefList}.
	 * @param ctx the parse tree
	 */
	void enterColumnInternalRefList(SQLBaseParser.ColumnInternalRefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#columnInternalRefList}.
	 * @param ctx the parse tree
	 */
	void exitColumnInternalRefList(SQLBaseParser.ColumnInternalRefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void enterColumnRef(SQLBaseParser.ColumnRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void exitColumnRef(SQLBaseParser.ColumnRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#tableRefWithWildcard}.
	 * @param ctx the parse tree
	 */
	void enterTableRefWithWildcard(SQLBaseParser.TableRefWithWildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#tableRefWithWildcard}.
	 * @param ctx the parse tree
	 */
	void exitTableRefWithWildcard(SQLBaseParser.TableRefWithWildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#tableAliasRefList}.
	 * @param ctx the parse tree
	 */
	void enterTableAliasRefList(SQLBaseParser.TableAliasRefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#tableAliasRefList}.
	 * @param ctx the parse tree
	 */
	void exitTableAliasRefList(SQLBaseParser.TableAliasRefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#tableWild}.
	 * @param ctx the parse tree
	 */
	void enterTableWild(SQLBaseParser.TableWildContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#tableWild}.
	 * @param ctx the parse tree
	 */
	void exitTableWild(SQLBaseParser.TableWildContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#tableRef}.
	 * @param ctx the parse tree
	 */
	void enterTableRef(SQLBaseParser.TableRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#tableRef}.
	 * @param ctx the parse tree
	 */
	void exitTableRef(SQLBaseParser.TableRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#fieldLength}.
	 * @param ctx the parse tree
	 */
	void enterFieldLength(SQLBaseParser.FieldLengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#fieldLength}.
	 * @param ctx the parse tree
	 */
	void exitFieldLength(SQLBaseParser.FieldLengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLBaseParser#typeDatetimePrecision}.
	 * @param ctx the parse tree
	 */
	void enterTypeDatetimePrecision(SQLBaseParser.TypeDatetimePrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLBaseParser#typeDatetimePrecision}.
	 * @param ctx the parse tree
	 */
	void exitTypeDatetimePrecision(SQLBaseParser.TypeDatetimePrecisionContext ctx);
}