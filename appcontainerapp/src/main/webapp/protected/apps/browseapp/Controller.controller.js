sap.ui.define([
	"ui5libs/controls/Controller",
	"ui5libs/ui5ajax",
	"ui5libs/errorfunctions",
	"ui5libs/controls/ActivationResultDialog"],
function(Controller, ui5ajax, errorfunctions) {
	"use strict";
	var thisControl;
	return Controller.extend("io.rtdi.appcontainer.browseapp.Controller", {
		init : function() {
			this.oDialog = new ui5libs.controls.ActivationResultDialog();
			thisControl = this;
		},
		formatterEditorLink: function(spath) {
			if (!spath) {
				return "";
			} else if (spath.endsWith(".view.xml")) {
				return "../editorapp/uieditorapp/index.html?filename=" + encodeURI(spath);
			} else {
				return "../editorapp/index.html?filename=" + encodeURI(spath);
			}
		},
		formatterEnableEditor: function(spath) {
			var seditorlink = this.formatterEditorLink(spath);
			if (seditorlink && seditorlink.length > 0 && !seditorlink.startsWith("../editorapp/index.html")) {
				return true;
			} else {
				return false;
			}
		},
		formatterTextEditorLink: function(spath) {
			if (!spath) {
				return "";
			} else {
				return "../editorapp/index.html?filename=" + encodeURI(spath);
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
					return "../../repo/currentuser/" + spath;
				} else if (spath.endsWith(".view.xml")) {
					return "../../repo/currentuser/" + spath.substring(0, spath.length - 9) + ".html";
				}
			}
			return undefined;
		},
		onDirectoryRefresh : function() {
			var oBrowseTreeModel = this.getView().byId("idBrowseTree").data("model");
			if (oBrowseTreeModel) {
				oBrowseTreeModel.reload();
			}
			var oFilesModel = this.getView().byId("idFiles").data("model");
			if (oFilesModel) {
				oFilesModel.reload();
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
				this.getView().setBusy(true);
				ui5ajax.ajaxGet(sap.ui.require.toUrl("ui5rest/activationapp/activateall/" + oContext.getObject().path))
					.then(
						data => {
							this.oDialog.getModel().setJSON(data.text);
							this.oDialog.getModel().refresh();
							this.oDialog.open();
							thisControl.getView().setBusy(false);
						}, 
						error => {
							thisControl.getView().setBusy(false);
							if (error.code === 202) {
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
		onFilesRefresh : function(oEvent) {
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
			var aFiles = oModel.getProperty("/files");
			ui5ajax.ajaxGet(sap.ui.require.toUrl("ui5rest/repo/mkdir/" + oDataExchange.newpath))
				.then(
					data => {
						var sParentPath = oDataExchange.parentpath;
						var oCurrentSubDirs = oModel.getProperty(sParentPath + "/folders");
						var oEntry = {"name" : oDataExchange.newname, "path": oDataExchange.newpath, "folders" : null, "filecount" : 0 };
						if (oCurrentSubDirs == null) {
							oCurrentSubDirs = [ oEntry ];
						} else {
							oCurrentSubDirs.push(oEntry);
						}
						oModel.setProperty(sParentPath + "/folders", oCurrentSubDirs);
						// There does not seem to be a better way then iterating over all
						var oTable = thisControl.getView().byId("idBrowseTree");
						for (var i=0; i<oTable.getRows().length; i++) {
							var oBinding = oTable.getRows()[i].getBindingContext();
							if (oBinding) {
								var sBindingPath = oBinding.getPath();
								var v = oModel.getProperty(sBindingPath);
								if (sBindingPath === oDataExchange.parentpath) {
					            	oTable.expand(i);
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
			var oDataExchange = { "currentname": oDir.name, "currentpath" : oDir.path, "callback" : this.doRenameDirectory, "modelpath" : sModelPath, create: false};
			this.showRenameDialog(oDataExchange);
		},
		doRenameDirectory : function(oDataExchange) {
			ui5ajax.postJsonObject(sap.ui.require.toUrl("ui5rest/repo/mv/" + oDataExchange.currentpath), { "name": oDataExchange.newname, "path": oDataExchange.newpath})
				.then(
					data => {
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
				ui5ajax.ajaxGet(sap.ui.require.toUrl("ui5rest/repo/rmdir/" + oDirectory.path))
					.then(
						data => {
						oFolders.splice(index, 1);
						oModel.setProperty(sFoldersPath, oFolders);
						thisControl.getView().byId("idFiles").getModel().setData(null); // empty model for files
						}, 
						error => {
							errorfunctions.addError(thisControl.getView(), error);
						}
					);
			}
		},
		onAddFile : function(oEvent) {
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
			ui5ajax.ajaxGet(sap.ui.require.toUrl("ui5rest/repo/touch/" + oDataExchange.newpath))
				.then(
					data => {
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
			ui5ajax.postJsonObject(sap.ui.require.toUrl("ui5rest/repo/mvfile/" + oDataExchange.currentpath), { "name": oDataExchange.newname, "path": oDataExchange.newpath})
				.then(
					data => {
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
				var oModelRmFile = new sap.ui.model.json.JSONModel();
				ui5ajax.ajaxGet(sap.ui.require.toUrl("ui5rest/repo/rm/" + oFile.path))
					.then(
						data => {
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
			var oSourcePath = oEvent.getParameter("draggedControl").getBindingContext().getPath();
			var oSourceModel = oEvent.getParameter("draggedControl").getModel();
			var oSourceRow = oSourceModel.getProperty(oSourcePath);
		
			var oTargetPath = oEvent.getParameter("droppedControl").getBindingContext().getPath();
			var oTargetModel = oEvent.getParameter("droppedControl").getModel();
			var oTargetRow = oTargetModel.getProperty(oTargetPath);
			
			if (oSourceRow.folders === undefined) {
				// dropped a file
				ui5ajax.postJsonObject(sap.ui.require.toUrl("ui5rest/repo/mvfile/" + oSourceRow.path), { "name": oSourceRow.name, "path": oTargetRow.path + "/" + oSourceRow.name})
					.then(
						data => {
				    		/*
				    		 * Update the file counters and remove the file from the source model
				    		 */
				    		var oView = sap.ui.getCore().byId("__xmlview0");
							var oFilesControl = oView.byId("idFiles");
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
				ui5ajax.postJsonObject(sap.ui.require.toUrl("ui5rest/repo/mvfile/" + oSourceRow.path), { "name": oSourceRow.name, "path": oTargetRow.path + "/" + oSourceRow.name })
					.then(
						data => {
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
							new sap.m.Input({id: "dialogpassword", value: "{/password}"}),
							new sap.m.Label({text: "Token"}),
							new sap.m.Input({id: "dialogtoken", value: "{/token}"}),
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
								} else if (!oModel.getProperty("/password") && !oModel.getProperty("/token")) {
									errorfunctions.uiError(that.getView(), "either password or token must be set");
								}
								ui5ajax.postJsonModel(sap.ui.require.toUrl("ui5rest/git/gitconfig/" + sPath), oModel)
									.then(
										data => {
											that.oGitSettingDialog.close();
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
							that.getView().setBusy(true);
							ui5ajax.postJsonModel(sap.ui.require.toUrl("ui5rest/git/gitpush/" + sPath, oModel))
								.then(
									data => {
										that.getView().setBusy(false);
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
			ui5ajax.ajaxGet(sap.ui.require.toUrl("ui5rest/git/gitpull/" + sPath))
				.then(
					data => {
						errorfunctions.uiSuccess(thisControl.getView(), { message: 'Pull succeeded' } );
					}, 
					error => {
						errorfunctions.addError(thisControl.getView(), error);
					}
				);
		}
	});

});
