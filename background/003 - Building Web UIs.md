# Building UIs - Design Thinking

**Goal**: As a developer I want to be able to build enterprise grade Web-UIs efficiently. All the customizations the UI framework provides should still be possible but for the normal case defaults are generated.

This allows building UIs for the appcontainer, like the repository browsing UI, but also other developers using the appcontainer to build applications for their end users.

The first finding was that UIs consists of different layers
 - Framework: This is the library being used to render the controls, work with events, bind data. It must have a rich set of controls, should be targeted towards database applications, allow grouping of controls into new controls. Typical frameworks are [Vue](https://vuejs.org/v2/guide/), [Angular](https://angular.io/guide/architecture), [React](https://reactjs.org/docs/getting-started.html). While all three allow data binding of a model into a view, it is very basic and manual. The requirement would be to load the first 30 rows into a drop down box and if the user scrolls to the bottom, more data is loaded from the backend via pagination. Restful as such lacks a standard way of doing that, but oData as a special type of Restful interface does. Again, none of the three frameworks support oData out of the box. Further more all controls provided are basic controls, not the ones required in typical database applications. [OpenUI5](https://openui5.org/) is used less often but is a perfect match for database applications.
 - Design language: Placing multiple controls onto a canvas does not lead to a beautiful UI. The design language describes when to use which control, common behavior, combinations of controls for typical use cases. The design language for OpenUI5 is [SAP Fiori](https://experience.sap.com/fiori-design/).
 - UI related metadata: An often overlooked fact is that the same UI can look different depending on the user viewing it. The reason can be
   - Preferences: Color scheme, font size
   - Permissions: One user is allowed to view and edit, another can only view, another can see additional sensitive data and one user does not have the permissions to open the screen at all.
   - Navigation permissions: When navigation options are shown to the user, the permissions should be considered as well. It would be a bad UI design to show all navigation options and raise a not-allowed error after the user clicked on it. The UI should only render navigation options the user is allowed to use.
   - Floorplans: While a MVC design pattern allows to build UIs based on a single model, in database applications screens often use multiple models. For example a master-detail screen for sales orders shows one sales order at the top and a list of all line items the order consists of in the detail area.



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
