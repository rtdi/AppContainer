# How to create Restful Endpoints

They are created automatically. Done.

All endpoints to read any table, execute queries, call any stored procedure are created fully automatic.

The list of endpoints is exposed via the following URLs:
 - Tables/Views: `.../AppContainer/protected/rest/odata/tables/RS?$format=json`
 - Procedures: `.../AppContainer/protected/rest/procedures`

If the logged in user has access Restful endpoints are exposed via the following patterns:
 - Tables/Views: `.../AppContainer/protected/rest/query/{schemaname}/{objectname}`
 - Procedures (POST): `.../AppContainer/protected/rest/procedures/{schemaname}/{procedurename}`
 
One Restful endpoint is `.../AppContainer/protected/rest/query` where complete SQL statements can be executed. 
Example: `.../AppContainer/protected/rest/query?$select=select%20table_name%20from%20information_schema.tables`

Because the database security is used, different users might have access to different database objects.

Also see the OpenAPI (aka Swagger) documentation provided by the AppContainer: `.../AppContainer/protected/swagger-ui/`.

