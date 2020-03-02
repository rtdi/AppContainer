package io.rtdi.hanaappcontainer.designtimeobjects.hdbcds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSBaseListener;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.ColumndefaultContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.ColumnnullableContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.CommentContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.ContextContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.Datatype1Context;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.Datatype2Context;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.EntityContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.KeycolumnContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.NamespaceContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.antlr4.HDBCDSParser.RegularcolumnContext;
import io.rtdi.hanaappcontainer.objects.HanaObject;
import io.rtdi.hanaappcontainer.objects.table.HanaTable;
import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;

public class ANTLRHDBCDSSetter extends HDBCDSBaseListener {
	private List<String> currentcontext = new ArrayList<>();
	private String namespace = null;
	private HanaTable currenttable;
	private Map<String, HanaObject> tabledirectory = new HashMap<>();
	private String schemaname;
	
	public ANTLRHDBCDSSetter(String schemaname) {
		this.schemaname = schemaname;
	}

	@Override
	public void enterDatatype1(Datatype1Context ctx) {
		// TODO Auto-generated method stub
		super.enterDatatype1(ctx);
	}

	@Override
	public void enterDatatype2(Datatype2Context ctx) {
		// TODO Auto-generated method stub
		super.enterDatatype2(ctx);
	}

	@Override
	public void enterContext(ContextContext ctx) {
		ParseTree t = ctx.getChild(1);
		if (t != null) {
			this.currentcontext.add(t.getText());
		}
	}

	@Override
	public void enterColumndefault(ColumndefaultContext ctx) {
		// TODO Auto-generated method stub
		super.enterColumndefault(ctx);
	}

	@Override
	public void enterColumnnullable(ColumnnullableContext ctx) {
		// TODO Auto-generated method stub
		super.enterColumnnullable(ctx);
	}

	@Override
	public void enterKeycolumn(KeycolumnContext ctx) {
	}

	@Override
	public void enterNamespace(NamespaceContext ctx) {
		ParseTree t = ctx.getChild(1);
		if (t != null) {
			this.namespace = t.getText();
		}
	}

	@Override
	public void enterComment(CommentContext ctx) {
		// TODO Auto-generated method stub
		super.enterComment(ctx);
	}

	@Override
	public void enterEntity(EntityContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			currenttable = new HanaTable();
			String tablename = getTablePrefix() + t.getText();
			currenttable.setTableName(tablename);
			currenttable.setSchemaName(schemaname);
			tabledirectory.put(tablename, currenttable);
		}
	}

	private String getTablePrefix() {
		StringBuilder b = new StringBuilder();
		if (namespace != null && namespace.length() != 0) {
			b.append(namespace);
			b.append("::");
		}
		for (String contextpart : currentcontext) {
			b.append(contextpart);
			b.append('.');
		}
		if (b.length() == 0) {
			return "";
		} else {
			return b.toString();
		}
	}

	@Override
	public void exitContext(ContextContext ctx) {
		currentcontext.remove(currentcontext.size()-1);
	}

	@Override
	public void enterRegularcolumn(RegularcolumnContext ctx) {
		ParseTree t = ctx.getChild(0);
		if (currenttable.getColumns() == null) {
			currenttable.setColumns(new ArrayList<>());
		};
		ColumnDefinition d = new ColumnDefinition();
		d.setName(t.getText());
		currenttable.getColumns().add(d);
	}

	public Map<String, HanaObject> getTables() {
		return tabledirectory;
	}
}
