## Folder structure

The  _hanarepo_  folder is the root folder of all development artifacts.
It is meant to be used by git, hence every developer has its own personal version of the repository.
Therefore, the first directory level is about the Hana username of the logged in user.
Within the development objects are separated by the schema each object should be deployed into.

Example: The file is located under USER1/SCHEMA2/TABLE_A.hdbtable

Upon activation, the user USER1 will create a table TABLE_A in the schema SCHEMA2. Hopefully USER1 has permissions on SCHEMA2.

## Aliasing

When deploying objects and using other elements the following cases should be possible (one hdbtable and one hdbview as example):

 - SCHEMA2.TABLE_A has a view SCHEMA2.VIEW_A.
 - SCHEMA2.TABLE_A should be accessed by a view in a different schema SCHEMA3.VIEW_A.
 - SCHEMA2.TABLE_A is used by other runtime objects not part of this repository and deployment process.
 - All developers work on the same schema, so they might overwrite each other's SCHEMA2.TABLE_A definition.
 - All developers should work within their own schemas for maximum independence.
 - The same application should be deployed twice within the same database using different schemas.
 
 Therefore the deployment process supports schema mappings. The development object is placed in one schema and using 
 objects from different owners, e.g. the SCHEMA3.VIEW_A is a select on SCHEMA2.TABLE_A. At activation time the logic tries to find these two 
 schema names first in the hanarepo/{user}/global.schemamapping file, if not present, in the hanarepo/global.schemamapping and does a textual replacement 
 of the schema names of the development file. 