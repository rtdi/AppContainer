# Bachelor

_Continuous Integration/Continuous Delivery (CI/CD) in the context of database applications_

## Design Thinking Goal

The user is able to deploy database applications equally to CI/CD pipelines in classic software development. Must support the initial creation of a database application, non-destructive upgrade from each version at the customer, automated testing and git integration.

## Architecture

The detailed architecture is discussed [here](docs/001 - Architecture basics.md) but essentially a Tomcat webserver with some apps is wrapped into a container and all operations are done via web technologies. The components implemented are:

- Tomcat Realms to delegate the authorization and authentication to the connected database - one realm per database type
- Swagger UI to document all Restful end points
- oData and Restful to expose database data
- Repository operation endpoints
- UIs for repository operations
- Activation logic for different types of resources (database specific)
