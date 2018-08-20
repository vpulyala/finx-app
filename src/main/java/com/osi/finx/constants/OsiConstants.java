package com.osi.finx.constants;

/**
 * This file should contain all constant values throughout the application.
 * If applicable, constants should be categorized in static inner classes.
 * 
 * <p>GENERIC_ERROR_CODES : SEQ ERR_0XXX is for Generic Errors
 * <p>GENERIC_SUCCESS_CODES : SEQ OK_0XXX is for Generic Success Messages
 * 
 * @author vpulyala
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
