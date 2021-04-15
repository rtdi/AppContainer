// Generated from HDBViewParser.g4 by ANTLR 4.8
package io.rtdi.appcontainer.antlr.sql;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HDBViewParser}.
 */
public interface HDBViewParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(HDBViewParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(HDBViewParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(HDBViewParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(HDBViewParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpression(HDBViewParser.QueryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#queryExpression}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpression(HDBViewParser.QueryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#queryExpressionBody}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpressionBody(HDBViewParser.QueryExpressionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#queryExpressionBody}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpressionBody(HDBViewParser.QueryExpressionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#queryExpressionParens}.
	 * @param ctx the parse tree
	 */
	void enterQueryExpressionParens(HDBViewParser.QueryExpressionParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#queryExpressionParens}.
	 * @param ctx the parse tree
	 */
	void exitQueryExpressionParens(HDBViewParser.QueryExpressionParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(HDBViewParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(HDBViewParser.QuerySpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#subquery}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(HDBViewParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#subquery}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(HDBViewParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#querySpecOption}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecOption(HDBViewParser.QuerySpecOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#querySpecOption}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecOption(HDBViewParser.QuerySpecOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void enterLimitClause(HDBViewParser.LimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#limitClause}.
	 * @param ctx the parse tree
	 */
	void exitLimitClause(HDBViewParser.LimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#simpleLimitClause}.
	 * @param ctx the parse tree
	 */
	void enterSimpleLimitClause(HDBViewParser.SimpleLimitClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#simpleLimitClause}.
	 * @param ctx the parse tree
	 */
	void exitSimpleLimitClause(HDBViewParser.SimpleLimitClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#limitOptions}.
	 * @param ctx the parse tree
	 */
	void enterLimitOptions(HDBViewParser.LimitOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#limitOptions}.
	 * @param ctx the parse tree
	 */
	void exitLimitOptions(HDBViewParser.LimitOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#limitOption}.
	 * @param ctx the parse tree
	 */
	void enterLimitOption(HDBViewParser.LimitOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#limitOption}.
	 * @param ctx the parse tree
	 */
	void exitLimitOption(HDBViewParser.LimitOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(HDBViewParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(HDBViewParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowClause(HDBViewParser.WindowClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowClause(HDBViewParser.WindowClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowDefinition}.
	 * @param ctx the parse tree
	 */
	void enterWindowDefinition(HDBViewParser.WindowDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowDefinition}.
	 * @param ctx the parse tree
	 */
	void exitWindowDefinition(HDBViewParser.WindowDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void enterWindowSpec(HDBViewParser.WindowSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void exitWindowSpec(HDBViewParser.WindowSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowSpecDetails}.
	 * @param ctx the parse tree
	 */
	void enterWindowSpecDetails(HDBViewParser.WindowSpecDetailsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowSpecDetails}.
	 * @param ctx the parse tree
	 */
	void exitWindowSpecDetails(HDBViewParser.WindowSpecDetailsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowFrameClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameClause(HDBViewParser.WindowFrameClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowFrameClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameClause(HDBViewParser.WindowFrameClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowFrameUnits}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameUnits(HDBViewParser.WindowFrameUnitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowFrameUnits}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameUnits(HDBViewParser.WindowFrameUnitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameExtent(HDBViewParser.WindowFrameExtentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowFrameExtent}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameExtent(HDBViewParser.WindowFrameExtentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowFrameStart}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameStart(HDBViewParser.WindowFrameStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowFrameStart}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameStart(HDBViewParser.WindowFrameStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowFrameBetween}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameBetween(HDBViewParser.WindowFrameBetweenContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowFrameBetween}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameBetween(HDBViewParser.WindowFrameBetweenContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowFrameBound}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameBound(HDBViewParser.WindowFrameBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowFrameBound}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameBound(HDBViewParser.WindowFrameBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowFrameExclusion}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrameExclusion(HDBViewParser.WindowFrameExclusionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowFrameExclusion}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrameExclusion(HDBViewParser.WindowFrameExclusionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#withClause}.
	 * @param ctx the parse tree
	 */
	void enterWithClause(HDBViewParser.WithClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#withClause}.
	 * @param ctx the parse tree
	 */
	void exitWithClause(HDBViewParser.WithClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#commonTableExpression}.
	 * @param ctx the parse tree
	 */
	void enterCommonTableExpression(HDBViewParser.CommonTableExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#commonTableExpression}.
	 * @param ctx the parse tree
	 */
	void exitCommonTableExpression(HDBViewParser.CommonTableExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupByClause(HDBViewParser.GroupByClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#groupByClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupByClause(HDBViewParser.GroupByClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#orderClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderClause(HDBViewParser.OrderClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#orderClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderClause(HDBViewParser.OrderClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#direction}.
	 * @param ctx the parse tree
	 */
	void enterDirection(HDBViewParser.DirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#direction}.
	 * @param ctx the parse tree
	 */
	void exitDirection(HDBViewParser.DirectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(HDBViewParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(HDBViewParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#tableReferenceList}.
	 * @param ctx the parse tree
	 */
	void enterTableReferenceList(HDBViewParser.TableReferenceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#tableReferenceList}.
	 * @param ctx the parse tree
	 */
	void exitTableReferenceList(HDBViewParser.TableReferenceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#selectOption}.
	 * @param ctx the parse tree
	 */
	void enterSelectOption(HDBViewParser.SelectOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#selectOption}.
	 * @param ctx the parse tree
	 */
	void exitSelectOption(HDBViewParser.SelectOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#lockingClause}.
	 * @param ctx the parse tree
	 */
	void enterLockingClause(HDBViewParser.LockingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#lockingClause}.
	 * @param ctx the parse tree
	 */
	void exitLockingClause(HDBViewParser.LockingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#lockStrengh}.
	 * @param ctx the parse tree
	 */
	void enterLockStrengh(HDBViewParser.LockStrenghContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#lockStrengh}.
	 * @param ctx the parse tree
	 */
	void exitLockStrengh(HDBViewParser.LockStrenghContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#lockedRowAction}.
	 * @param ctx the parse tree
	 */
	void enterLockedRowAction(HDBViewParser.LockedRowActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#lockedRowAction}.
	 * @param ctx the parse tree
	 */
	void exitLockedRowAction(HDBViewParser.LockedRowActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#selectItemList}.
	 * @param ctx the parse tree
	 */
	void enterSelectItemList(HDBViewParser.SelectItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#selectItemList}.
	 * @param ctx the parse tree
	 */
	void exitSelectItemList(HDBViewParser.SelectItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void enterSelectItem(HDBViewParser.SelectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void exitSelectItem(HDBViewParser.SelectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#selectAlias}.
	 * @param ctx the parse tree
	 */
	void enterSelectAlias(HDBViewParser.SelectAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#selectAlias}.
	 * @param ctx the parse tree
	 */
	void exitSelectAlias(HDBViewParser.SelectAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(HDBViewParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(HDBViewParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#tableReference}.
	 * @param ctx the parse tree
	 */
	void enterTableReference(HDBViewParser.TableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#tableReference}.
	 * @param ctx the parse tree
	 */
	void exitTableReference(HDBViewParser.TableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#escapedTableReference}.
	 * @param ctx the parse tree
	 */
	void enterEscapedTableReference(HDBViewParser.EscapedTableReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#escapedTableReference}.
	 * @param ctx the parse tree
	 */
	void exitEscapedTableReference(HDBViewParser.EscapedTableReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#joinedTable}.
	 * @param ctx the parse tree
	 */
	void enterJoinedTable(HDBViewParser.JoinedTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#joinedTable}.
	 * @param ctx the parse tree
	 */
	void exitJoinedTable(HDBViewParser.JoinedTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#innerJoinType}.
	 * @param ctx the parse tree
	 */
	void enterInnerJoinType(HDBViewParser.InnerJoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#innerJoinType}.
	 * @param ctx the parse tree
	 */
	void exitInnerJoinType(HDBViewParser.InnerJoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#outerJoinType}.
	 * @param ctx the parse tree
	 */
	void enterOuterJoinType(HDBViewParser.OuterJoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#outerJoinType}.
	 * @param ctx the parse tree
	 */
	void exitOuterJoinType(HDBViewParser.OuterJoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#tableFactor}.
	 * @param ctx the parse tree
	 */
	void enterTableFactor(HDBViewParser.TableFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#tableFactor}.
	 * @param ctx the parse tree
	 */
	void exitTableFactor(HDBViewParser.TableFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#singleTable}.
	 * @param ctx the parse tree
	 */
	void enterSingleTable(HDBViewParser.SingleTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#singleTable}.
	 * @param ctx the parse tree
	 */
	void exitSingleTable(HDBViewParser.SingleTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#singleTableParens}.
	 * @param ctx the parse tree
	 */
	void enterSingleTableParens(HDBViewParser.SingleTableParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#singleTableParens}.
	 * @param ctx the parse tree
	 */
	void exitSingleTableParens(HDBViewParser.SingleTableParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#derivedTable}.
	 * @param ctx the parse tree
	 */
	void enterDerivedTable(HDBViewParser.DerivedTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#derivedTable}.
	 * @param ctx the parse tree
	 */
	void exitDerivedTable(HDBViewParser.DerivedTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#tableReferenceListParens}.
	 * @param ctx the parse tree
	 */
	void enterTableReferenceListParens(HDBViewParser.TableReferenceListParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#tableReferenceListParens}.
	 * @param ctx the parse tree
	 */
	void exitTableReferenceListParens(HDBViewParser.TableReferenceListParensContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#unionOption}.
	 * @param ctx the parse tree
	 */
	void enterUnionOption(HDBViewParser.UnionOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#unionOption}.
	 * @param ctx the parse tree
	 */
	void exitUnionOption(HDBViewParser.UnionOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void enterTableAlias(HDBViewParser.TableAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void exitTableAlias(HDBViewParser.TableAliasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link HDBViewParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(HDBViewParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOr}
	 * labeled alternative in {@link HDBViewParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(HDBViewParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNot}
	 * labeled alternative in {@link HDBViewParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNot(HDBViewParser.ExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNot}
	 * labeled alternative in {@link HDBViewParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNot(HDBViewParser.ExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprIs}
	 * labeled alternative in {@link HDBViewParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprIs(HDBViewParser.ExprIsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprIs}
	 * labeled alternative in {@link HDBViewParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprIs(HDBViewParser.ExprIsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link HDBViewParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(HDBViewParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAnd}
	 * labeled alternative in {@link HDBViewParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(HDBViewParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprPredicate}
	 * labeled alternative in {@link HDBViewParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprPredicate(HDBViewParser.PrimaryExprPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprPredicate}
	 * labeled alternative in {@link HDBViewParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprPredicate(HDBViewParser.PrimaryExprPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprCompare}
	 * labeled alternative in {@link HDBViewParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprCompare(HDBViewParser.PrimaryExprCompareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprCompare}
	 * labeled alternative in {@link HDBViewParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprCompare(HDBViewParser.PrimaryExprCompareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprAllAny}
	 * labeled alternative in {@link HDBViewParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprAllAny(HDBViewParser.PrimaryExprAllAnyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprAllAny}
	 * labeled alternative in {@link HDBViewParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprAllAny(HDBViewParser.PrimaryExprAllAnyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExprIsNull}
	 * labeled alternative in {@link HDBViewParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExprIsNull(HDBViewParser.PrimaryExprIsNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExprIsNull}
	 * labeled alternative in {@link HDBViewParser#boolPri}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExprIsNull(HDBViewParser.PrimaryExprIsNullContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(HDBViewParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(HDBViewParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(HDBViewParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(HDBViewParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExprIn}
	 * labeled alternative in {@link HDBViewParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExprIn(HDBViewParser.PredicateExprInContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExprIn}
	 * labeled alternative in {@link HDBViewParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExprIn(HDBViewParser.PredicateExprInContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExprBetween}
	 * labeled alternative in {@link HDBViewParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExprBetween(HDBViewParser.PredicateExprBetweenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExprBetween}
	 * labeled alternative in {@link HDBViewParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExprBetween(HDBViewParser.PredicateExprBetweenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predicateExprLike}
	 * labeled alternative in {@link HDBViewParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void enterPredicateExprLike(HDBViewParser.PredicateExprLikeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predicateExprLike}
	 * labeled alternative in {@link HDBViewParser#predicateOperations}.
	 * @param ctx the parse tree
	 */
	void exitPredicateExprLike(HDBViewParser.PredicateExprLikeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#bitExpr}.
	 * @param ctx the parse tree
	 */
	void enterBitExpr(HDBViewParser.BitExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#bitExpr}.
	 * @param ctx the parse tree
	 */
	void exitBitExpr(HDBViewParser.BitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprColumnRef}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprColumnRef(HDBViewParser.SimpleExprColumnRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprColumnRef}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprColumnRef(HDBViewParser.SimpleExprColumnRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprParamMarker}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprParamMarker(HDBViewParser.SimpleExprParamMarkerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprParamMarker}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprParamMarker(HDBViewParser.SimpleExprParamMarkerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprSum}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprSum(HDBViewParser.SimpleExprSumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprSum}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprSum(HDBViewParser.SimpleExprSumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprCast}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprCast(HDBViewParser.SimpleExprCastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprCast}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprCast(HDBViewParser.SimpleExprCastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprUnary}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprUnary(HDBViewParser.SimpleExprUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprUnary}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprUnary(HDBViewParser.SimpleExprUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprSubQuery}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprSubQuery(HDBViewParser.SimpleExprSubQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprSubQuery}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprSubQuery(HDBViewParser.SimpleExprSubQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprGroupingOperation}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprGroupingOperation(HDBViewParser.SimpleExprGroupingOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprGroupingOperation}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprGroupingOperation(HDBViewParser.SimpleExprGroupingOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprNot}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprNot(HDBViewParser.SimpleExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprNot}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprNot(HDBViewParser.SimpleExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprOdbc}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprOdbc(HDBViewParser.SimpleExprOdbcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprOdbc}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprOdbc(HDBViewParser.SimpleExprOdbcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprRuntimeFunction}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprRuntimeFunction(HDBViewParser.SimpleExprRuntimeFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprRuntimeFunction}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprRuntimeFunction(HDBViewParser.SimpleExprRuntimeFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprFunction}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprFunction(HDBViewParser.SimpleExprFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprFunction}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprFunction(HDBViewParser.SimpleExprFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprList}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprList(HDBViewParser.SimpleExprListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprList}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprList(HDBViewParser.SimpleExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprCase}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprCase(HDBViewParser.SimpleExprCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprCase}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprCase(HDBViewParser.SimpleExprCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprConcat}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprConcat(HDBViewParser.SimpleExprConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprConcat}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprConcat(HDBViewParser.SimpleExprConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprLiteral}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprLiteral(HDBViewParser.SimpleExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprLiteral}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprLiteral(HDBViewParser.SimpleExprLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleExprWindowingFunction}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprWindowingFunction(HDBViewParser.SimpleExprWindowingFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleExprWindowingFunction}
	 * labeled alternative in {@link HDBViewParser#simpleExpr}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprWindowingFunction(HDBViewParser.SimpleExprWindowingFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#sumExpr}.
	 * @param ctx the parse tree
	 */
	void enterSumExpr(HDBViewParser.SumExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#sumExpr}.
	 * @param ctx the parse tree
	 */
	void exitSumExpr(HDBViewParser.SumExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#groupingOperation}.
	 * @param ctx the parse tree
	 */
	void enterGroupingOperation(HDBViewParser.GroupingOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#groupingOperation}.
	 * @param ctx the parse tree
	 */
	void exitGroupingOperation(HDBViewParser.GroupingOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterWindowFunctionCall(HDBViewParser.WindowFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitWindowFunctionCall(HDBViewParser.WindowFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowingClause}.
	 * @param ctx the parse tree
	 */
	void enterWindowingClause(HDBViewParser.WindowingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowingClause}.
	 * @param ctx the parse tree
	 */
	void exitWindowingClause(HDBViewParser.WindowingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#leadLagInfo}.
	 * @param ctx the parse tree
	 */
	void enterLeadLagInfo(HDBViewParser.LeadLagInfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#leadLagInfo}.
	 * @param ctx the parse tree
	 */
	void exitLeadLagInfo(HDBViewParser.LeadLagInfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#inSumExpr}.
	 * @param ctx the parse tree
	 */
	void enterInSumExpr(HDBViewParser.InSumExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#inSumExpr}.
	 * @param ctx the parse tree
	 */
	void exitInSumExpr(HDBViewParser.InSumExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#identListArg}.
	 * @param ctx the parse tree
	 */
	void enterIdentListArg(HDBViewParser.IdentListArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#identListArg}.
	 * @param ctx the parse tree
	 */
	void exitIdentListArg(HDBViewParser.IdentListArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#identList}.
	 * @param ctx the parse tree
	 */
	void enterIdentList(HDBViewParser.IdentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#identList}.
	 * @param ctx the parse tree
	 */
	void exitIdentList(HDBViewParser.IdentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#runtimeFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterRuntimeFunctionCall(HDBViewParser.RuntimeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#runtimeFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitRuntimeFunctionCall(HDBViewParser.RuntimeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#timeFunctionParameters}.
	 * @param ctx the parse tree
	 */
	void enterTimeFunctionParameters(HDBViewParser.TimeFunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#timeFunctionParameters}.
	 * @param ctx the parse tree
	 */
	void exitTimeFunctionParameters(HDBViewParser.TimeFunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#fractionalPrecision}.
	 * @param ctx the parse tree
	 */
	void enterFractionalPrecision(HDBViewParser.FractionalPrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#fractionalPrecision}.
	 * @param ctx the parse tree
	 */
	void exitFractionalPrecision(HDBViewParser.FractionalPrecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#substringFunction}.
	 * @param ctx the parse tree
	 */
	void enterSubstringFunction(HDBViewParser.SubstringFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#substringFunction}.
	 * @param ctx the parse tree
	 */
	void exitSubstringFunction(HDBViewParser.SubstringFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(HDBViewParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(HDBViewParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#udfExprList}.
	 * @param ctx the parse tree
	 */
	void enterUdfExprList(HDBViewParser.UdfExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#udfExprList}.
	 * @param ctx the parse tree
	 */
	void exitUdfExprList(HDBViewParser.UdfExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#udfExpr}.
	 * @param ctx the parse tree
	 */
	void enterUdfExpr(HDBViewParser.UdfExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#udfExpr}.
	 * @param ctx the parse tree
	 */
	void exitUdfExpr(HDBViewParser.UdfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#whenExpression}.
	 * @param ctx the parse tree
	 */
	void enterWhenExpression(HDBViewParser.WhenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#whenExpression}.
	 * @param ctx the parse tree
	 */
	void exitWhenExpression(HDBViewParser.WhenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#thenExpression}.
	 * @param ctx the parse tree
	 */
	void enterThenExpression(HDBViewParser.ThenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#thenExpression}.
	 * @param ctx the parse tree
	 */
	void exitThenExpression(HDBViewParser.ThenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#elseExpression}.
	 * @param ctx the parse tree
	 */
	void enterElseExpression(HDBViewParser.ElseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#elseExpression}.
	 * @param ctx the parse tree
	 */
	void exitElseExpression(HDBViewParser.ElseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#castType}.
	 * @param ctx the parse tree
	 */
	void enterCastType(HDBViewParser.CastTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#castType}.
	 * @param ctx the parse tree
	 */
	void exitCastType(HDBViewParser.CastTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(HDBViewParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(HDBViewParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#notRule}.
	 * @param ctx the parse tree
	 */
	void enterNotRule(HDBViewParser.NotRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#notRule}.
	 * @param ctx the parse tree
	 */
	void exitNotRule(HDBViewParser.NotRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#not2Rule}.
	 * @param ctx the parse tree
	 */
	void enterNot2Rule(HDBViewParser.Not2RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#not2Rule}.
	 * @param ctx the parse tree
	 */
	void exitNot2Rule(HDBViewParser.Not2RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#exprListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterExprListWithParentheses(HDBViewParser.ExprListWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#exprListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitExprListWithParentheses(HDBViewParser.ExprListWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#exprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterExprWithParentheses(HDBViewParser.ExprWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#exprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitExprWithParentheses(HDBViewParser.ExprWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#simpleExprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExprWithParentheses(HDBViewParser.SimpleExprWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#simpleExprWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExprWithParentheses(HDBViewParser.SimpleExprWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#orderList}.
	 * @param ctx the parse tree
	 */
	void enterOrderList(HDBViewParser.OrderListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#orderList}.
	 * @param ctx the parse tree
	 */
	void exitOrderList(HDBViewParser.OrderListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#orderExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrderExpression(HDBViewParser.OrderExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#orderExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrderExpression(HDBViewParser.OrderExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#groupList}.
	 * @param ctx the parse tree
	 */
	void enterGroupList(HDBViewParser.GroupListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#groupList}.
	 * @param ctx the parse tree
	 */
	void exitGroupList(HDBViewParser.GroupListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#groupingExpression}.
	 * @param ctx the parse tree
	 */
	void enterGroupingExpression(HDBViewParser.GroupingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#groupingExpression}.
	 * @param ctx the parse tree
	 */
	void exitGroupingExpression(HDBViewParser.GroupingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#pureIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterPureIdentifier(HDBViewParser.PureIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#pureIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitPureIdentifier(HDBViewParser.PureIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(HDBViewParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(HDBViewParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(HDBViewParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(HDBViewParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#identifierListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierListWithParentheses(HDBViewParser.IdentifierListWithParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#identifierListWithParentheses}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierListWithParentheses(HDBViewParser.IdentifierListWithParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedIdentifier(HDBViewParser.QualifiedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedIdentifier(HDBViewParser.QualifiedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#simpleIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSimpleIdentifier(HDBViewParser.SimpleIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#simpleIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSimpleIdentifier(HDBViewParser.SimpleIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#dotIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterDotIdentifier(HDBViewParser.DotIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#dotIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitDotIdentifier(HDBViewParser.DotIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#ulong_number}.
	 * @param ctx the parse tree
	 */
	void enterUlong_number(HDBViewParser.Ulong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#ulong_number}.
	 * @param ctx the parse tree
	 */
	void exitUlong_number(HDBViewParser.Ulong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#real_ulong_number}.
	 * @param ctx the parse tree
	 */
	void enterReal_ulong_number(HDBViewParser.Real_ulong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#real_ulong_number}.
	 * @param ctx the parse tree
	 */
	void exitReal_ulong_number(HDBViewParser.Real_ulong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void enterUlonglong_number(HDBViewParser.Ulonglong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void exitUlonglong_number(HDBViewParser.Ulonglong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#real_ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void enterReal_ulonglong_number(HDBViewParser.Real_ulonglong_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#real_ulonglong_number}.
	 * @param ctx the parse tree
	 */
	void exitReal_ulonglong_number(HDBViewParser.Real_ulonglong_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(HDBViewParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(HDBViewParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#signedLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSignedLiteral(HDBViewParser.SignedLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#signedLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSignedLiteral(HDBViewParser.SignedLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#stringList}.
	 * @param ctx the parse tree
	 */
	void enterStringList(HDBViewParser.StringListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#stringList}.
	 * @param ctx the parse tree
	 */
	void exitStringList(HDBViewParser.StringListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#textStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTextStringLiteral(HDBViewParser.TextStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#textStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTextStringLiteral(HDBViewParser.TextStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#textString}.
	 * @param ctx the parse tree
	 */
	void enterTextString(HDBViewParser.TextStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#textString}.
	 * @param ctx the parse tree
	 */
	void exitTextString(HDBViewParser.TextStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#textStringHash}.
	 * @param ctx the parse tree
	 */
	void enterTextStringHash(HDBViewParser.TextStringHashContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#textStringHash}.
	 * @param ctx the parse tree
	 */
	void exitTextStringHash(HDBViewParser.TextStringHashContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#textLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTextLiteral(HDBViewParser.TextLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#textLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTextLiteral(HDBViewParser.TextLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#textStringNoLinebreak}.
	 * @param ctx the parse tree
	 */
	void enterTextStringNoLinebreak(HDBViewParser.TextStringNoLinebreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#textStringNoLinebreak}.
	 * @param ctx the parse tree
	 */
	void exitTextStringNoLinebreak(HDBViewParser.TextStringNoLinebreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#textStringLiteralList}.
	 * @param ctx the parse tree
	 */
	void enterTextStringLiteralList(HDBViewParser.TextStringLiteralListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#textStringLiteralList}.
	 * @param ctx the parse tree
	 */
	void exitTextStringLiteralList(HDBViewParser.TextStringLiteralListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#numLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumLiteral(HDBViewParser.NumLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#numLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumLiteral(HDBViewParser.NumLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(HDBViewParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#boolLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(HDBViewParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(HDBViewParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#nullLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(HDBViewParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#temporalLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTemporalLiteral(HDBViewParser.TemporalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#temporalLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTemporalLiteral(HDBViewParser.TemporalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#floatOptions}.
	 * @param ctx the parse tree
	 */
	void enterFloatOptions(HDBViewParser.FloatOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#floatOptions}.
	 * @param ctx the parse tree
	 */
	void exitFloatOptions(HDBViewParser.FloatOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#standardFloatOptions}.
	 * @param ctx the parse tree
	 */
	void enterStandardFloatOptions(HDBViewParser.StandardFloatOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#standardFloatOptions}.
	 * @param ctx the parse tree
	 */
	void exitStandardFloatOptions(HDBViewParser.StandardFloatOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#precision}.
	 * @param ctx the parse tree
	 */
	void enterPrecision(HDBViewParser.PrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#precision}.
	 * @param ctx the parse tree
	 */
	void exitPrecision(HDBViewParser.PrecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#textOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTextOrIdentifier(HDBViewParser.TextOrIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#textOrIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTextOrIdentifier(HDBViewParser.TextOrIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#sizeNumber}.
	 * @param ctx the parse tree
	 */
	void enterSizeNumber(HDBViewParser.SizeNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#sizeNumber}.
	 * @param ctx the parse tree
	 */
	void exitSizeNumber(HDBViewParser.SizeNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#parentheses}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(HDBViewParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#parentheses}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(HDBViewParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#equal}.
	 * @param ctx the parse tree
	 */
	void enterEqual(HDBViewParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#equal}.
	 * @param ctx the parse tree
	 */
	void exitEqual(HDBViewParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#identifierKeyword}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierKeyword(HDBViewParser.IdentifierKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#identifierKeyword}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierKeyword(HDBViewParser.IdentifierKeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#identifierKeywordsUnambiguous}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierKeywordsUnambiguous(HDBViewParser.IdentifierKeywordsUnambiguousContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#identifierKeywordsUnambiguous}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierKeywordsUnambiguous(HDBViewParser.IdentifierKeywordsUnambiguousContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#windowName}.
	 * @param ctx the parse tree
	 */
	void enterWindowName(HDBViewParser.WindowNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#windowName}.
	 * @param ctx the parse tree
	 */
	void exitWindowName(HDBViewParser.WindowNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#fieldIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldIdentifier(HDBViewParser.FieldIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#fieldIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldIdentifier(HDBViewParser.FieldIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(HDBViewParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(HDBViewParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#columnInternalRef}.
	 * @param ctx the parse tree
	 */
	void enterColumnInternalRef(HDBViewParser.ColumnInternalRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#columnInternalRef}.
	 * @param ctx the parse tree
	 */
	void exitColumnInternalRef(HDBViewParser.ColumnInternalRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#columnInternalRefList}.
	 * @param ctx the parse tree
	 */
	void enterColumnInternalRefList(HDBViewParser.ColumnInternalRefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#columnInternalRefList}.
	 * @param ctx the parse tree
	 */
	void exitColumnInternalRefList(HDBViewParser.ColumnInternalRefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void enterColumnRef(HDBViewParser.ColumnRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#columnRef}.
	 * @param ctx the parse tree
	 */
	void exitColumnRef(HDBViewParser.ColumnRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#tableRefWithWildcard}.
	 * @param ctx the parse tree
	 */
	void enterTableRefWithWildcard(HDBViewParser.TableRefWithWildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#tableRefWithWildcard}.
	 * @param ctx the parse tree
	 */
	void exitTableRefWithWildcard(HDBViewParser.TableRefWithWildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#tableAliasRefList}.
	 * @param ctx the parse tree
	 */
	void enterTableAliasRefList(HDBViewParser.TableAliasRefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#tableAliasRefList}.
	 * @param ctx the parse tree
	 */
	void exitTableAliasRefList(HDBViewParser.TableAliasRefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#tableWild}.
	 * @param ctx the parse tree
	 */
	void enterTableWild(HDBViewParser.TableWildContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#tableWild}.
	 * @param ctx the parse tree
	 */
	void exitTableWild(HDBViewParser.TableWildContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#tableRef}.
	 * @param ctx the parse tree
	 */
	void enterTableRef(HDBViewParser.TableRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#tableRef}.
	 * @param ctx the parse tree
	 */
	void exitTableRef(HDBViewParser.TableRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#fieldLength}.
	 * @param ctx the parse tree
	 */
	void enterFieldLength(HDBViewParser.FieldLengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#fieldLength}.
	 * @param ctx the parse tree
	 */
	void exitFieldLength(HDBViewParser.FieldLengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBViewParser#typeDatetimePrecision}.
	 * @param ctx the parse tree
	 */
	void enterTypeDatetimePrecision(HDBViewParser.TypeDatetimePrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBViewParser#typeDatetimePrecision}.
	 * @param ctx the parse tree
	 */
	void exitTypeDatetimePrecision(HDBViewParser.TypeDatetimePrecisionContext ctx);
}