sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/ui/model/odata/v4/ODataModel",
	"ui5libs/ui5ajax"],
function(Controller, ODataModel, ui5ajax) {
	"use strict";
	return Controller.extend("io.rtdi.hanaappcontainer.browseapp.Controller", {
		onInit : function() {
			this.onDirectoryRefresh();
		},
		formatterEditorLink: function(spath) {
			if (!spath) {
				return "";
			} else if (spath.endsWith(".view.xml")) {
				return "../editorapp/UIEditor.html?filename=" + encodeURI(spath);
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
			if (spath && (spath.endsWith(".html") || spath.endsWith(".view.xml"))) {
				return "../hanarepo/currentuser/" + spath.substring(0, spath.length - 9) + ".html";
			} else {
				return undefined;
			}
		},
		onAddDirectory : function() {
			var that = this;
			var oModel = this.getView().getModel();
			var oCurrentSubDirs = oModel.getProperty("/folders/0/folders");
			var sNewDir = "newschema";
			if (oCurrentSubDirs != null) {
				// find the subdirectory called "newfolder" with the highest number suffix
				for(let i = 0; i < oCurrentSubDirs.length; i++) {
					var sName = oCurrentSubDirs[i].name;
					if (sName === sNewDir) {
						sap.m.MessageToast.show('Directory with name "' + sNewDir + '" exists already');
						return; // has a sub directory of that name already
					}
				}
			}
			var oEntry = {"name" : sNewDir, "path": sNewDir, "folders" : null, "filecount" : 0 };
			
			var oModelAddDir = new sap.ui.model.json.JSONModel();
			oModelAddDir.attachRequestCompleted(function(oRespEvent) {
				if (oRespEvent.getParameters().success) {
					if (oCurrentSubDirs == null) {
						oCurrentSubDirs = [ oEntry ];
					} else {
						oCurrentSubDirs.push(oEntry);
					}
					oModel.setProperty("/folders", oCurrentSubDirs);
				} else {
					sap.m.MessageToast.show('Operation failed on the server ' + oRespEvent.getParameters().responseText);
				}
		    });
			oModelAddDir.attachRequestFailed(function(oRespEvent) {
				sap.m.MessageToast.show('Operation failed on the server ' + oRespEvent.getParameters().responseText);
		    });
			oModelAddDir.loadData("../rest/browseapp/mkdir/" + sNewDir);
		},
		onDirectoryRefresh : function() {
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.loadData(sap.ui.require.toUrl("ui5rest")+"/browseapp/browse");
			this.getView().setModel(oModel);
			var oFileModel = new sap.ui.model.json.JSONModel();
			oFileModel.loadData(sap.ui.require.toUrl("ui5rest")+"/browseapp/files/.");
			this.getView().byId("idFiles").setModel(oFileModel); // empty model
		},
		onSelectDir : function(oEvent) {
			var oContext = oEvent.getParameters().rowBindingContext;
			if (typeof oContext !== 'undefined' && typeof oContext.getObject() !== 'undefined') {
				var oModel = new sap.ui.model.json.JSONModel();
				oModel.loadData(sap.ui.require.toUrl("ui5rest")+"/browseapp/files/" + oContext.getObject().path);
				this.getView().byId("idFiles").setModel(oModel);
			}
		},
		onFilesRefresh : function(oEvent) {
			var oControl = this.getView().byId("idFiles");
			var oModel = oControl.getModel();
			oModel.loadData(sap.ui.require.toUrl("ui5rest")+"/browseapp/files/" + oModel.getProperty("/path"));
			oControl.setModel(oModel);
		},
		onAddSubdirectory : function(oEvent) {
			// create a new sub directory with the name newfolder, but only if there is none.
			var that = this;
			var oControl = oEvent.getSource();
			var oContext = oControl.getBindingContext();
			var sParentPath = oContext.getPath();
			var oModel = this.getView().getModel();
			var oDirectory = oModel.getProperty(sParentPath);
			var oCurrentSubDirs = oModel.getProperty(sParentPath + "/folders");
			var sNewDir = "newfolder";
			if (oCurrentSubDirs != null) {
				// find the subdirectory called "newfolder" with the highest number suffix
				for(let i = 0; i < oCurrentSubDirs.length; i++) {
					var sName = oCurrentSubDirs[i].name;
					if (sName === sNewDir) {
						sap.m.MessageToast.show('Directory with name "newfolder" exists already');
						return; // has a sub directory of that name already
					}
				}
			}
			var sPath = oDirectory.path + "/" + sNewDir;
			var oEntry = {"name" : sNewDir, "path": sPath, "folders" : null, "filecount" : 0 };
			
			var oModelAddDir = new sap.ui.model.json.JSONModel();
			oModelAddDir.attachRequestCompleted(function(oRespEvent) {
				if (oRespEvent.getParameters().success) {
					if (oCurrentSubDirs == null) {
						oCurrentSubDirs = [ oEntry ];
					} else {
						oCurrentSubDirs.push(oEntry);
					}
					oModel.setProperty(sParentPath + "/folders", oCurrentSubDirs);
					var oRow = oControl.getParent().getParent();
					var rowindex = oRow.getIndex();
					that.getView().byId("idBrowseTree").expand(rowindex);
				} else {
					sap.m.MessageToast.show('Operation failed on the server ' + oRespEvent.getParameters().responseText);
				}
		    });
			oModelAddDir.attachRequestFailed(function(oRespEvent) {
				sap.m.MessageToast.show('Operation failed on the server ' + oRespEvent.getParameters().responseText);
		    });
			oModelAddDir.loadData(sap.ui.require.toUrl("ui5rest")+"/browseapp/mkdir/" + sPath);
		},
		onRenameDirectory : function(oEvent) {
			var oControl = oEvent.getSource();
			var oContext = oControl.getBindingContext();
			var sModelPath = oContext.getPath();
			var oModel = oControl.getModel();
			var oDir = oModel.getProperty(sModelPath);
			var oDataExchange = { "currentname": oDir.name, "currentpath" : oDir.path, "callback" : this.doRenameDirectory, "modelpath" : sModelPath};
			this.showRenameDialog(oDataExchange);
		},
		doRenameDirectory : function(oDataExchange) {
			ui5ajax.postObject(sap.ui.require.toUrl("ui5rest")+"/browseapp/mvfile/" + oDataExchange.currentpath, { "name": oDataExchange.newname, "path": oDataExchange.newpath})
				.then(
					data => {
			    		var oView = sap.ui.getCore().byId("__xmlview0");
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
						sap.m.MessageToast.show('Call failed with message "' + error + '"');
					}
				);
		},
		onDeleteDirectory : function(oEvent) {
			var that = this;
			var oControl = oEvent.getSource();
			var oContext = oControl.getBindingContext();
			var sModelPath = oContext.getPath();
			var oModel = this.getView().getModel();
			var oDirectory = oModel.getProperty(sModelPath);
			var sFoldersPath = sModelPath.substring(0, sModelPath.lastIndexOf('/')); // .....folders/7/folders/5
			var index = Number(sModelPath.substring(sModelPath.lastIndexOf('/')+1));
			if (index !== NaN && index != -1) {
				var oFolders = oModel.getProperty(sFoldersPath);
				var oModelRmDir = new sap.ui.model.json.JSONModel();
				oModelRmDir.attachRequestCompleted(function(oRespEvent) {
					if (oRespEvent.getParameters().success) {
						oFolders.splice(index, 1);
						oModel.setProperty(sFoldersPath, oFolders);
						that.getView().byId("idFiles").setModel(new sap.ui.model.json.JSONModel()); // empty model for files
					} else {
						sap.m.MessageToast.show('Operation failed on the server ' + oRespEvent.getParameters().responseText);
					}
			    });
				oModelRmDir.attachRequestFailed(function(oRespEvent) {
					sap.m.MessageToast.show('Operation failed on the server ' + oRespEvent.getParameters().responseText);
			    });
				oModelRmDir.loadData(sap.ui.require.toUrl("ui5rest")+"/browseapp/rmdir/" + oDirectory.path);
			}
		},
		onAddFile : function(oEvent) {
			var oControl = this.getView().byId("idFiles");
			var oModel = oControl.getModel();
			var sPath = oModel.getProperty("/path");
			var sNewFile = "newfile";
			var that = this;
			if (sPath !== "") {
				var aFiles = oModel.getProperty("/files");
				for(let i = 0; i < aFiles.length; i++) {
					var sName = aFiles.name;
					if (sName === sNewFile) {
						sap.m.MessageToast.show('Directory has a file called "newfile" already');
						return; // has a file of that name already, stop
					}
				}
				var oModelAddFile = new sap.ui.model.json.JSONModel();
				oModelAddFile.attachRequestCompleted(function(oRespEvent) {
					oModel.setProperty("/files/" + aFiles.length, {"path": sPath + "/" + sNewFile, "name": sNewFile } );
			    });
				oModelAddFile.attachRequestFailed(function(oRespEvent) {
					sap.m.MessageToast.show('Operation failed on the server ' + oRespEvent.getParameters("responseText"));
			    });
				oModelAddFile.loadData(sap.ui.require.toUrl("ui5rest")+"/browseapp/touchfile/" + sPath + "/" + sNewFile);
			}
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
			ui5ajax.postObject(sap.ui.require.toUrl("ui5rest")+"/browseapp/mvfile/" + oDataExchange.currentpath, { "name": oDataExchange.newname, "path": oDataExchange.newpath})
				.then(
					data => {
			    		var oView = sap.ui.getCore().byId("__xmlview0");
						var oFilesControl = oView.byId("idFiles");
						var oModel = oFilesControl.getModel();
						oModel.setProperty(oDataExchange.modelpath, { "name": oDataExchange.newname, "path" : oDataExchange.newpath } );
					}, 
					error => {
						sap.m.MessageToast.show('Call failed with message "' + error + '"');
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
				oModelRmFile.attachRequestCompleted(function(oRespEvent) {
					if (oRespEvent.getParameters().success) {
						var data = oModel.getProperty("/files");
						data.splice(index, 1);
						oModel.setProperty("/files", data);
					}
			    });
				oModelRmFile.attachRequestFailed(function(oRespEvent) {
					sap.m.MessageToast.show('Operation failed on the server' + oRespEvent.getParameters("responseText"));
			    });
				oModelRmFile.loadData(sap.ui.require.toUrl("ui5rest")+"/browseapp/rmfile/" + oFile.path);
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
				ui5ajax.postObject(sap.ui.require.toUrl("ui5rest")+"/browseapp/mvfile/" + oSourceRow.path, { "name": oSourceRow.name, "path": oTargetRow.path + "/" + oSourceRow.name})
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
							sap.m.MessageToast.show('Call failed with message "' + error + '"');
						}
					);
			} else {
				// dropped a directory				
				ui5ajax.postObject(sap.ui.require.toUrl("ui5rest")+"/browseapp/mvfile/" + oSourceRow.path, { "name": oDataExchange.newname, "path": oDataExchange.newpath})
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
							sap.m.MessageToast.show('Call failed with message "' + error + '"');
						}
					);
			}
		},
		showRenameDialog: function (oDataExchange) {
			var oDialog = new sap.m.Dialog({
				title: 'Rename',
				type: 'Message',
				content: [
					new sap.m.Label({ text: 'Rename to...', labelFor: 'renameInput' }),
					new sap.m.Input('renameInput', {
						value: oDataExchange.currentname,
						width: '100%',
						placeholder: 'New name'
					})
				],
				beginButton: new sap.m.Button({
					type: sap.m.ButtonType.Emphasized,
					text: 'Rename',
					enabled: true,
					press: function () {
						oDataExchange.newname = sap.ui.getCore().byId('renameInput').getValue();
						oDataExchange.newpath = oDataExchange.currentpath.substring(0, oDataExchange.currentpath.lastIndexOf('/')) + "/" + oDataExchange.newname;
						oDialog.close();
						oDataExchange.callback(oDataExchange);
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

			oDialog.open();
		},
		onGitRemote: function() {
			if (!this.oGitSettingDialog) {
				var that = this; 
				this.oGitSettingDialog = new sap.m.Dialog({
					title: "Remote git settings",
					contentWidth: "550px",
					contentHeight: "300px",
					customHeader: [ new sap.m.Toolbar(
						{content: [ 
							new sap.m.Image({src: "../../../public/media/git-logo-64-64.png"}),
							new sap.m.Text({ text: 'Git configuration'})
						]})
					],
					content: [
						new sap.m.Label({text: "Remote git url"}),
						new sap.m.Input({id: "dialogurl", value: "{/remoteurl}"}),
						new sap.m.Label({text: "Username/AccessKey"}),
						new sap.m.Input({id: "dialogusername", value: "{/username}"}),
						new sap.m.Label({text: "Password/AccessSecret"}),
						new sap.m.Input({id: "dialogpassword", value: "{/password}"}),
						new sap.m.Label({text: "email"}),
						new sap.m.Input({id: "email", value: "{/email}"})
					],
					beginButton: new sap.m.Button({
						type: sap.m.ButtonType.Emphasized,
						text: "OK",
						press: function () {
							var oModel = that.oGitSettingDialog.getModel();
							ui5ajax.postModel(sap.ui.require.toUrl("ui5rest")+"/browseapp/gitconfig", oModel)
								.then(
									data => {
										that.oGitSettingDialog.close();
									},
									error => {
										sap.m.MessageToast.show('Call failed with message "' + error + '"');
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
				this.oGitSettingDialog.setModel(oDialogModel);

				//to get access to the controller's model
				this.getView().addDependent(this.oGitSettingDialog);
			}

			this.oGitSettingDialog.open();
		},
		onGitPush: function() {
			if (!this.oCommitDialog) {
				var that = this; 
				this.oCommitDialog = new sap.m.Dialog({
					title: "Commit message",
					contentWidth: "550px",
					contentHeight: "300px",
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
							ui5ajax.postModel(sap.ui.require.toUrl("ui5rest")+"/browseapp/gitpush", oModel)
								.then(
									data => {
										that.oCommitDialog.close();
										sap.m.MessageToast.show(data);
										that.onDirectoryRefresh();
										oModel.setJSON({ message: '' });
									},
									error => {
										sap.m.MessageToast.show('Call failed with message "' + error + '"');
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
			ui5ajax.ajaxGet(sap.ui.require.toUrl("ui5rest")+"/browseapp/gitpull")
				.then(
					data => {
						sap.m.MessageToast.show('Pull succeeded');
					}, 
					error => {
						sap.m.MessageToast.show('Call failed with message "' + error + '"');
					}
				);
		}
	});

});
