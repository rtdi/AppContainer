package io.rtdi.appcontainer.db.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.db.rest.entity.Column;
import io.rtdi.appcontainer.db.rest.entity.SchemaDefinition;
import io.rtdi.appcontainer.db.rest.entity.SourceDetails;
import io.rtdi.appcontainer.dbactivationbase.AppContainerSQLException;
import io.rtdi.appcontainer.plugins.database.DatabaseObjectTree;
import io.rtdi.appcontainer.plugins.database.IDatabaseProvider;
import io.rtdi.appcontainer.plugins.database.SelectSource;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import io.rtdi.appcontainer.utils.DatabaseProvider;
import io.rtdi.appcontainer.utils.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Configuration;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class DatabaseSchemaCatalog {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("catalog/schemas")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All schemas of the database",
			description = "Returns a list of all schemas in the database",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The list of schemas",
	                    content = {
	                            @Content(
	                            		array = @ArraySchema(schema = @Schema(implementation = SchemaDefinition.class))
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Information")
    public Response getSchemas(
    		@QueryParam("pattern")
   		 	@Parameter(
 	    		description = "an optional pattern to filter names on",
 	    		example = ""
 	    		)
    		String pattern) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			if (pattern != null && pattern.length() == 0) {
				pattern = null;
			}
			try (Connection conn = dbprincipal.getConnection();) {
				try (ResultSet rs = conn.getMetaData().getSchemas(conn.getCatalog(), pattern); ) {
					List<SchemaDefinition> schemas = new ArrayList<>();
					while (rs.next()) {
						schemas.add(new SchemaDefinition(rs.getString(1)));
					}
					return Response.ok(schemas).build();
				}
			} catch (SQLException e) {
				throw AppContainerSQLException.cloneFrom(e, "JDBC getSchemas()", null);
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("catalog/schemas/{schema}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All tables/views/synonyms of a schema of the database",
			description = "Returns a list of all tables/views in the database that belong to one schema",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The list of tables/views/synonyms",
	                    content = {
	                            @Content(
	                            		array = @ArraySchema(schema = @Schema(implementation = SourceDetails.class))
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Information")
    public Response getSources(
    		@PathParam("schema")
   		 	@Parameter(
 	    		description = "Schema to browse from",
 	    		example = "SYS"
 	    		)
    		String schemaraw,
    		@QueryParam("pattern")
   		 	@Parameter(
 	    		description = "an optional pattern to filter names on",
 	    		example = ""
 	    		)
    		String pattern) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			if (pattern != null && pattern.length() == 0) {
				pattern = null;
			}
			String schema = Util.decodeURIfull(schemaraw);
			String[] types = {"TABLE","VIEW", "SYSTEM TABLE", "ALIAS", "SYNONYM"};
			try (Connection conn = dbprincipal.getConnection();) {
				try (ResultSet rs = conn.getMetaData().getTables(conn.getCatalog(), schema, pattern, types); ) {
					List<SourceDetails> sources = new ArrayList<>();
					while (rs.next()) {
						sources.add(new SourceDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
					}
					return Response.ok(sources).build();
				}
			} catch (SQLException e) {
				throw AppContainerSQLException.cloneFrom(e, "JDBC getTables()", null);
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("catalog/schemas/{schema}/{sourcename}/columns")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Get all columns",
			description = "Returns a list of all columns of the table/view",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The list of columns",
	                    content = {
	                            @Content(
	                                    array = @ArraySchema(schema = @Schema(implementation = Column.class))
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Information")
    public Response getColumns(
    		@PathParam("schema")
   		 	@Parameter(
 	    		description = "Schema to browse from",
 	    		example = "SYS"
 	    		)
    		String schemaraw,
    		@PathParam("sourcename")
   		 	@Parameter(
 	    		description = "table/view name",
 	    		example = "ORDERS"
 	    		)
    		String nameraw) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			String schema = Util.decodeURIfull(schemaraw);
			String name = Util.decodeURIfull(nameraw);
			try (Connection conn = dbprincipal.getConnection();) {
				Map<String, Column> index = new HashMap<>();
				List<Column> columns = new ArrayList<>();
				try (ResultSet rs = conn.getMetaData().getColumns(conn.getCatalog(), schema, name, null); ) {
					while (rs.next()) {
						Integer length = rs.getInt(7);
						if (rs.wasNull()) {
							length = null;
						}
						Integer precision = rs.getInt(9);
						if (rs.wasNull()) {
							precision = null;
						}
						Column c = new Column(rs.getString(4), rs.getString(6), length, precision, "NO".equals(rs.getString(18)), rs.getInt(17), rs.getString(12));
						index.put(c.getName(), c);
						columns.add(c);
					}
				}
				try (ResultSet rs = conn.getMetaData().getPrimaryKeys(conn.getCatalog(), schema, name); ) {
					while (rs.next()) {
						Column c = index.get(rs.getString(4));
						if (c != null) {
							c.setPkindex(rs.getInt(5));
						}
					}
				}
				return Response.ok(columns).build();
			} catch (SQLException e) {
				throw AppContainerSQLException.cloneFrom(e, "JDBC getColumns() and getPrimaryKeys()", null);
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("catalog/schemas/{schema}/{sourcename}/dependencies")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Get all dependent objects",
			description = "Returns a a tree of all objects this source depends on",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The list of columns",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = DatabaseObjectTree.class)
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Information")
    public Response getDependencies(
    		@PathParam("schema")
   		 	@Parameter(
 	    		description = "Schema to browse from",
 	    		example = "SYS"
 	    		)
    		String schemaraw,
    		@PathParam("sourcename")
   		 	@Parameter(
 	    		description = "table/view name",
 	    		example = "ORDERS"
 	    		)
    		String nameraw) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			String schema = Util.decodeURIfull(schemaraw);
			String name = Util.decodeURIfull(nameraw);
			IDatabaseProvider provider = DatabaseProvider.getDatabaseProvider(servletContext, dbprincipal.getDriver());
			try (Connection conn = dbprincipal.getConnection();) {
				DatabaseObjectTree tree = provider.getCatalogService().getDependencies(conn, schema, name);
				return Response.ok(tree).build();
			} catch (SQLException e) {
				throw AppContainerSQLException.cloneFrom(e, "JDBC getColumns() and getPrimaryKeys()", null);
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("catalog/sources")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Get all tables, views, synonyms",
			description = "Returns a list of all elements useable in the from clause and their actual target object",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The list of tables, views and synonyms",
	                    content = {
	                            @Content(
	                                    array = @ArraySchema(schema = @Schema(implementation = SelectSource.class))
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "400", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Information")
    public Response getAllSources(
    		@QueryParam("internal")
   		 	@Parameter(
 	    		description = "if present, all internal objects are shown as well, e.g. from SYS",
 	    		example = "true"
 	    		)
    		String internal) {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			IDatabaseProvider provider = DatabaseProvider.getDatabaseProvider(servletContext, dbprincipal.getDriver());
			try (Connection conn = dbprincipal.getConnection();) {
				boolean showinternal = false;
				if (internal != null && internal.equalsIgnoreCase("true")) {
					showinternal = true;
				}
				List<SelectSource> res = provider.getCatalogService().getAllSelectSources(conn, showinternal);
				/*
				 * Short qualifiers might not be unique, e.g. there might be a public synonym TABLES and the user creates a new table called TABLES.
				 * In that case the shortqualifier must be the qualifier.
				 */
				Map<String, SelectSource> shortqualifiers = new HashMap<>();
				for (SelectSource item : res) {
					SelectSource previousitem = shortqualifiers.get(item.getQualifiershort());
					if (previousitem != null) {
						item.setQualifiershort(item.getQualifier());
						previousitem.setQualifiershort(previousitem.getQualifier());
					} else {
						shortqualifiers.put(item.getQualifiershort(), item);
					}
				}
				return Response.ok(res).build();
			} catch (SQLException e) {
				throw AppContainerSQLException.cloneFrom(e, "select all view, tables, synonyms", null);
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

}
