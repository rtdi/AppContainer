package io.rtdi.hanaappcontainer.editorapp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.rtdi.hanaappcontainer.WebAppConstants;
import io.rtdi.hanaappcontainer.designtimeobjects.hdbtable.HDBTable;
import io.rtdi.hanaappcontainer.objects.ActivationStyle;
import io.rtdi.hanaappcontainer.objects.HanaFileTypes;
import io.rtdi.hanaappcontainer.objects.table.Actions;
import io.rtdi.hanaappcontainer.objects.table.HanaTable;
import io.rtdi.hanaappserver.hanarealm.HanaPrincipal;
import io.rtdi.hanaappserver.utils.ErrorMessage;
import io.rtdi.hanaappserver.utils.HanaSQLException;
import io.rtdi.hanaappserver.utils.SessionHandler;
import io.rtdi.hanaappserver.utils.Util;

@Path("/editorapp")
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
    public Response activate(@PathParam("path") String path) {
		HanaPrincipal user = (HanaPrincipal) request.getUserPrincipal();
		try {
			String username = user.getHanaUser();
			String rootpath = request.getServletContext().getRealPath(WebAppConstants.HANAREPO);
			try (Connection conn = SessionHandler.handleSession(request, log);) {
				username = Util.validateFilename(username);
				File file = new File(rootpath + File.separatorChar + username + File.separatorChar + path);
				if (!file.isFile()) {
					throw new IOException("Cannot find file \"" + file.getAbsolutePath() + "\" on the server");
				}
				File rootdir = new File(rootpath + File.separatorChar + username);
				String schemaname = Util.fileToSchemaname(file, rootdir);
				HanaFileTypes filetype = getFileType(file);
				if (filetype != null) {
					String text = new String(Files.readAllBytes(file.toPath()));
					switch (filetype) {
					case HDBCDS:
						break;
					case HDBPROCEDURE:
						break;
					case HDBTABLE:
						String tablename = Util.fileToTablename(file, rootdir);
						HanaTable table = HDBTable.parseHDBTableText(text, schemaname, tablename);
						try {
							table.valid();
							Actions.activate(conn, schemaname, table, ActivationStyle.RECONCILE);
							return Response.ok(table.getCreationMessages()).build();
						} catch (HanaSQLException e) {
							throw new HanaSQLException(e, table.getCreationMessages(), "Activation failed");
						}
					case HDBVIEW:
						break;
					default:
						break;
					}
				}
				throw new HanaSQLException("The requested file has an extension that cannot be handled", file.getName());
			} catch (SQLException e) {
				throw new HanaSQLException(e, "Activation failed", null);
			}
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(new ErrorMessage(e)).build();
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
