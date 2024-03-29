sap.ui.define([
	"ui5libs/controls/Controller",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"ui5libs/helperfunctions",
	"ui5libs/controls/ActivationResultDialog"],
function(Controller, ui5ajax, errorfunctions, helperfunctions) {
	"use strict";
	var thisControl;
	return Controller.extend("io.rtdi.appcontainer.browseapp.Controller", {
		init : function() {
			this.oDialog = new ui5libs.controls.ActivationResultDialog();
			thisControl = this;
		},
		formatterEditorLink: function(spath) {
			return helperfunctions.getNativeEditorLink(spath);
		},
		formatterEnableActivate: function(spath) {
			return helperfunctions.isActivateable(spath);
		},
		formatterEnableEditor: function(spath) {
			var seditorlink = this.formatterEditorLink(spath);
			if (!!seditorlink) {
				return true;
			} else {
				return false;
			}
		},
		formatterTextEditorLink: function(spath) {
			if (helperfunctions.isTextFile(spath)) {
				return "../editorapp/index.html?filename=" + encodeURI(spath);
			} else {
				return "";
			}
		},
		formatterEnableRun: function(spath) {
			if (spath && (spath.endsWith(".html") || spath.endsWith(".view.xml"))) {
				return true;
			} else {
				return false;
			}
		},
		formatterLinkRun: function(spath) {
			if (spath) {
				if (spath.endsWith(".html")) {
					return "../../repofiles/currentuser/" + spath;
				} else if (spath.endsWith(".view.xml")) {
					return "../../repofiles/currentuser/" + spath.substring(0, spath.length - 9) + ".html";
				}
			}
			return undefined;
		},
		onDirectoryRefresh : function() {
			var oBrowseTreeModel = this.getView().byId("idBrowseTree").data("model");
			if (oBrowseTreeModel) {
				oBrowseTreeModel.reload();
			}
			var oModelContainer = this.getView().byId("idFiles").data("model");
			if (oModelContainer) {
				oModelContainer.setUrl(sap.ui.require.toUrl("ui5rest/repo/files"));
				oModelContainer.reload();
			}
		},
		onSelectDir : function(oEvent) {
			var oContext = oEvent.getParameters().rowContext;
			if (oContext && oContext.getObject()) {
				var oModelContainer = this.getView().byId("idFiles").data("model");
				if (oModelContainer) {
					oModelContainer.setUrl(sap.ui.require.toUrl("ui5rest/repo/files/" + oContext.getObject().path));
					oModelContainer.reload();
				}
			}
		},
		onActivateDirectory : function(oEvent) {
			var oControl = oEvent.getSource();
			var oContext = oControl.getBindingContext();
			if (oContext && oContext.getObject()) {
				ui5ajax.ajaxGet("/activationapp/activateall/" + oContext.getObject().path, "ui5rest", oControl)
					.then(
						data => {
							this.oDialog.getModel().setJSON(data.text);
							this.oDialog.getModel().refresh();
							this.oDialog.open();
						}, 
						error => {
							if (error.code === 400) {
								errorfunctions.addError(this.getView(), error);
							} else {
								this.oDialog.getModel().setJSON(error.text);
								this.oDialog.getModel().refresh();
								this.oDialog.open();
							}
						}
					);
			}
		},
		onActivateFile: function () {
			ui5ajax.ajaxGet("/activation/activate/" + filepath, "ui5rest")
				.then(
					data => {
						this.oDialog.getModel().setJSON(data.text);
						this.oDialog.getModel().refresh();
						this.oDialog.open();
					}, 
					error => {
						if (error.code === 400) {
							errorfunctions.addError(this.getView(), error);
						} else {
							this.oDialog.getModel().setJSON(error.text);
							this.oDialog.getModel().refresh();
							this.oDialog.open();
						}
					}
				);
		},
		onFilesRefresh : function() {
			var oModelContainer = this.getView().byId("idFiles").data("model");
			oModelContainer.reload();
		},
		onAddSubdirectory : function(oEvent) {
			var oControl = oEvent.getSource();
			var oContext = oControl.getBindingContext();
			var sParentPath = oContext.getPath();
			var oBrowseTree = this.getView().byId("idBrowseTree");
			var oModelContainer = oBrowseTree.data("model");
			var oModel = oModelContainer.getModel();
			var oDirectory = oModel.getProperty(sParentPath);
			var oDataExchange = {
				"currentname": "newdir",
				"currentpath" : oDirectory.path + "/newdir",
				"callback" : this.doCallAddSubDir,
				"create": true,
				"parentpath" : sParentPath
			};
			this.showRenameDialog(oDataExchange);
		},

		doCallAddSubDir : function(oDataExchange) {
			var oModel = thisControl.getView().byId("idBrowseTree").getModel();
			ui5ajax.ajaxGet("/mkdir/" + oDataExchange.newpath, "ui5rest")
				.then(
					() => {
						var sParentPath = oDataExchange.parentpath;
						var oCurrentSubDirs = oModel.getProperty(sParentPath + "/folders");
						var oEntry = {"name" : oDataExchange.newname, "path": oDataExchange.newpath, "folders" : null, "filecount" : 0 };
						if (oCurrentSubDirs == null) {
							oCurrentSubDirs = [ oEntry ];
						} else {
							oCurrentSubDirs.push(oEntry);
						}
						oModel.setProperty(sParentPath + "/folders", oCurrentSubDirs);
						// There does not seem to be a better way other than iterating over all
						var oTable = thisControl.getView().byId("idBrowseTree");
						for (var i=0; i<oTable.getRows().length; i++) {
							var oBinding = oTable.getRows()[i].getBindingContext();
							if (oBinding) {
								var sBindingPath = oBinding.getPath();
								if (sBindingPath === oDataExchange.parentpath) {
					            	oTable.expand(i);
					            	oTable.setSelectedIndex(oTable.getRows()[i].getIndex());
					            }
					        }
				        }
					}, 
					error => {
						errorfunctions.addError(thisControl.getView(), error);
					}
				);
		},
		onRenameDirectory : function(oEvent) {
			var oControl = oEvent.getSource();
			var oContext = oControl.getBindingContext();
			var sModelPath = oContext.getPath();
			var oModel = oControl.getModel();
			var oDir = oModel.getProperty(sModelPath);
			var oRow = oControl.getParent().getParent(); // control is inside a cell inside a row
			var oDataExchange = { "currentname": oDir.name, "currentpath" : oDir.path, "callback" : this.doRenameDirectory, "modelpath" : sModelPath, create: false, row: oRow};
			this.showRenameDialog(oDataExchange);
		},
		doRenameDirectory : function(oDataExchange) {
			ui5ajax.postJsonObject("/repo/mv/" + oDataExchange.currentpath, { "name": oDataExchange.newname, "path": oDataExchange.newpath}, "ui5rest")
				.then(
					() => {
			    		var oView = thisControl.getView();
						var oFilesControl = oView.byId("idBrowseTree");
						var oModel = oFilesControl.getModel();
						oModel.setProperty(oDataExchange.modelpath + "/name", oDataExchange.newname);
						
						function swappath(sModelPath, oModel, pathlength, newpath) {
							var currentpath = oModel.getProperty(sModelPath + "/path");
							var sSubFolderModelPath = sModelPath + "/folders";
							var subfolders = oModel.getProperty(sSubFolderModelPath);
							var sReplacedPath = newpath + currentpath.substring(pathlength);
							oModel.setProperty(sModelPath + "/path", sReplacedPath);
							if (subfolders != null) {
								for (let i=0; i<subfolders.length; i++) {
									swappath(sSubFolderModelPath + "/" + i, oModel, pathlength, newpath)
								}
							}
						};
						swappath(oDataExchange.modelpath, oModel, oDataExchange.currentpath.length, oDataExchange.newpath);
						if (oDataExchange.row) {
							oFilesControl.setSelectedIndex(oDataExchange.row.getIndex());
						}
					}, 
					error => {
						errorfunctions.addError(thisControl.getView(), error);
					}
				);
		},
		onDeleteDirectory : function(oEvent) {
			var oControl = oEvent.getSource();
			var oContext = oControl.getBindingContext();
			var sModelPath = oContext.getPath();
			var oModel = thisControl.getView().byId("idBrowseTree").getModel();
			var oDirectory = oModel.getProperty(sModelPath);
			var sFoldersPath = sModelPath.substring(0, sModelPath.lastIndexOf('/')); // .....folders/7/folders/5
			var index = Number(sModelPath.substring(sModelPath.lastIndexOf('/')+1));
			if (index !== NaN && index != -1 && oDirectory.path !== '.') {
				var oFolders = oModel.getProperty(sFoldersPath);
				ui5ajax.ajaxGet("/repo/rmdir/" + oDirectory.path, "ui5rest")
					.then(
						() => {
							oFolders.splice(index, 1);
							oModel.setProperty(sFoldersPath, oFolders);
							var oModelContainer = thisControl.getView().byId("idFiles").data("model");
							oModelContainer.setUrl(sap.ui.require.toUrl("ui5rest/repo/files"));
							oModelContainer.reload();
						}, 
						error => {
							errorfunctions.addError(thisControl.getView(), error);
						}
					);
			}
		},
		onAddFile : function() {
			var oControl = this.getView().byId("idFiles");
			var oModel = oControl.getModel();
			var sPath = oModel.getProperty("/path");
			var oDataExchange = { "currentname": "newfile", "currentpath" : sPath + "/newfile", "callback" : this.doCallAddFile, "create": true };
			this.showRenameDialog(oDataExchange);
		},
		doCallAddFile : function(oDataExchange) {
			var oControl = thisControl.getView().byId("idFiles");
			var oModel = oControl.getModel();
			var aFiles = oModel.getProperty("/files");
			ui5ajax.ajaxGet("/repo/touch/" + oDataExchange.newpath, "ui5rest")
				.then(
					() => {
						oModel.setProperty("/files/" + aFiles.length, {"path": oDataExchange.newpath, "name": oDataExchange.newname } );
					}, 
					error => {
						errorfunctions.addError(thisControl.getView(), error);
					}
				);
		},
		onRenameFile : function(oEvent) {
			var oControl = oEvent.getSource();
			var oContext = oControl.getBindingContext();
			var sModelPath = oContext.getPath();
			var oModel = oControl.getModel();
			var oFile = oModel.getProperty(sModelPath);
			var oDataExchange = { "currentname": oFile.name, "currentpath" : oFile.path, "callback" : this.doRenameFile, "modelpath" : sModelPath };
			this.showRenameDialog(oDataExchange);
		},
		doRenameFile : function(oDataExchange) {
			ui5ajax.postJsonObject("/repo/mv/" + oDataExchange.currentpath, { "name": oDataExchange.newname, "path": oDataExchange.newpath}, "ui5rest")
				.then(
					() => {
						var oFilesControl = thisControl.getView().byId("idFiles");
						var oModel = oFilesControl.getModel();
						oModel.setProperty(oDataExchange.modelpath, { "name": oDataExchange.newname, "path" : oDataExchange.newpath } );
					}, 
					error => {
						errorfunctions.addError(thisControl.getView(), error);
					}
				);
		},
		onDeleteFile : function(oEvent) {
			var oControl = oEvent.getSource();
			var oContext = oControl.getBindingContext();
			var sModelPath = oContext.getPath();
			var oModel = oControl.getModel();
			var oFile = oModel.getProperty(sModelPath);
			var index = Number(sModelPath.substring(sModelPath.lastIndexOf("/")+1));
			if (index !== NaN && index != -1) {
				ui5ajax.ajaxGet("/repo/rm/" + oFile.path, "ui5rest")
					.then(
						() => {
							var aFiles = oModel.getProperty("/files");
							aFiles.splice(index, 1);
							oModel.setProperty("/files", aFiles);
						}, 
						error => {
							errorfunctions.addError(thisControl.getView(), error);
						}
					);
			}
		},
		onDropFile: function(oEvent) {
			var draggedcontrol = oEvent.getParameter("draggedControl");
			var droppedatcontrol = oEvent.getParameter("droppedControl");
			var oTargetModel = droppedatcontrol.getModel();
			if (draggedcontrol) {
				var oSourcePath = draggedcontrol.getBindingContext().getPath();
				var oSourceModel = draggedcontrol.getModel();
				var oSourceRow = oSourceModel.getProperty(oSourcePath);
				var oTargetPath = droppedatcontrol.getBindingContext().getPath();
				var oTargetRow = oTargetModel.getProperty(oTargetPath);
				if (oSourceRow.folders === undefined) {
					// dropped a file
					ui5ajax.postJsonObject("/repo/mv/" + oSourceRow.path, { "name": oSourceRow.name, "path": oTargetRow.path + "/" + oSourceRow.name}, "ui5rest")
						.then(
							() => {
					    		/*
					    		 * Update the file counters and remove the file from the source model
					    		 */
								oTargetModel.setProperty(oTargetPath + "/filecount", oTargetRow.filecount + 1);
								var oSourcePathParent = oSourcePath.substring(0, oSourcePath.lastIndexOf("/"));
								var aFiles = oSourceModel.getProperty(oSourcePathParent);
								var index = Number(oSourcePath.substring(oSourcePath.lastIndexOf("/")+1));
								if (index !== NaN && index != -1) {
									aFiles.splice(index, 1);
									oSourceModel.setProperty(oSourcePathParent, aFiles);
								}
							}, 
							error => {
								errorfunctions.addError(thisControl.getView(), error);
							}
						);
				} else {
					// dropped a directory				
					ui5ajax.postJsonObject("/repo/mv/" + oSourceRow.path, { "name": oSourceRow.name, "path": oTargetRow.path + "/" + oSourceRow.name }, "ui5rest")
						.then(
							() => {
					    		/*
					    		 * Within the model tree add the folder to the new position and remove it from the old.
					    		 * Then walk through the entire subelements to update the path with the new root location.
					    		 */
					    		var oView = sap.ui.getCore().byId("__xmlview0");
								var oModel = oView.getModel();
								
								function swappath(sModelPath, oModel, pathlength, newpath) {
									var currentpath = oModel.getProperty(sModelPath + "/path");
									var sSubFolderModelPath = sModelPath + "/folders";
									var subfolders = oModel.getProperty(sSubFolderModelPath);
									var sReplacedPath = newpath + currentpath.substring(pathlength);
									oModel.setProperty(sModelPath + "/path", sReplacedPath);
									if (subfolders != null) {
										for (let i=0; i<subfolders.length; i++) {
											swappath(sSubFolderModelPath + "/" + i, oModel, pathlength, newpath)
										}
									}
								};
								swappath(oSourcePath, oModel, oSourceRow.path.length, oTargetRow.path + "/" + oSourceRow.name);
	
								// add the folder to the new directory in the tree
								var sFolderPath = oTargetPath + "/folders";
								var aFolders = oTargetModel.getProperty(sFolderPath);
								if (aFolders == null) {
									aFolders = [ oSourceRow ];
								} else {
									aFolders.push(oSourceRow);
								}
								oTargetModel.setProperty(sFolderPath, aFolders);
								
								// remove the folder from the source tree
								var oSourcePathParent = oSourcePath.substring(0, oSourcePath.lastIndexOf("/"));
								var aSubFolders = oSourceModel.getProperty(oSourcePathParent);
								var index = Number(oSourcePath.substring(oSourcePath.lastIndexOf("/")+1));
								if (index !== NaN && index != -1) {
									aSubFolders.splice(index, 1);
									oSourceModel.setProperty(oSourcePathParent, aSubFolders);
								}
							}, 
							error => {
								errorfunctions.addError(this.getView(), error);
							}
						);
				}
			}
		},
		_saveFile: function(file, path) {
			/*
			 * A file was dropped onto a row in the directory tree
			 */
			var that = this;
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onloadend = () => {
		    	var content = reader.result; // "data:image/png;base64,iVBORw0KGgoAAAAN..."
		    	var pos = content.indexOf("base64,");
		    	var binarydata = atob(content.substring(pos+7));
				ui5ajax.postBinary("/repo/file/" + path, binarydata, "ui5rest")
					.then(
						() => {
							that.onDirectoryRefresh();
						},
						error => {
							errorfunctions.addError(thisControl.getView(), error);
						}
					);
			}
		},
		onDropFileOnDirectory: function(oEvent) {
			/*
			 * A file was dropped onto a row in the directory tree
			 */
			var droppedatcontrol = oEvent.getParameter("droppedControl");
			var modelpath = droppedatcontrol.getBindingContext().getPath(); // the target directory is the entry the files have been dropped on
			var oTargetModel = droppedatcontrol.getModel();
			var oTargetRow = oTargetModel.getProperty(modelpath);
			var files = oEvent.getParameter("browserEvent").dataTransfer.files;
			for (var file of files) {
				this._saveFile(file, oTargetRow.path + "/" + file.name);
			}
		},
		onDropFileAdd: function(oEvent) {
			/*
			 * A file was dropped in the empty space of the file list, and/replace a file with the same name
			 */
			var droppedatcontrol = oEvent.getParameter("droppedControl");
			var oTargetModel = droppedatcontrol.getModel();
			var path =  oTargetModel.getProperty("/path"); // The target directory is the directory of the file list model
			var files = oEvent.getParameter("browserEvent").dataTransfer.files;
			for (var file of files) {
				this._saveFile(file, path + "/" + file.name);
			}
		},
		showRenameDialog: function (oDataExchange) {
			var text1 = 'Rename';
			var text2 = 'Rename to...';
			if (oDataExchange.create) {
				text1 = 'New';
				text2 = 'Name...';
			}
			var onOkay = function() {
				oDataExchange.newname = sap.ui.getCore().byId('renameInput').getValue();
				oDataExchange.newpath = oDataExchange.currentpath.substring(0, oDataExchange.currentpath.lastIndexOf('/')) + "/" + oDataExchange.newname;
				oDialog.close();
				oDataExchange.callback(oDataExchange);
			}
			var oDialog = new sap.m.Dialog({
				title: text1,
				type: 'Message',
				content: [
					new sap.m.Label({ text: text2, labelFor: 'renameInput' }),
					new sap.m.Input('renameInput', {
						value: oDataExchange.currentname,
						width: '100%',
						placeholder: 'New name'
					})
				],
				beginButton: new sap.m.Button({
					type: sap.m.ButtonType.Emphasized,
					text: text1,
					enabled: true,
					press: function () {
						onOkay();
					}.bind(this)
				}),
				endButton: new sap.m.Button({
					text: 'Cancel',
					press: function () {
						oDialog.close();
					}
				}),
				afterClose: function () {
					oDialog.destroy();
				}
			});
			oDialog.addEventDelegate({onsapenter: onOkay}, this);
			oDialog.open();
		},
		onGitRemote: function() {
			var oFilesModel = this.getView().byId("idFiles").getModel();
			var sPath = oFilesModel.getProperty("/path");
			if (sPath) {
				if (!this.oGitSettingDialog) {
					var that = this; 
					this.oGitSettingDialog = new sap.m.Dialog({
						title: "Remote git settings",
						contentWidth: "550px",
						contentHeight: "500px",
						resizable: true,
						draggable: true,
						customHeader: [ new sap.m.Toolbar(
							{content: [ 
								new sap.m.Image({src: "../../../public/media/git-logo-64-64.png"}),
								new sap.m.Text({ text: 'Git configuration'})
							]})
						],
						content: [
							new sap.m.Label({text: "Remote git url (*)"}),
							new sap.m.Input({id: "dialogurl", value: "{/remoteurl}"}),
							new sap.m.Label({text: "Username (*)"}),
							new sap.m.Input({id: "dialogusername", value: "{/username}"}),
							new sap.m.Label({text: "Password"}),
							new sap.m.Input({id: "dialogpassword", value: "{/password}", type: "Password"}),
							new sap.m.Label({text: "Token"}),
							new sap.m.Input({id: "dialogtoken", value: "{/token}", type: "Password"}),
							new sap.m.Label({text: "email (*)"}),
							new sap.m.Input({id: "email", value: "{/email}"}),
							new sap.m.Text({text: "(*) Mandatory input"})
						],
						beginButton: new sap.m.Button({
							type: sap.m.ButtonType.Emphasized,
							text: "OK",
							press: function () {
								var oModel = that.oGitSettingDialog.getModel();
								if (!oModel.getProperty("/remoteurl")) {
									errorfunctions.uiError(that.getView(), "Remote git url not set");
								} else if (!oModel.getProperty("/username")) {
									errorfunctions.uiError(that.getView(), "Username not set");
								} else if (!oModel.getProperty("/email")) {
									errorfunctions.uiError(that.getView(), "email not set");
								}
								ui5ajax.postJsonModel("/git/gitconfig/" + sPath, oModel, "ui5rest", that.oGitSettingDialog)
									.then(
										() => {
											that.oGitSettingDialog.close();
											that.onDirectoryRefresh();
										},
										error => {
											errorfunctions.addError(thisControl.getView(), error);
										}
									);
							}.bind(this)
						}),
						endButton: new sap.m.Button({
							text: "Close",
							press: function () {
								this.oGitSettingDialog.close();
							}.bind(this)
						})
					});
					var oDialogModel = new sap.ui.model.json.JSONModel();
					oDialogModel.loadData(sap.ui.require.toUrl("ui5rest/git/gitconfig/" + sPath));
					this.oGitSettingDialog.setModel(oDialogModel);
	
					//to get access to the controller's model
					this.getView().addDependent(this.oGitSettingDialog);
				}
				this.oGitSettingDialog.open();
			} else {
				errorfunctions.uiError(this.getView(), "A git repo requires a directory");
			}
		},
		onGitPush: function() {
			var oFilesModel = this.getView().byId("idFiles").getModel();
			var sPath = oFilesModel.getProperty("/path");
			if (!this.oCommitDialog) {
				var that = this; 
				this.oCommitDialog = new sap.m.Dialog({
					title: "Commit message",
					contentWidth: "550px",
					contentHeight: "300px",
					resizable: true,
					draggable: true,
					customHeader: [ new sap.m.Toolbar(
						{content: [ 
							new sap.m.Image({src: "../../../public/media/git-logo-64-64.png"}),
							new sap.m.Text({ text: 'Commit message'})
						]})
					],
					content: [
						new sap.m.TextArea({id: "dialogmessage", value: "{/message}", width: "100%", height: "200px" }),
					],
					beginButton: new sap.m.Button({
						type: sap.m.ButtonType.Emphasized,
						text: "Commit",
						press: function () {
							var oModel = that.oCommitDialog.getModel();
							ui5ajax.postJsonModel("/git/gitpush/" + sPath, oModel, "ui5rest", that.oCommitDialog)
								.then(
									data => {
										that.oCommitDialog.close();
										errorfunctions.uiSuccess(thisControl.getView(), data );
										that.onDirectoryRefresh();
										oModel.setData({ message: '' });
									},
									error => {
										errorfunctions.addError(thisControl.getView(), error);
									}
								);
						}.bind(this)
					}),
					endButton: new sap.m.Button({
						text: "Cancel",
						press: function () {
							this.oCommitDialog.close();
						}.bind(this)
					})
				});
				var oDialogModel = new sap.ui.model.json.JSONModel();
				this.oCommitDialog.setModel(oDialogModel);
				
				//to get access to the controller's model
				this.getView().addDependent(this.oCommitDialog);
			}

			this.oCommitDialog.open();
		},
		onGitPull: function() {
			var oFilesModel = this.getView().byId("idFiles").getModel();
			var sPath = oFilesModel.getProperty("/path");
			ui5ajax.ajaxGet("/git/gitpull/" + sPath, "ui5rest", this.getView())
				.then(
					() => {
						errorfunctions.uiSuccess(thisControl.getView(), { message: 'Pull succeeded' } );
					}, 
					error => {
						errorfunctions.addError(thisControl.getView(), error);
					}
				);
		},
		onImportSchema : function() {
			var that = this;
			var onOkay = function() {
				var oFilesModel = that.getView().byId("idFiles").getModel();
				var sPath = oFilesModel.getProperty("/path");
				var sSchema = oDialog.getContent()[1].getSelectedKey();
				ui5ajax.ajaxGet("/repo/reveng/importall/" + sSchema + "/" + sPath, "ui5rest", this.getView())
					.then(
						() => {
							errorfunctions.uiSuccess(thisControl.getView(), { message: 'Import-all succeeded' } );
							that.onDirectoryRefresh();
							oDialog.close();
						}, 
						error => {
							errorfunctions.addError(thisControl.getView(), error);
							that.onDirectoryRefresh();
							oDialog.close();
						}
					);
			}
			var oDialog = new sap.m.Dialog({
				title: "Select DB schema to import",
				type: 'Message',
				content: [
					new sap.m.Label({ text: "Schema name", labelFor: 'schemaInput' }),
					new sap.m.Select('schemaInput')
				],
				beginButton: new sap.m.Button({
					type: sap.m.ButtonType.Emphasized,
					text:"Import",
					enabled: true,
					press: function () {
						onOkay();
					}.bind(this)
				}),
				endButton: new sap.m.Button({
					text: 'Cancel',
					press: function () {
						oDialog.close();
					}
				}),
				afterClose: function () {
					oDialog.destroy();
				}
			});
			var oDialogModel = new sap.ui.model.json.JSONModel();
			oDialogModel.loadData(sap.ui.require.toUrl("ui5rest/catalog/schemas"));
			oDialog.setModel(oDialogModel);
			oDialog.addEventDelegate({onsapenter: onOkay}, this);
			oDialog.getContent()[1].bindItems({
				path: "/",
				template: new sap.ui.core.ListItem({ text: "{schemaname}", key: "{schemaname}" })
			});
			oDialog.open();
		},

	});

});
