package io.rtdi.hanaappcontainer.activationapp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.hanaappcontainer.WebAppConstants;
import io.rtdi.hanaappcontainer.designtimeobjects.csv.CSVImport;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbcds.HDBCDS;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.HDBTable;
import io.rtdi.hanaappcontainer.objects.table.HanaTable;
import io.rtdi.hanaappserver.ActivationResult;
import io.rtdi.hanaappserver.ActivationStyle;
import io.rtdi.hanaappserver.ActivationSuccess;
import io.rtdi.hanaappserver.HanaFileTypes;
import io.rtdi.hanaappserver.HanaParsingException;
import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;
import io.rtdi.hanaappserver.utils.ErrorMessage;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.SessionHandler;
import io.rtdi.hanaappserver.utils.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/activationapp")
public class ActivationService {
	protected final Logger log = LogManager.getLogger(this.getClass().getName());

	@Context
    private Configuration configuration;

	@Context 
	private ServletContext servletContext;
	
	@Context 
	private HttpServletRequest request;

	@GET
	@Path("activate/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Activate file",
			description = "Activate a single design time object",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The detailed information what was activited and how",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = ActivationResult.class)
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
	@Tag(name = "Filesystem")
    public Response activateSingle(
    		@PathParam("path") 
    	    @Parameter(
    	    		description = "The location of a single file in the repository",
    	    		example = "USER1/SCHEMA1/dir1/dir2/mytable.hdbtable"
    	    		)
    		String path) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		try {
			String username = user.getHanaUser();
			try (Connection conn = SessionHandler.handleSession(request, log);) {
				username = Util.validateFilename(username);
				java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
				java.nio.file.Path ppath = upath.resolve(path);
				File file = ppath.toFile();
				if (!file.isFile()) {
					throw new IOException("Cannot find file \"" + file.getAbsolutePath() + "\" on the server");
				}
				File rootdir = upath.toFile();
				String schemaname = Util.fileToSchemaname(file, rootdir);
				ActivationResult cdsactivationresult = new ActivationResult("Activating the file", null, ActivationSuccess.SUCCESS, null);
				activateFile(file, schemaname, conn, cdsactivationresult, rootdir);
				return Response.ok(cdsactivationresult).build();
			} catch (SQLException e) {
				throw new HanaSQLException(e, "Activation failed", null);
			}
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}
	
	@GET
	@Path("activateall/{path:.*}")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Activate all files in a directory",
			description = "Activates all files in a directory recursively",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The detailed information what was activited and how",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = ActivationResult.class)
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
	@Tag(name = "Filesystem")
    public Response activateAll(@PathParam("path") String path) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		try {
			String username = user.getHanaUser();
			try (Connection conn = SessionHandler.handleSession(request, log);) {
				username = Util.validateFilename(username);
				java.nio.file.Path upath = WebAppConstants.getHanaRepoUserDir(request.getServletContext(), username);
				java.nio.file.Path ppath = upath.resolve(path);
				File file = ppath.toFile();
				if (!file.exists()) {
					throw new IOException("Cannot find file \"" + file.getAbsolutePath() + "\" on the server");
				}
				File rootdir = upath.toFile();
				String schemaname = Util.fileToSchemaname(file, rootdir);
				if (schemaname != null) {
					ActivationResult result = new ActivationResult("Activating the CDS file", null, ActivationSuccess.SUCCESS, null);
					try {
						if (file.isDirectory()) {
							activateRecursive(file, schemaname, conn, result, rootdir);
						} else {
							activateFile(file, schemaname, conn, result, rootdir);
						}
						return Response.ok(result).build();
					} catch (HanaSQLException e) {
						return Response.ok(result).build();
					}
				} else {
					throw new HanaSQLException("The requested directory is invalid", file.getName());
				}
			} catch (SQLException e) {
				throw new HanaSQLException(e, "Activation failed because the database connection has a problem", null);
			}
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
		}
	}


	private void activateRecursive(
			File file, 
			String schemaname, 
			Connection conn, 
			ActivationResult cdsactivationresult,
			File rootdir) 
					throws HanaParsingException, HanaSQLException, IOException {
		if (file != null && file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isDirectory()) {
					activateRecursive(f, schemaname, conn, cdsactivationresult, rootdir);
				} else {
					activateFile(f, schemaname, conn, cdsactivationresult, rootdir);
				}
			}
		}
		
	}

	private void activateFile(
			File file, String schemaname,
			Connection conn,
			ActivationResult result,
			File rootdir) 
					throws HanaParsingException, HanaSQLException, IOException {
		HanaFileTypes filetype = getFileType(file);
		if (filetype != null) {
			String text = new String(Files.readAllBytes(file.toPath()));
			switch (filetype) {
			case HDBCDS:
				HDBCDS cds = HDBCDS.parseHBDCDSFile(text, schemaname);
				cds.valid(result);
				cds.activate(result, conn, ActivationStyle.RECONCILE);
				break;
			case HDBPROCEDURE:
				break;
			case HDBTABLE: {
				String tablename = Util.fileToTablename(file, rootdir);
				HanaTable table = HDBTable.parseHDBTableText(text, schemaname, tablename);
				table.valid(result);
				table.activate(result, conn, ActivationStyle.RECONCILE);
				break;
			}
			case HDBVIEW:
				break;
			case CSV: {
				String tablename = file.getName().substring(0, file.getName().length()-4);
				CSVImport imp = new CSVImport(result, conn, ActivationStyle.RECONCILE);
				imp.csvImport(file, schemaname, tablename);
			}
			default:
				break;
			}
		}
	}

	public static HanaFileTypes getFileType(File file) {
		try {
			String filetype = Util.getFileExtension(file);
			if (filetype == null) {
				return null;
			} else {
				return HanaFileTypes.valueOf(filetype.toUpperCase());
			}
		} catch (IllegalArgumentException e) {
			return null; // meaning this file has an extension that is not handled, which is just fine
		}

	}
}
