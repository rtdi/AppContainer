// Generated from HDBTable.g4 by ANTLR 4.4
package io.rtdi.hanaappcontainer.antlr4.hdbtable;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HDBTableParser}.
 */
public interface HDBTableListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#temporary}.
	 * @param ctx the parse tree
	 */
	void enterTemporary(@NotNull HDBTableParser.TemporaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#temporary}.
	 * @param ctx the parse tree
	 */
	void exitTemporary(@NotNull HDBTableParser.TemporaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columncomment}.
	 * @param ctx the parse tree
	 */
	void enterColumncomment(@NotNull HDBTableParser.ColumncommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columncomment}.
	 * @param ctx the parse tree
	 */
	void exitColumncomment(@NotNull HDBTableParser.ColumncommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#keyvaluepairs}.
	 * @param ctx the parse tree
	 */
	void enterKeyvaluepairs(@NotNull HDBTableParser.KeyvaluepairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#keyvaluepairs}.
	 * @param ctx the parse tree
	 */
	void exitKeyvaluepairs(@NotNull HDBTableParser.KeyvaluepairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columns}.
	 * @param ctx the parse tree
	 */
	void enterColumns(@NotNull HDBTableParser.ColumnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columns}.
	 * @param ctx the parse tree
	 */
	void exitColumns(@NotNull HDBTableParser.ColumnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnlength}.
	 * @param ctx the parse tree
	 */
	void enterColumnlength(@NotNull HDBTableParser.ColumnlengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnlength}.
	 * @param ctx the parse tree
	 */
	void exitColumnlength(@NotNull HDBTableParser.ColumnlengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexdef}.
	 * @param ctx the parse tree
	 */
	void enterIndexdef(@NotNull HDBTableParser.IndexdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexdef}.
	 * @param ctx the parse tree
	 */
	void exitIndexdef(@NotNull HDBTableParser.IndexdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(@NotNull HDBTableParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(@NotNull HDBTableParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnprecision}.
	 * @param ctx the parse tree
	 */
	void enterColumnprecision(@NotNull HDBTableParser.ColumnprecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnprecision}.
	 * @param ctx the parse tree
	 */
	void exitColumnprecision(@NotNull HDBTableParser.ColumnprecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnar}.
	 * @param ctx the parse tree
	 */
	void enterColumnar(@NotNull HDBTableParser.ColumnarContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnar}.
	 * @param ctx the parse tree
	 */
	void exitColumnar(@NotNull HDBTableParser.ColumnarContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#synonym}.
	 * @param ctx the parse tree
	 */
	void enterSynonym(@NotNull HDBTableParser.SynonymContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#synonym}.
	 * @param ctx the parse tree
	 */
	void exitSynonym(@NotNull HDBTableParser.SynonymContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(@NotNull HDBTableParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(@NotNull HDBTableParser.IndexesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexorder}.
	 * @param ctx the parse tree
	 */
	void enterIndexorder(@NotNull HDBTableParser.IndexorderContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexorder}.
	 * @param ctx the parse tree
	 */
	void exitIndexorder(@NotNull HDBTableParser.IndexorderContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnarray}.
	 * @param ctx the parse tree
	 */
	void enterColumnarray(@NotNull HDBTableParser.ColumnarrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnarray}.
	 * @param ctx the parse tree
	 */
	void exitColumnarray(@NotNull HDBTableParser.ColumnarrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#kvtypes}.
	 * @param ctx the parse tree
	 */
	void enterKvtypes(@NotNull HDBTableParser.KvtypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#kvtypes}.
	 * @param ctx the parse tree
	 */
	void exitKvtypes(@NotNull HDBTableParser.KvtypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#schemaname}.
	 * @param ctx the parse tree
	 */
	void enterSchemaname(@NotNull HDBTableParser.SchemanameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#schemaname}.
	 * @param ctx the parse tree
	 */
	void exitSchemaname(@NotNull HDBTableParser.SchemanameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#primarykeys}.
	 * @param ctx the parse tree
	 */
	void enterPrimarykeys(@NotNull HDBTableParser.PrimarykeysContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#primarykeys}.
	 * @param ctx the parse tree
	 */
	void exitPrimarykeys(@NotNull HDBTableParser.PrimarykeysContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexunique}.
	 * @param ctx the parse tree
	 */
	void enterIndexunique(@NotNull HDBTableParser.IndexuniqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexunique}.
	 * @param ctx the parse tree
	 */
	void exitIndexunique(@NotNull HDBTableParser.IndexuniqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexarray}.
	 * @param ctx the parse tree
	 */
	void enterIndexarray(@NotNull HDBTableParser.IndexarrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexarray}.
	 * @param ctx the parse tree
	 */
	void exitIndexarray(@NotNull HDBTableParser.IndexarrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnscale}.
	 * @param ctx the parse tree
	 */
	void enterColumnscale(@NotNull HDBTableParser.ColumnscaleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnscale}.
	 * @param ctx the parse tree
	 */
	void exitColumnscale(@NotNull HDBTableParser.ColumnscaleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnnullable}.
	 * @param ctx the parse tree
	 */
	void enterColumnnullable(@NotNull HDBTableParser.ColumnnullableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnnullable}.
	 * @param ctx the parse tree
	 */
	void exitColumnnullable(@NotNull HDBTableParser.ColumnnullableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnname}.
	 * @param ctx the parse tree
	 */
	void enterColumnname(@NotNull HDBTableParser.ColumnnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnname}.
	 * @param ctx the parse tree
	 */
	void exitColumnname(@NotNull HDBTableParser.ColumnnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columndefaultvalue}.
	 * @param ctx the parse tree
	 */
	void enterColumndefaultvalue(@NotNull HDBTableParser.ColumndefaultvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columndefaultvalue}.
	 * @param ctx the parse tree
	 */
	void exitColumndefaultvalue(@NotNull HDBTableParser.ColumndefaultvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexcolumns}.
	 * @param ctx the parse tree
	 */
	void enterIndexcolumns(@NotNull HDBTableParser.IndexcolumnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexcolumns}.
	 * @param ctx the parse tree
	 */
	void exitIndexcolumns(@NotNull HDBTableParser.IndexcolumnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexType}.
	 * @param ctx the parse tree
	 */
	void enterIndexType(@NotNull HDBTableParser.IndexTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexType}.
	 * @param ctx the parse tree
	 */
	void exitIndexType(@NotNull HDBTableParser.IndexTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#primarykeyindextype}.
	 * @param ctx the parse tree
	 */
	void enterPrimarykeyindextype(@NotNull HDBTableParser.PrimarykeyindextypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#primarykeyindextype}.
	 * @param ctx the parse tree
	 */
	void exitPrimarykeyindextype(@NotNull HDBTableParser.PrimarykeyindextypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnunique}.
	 * @param ctx the parse tree
	 */
	void enterColumnunique(@NotNull HDBTableParser.ColumnuniqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnunique}.
	 * @param ctx the parse tree
	 */
	void exitColumnunique(@NotNull HDBTableParser.ColumnuniqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexname}.
	 * @param ctx the parse tree
	 */
	void enterIndexname(@NotNull HDBTableParser.IndexnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexname}.
	 * @param ctx the parse tree
	 */
	void exitIndexname(@NotNull HDBTableParser.IndexnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#logging}.
	 * @param ctx the parse tree
	 */
	void enterLogging(@NotNull HDBTableParser.LoggingContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#logging}.
	 * @param ctx the parse tree
	 */
	void exitLogging(@NotNull HDBTableParser.LoggingContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnsqltype}.
	 * @param ctx the parse tree
	 */
	void enterColumnsqltype(@NotNull HDBTableParser.ColumnsqltypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnsqltype}.
	 * @param ctx the parse tree
	 */
	void exitColumnsqltype(@NotNull HDBTableParser.ColumnsqltypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columndef}.
	 * @param ctx the parse tree
	 */
	void enterColumndef(@NotNull HDBTableParser.ColumndefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columndef}.
	 * @param ctx the parse tree
	 */
	void exitColumndef(@NotNull HDBTableParser.ColumndefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#stringarray}.
	 * @param ctx the parse tree
	 */
	void enterStringarray(@NotNull HDBTableParser.StringarrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#stringarray}.
	 * @param ctx the parse tree
	 */
	void exitStringarray(@NotNull HDBTableParser.StringarrayContext ctx);
}