package io.rtdi.appcontainer.activationapp;

public enum ActivationStyle {
	/**
	 * add tables, columns, indexes but do not remove anything
	 */
	ADDONLY,
	/**
	 * it is allowed to drop tables and recreate those with the danger of data loss
	 */
	DROPCREATE, 
	/**
	 * Assume this is the first deployment
	 */
	FRESHDEPLOY,
	/**
	 * Modify the objects in a non-destructive way. Might throw error.
	 */
	RECONCILE;
}
