# Restful API guidelines

All Restful APIs this application does expose must follow certain guidelines:

1. They must be properly annotated using the OpenAPI spec, see example below
2. In case of success it returns the code 200 with the data
3. In case of failure it returns status code 202 to indicate the returned value is valid Json but an error object. 
A convenient way to create that response is to catch any exceptions and `return ErrorMessage.createResponse(e);`.
4. Every API has at least one of the following tags: Repository, ReadDB, WriteDB, Information. see [WebApplication.java](../appcontainerapp/src/main/java/io/rtdi/appcontainer/WebApplication.java)




```
@Operation(
        summary = "Execute a select statement and return the data as Json",
        description = "It executes the provided select and returns the data",
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "A json object representing the resultset",
                        content = {
                                @Content( schema = @Schema(type = "object") )
                        }
                ),
                @ApiResponse(
                        responseCode = "202", 
                        description = "Any exception thrown",
                        content = {
                                @Content( schema = @Schema(implementation = ErrorMessage.class) )
                        }
                )
        }
)
```

## Implementation

The Restful APIs are implemented using the JAX-RS framework with Jackson configured as JSON serializer.

To initialize the framework a [WebApplication](https://git.sbg.ac.at/s1080660/bachelor/-/blob/main/appcontainerapp/src/main/java/io/rtdi/appcontainer/WebApplication.java) class with an ApplicationPath annotation is defined. It provides basic information for Swagger and registers multiple classes for JAX-RS use.

```
String [] p = {"io.rtdi.appcontainer"};
packages(p);
register(JacksonFeature.class);
register(RolesAllowedDynamicFeature2.class);
register(new OpenApiResource());
```

The first line tells the parent Java package all restful service classes can be found, the next two configure settings and the last is to load the Swagger/OpenAPI services.

Equipped with these settings writing Restful APIs is very simple.

A few annotations tell JAX-RS about the service specifics, here that a http GET service is implemented under the relative path `./query` and the only response this service can create is of MIME type Json. 
The method has the means to take an URL parameter `$select` of type String and it is mapped to the parameter called `query`

```
@GET
@Path("query")
@Produces(MediaType.APPLICATION_JSON)
public Response query(
        @QueryParam("$select")
                @Parameter(
                description = "The select statement to execute, must start with \"select\" as first keyword",
                example = "select user_name from users"
                )
        String query) {
        try {
                IDatabaseLoginPrincipal dbprincipal = DatabaseServlet.getPrincipal(request);
                try (Connection conn = dbprincipal.getConnection();) {
                        ...
                        return Response.ok(rows).build();
                }
        } catch (Exception e) {
                return ErrorMessage.createResponse(e);
        }
}
```


