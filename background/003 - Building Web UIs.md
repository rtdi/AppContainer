# Building UIs - Design Thinking

**Goal**: As a developer I want to be able to build enterprise grade Web-UIs efficiently. All the customizations the UI framework provides should still be possible but for the normal case defaults are generated.

This allows building UIs for the appcontainer, like the repository browsing UI, but also other developers using the appcontainer to build applications for their end users.

The first finding was that UIs consists of different layers
 - **Framework**: This is the library being used to render the controls, work with events, bind data. It must have a rich set of controls, should be targeted towards database applications, allow grouping of controls into new controls. Typical frameworks are [Vue](https://vuejs.org/v2/guide/), [Angular](https://angular.io/guide/architecture), [React](https://reactjs.org/docs/getting-started.html). While all three allow data binding of a model into a view, it is very basic and manual. The requirement would be to load the first 30 rows into a drop down box and if the user scrolls to the bottom, more data is loaded from the backend via pagination. Restful as such lacks a standard way of doing that, but oData as a special type of Restful interface does. Again, none of the three frameworks support oData out of the box. Further more all controls provided are basic controls, not the ones required in typical database applications. [OpenUI5](https://openui5.org/) is used less often but is a perfect match for database applications.
 - **Design language**: Placing multiple controls onto a canvas does not lead to a beautiful UI. The design language describes when to use which control, common behavior, combinations of controls for typical use cases. The design language for OpenUI5 is [SAP Fiori](https://experience.sap.com/fiori-design/).
 - **UI related metadata**: An often overlooked fact is that the same UI can look different depending on the user viewing it. The reason can be
   - Preferences: Color scheme, font size
   - Permissions: One user is allowed to view and edit, another can only view, another can see additional sensitive data and one user does not have the permissions to open the screen at all.
   - Navigation permissions: When navigation options are shown to the user, the permissions should be considered as well. It would be a bad UI design to show all navigation options and raise a not-allowed error after the user clicked on it. The UI should only render navigation options the user is allowed to use.
 - **Floorplans**: While a MVC design pattern allows to build UIs based on a single model, in database applications screens often use multiple models. For example a master-detail screen for sales orders shows one sales order at the top and a list of all line items the order consists of in the detail area.



