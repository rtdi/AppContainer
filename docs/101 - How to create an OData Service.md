# How to create an OData Service

They are created automatically. Done.

The list of all oData endpoints is exposed via an oData service and its endpoint is `/AppContainer/protected/rest/odata/tables/`. 
Hence the link `.../AppContainer/protected/rest/odata/tables/RS?$format=json` returns the list.

Each table/view the logged in user has access to is exposed as one oData service and its the URLs follows the pattern `.../AppContainer/protected/rest/odata/tables/{schemaname}/{objectname}/`.

Because the database security is used, different users might have access to different database objects.

Also see the OpenAPI (aka Swagger) documentation provided by the AppContainer: `.../AppContainer/protected/swagger-ui/`.

