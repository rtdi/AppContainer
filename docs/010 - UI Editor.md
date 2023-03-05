# UI Editor (Prototype)

_Create the ViewXML of UI5 via a NoCode/LowCode editor using dran'n drop_

## User Story

Navigate to the repository browser.

The repository browser shows on the left hand side the directory structure for the logged in user and on the right half of the screen the files in the currently selected directory.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-2.png" width="750">

The user can do all the normal file operations, rename, delete, create, move files and directories.

To create any new file the add button is clicked

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-3.png" width="300">

and the the name of the file to be created can be specified. In this case the user wants to create a UI screen, hence the extension *.view.xml.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-5.png" width="750">


This is a regular text file and can be edit as such by clicking on its name.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-4.png" width="300">

The text editor shows the empty file and allows to create the XML structure. The editor supports basic syntax highlighting.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-6.png" width="750">


Because this is a *.view.xml file, a visual UI5 editor exists as well, which is opened when selecting the "editor" link instead of the file name as before.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-7.png" width="750">


The editor modifies the controls with a border to provide a visual handle for modifying the controls.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-8.png" width="750">

Either way, it is just another option to create or modify the view.xml which is the main component in the UI5 framework for describing the UI. Because both editors work on the same XML file, there is no limitation is starting with the one editor and switching to the other back and forth. The developer can use whatever makes more sense for the sitation at hand.

Building proper applications requires much more than just arranging UI controls. It starts with the shell bar at the top for navigation, error message visualization, a logout button. For consistency this shell bar must look identical in all screens and hence is provided as a custom control. The same control used by the AppContainer itself!

Therefore this `ui5libs.controls:ShellBar` is used as first control in the XML view. Further more the screen has an Overflow Toolbar and underneath it should render as many `items` as there are records in the `/apps` array of the `./tables.json` file. The object to render for each is the `core:Fragment`.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-9.png" width="750">


The result of this configuration looks like this.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-10.png" width="750">


  A screen with the text "Select Data Area" in the ShellBar, the text "Configure a data area" in the Toolbar and underneath three tiles horizontally arranged.

Why three tiles and with that name? Because the table.json used in the view contains the data.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-11.png" width="300">

<br>

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-12.png" width="750">


How such a tile must look like is defined using a UI5 fragment, which is another file referenced in the view.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-13.png" width="750">


The interesting part is why it was enough to create the view.xml file to render a page. If that xml file would be opened via the browser, the browser would show the XML text and not build a UI!
In fact all UI frameworks need some additional files to work. In case of UI5 these are as bare minimum:

- a html file to bootstrap the UI framework and loading the correct view.xml file.
- a controller that does initialize the system and provides the data as model
- a manifest file with masterdata about the application
- a Component.js with global settings, e.g. where to even find the `ui5libs` files

All this boiler plate code is mandatory, similar for the various apps but not identical.
And the AppContainer generates those on the fly.

When selecting the `run` link, the opened URL is actually a html file with the same name as the view (index.view.xml --> index.html) and the AppContainer produces the content of this file to instantiate the page with the view.xml.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-14.png" width="750">


Same thing for all other required files.

The `Controller.controller.js` used to initialize the application has by default no additional coding but extends the class `ui5libs.controls.Controller.js`. This Controller goes through the control tree in the XML view and when it finds the annotation to assign a model to this control, it does create the model, loads the data (asynchronously) and sets the model to this control.

<img src="https://raw.githubusercontent.com/rtdi/AppContainer/master/_media/readme/image-15.png" width="750">

The way UI5 suggests to load a model is by specifying which model goes to what control in the Controller and to maintain the model details (URL for the data, model type,...) in the Manifest file.
For simple projects that is okay but for larger projects, where the view has a model, all the list and combo boxes, all selectors, all tables have their own models for the lookup data, it is very hard to keep the three areas in sync.
Therefore in the AppContainer the controls in the view state which data they want to show. All in one place.


