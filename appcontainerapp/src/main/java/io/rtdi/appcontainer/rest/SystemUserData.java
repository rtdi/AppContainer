package io.rtdi.appcontainer.rest;

import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;

import io.rtdi.appcontainer.databaseloginrealm.IDatabaseLoginPrincipal;
import io.rtdi.appcontainer.rest.entity.CustomSuccessMessage;
import io.rtdi.appcontainer.rest.entity.ErrorMessage;
import io.rtdi.appcontainer.rest.entity.UserData;
import io.rtdi.appcontainer.servlets.DatabaseServlet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/system")
public class SystemUserData {

	@Context 
	private HttpServletRequest request;

	@GET
	@Path("usersettings")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "Return the defaults and permissions of the user",
			description = "Show the perferences, user groups and other user specific data",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "user data",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = UserData.class)
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
    public Response settings() {
		try {
			IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
			if (dbprincipal == null) {
				throw new IOException("The user did not log in yet");
			}
			UserData data = new UserData(dbprincipal);
			return CustomSuccessMessage.createResponse(data);
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("timezones")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All timezones",
			description = "Return the list of all timezones",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "all timezone ids",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = String[].class)
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
    public Response getTimeZones() {
		try {
			return CustomSuccessMessage.createResponse(TimeZone.getAvailableIDs());
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("countries")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All countries",
			description = "Return the list of all countries",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "all country codes",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = String[].class)
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
    public Response getCountries() {
		try {
			return CustomSuccessMessage.createResponse(Locale.getISOCountries());
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

	@GET
	@Path("languages")
    @Produces(MediaType.APPLICATION_JSON)
	@Operation(
			summary = "All languages",
			description = "Return the list of all languages",
			responses = {
					@ApiResponse(
	                    responseCode = "200",
	                    description = "all languages codes",
	                    content = {
	                            @Content(
	                                    schema = @Schema(implementation = String[].class)
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
    public Response getLanguages() {
		try {
			return CustomSuccessMessage.createResponse(Locale.getISOLanguages());
		} catch (Exception e) {
			return ErrorMessage.createResponse(e);
		}
	}

}
