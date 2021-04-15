package io.rtdi.appcontainer.objects.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import io.rtdi.appcontainer.activationapp.ActivationResult;
import io.rtdi.appcontainer.activationapp.ActivationStyle;
import io.rtdi.appcontainer.activationapp.ActivationSuccess;
import io.rtdi.appcontainer.objects.Association;
import io.rtdi.appcontainer.objects.ColumnMask;
import io.rtdi.appcontainer.objects.HanaObjectWithColumns;
import io.rtdi.appcontainer.objects.table.subelements.ColumnDefinition;
import io.rtdi.appcontainer.utils.HanaSQLException;

public class HanaView extends HanaObjectWithColumns {
	private String viewdefinition = null;
	private List<ColumnDefinition> parameters;
	private Map<String, Association> associations;
	private Boolean hasStructuredPriv;
	private List<ColumnMask> maskedcolumns;
	private ViewCacheSpec cachespec;
	
	public HanaView(String schemaname, String viewname) throws HanaSQLException {
		super(schemaname, viewname);
	}

	public List<ColumnDefinition> getParameters() {
		return parameters;
	}
	
	public Map<String, Association> getAssociations() {
		return associations;
	}
	
	@Override
	public ActivationResult activate(ActivationResult result, Connection conn, ActivationStyle activation) throws HanaSQLException {
		try {
			String viewname = getObjectName();
			HanaViewDiffAction action = new HanaViewDiffAction(conn, this, activation, result);
			HanaView currentview = createDefinitionFromDatabase(conn, getSchemaName(), viewname);
			if (currentview == null) {
				action.createView();
			} else {
				action.addCreationMessage("View exists already, applying changes if needed", null, ActivationSuccess.SUCCESS);
				currentview.diff(action);
			}
			return result;
		} catch (HanaSQLException e) {
			result.addResult(e.toString(), e.getSQLStatement(), ActivationSuccess.FAILED, this);
			throw e;
		}
	}

	private void diff(HanaViewDiffAction action) throws HanaSQLException {
		try {
			boolean recreate = false;
			if (parameters != null && action.getObject().getParameters() == null ||
					parameters == null && action.getObject().getParameters() != null ||
					(parameters != null && action.getObject().getParameters() != null && !parameters.equals(action.getObject().getParameters()))) {
				recreate = true;
			}
			if (recreate) {
				action.dropView();
				action.createView();
			} else {
				if (!viewdefinition.equals(action.getObject().getViewDefinition())) {
					action.alterViewDefinition();
				}
			}
		} catch (HanaSQLException e) {
			action.addCreationMessage(e.toString(), e.getSQLStatement(), ActivationSuccess.FAILED);
			throw e;
		}
	}

	public static HanaView createDefinitionFromDatabase(Connection conn, String schemaName, String viewname) throws HanaSQLException {
		HanaView view = new HanaView(schemaName, viewname);
		String sql = "select definition, comments from views where schema_name = ? and view_name = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schemaName);
			stmt.setString(2, viewname);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					view.setViewDefinition(rs.getString(1));
					view.setDescription(rs.getString(2));
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw new HanaSQLException(e, sql, "Failed to query the database for the view definition");
		}
		sql = "select column_name, data_type_name, length, scale, is_nullable, comment from view_columns where schema_name = ? and view_name = ? order by position";
		try (PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, schemaName);
			stmt.setString(2, viewname);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					ColumnDefinition column = new ColumnDefinition();
					column.setName(rs.getString(1));
					column.setDataType(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5).equalsIgnoreCase("TRUE"));
					column.setComment(rs.getString(6));
					view.addColumn(column);
				}
			}
		} catch (SQLException e) {
			throw new HanaSQLException(e, sql, "Failed to query the database for the view columns");
		}
		return view;
	}

	public void setViewDefinition(String viewdefinition) {
		this.viewdefinition = viewdefinition;
	}

	public String getViewDefinition() {
		return viewdefinition;
	}
	
	public static enum CacheType {
		STATIC,
		DYNAMIC;
	}
	
	public static class ViewCacheSpec {
		private CacheType cachetype;
		private int retention_minutes;
		private String projection;
		private String filter;
		private String location;
		private boolean force;
		
		public int getRetentionTime() {
			return retention_minutes;
		}
		
		public void setRetentionTime(int minutes) {
			this.retention_minutes = minutes;
		}

		public CacheType getCacheType() {
			return cachetype;
		}
		
		public void setCacheType(CacheType type) {
			this.cachetype = type;
		}

		public String getProjection() {
			return projection;
		}

		public void setProjection(String projection) {
			this.projection = projection;
		}

		public String getFilter() {
			return filter;
		}

		public void setFilter(String filter) {
			this.filter = filter;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public boolean isForce() {
			return force;
		}

		public void setForce(boolean force) {
			this.force = force;
		}
	}

	public Boolean getHasStructuredPriv() {
		return hasStructuredPriv;
	}
	
	public void setStructuredPriv(Boolean b) {
		this.hasStructuredPriv = b;
	}

	public List<ColumnMask> getMaskedColumns() {
		return maskedcolumns;
	}

	public ViewCacheSpec getCacheSpec() {
		return cachespec;
	}
	
}
