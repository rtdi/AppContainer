// Generated from HDBTable.g4 by ANTLR 4.8
package io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HDBTableParser}.
 */
public interface HDBTableListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#keyvaluepairs}.
	 * @param ctx the parse tree
	 */
	void enterKeyvaluepairs(HDBTableParser.KeyvaluepairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#keyvaluepairs}.
	 * @param ctx the parse tree
	 */
	void exitKeyvaluepairs(HDBTableParser.KeyvaluepairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#kvtypes}.
	 * @param ctx the parse tree
	 */
	void enterKvtypes(HDBTableParser.KvtypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#kvtypes}.
	 * @param ctx the parse tree
	 */
	void exitKvtypes(HDBTableParser.KvtypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#schemaname}.
	 * @param ctx the parse tree
	 */
	void enterSchemaname(HDBTableParser.SchemanameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#schemaname}.
	 * @param ctx the parse tree
	 */
	void exitSchemaname(HDBTableParser.SchemanameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#synonym}.
	 * @param ctx the parse tree
	 */
	void enterSynonym(HDBTableParser.SynonymContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#synonym}.
	 * @param ctx the parse tree
	 */
	void exitSynonym(HDBTableParser.SynonymContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(HDBTableParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(HDBTableParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#temporary}.
	 * @param ctx the parse tree
	 */
	void enterTemporary(HDBTableParser.TemporaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#temporary}.
	 * @param ctx the parse tree
	 */
	void exitTemporary(HDBTableParser.TemporaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#logging}.
	 * @param ctx the parse tree
	 */
	void enterLogging(HDBTableParser.LoggingContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#logging}.
	 * @param ctx the parse tree
	 */
	void exitLogging(HDBTableParser.LoggingContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnar}.
	 * @param ctx the parse tree
	 */
	void enterColumnar(HDBTableParser.ColumnarContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnar}.
	 * @param ctx the parse tree
	 */
	void exitColumnar(HDBTableParser.ColumnarContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columns}.
	 * @param ctx the parse tree
	 */
	void enterColumns(HDBTableParser.ColumnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columns}.
	 * @param ctx the parse tree
	 */
	void exitColumns(HDBTableParser.ColumnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexes}.
	 * @param ctx the parse tree
	 */
	void enterIndexes(HDBTableParser.IndexesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexes}.
	 * @param ctx the parse tree
	 */
	void exitIndexes(HDBTableParser.IndexesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#primarykeys}.
	 * @param ctx the parse tree
	 */
	void enterPrimarykeys(HDBTableParser.PrimarykeysContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#primarykeys}.
	 * @param ctx the parse tree
	 */
	void exitPrimarykeys(HDBTableParser.PrimarykeysContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#primarykeyindextype}.
	 * @param ctx the parse tree
	 */
	void enterPrimarykeyindextype(HDBTableParser.PrimarykeyindextypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#primarykeyindextype}.
	 * @param ctx the parse tree
	 */
	void exitPrimarykeyindextype(HDBTableParser.PrimarykeyindextypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnarray}.
	 * @param ctx the parse tree
	 */
	void enterColumnarray(HDBTableParser.ColumnarrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnarray}.
	 * @param ctx the parse tree
	 */
	void exitColumnarray(HDBTableParser.ColumnarrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columndef}.
	 * @param ctx the parse tree
	 */
	void enterColumndef(HDBTableParser.ColumndefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columndef}.
	 * @param ctx the parse tree
	 */
	void exitColumndef(HDBTableParser.ColumndefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexarray}.
	 * @param ctx the parse tree
	 */
	void enterIndexarray(HDBTableParser.IndexarrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexarray}.
	 * @param ctx the parse tree
	 */
	void exitIndexarray(HDBTableParser.IndexarrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexdef}.
	 * @param ctx the parse tree
	 */
	void enterIndexdef(HDBTableParser.IndexdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexdef}.
	 * @param ctx the parse tree
	 */
	void exitIndexdef(HDBTableParser.IndexdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnname}.
	 * @param ctx the parse tree
	 */
	void enterColumnname(HDBTableParser.ColumnnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnname}.
	 * @param ctx the parse tree
	 */
	void exitColumnname(HDBTableParser.ColumnnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnsqltype}.
	 * @param ctx the parse tree
	 */
	void enterColumnsqltype(HDBTableParser.ColumnsqltypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnsqltype}.
	 * @param ctx the parse tree
	 */
	void exitColumnsqltype(HDBTableParser.ColumnsqltypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnnullable}.
	 * @param ctx the parse tree
	 */
	void enterColumnnullable(HDBTableParser.ColumnnullableContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnnullable}.
	 * @param ctx the parse tree
	 */
	void exitColumnnullable(HDBTableParser.ColumnnullableContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnlength}.
	 * @param ctx the parse tree
	 */
	void enterColumnlength(HDBTableParser.ColumnlengthContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnlength}.
	 * @param ctx the parse tree
	 */
	void exitColumnlength(HDBTableParser.ColumnlengthContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnprecision}.
	 * @param ctx the parse tree
	 */
	void enterColumnprecision(HDBTableParser.ColumnprecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnprecision}.
	 * @param ctx the parse tree
	 */
	void exitColumnprecision(HDBTableParser.ColumnprecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnscale}.
	 * @param ctx the parse tree
	 */
	void enterColumnscale(HDBTableParser.ColumnscaleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnscale}.
	 * @param ctx the parse tree
	 */
	void exitColumnscale(HDBTableParser.ColumnscaleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columndefaultvalue}.
	 * @param ctx the parse tree
	 */
	void enterColumndefaultvalue(HDBTableParser.ColumndefaultvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columndefaultvalue}.
	 * @param ctx the parse tree
	 */
	void exitColumndefaultvalue(HDBTableParser.ColumndefaultvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columncomment}.
	 * @param ctx the parse tree
	 */
	void enterColumncomment(HDBTableParser.ColumncommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columncomment}.
	 * @param ctx the parse tree
	 */
	void exitColumncomment(HDBTableParser.ColumncommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#columnunique}.
	 * @param ctx the parse tree
	 */
	void enterColumnunique(HDBTableParser.ColumnuniqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#columnunique}.
	 * @param ctx the parse tree
	 */
	void exitColumnunique(HDBTableParser.ColumnuniqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexname}.
	 * @param ctx the parse tree
	 */
	void enterIndexname(HDBTableParser.IndexnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexname}.
	 * @param ctx the parse tree
	 */
	void exitIndexname(HDBTableParser.IndexnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexunique}.
	 * @param ctx the parse tree
	 */
	void enterIndexunique(HDBTableParser.IndexuniqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexunique}.
	 * @param ctx the parse tree
	 */
	void exitIndexunique(HDBTableParser.IndexuniqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexorder}.
	 * @param ctx the parse tree
	 */
	void enterIndexorder(HDBTableParser.IndexorderContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexorder}.
	 * @param ctx the parse tree
	 */
	void exitIndexorder(HDBTableParser.IndexorderContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexType}.
	 * @param ctx the parse tree
	 */
	void enterIndexType(HDBTableParser.IndexTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexType}.
	 * @param ctx the parse tree
	 */
	void exitIndexType(HDBTableParser.IndexTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#indexcolumns}.
	 * @param ctx the parse tree
	 */
	void enterIndexcolumns(HDBTableParser.IndexcolumnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#indexcolumns}.
	 * @param ctx the parse tree
	 */
	void exitIndexcolumns(HDBTableParser.IndexcolumnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBTableParser#stringarray}.
	 * @param ctx the parse tree
	 */
	void enterStringarray(HDBTableParser.StringarrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBTableParser#stringarray}.
	 * @param ctx the parse tree
	 */
	void exitStringarray(HDBTableParser.StringarrayContext ctx);
}