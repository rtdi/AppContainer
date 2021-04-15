## Anatomy of a UI5 application

html -> component -> manifest -> view -> controller



## Resource roots

The generated component.js file for an UI5 app contains the following resource roots 

- **ui5app** ("./"): The location of the application itself, the path "./" so to speak as seen from the html file. The component.js for example would be reference-able by the namespace "ui5app.component".
- **ui5root** ("/AppContainer"): Stands for the appcontainer root path and thus all subdirectories and files can be reached.
- **ui5externallibs** ("/ui5externallibs"): Points to the another web application on the web server, the /ui5externallibs. The idea is that users can place all their additional UI5 libraries, that are not part of the application as such, here.
- **ui5libs** ("/AppContainer/ui5libs"): The appcontainer comes with a number of libraries, controls and functions. All use this directory as root.
- **ui5rest** ("/AppContainer/protected/rest"): The location where all Rest services the appcontainer exposes, can be found.
- **ui5odata** ("/AppContainer/protected/odata"): The location where all oData services the appcontainer exposes, can be found.

Models in XMLView

App Header Shell bar

Security

ODataContainer