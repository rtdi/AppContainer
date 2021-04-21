package io.rtdi.appcontainer.importapp;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.appcontainer.WebAppConstants;
import io.rtdi.appcontainer.realm.IAppContainerPrincipal;
import io.rtdi.appcontainer.utils.ErrorMessage;
import io.rtdi.appcontainer.utils.HanaSQLException;
import io.rtdi.appcontainer.utils.SessionHandler;
import io.rtdi.appcontainer.utils.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/importapp")
public class ImportService {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("{schema}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Generate designtime artifacts",
			description = "Scans a schema for tables, views and other objects and generates the design time files (reverse engineering)",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The directory content",
	                    content = {
	                            @Content(
	                            		array = @ArraySchema(schema = @Schema(type = "string"))
	                            )
	                    }
                    ),
					@ApiResponse(
							responseCode = "500", 
							description = "Any exception thrown",
		                    content = {
		                            @Content(
		                                    schema = @Schema(implementation = ErrorMessage.class)
		                            )
		                    }
					)
            })
	@Tag(name = "Filesystem")
    public Response runImport(@PathParam("schema") String schemaraw, @QueryParam("type") ImportType importtype) {
		IAppContainerPrincipal user = (IAppContainerPrincipal) request.getUserPrincipal();
		String username = user.getDBUser();
		ArrayList<String> importresult = new ArrayList<>();
		try (Connection conn = SessionHandler.handleSession(request, log);) {
			username = Util.validateFilename(username);
			String schemaname = Util.decodeURIfull(schemaraw);
			schemaname = Util.validateFilename(schemaname);
			java.nio.file.Path spath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
			File rootdir = spath.toFile();
			if (!rootdir.isDirectory()) {
				if (!rootdir.mkdirs()) {
					throw new IOException("Cannot create the directory \"" + rootdir.getAbsolutePath() + "\" on the server");
				}
			}
			String sql = "select table_name from tables where schema_name = ? and is_user_defined_type = 'FALSE'";
			try (PreparedStatement stmt = conn.prepareStatement(sql);) {
				stmt.setString(1, schemaname);
				try (ResultSet rs = stmt.executeQuery();) {
					while (rs.next()) {
						String tablename = rs.getString(1);
						// HanaTable table = HanaTable.createDefinitionFromDatabase(conn, schemaname, tablename);
						// String hdbtablecontent = HDBTable.getHDBTableDefinition(table);
						String path = Util.packageToPath(tablename);
						String filename = Util.packageToFilename(tablename);
						filename = filename + ".hdbtable";
						java.nio.file.Path ppath = spath.resolve(path);
						File d = ppath.toFile();
						if (!d.exists()) {
							if (!d.mkdirs()) {
								throw new HanaSQLException("Failed to create the directory", d.getAbsolutePath());
							}
						}
						
						// Files.writeString(ppath.resolve(filename), hdbtablecontent, StandardOpenOption.CREATE);
					}
				}
			} catch (SQLException e) {
				throw new HanaSQLException(e, sql, "Please file an issue");
			}
			return Response.ok(importresult).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ErrorMessage(e)).build();
		}
	}
	
}
