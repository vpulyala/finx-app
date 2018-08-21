package com.osi.finx.util;

public class OsiCommonUtil {
	
	public static String createGenericJSONResponseForSuccess(String reponseMessage){
		StringBuilder osiErrorResponse = new StringBuilder();
		osiErrorResponse.append("{");
		osiErrorResponse.append("\"httpStatus\":200,");
		osiErrorResponse.append("\"responseMessage\":\""+reponseMessage+"\"");
		osiErrorResponse.append("}");
		return osiErrorResponse.toString();
	}
	
	public static String createGenericJSONResponseForSuccess(int reponseMessage){
		StringBuilder osiErrorResponse = new StringBuilder();
		osiErrorResponse.append("{");
		osiErrorResponse.append("\"httpStatus\":200,");
		osiErrorResponse.append("\"responseMessage\":"+reponseMessage);
		osiErrorResponse.append("}");
		return osiErrorResponse.toString();
	}	
	
}
