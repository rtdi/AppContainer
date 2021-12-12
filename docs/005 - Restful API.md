# Restful API guidelines

All Restful APIs this application does expose must follow certain guidelines:

1. They must be properly annotated using the OpenAPI spec, see example below
2. In case of success it returns the code 200 with the data
3. In case of failure it returns status code 202 to indicate the returned value is valid Json but an error object. 
A convenient way to create that response is to catch any exceptions and `return ErrorMessage.createResponse(e);`.
4. Every API has at least one of the following tags: Repository, ReadDB, WriteDB, Information. see [WebApplication.java](../appcontainerapp/src/main/java/io/rtdi/appcontainer/WebApplication.java)




```
summary = "Execute a select statement and return the data as Json",
description = "It executes the provided select and returns the data",
responses = {
		@ApiResponse(
            responseCode = "200",
            description = "A json object representing the resultset",
            content = {
                    @Content(
                            schema = @Schema(type = "object")
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
```