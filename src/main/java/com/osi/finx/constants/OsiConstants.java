package com.osi.finx.constants;

/**
 * This file should contain all constant values throughout the application.
 * If applicable, constants should be categorized in static inner classes.
 * 
 * <p>GENERIC_ERROR_CODES : SEQ ERR_0XXX is for Generic Errors
 * <p>GENERIC_SUCCESS_CODES : SEQ OK_0XXX is for Generic Success Messages
 * 
 */
public class OsiConstants {
	
	/**
	 * This static class should be used to access 
	 * Generic Error codes throughout the application.
	 * These codes take precedence over any other error code. 
	 * 
	 */
	public static final class GENERIC_ERROR_CODES {
		public static final String ERR_0001 = "Failed";
		public static final String ERR_0002 = "0";		
		public static final String ERR_0003 = "0003 - An error occurred while searching for your transaction.";		
		public static final String ERR_0004 = "0004 - An error occured while saving an object. Possible duplicate records in dataset.";	
		public static final String ERR_0005 = "0005 - An error occured while saving an object. Please check the validity of the dataset.";	
		public static final String ERR_0006 = "0006 - No Records Found.";
		public static final String ERR_0007 = "0007 - An error occurred while trying to construct an email notification.";
		public static final String ERR_0008 = "0008 - An error occurred while trying to load an entity.";
		public static final String ERR_0009 = "0009 - An error occured while deleting an object.";
		public static final String ERR_0010 = "0010 - An error occurred while processing the transactions.";
		public static final String ERR_0011 = "0011 - An error occurred while trying to Close the Database connection.";
	}
	
	/**
	 * This static class should be used to access 
	 * Generic success messages that are returned out of the application.
	 * These should be used consistently. If any other generic response is expected
	 * static variable here should be added.
	 *
	 */
	public static final class GENERIC_SUCCESS_CODES {
		// 
		public static final String OK_0001 = "Success";
		public static final String OK_0002 = "1";
	}
		
}
