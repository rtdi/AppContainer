package io.rtdi.appcontainer.repo.rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.AppContainerSQLException;
import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.ObjectType;
import io.rtdi.appcontainer.repo.CreateCSV;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.rest.entity.SuccessMessage;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import io.rtdi.appcontainer.utils.DatabaseProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/repo/reveng")
public class DatabaseReverseEngineer {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("list/{schema}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Lists all import-able objects",
			description = "Returns a list of all import-able objects in the database",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "List of objects as tree",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = DBObjectTree.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response getImportableObjects(
    		@PathParam("schema") 
		    @Parameter(
		    		description = "Schema of the objects to import",
		    		example = "SYS"
		    		)
			String schemaraw
    	) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			DBObjectTree tree = new DBObjectTree(schemaraw, servletContext, dbprincipal);
			return Response.ok(tree).build();
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}
	
	@POST
	@Path("import/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Import specific objects",
			description = "Import all selected objects into the repo directory",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "List of objects as tree",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = DBObjectTree.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response importObjects(
    		@PathParam("path") 
       		@Parameter(
       	    		description = "Path where to import the db objects to",
       	    		example = "dir1"
       	    		)
       		String path,
			DBObjectTree tree
    	) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			java.nio.file.Path targetpath = RepoService.getEffectivePath(request, path);
			try (Connection conn = dbprincipal.getConnection();) {
				IDatabaseProvider provider = DatabaseProvider.getDatabaseProvider(servletContext, dbprincipal.getDriver());
				importObjectsRecursive(tree, targetpath, provider, conn);
				return Response.ok(tree).build();
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}
	
	@POST
	@Path("importdata/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Import a single table",
			description = "Import the contents of a table/view as CSV file",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "Simple success message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response importData(
    		@PathParam("path") 
       		@Parameter(
       	    		description = "Path of the CSV file to be created",
       	    		example = "dir1/TABLE1.csv"
       	    		)
       		String path,
			String sql
    	) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			java.nio.file.Path targetpath = RepoService.getEffectivePath(request, path);
			try (Connection conn = dbprincipal.getConnection();) {
				int rowcount = CreateCSV.createCSV(conn, sql, targetpath);
				return SuccessMessage.createResponseOK(String.format("Data imported, %d rows", rowcount));
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}
		
	@GET
	@Path("importall/{schema}/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Import specific objects",
			description = "Returns a list of all import-able objects in the database",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "List of objects as tree",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = DBObjectTree.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "202", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Repository")
    public Response importAllObjects(
			@PathParam("schema") 
			@Parameter(
					description = "Schema of the objects to import",
					example = "SYS"
					)
			String schemaraw,
			@PathParam("path") 
			@Parameter(
					description = "Path where to import the db objects to",
					example = "dir1"
					)
			String path
    	) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			java.nio.file.Path targetpath = RepoService.getEffectivePath(request, path);
			try (Connection conn = dbprincipal.getConnection();) {
				IDatabaseProvider provider = DatabaseProvider.getDatabaseProvider(servletContext, dbprincipal.getDriver());
				DBObjectTree tree = new DBObjectTree(schemaraw, servletContext, dbprincipal);
				importObjectsRecursive(tree, targetpath, provider, conn);
				return Response.ok(tree).build();
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	private static void importObjectsRecursive(
			DBObjectNode node,
			java.nio.file.Path targetpath,
			IDatabaseProvider provider,
			Connection conn) throws SQLException, IOException {
		if (node.isToImport() && node.getObjectType() != null) {
			String ddl = null;
			switch (node.getObjectType()) {
			case FUNCTION:
				ddl = provider.getCatalogService().getFunctionDDL(conn, node.schemaname, node.objectname);
				break;
			case PROCEDURE:
				ddl = provider.getCatalogService().getProcedureDDL(conn, node.schemaname, node.objectname);
				break;
			case TABLE:
				ddl = provider.getCatalogService().getTableDDL(conn, node.schemaname, node.objectname);
				break;
			case VIEW:
				ddl = provider.getCatalogService().getViewDDL(conn, node.schemaname, node.objectname);
				break;
			default:
				break;
			}
			if (ddl != null) {
				File dir = targetpath.toFile();
				if (!dir.exists()) {
					dir.mkdirs();
				}
				File file = targetpath.resolve(node.getNodeName() + ".sql").toFile();
				if (file.exists()) {
					node.importresult = "File exists .. skipped";
				} else {
					Files.writeString(file.toPath(), ddl);
					node.importresult = "File created";
				}
			}
		}
		java.nio.file.Path p = targetpath.resolve(node.getNodeName());
		if (node.getChildren() != null) {
			for (DBObjectNode child : node.getChildren()) {
				importObjectsRecursive(child, p, provider, conn);
			}
		}
	}

	
	public static class DBObjectTree extends DBObjectNode {
		
		public DBObjectTree(String schemaname) {
			super(schemaname, null);
		}
		
		public DBObjectTree(String schemaname, ServletContext servletContext, IDatabaseLoginPrincipal dbprincipal) throws SQLException, IOException {
			this(schemaname);
			try (Connection conn = dbprincipal.getConnection();) {
				// Read all tables
				DBObjectNode tables = this.addChild(new DBObjectNode("00_TABLES", null));
				String[] types = {"TABLE"};
				try (ResultSet rs = conn.getMetaData().getTables(null, schemaname, null, types);) {
					while (rs.next()) {
						DBObjectNode table = new DBObjectNode(rs.getString(3), rs.getString(2), rs.getString(3), ObjectType.TABLE);
						tables.addChild(table);
					}
				} catch (SQLException e) {
					throw AppContainerSQLException.cloneFrom("Cannot read all tables", e, "JDBC: getTables()", null);
				}
				
				// Read all views
				DBObjectNode views = this.addChild(new DBObjectNode("01_VIEWS", null));
				types[0] = "VIEW";
				try (ResultSet rs = conn.getMetaData().getTables(null, schemaname, null, types);) {
					while (rs.next()) {
						DBObjectNode view = new DBObjectNode(rs.getString(3), rs.getString(2), rs.getString(3), ObjectType.TABLE);
						views.addChild(view);
					}
				} catch (SQLException e) {
					throw AppContainerSQLException.cloneFrom("Cannot read all tables", e, "JDBC: getTables()", null);
				}

				// Read all functions
				DBObjectNode funcs = this.addChild(new DBObjectNode("02_FUNCTIONS", null));
				types[0] = "FUNCTIONS";
				try (ResultSet rs = conn.getMetaData().getTables(null, schemaname, null, types);) {
					while (rs.next()) {
						DBObjectNode func = new DBObjectNode(rs.getString(3), rs.getString(2), rs.getString(3), ObjectType.FUNCTION);
						funcs.addChild(func);
					}
				} catch (SQLException e) {
					throw AppContainerSQLException.cloneFrom("Cannot read all functions", e, "JDBC: getTables()", null);
				}

				// Read all procedures
				DBObjectNode procs = this.addChild(new DBObjectNode("03_PROCEDURES", null));
				types[0] = "PROCEDURE";
				try (ResultSet rs = conn.getMetaData().getTables(null, schemaname, null, types);) {
					while (rs.next()) {
						DBObjectNode proc = new DBObjectNode(rs.getString(3), rs.getString(2), rs.getString(3), ObjectType.PROCEDURE);
						procs.addChild(proc);
					}
				} catch (SQLException e) {
					throw AppContainerSQLException.cloneFrom("Cannot read all procedures", e, "JDBC: getTables()", null);
				}
			}
		}
	}

	public static class DBObjectNode {
		private String nodename;
		private String schemaname;
		private String objectname;
		private ObjectType objecttype;
		private List<DBObjectNode> children;
		private String importresult;
		private boolean toimport = true;

		public DBObjectNode() {
		}
		
		public DBObjectNode(String nodename, ObjectType type) {
			this.nodename = nodename;
			this.objecttype = type;
		}
		public DBObjectNode(String nodename, String schemaname, String objectname, ObjectType type) {
			this(nodename, type);
			this.schemaname = schemaname;
			this.objectname = objectname;
		}

		public DBObjectNode addChild(DBObjectNode child) {
			if (children == null) {
				children = new ArrayList<>();
			}
			children.add(child);
			return child;
		}

		public String getNodeName() {
			return nodename;
		}
		public String getSchemaName() {
			return schemaname;
		}
		public String getObjectName() {
			return objectname;
		}
		public ObjectType getObjectType() {
			return objecttype;
		}
		public List<DBObjectNode> getChildren() {
			return children;
		}
		public String getImportResult() {
			return importresult;
		}
		public boolean isToImport() {
			return toimport;
		}
		public void setToImport(boolean toimport) {
			this.toimport = toimport;
		}
		public void setNodeName(String nodename) {
			this.nodename = nodename;
		}
		public void setSchemaName(String schemaname) {
			this.schemaname = schemaname;
		}
		public void setObjectName(String objectname) {
			this.objectname = objectname;
		}
		public void setObjectType(ObjectType objecttype) {
			this.objecttype = objecttype;
		}
		public void setChildren(List<DBObjectNode> children) {
			this.children = children;
		}

	}
}
