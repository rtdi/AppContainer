package io.rtdi.appcontainer.rest;

import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.rest.entity.SuccessMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/session")
public class Session {

	@Context 
	private HttpServletRequest request;

	@GET
	@Path("loginsuccess")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Display a static success message",
			description = "Just display a success message to indicate the user has access to this protected service",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "The directory tree",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
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
	@Tag(name = "Repository")
    public Response login() {
		try {
			return SuccessMessage.createResponseOK();
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("logout")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Logout the user",
			description = "Triggers a session.invalidate to logout the user from this session",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "OK message",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = SuccessMessage.class)
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
	@Tag(name = "Repository")
    public Response logout() {
		try {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
				return SuccessMessage.createResponseOK();
			} else {
				return ErrorMessage.createResponse("There is something wrong, a user without a session was able to call the protected logout call");
			}
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

}
