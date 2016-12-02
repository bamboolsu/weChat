package com.le.util;

public class DateUtil {
	/** 
	    * Ê±¼äunix×ª»» 
	    * @param timestampString 
	    * @return 
	    */  
	   public static String TimeStampDate(String timestampString, String format) {  
	       Long timestamp = Long.parseLong(timestampString) * 1000;  
	       String date = new java.text.SimpleDateFormat(format).format(new java.util.Date(timestamp));  
	       return date;  
	   }  
}
