sap.ui.define([ "sap/ui/core/mvc/Controller",
		"sap/ui/model/odata/v4/ODataModel"], function(Controller, ODataModel) {
	"use strict";

	return Controller.extend("io.rtdi.hanaappcontainer.browseapp.Controller", {

		onInit : function() {
			this.onDirectoryRefresh();
		},
		onAddDirectory : function() {
			var that = this;
			var oModel = this.getView().getModel();
			var oCurrentSubDirs = oModel.getProperty("/folders");
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
			oModel.loadData("../rest/browseapp/browse");
			this.getView().setModel(oModel);
			this.getView().byId("idFiles").setModel(new sap.ui.model.json.JSONModel()); // empty model
		},
		onSelectDir : function(oEvent) {
			var oContext = oEvent.getParameters().rowBindingContext;
			if (oContext.getObject() !== undefined) {
				var oModel = new sap.ui.model.json.JSONModel();
				oModel.loadData("../rest/browseapp/files/" + oContext.getObject().path);
				this.getView().byId("idFiles").setModel(oModel);
			}
		},
		onFilesRefresh : function(oEvent) {
			var oControl = this.getView().byId("idFiles");
			var oModel = oControl.getModel();
			oModel.loadData("../rest/browseapp/files/" + oModel.getProperty("/path"));
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
			oModelAddDir.loadData("../rest/browseapp/mkdir/" + sPath);
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
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.open("POST", "../rest/browseapp/mvfile/" + oDataExchange.currentpath);
			xmlhttp.setRequestHeader("Content-Type", "application/json");
			xmlhttp.onreadystatechange = function() {
			    if (xmlhttp.readyState == 4) {
			    	if (xmlhttp.status == 200) {
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
				    } else {
				    	sap.m.MessageToast.show('Operation failed on the server ' + xmlhttp.responseText);
				    }
				}
			}
			var oPost = { "name": oDataExchange.newname, "path": oDataExchange.newpath};
			xmlhttp.send(JSON.stringify(oPost));
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
				oModelRmDir.loadData("../rest/browseapp/rmdir/" + oDirectory.path);
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
				oModelAddFile.loadData("../rest/browseapp/touchfile/" + sPath + "/" + sNewFile);
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
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.open("POST", "../rest/browseapp/mvfile/" + oDataExchange.currentpath);
			xmlhttp.setRequestHeader("Content-Type", "application/json");
			xmlhttp.onreadystatechange = function() {
			    if (xmlhttp.readyState == 4) {
			    	if (xmlhttp.status == 200) {
			    		var oView = sap.ui.getCore().byId("__xmlview0");
						var oFilesControl = oView.byId("idFiles");
						var oModel = oFilesControl.getModel();
						oModel.setProperty(oDataExchange.modelpath, { "name": oDataExchange.newname, "path" : oDataExchange.newpath } );
				    } else {
				    	sap.m.MessageToast.show('Operation failed on the server ' + xmlhttp.responseText);
				    }
				}
			}
			var oPost = { "name": oDataExchange.newname, "path": oDataExchange.newpath};
			xmlhttp.send(JSON.stringify(oPost));
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
				oModelRmFile.loadData("../rest/browseapp/rmfile/" + oFile.path);
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
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.open("POST", "../rest/browseapp/mvfile/" + oSourceRow.path);
				xmlhttp.setRequestHeader("Content-Type", "application/json");
				xmlhttp.onreadystatechange = function() {
				    if (xmlhttp.readyState == 4) {
				    	if (xmlhttp.status == 200) {
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
					    } else {
					    	sap.m.MessageToast.show('Operation failed on the server ' + xmlhttp.responseText);
					    }
					}
				}
				var oPost = { "name": oSourceRow.name, "path": oTargetRow.path + "/" + oSourceRow.name};
				xmlhttp.send(JSON.stringify(oPost));
			} else {
				// dropped a directory				
				
				var xmlhttp = new XMLHttpRequest();
				xmlhttp.open("POST", "../rest/browseapp/mvfile/" + oSourceRow.path);
				xmlhttp.setRequestHeader("Content-Type", "application/json");
				xmlhttp.onreadystatechange = function() {
				    if (xmlhttp.readyState == 4) {
				    	if (xmlhttp.status == 200) {
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

					    } else {
					    	sap.m.MessageToast.show('Operation failed on the server ' + xmlhttp.responseText);
					    }
					}
				}
				var oPost = { "name": oSourceRow.name, "path": oTargetRow.path + "/" + oSourceRow.name};
				xmlhttp.send(JSON.stringify(oPost));
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
						oDataExchange.callback(oDataExchange)
					}
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
		}
	});

});
