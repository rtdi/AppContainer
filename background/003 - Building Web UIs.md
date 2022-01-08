# Building UIs - Design Thinking

**Goal**: _As a developer I want to be able to build enterprise grade Web-UIs efficiently. All the customizations the UI framework provides should still be possible but for the normal case defaults are generated._


This allows building UIs for the appcontainer, like the repository browsing UI, but also other developers using the appcontainer to build applications for their end users.

The first finding was that UIs consists of different layers
 - **Framework**: This is the library being used to render the controls, work with events, bind data. It must have a rich set of controls, should be targeted towards database applications, allow grouping of controls into new controls. Typical frameworks are [Vue](https://vuejs.org/v2/guide/), [Angular](https://angular.io/guide/architecture), [React](https://reactjs.org/docs/getting-started.html). While all three allow data binding of a model into a view, it is very basic and manual. The requirement would be to load the first 30 rows into a drop down box and if the user scrolls to the bottom, more data is loaded from the backend via pagination. Restful as such lacks a standard way of doing that, but oData as a special type of Restful interface does. Again, none of the three frameworks support oData out of the box. Further more all controls provided are basic controls, not the ones required in typical database applications. [OpenUI5](https://openui5.org/) is used less often but is a perfect match for database applications.
 - **Design language**: Placing multiple controls onto a canvas does not lead to a beautiful UI. The design language describes when to use which control, common behavior, combinations of controls for typical use cases. The design language for OpenUI5 is [SAP Fiori](https://experience.sap.com/fiori-design/).
 - **UI related metadata**: An often overlooked fact is that the same UI can look different depending on the user viewing it. The reason can be
   - Preferences: Color scheme, font size
   - Permissions: One user is allowed to view and edit, another can only view, another can see additional sensitive data and one user does not have the permissions to open the screen at all.
   - Navigation permissions: When navigation options are shown to the user, the permissions should be considered as well. It would be a bad UI design to show all navigation options and raise a not-allowed error after the user clicked on it. The UI should only render navigation options the user is allowed to use.
 - **Floorplans**: While a MVC design pattern allows to build UIs based on a single model, in database applications screens often use multiple models. For example a master-detail screen for sales orders shows one sales order at the top and a list of all line items the order consists of in the detail area.
 - **Shell**: A common frame shared by all applications with menu, logout, user preferences, breadcrumbs and other navigation options.

### Conclusion 1 - Service for user metadata

A service returning metadata about the user, at least all the roles the user belongs to, must exist.
`rest/system/usersettings`

### Conclusion 2 - Each application defines the required role(s)

For global navigation each application provides a list of roles the user must have in order to open the application.
If no role is specified it is PUBLIC but for example an application showing sensitive sales data can only be called by users who have the database roles SALES and MANAGER assigned.
Whereever a link to this application is shown, the role membership is tested and in case the user lacks the permissions, the link is either disabled or invisible.

### Conclusion 3 - OpenUI5 with Fiori design language is the primary targeted

While any kind of html page can be created, thus all UI frameworks can be used, it should be easy to create OpenUI5 applications.
This is achieved by preinstalling the framework but also providing helper methods and services.
The general guidline shall be that required OpenUI5 files are created automatically on the fly, unless one exists in particular. The html page with its bootstrapping is a good example. UI5 requires such html page to exist but it will be similar for most applications. It sets the window title, loads the UI5 framework, the shell and user defaults and within is the application specific view rendered. If the html file exists in the repository it is used, else a servlet generates that automatically.


