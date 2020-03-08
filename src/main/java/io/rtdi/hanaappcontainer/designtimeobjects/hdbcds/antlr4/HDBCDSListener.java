// Generated from HDBCDS.g4 by ANTLR 4.8
package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HDBCDSParser}.
 */
public interface HDBCDSListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link HDBCDSParser#namespace}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(HDBCDSParser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#namespace}.
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
	 * Enter a parse tree produced by {@link HDBCDSParser#columnname}.
	 * @param ctx the parse tree
	 */
	void enterColumnname(HDBCDSParser.ColumnnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#columnname}.
	 * @param ctx the parse tree
	 */
	void exitColumnname(HDBCDSParser.ColumnnameContext ctx);
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
	 * Enter a parse tree produced by {@link HDBCDSParser#joinclause}.
	 * @param ctx the parse tree
	 */
	void enterJoinclause(HDBCDSParser.JoinclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#joinclause}.
	 * @param ctx the parse tree
	 */
	void exitJoinclause(HDBCDSParser.JoinclauseContext ctx);
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
	 * Enter a parse tree produced by {@link HDBCDSParser#projection}.
	 * @param ctx the parse tree
	 */
	void enterProjection(HDBCDSParser.ProjectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#projection}.
	 * @param ctx the parse tree
	 */
	void exitProjection(HDBCDSParser.ProjectionContext ctx);
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
	 * Enter a parse tree produced by {@link HDBCDSParser#privcheck}.
	 * @param ctx the parse tree
	 */
	void enterPrivcheck(HDBCDSParser.PrivcheckContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#privcheck}.
	 * @param ctx the parse tree
	 */
	void exitPrivcheck(HDBCDSParser.PrivcheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link HDBCDSParser#databaseobject}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseobject(HDBCDSParser.DatabaseobjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#databaseobject}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseobject(HDBCDSParser.DatabaseobjectContext ctx);
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
	 * Enter a parse tree produced by {@link HDBCDSParser#quotedname}.
	 * @param ctx the parse tree
	 */
	void enterQuotedname(HDBCDSParser.QuotednameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HDBCDSParser#quotedname}.
	 * @param ctx the parse tree
	 */
	void exitQuotedname(HDBCDSParser.QuotednameContext ctx);
}