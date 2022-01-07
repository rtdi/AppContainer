# Building UIs

WebUIs are built using JavaScript frameworks in combination with ajax and restful endpoints. This has a couple of consequences:

1. UI frameworks tend to be large, loading them for every single page is very costly. One application should be a single page with internal routing, which replaces the view content instead of multiple html pages with the complete initialization overhead.
1. The html page provides the framework loading, then a shell (top menu, breadcrumbs,..) is shown and within the shell are the app specific screens. How can a common shell load app specifc screen or how does the app reuse the common shell code?
1. Frameworks do not provide solutions for
  - Permissions within the page: can the user view and edit and delete or just view?
  - Disable controls based on the user permissions: If the user has no edit permission, the edit button should be disabled.
  - Permission based navigation: Similar to above, if the user has no permissions to access an application, the link/button/menu should be disabled.
  - A standard way of error handling: If a rest call fails, either with a http status code or by responding with a json payload with information about the failure, the developer must add code on how to deal with that. There should be a simple method for that shared across all pages.
1. Controls allow to be customized property by property and when bound to data the customization can be taken from the data, e.g. `control.backgroundcolor = {data.status = 'ERROR'?'RED':'WHITE'}`. But there are use cases where even more is needed, e.g. an XSLT transformation. Where can this be done?
1. Table structure and control data structure differ: For example a table has a parent-child column but the control requires `{node: {name: 'root', children: [ {node: ....}]}}`. Where does this transformation take place and by which software component?
1. Boiler plate code: Frameworks provide options for customizations but often this is not needed. But the file still must exist and hence the developer has to create similar files for every application. For example a manifest file where everything is default, only the application title is different. These files should be created automatically.

As this appcontainer consists of a connected database, services to provide the data and the UI framework, it can provide more support to the developer.
