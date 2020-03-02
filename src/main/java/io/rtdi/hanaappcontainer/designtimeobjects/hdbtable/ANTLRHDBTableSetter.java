package io.rtdi.hanaappcontainer.designtimeobjects.hdbtable;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableBaseListener;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumnarContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumncommentContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumndefContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumndefaultvalueContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumnlengthContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumnnameContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumnnullableContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumnprecisionContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumnscaleContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumnsqltypeContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.ColumnuniqueContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.DescriptionContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.IndexTypeContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.IndexcolumnsContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.IndexdefContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.IndexnameContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.IndexorderContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.IndexuniqueContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.LoggingContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.PrimarykeyindextypeContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.PrimarykeysContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.SchemanameContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.StringarrayContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.SynonymContext;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.antlr4.HDBTableParser.TemporaryContext;
import io.rtdi.hanaappcontainer.objects.table.HanaTable;
import io.rtdi.hanaappcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.IndexDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.IndexType;
import io.rtdi.hanaappcontainer.objects.table.subelements.Order;
import io.rtdi.hanaappcontainer.objects.table.subelements.PrimaryKeyDefinition;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableLoggingType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TableType;
import io.rtdi.hanaappcontainer.objects.table.subelements.TemporaryType;
import io.rtdi.hanaappserver.utils.HanaDataType;
import io.rtdi.hanaappserver.utils.Util;


public class ANTLRHDBTableSetter extends HDBTableBaseListener {
	
	private HanaTable hdbtable;
	private ColumnDefinition columndef;
	private IndexDefinition indexdef;

	public ANTLRHDBTableSetter(HanaTable hdbtable) {
		this.hdbtable = hdbtable;
	}

	@Override
	public void enterTemporary(TemporaryContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			String s = t.getText().toUpperCase();
			switch (s) {
			case "TRUE": 
				hdbtable.setTemporary(TemporaryType.GLOBALTEMPORARY);
				break;
			case "FALSE":
				break;
			default:
				hdbtable.addCreationMessage("The value for \"table.temporary\" can only be \"true\" or \"false\" (" + t.getText() + "\"");	
			}
		}
	}

	@Override
	public void enterColumncomment(ColumncommentContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			columndef.setComment(Util.trimQuotes(t.getText()));
		}
	}

	@Override
	public void enterColumnlength(ColumnlengthContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			try {
				columndef.setLength(Integer.valueOf(t.getText()));
			} catch (NumberFormatException e) {
				hdbtable.addCreationMessage("The column \"" + columndef.getName() + "\" has no valid length number (" + t.getText() + ")");
			}
		}
	}

	@Override
	public void enterIndexdef(IndexdefContext ctx) {
		this.indexdef = new IndexDefinition();
		if (hdbtable.getIndexes() == null) {
			hdbtable.setIndexes(new ArrayList<>());
		}
		hdbtable.getIndexes().add(indexdef);
	}

	@Override
	public void enterDescription(DescriptionContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			hdbtable.setDescription(Util.trimQuotes(t.getText()));
		}
	}

	@Override
	public void enterColumnprecision(ColumnprecisionContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			try {
				columndef.setPrecision(Integer.valueOf(t.getText()));
			} catch (NumberFormatException e) {
				hdbtable.addCreationMessage("The column \"" + columndef.getName() + "\" has no valid precision number (" + t.getText() + ")");
			}
		}
	}

	@Override
	public void enterColumnar(ColumnarContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			String s = t.getText();
			switch (s) {
			case "ROWSTORE":
				hdbtable.setTableType(TableType.ROW);
				break;
			case "COLUMNSTORE":
				hdbtable.setTableType(TableType.COLUMN);
				break;
			default:
				break;
			}			
		}
	}

	@Override
	public void enterSynonym(SynonymContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			String s = t.getText().toUpperCase();
			switch (s) {
			case "TRUE": 
				hdbtable.setHasPublicSynonym(Boolean.TRUE);
				break;
			case "FALSE":
				break;
			default:
				hdbtable.addCreationMessage("The value for \"table.public\" can only be \"true\" or \"false\" (" + t.getText() + "\"");	
			}
		}
	}

	@Override
	public void enterIndexorder(IndexorderContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			String s = t.getText().toUpperCase();
			switch (s) {
			case "ASC":
				indexdef.setOrder(Order.ASC);
				break;
			case "DSC":
				indexdef.setOrder(Order.DESC);
				break;
			default:
				hdbtable.addCreationMessage("The value for the index definition \"order\" can only be \"ASC\" or \"DSC\" (" + t.getText() + "\"");	
			}
		}
	}


	@Override
	public void enterSchemaname(SchemanameContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			hdbtable.setSchemaName(Util.trimQuotes(t.getText()));
		}
	}

	@Override
	public void enterPrimarykeys(PrimarykeysContext ctx) {
		if (hdbtable.getPrimaryKey() == null) {
			hdbtable.setPrimaryKey(new PrimaryKeyDefinition());
		}
		ParseTree t = ctx.getChild(2);
		hdbtable.getPrimaryKey().setPkcolumns(getStringArray(t));
	}

	@Override
	public void enterIndexunique(IndexuniqueContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			String s = t.getText().toUpperCase();
			switch (s) {
			case "TRUE": 
				indexdef.setUnique(Boolean.TRUE);
				break;
			case "FALSE":
				indexdef.setUnique(Boolean.FALSE);
				break;
			default:
				hdbtable.addCreationMessage("The column \"" + columndef.getName() + "\" has no valid unique boolean value (" + t.getText() + ")");	
			}
		}
	}

	@Override
	public void enterColumnscale(ColumnscaleContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			try {
				columndef.setScale(Integer.valueOf(t.getText()));
			} catch (NumberFormatException e) {
				hdbtable.addCreationMessage("The column \"" + columndef.getName() + "\" has no valid scale number (" + t.getText() + ")");
			}
		}
	}

	@Override
	public void enterColumnnullable(ColumnnullableContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			String s = t.getText().toUpperCase();
			switch (s) {
			case "TRUE": 
				columndef.setNullable(Boolean.TRUE);
				break;
			case "FALSE":
				columndef.setNullable(Boolean.FALSE);
				break;
			default:
				hdbtable.addCreationMessage("The column \"" + columndef.getName() + "\" has no valid nullable boolean value (" + t.getText() + ")");	
			}
		}
	}

	@Override
	public void enterColumnname(ColumnnameContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			columndef.setName(Util.trimQuotes(t.getText()));
		}
	}

	@Override
	public void enterColumndefaultvalue(ColumndefaultvalueContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			columndef.setDefaultValue(Util.trimQuotes(t.getText()));
		}
	}

	@Override
	public void enterIndexcolumns(IndexcolumnsContext ctx) {
		ParseTree t = ctx.getChild(2);
		indexdef.setIndexColumns(getStringArray(t));
	}

	private List<String> getStringArray(ParseTree element) {
		List<String> l = new ArrayList<>();
		for (int i=0; i<element.getChildCount();i++) {
			ParseTree t = element.getChild(i);
			String tag = t.getText();
			switch (tag) {
			case "[":
			case "]":
			case ",":
				break;
			default:
				if (tag.startsWith("\"") && tag.endsWith("\"")) {
					l.add(tag.substring(1, tag.length()-1));
				} else {
					l.add(tag);
				}
			}
		}
		return l;
	}
	
	@Override
	public void enterIndexType(IndexTypeContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			String s = t.getText().toUpperCase();
			switch (s) {
			case "B_TREE":
				indexdef.setIndexType(IndexType.BTREE);
				break;
			case "CPB_TREE":
				indexdef.setIndexType(IndexType.CPBTREE);
				break;
			default:
				hdbtable.addCreationMessage("The value for the index definition \"order\" can only be \"ASC\" or \"DSC\" (" + t.getText() + "\"");	
			}
		}
	}

	@Override
	public void enterPrimarykeyindextype(PrimarykeyindextypeContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			if (hdbtable.getPrimaryKey() == null) {
				hdbtable.setPrimaryKey(new PrimaryKeyDefinition());
			}
			switch (t.getText().toUpperCase()) {
			case "B_TREE": 
				hdbtable.getPrimaryKey().setIndexType(IndexType.BTREE);
				break;
			case "CPB_TREE": 
				hdbtable.getPrimaryKey().setIndexType(IndexType.CPBTREE);
				break;
			default:
				hdbtable.addCreationMessage("The value for the index definition \"type\" can only be \"B_TREE\" or \"CPB_TREE\" (" + t.getText() + "\"");	
			}
		}
	}

	@Override
	public void enterColumnunique(ColumnuniqueContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			String s = t.getText().toUpperCase();
			switch (s) {
			case "TRUE": 
				columndef.setUnique(Boolean.TRUE);
				break;
			case "FALSE":
				columndef.setUnique(Boolean.FALSE);
				break;
			default:
				hdbtable.addCreationMessage("The column \"" + columndef.getName() + "\" has no valid unique boolean value (" + t.getText() + ")");	
			}
		}
	}

	@Override
	public void enterIndexname(IndexnameContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			indexdef.setName(Util.trimQuotes(t.getText()));
		}
	}

	@Override
	public void enterLogging(LoggingContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			String s = t.getText().toUpperCase();
			switch (s) {
			case "NOLOGGING":
				hdbtable.setLoggingType(TableLoggingType.NOLOGGING);
				break;
			case "LOGGING":
				hdbtable.setLoggingType(TableLoggingType.LOGGING);
				break;
			default:
				hdbtable.addCreationMessage("The value for the table logging can only be \"LOGGING\" or \"NOLOGGING\" (" + t.getText() + "\"");	
				break;
			}
		}
	}

	@Override
	public void enterColumnsqltype(ColumnsqltypeContext ctx) {
		ParseTree t = ctx.getChild(2);
		if (t != null) {
			try {
				columndef.setSqlType(HanaDataType.valueOf(t.getText()));
			} catch (Exception e) {
				hdbtable.addCreationMessage("The column \"" + columndef.getName() + "\" has no valid sqlType value (" + t.getText() + ")");	
			}
		}
	}

	@Override
	public void enterColumndef(ColumndefContext ctx) {
		this.columndef = new ColumnDefinition();
		if (hdbtable.getColumns() == null) {
			hdbtable.setColumns(new ArrayList<>());
		}
		hdbtable.getColumns().add(columndef);
	}

	@Override
	public void enterStringarray(StringarrayContext ctx) {
		// TODO Auto-generated method stub
		super.enterStringarray(ctx);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		super.visitTerminal(node);
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		hdbtable.addCreationMessage("Found the text \"" + node.getText() + "\" which cannot be parsed. The file is syntactically incorrect.");
		hdbtable.addCreationMessage("Details: " + node.toStringTree());
	}

}
