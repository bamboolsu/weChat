package com.le.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	/** 
	    * ʱ��unixת�� 
	    * @param timestampString 
	    * @return 
	    */  
	   public static String TimeStampDate(String timestampString, String format) {  
	       Long timestamp = Long.parseLong(timestampString) * 1000;  
	       String date = new java.text.SimpleDateFormat(format).format(new java.util.Date(timestamp));  
	       return date;  
	   }  
	   
	   /**
	    * ������ǰ
	    * @param day ��
	    * @return
	    */
	   public static String SomeTime(int day){
		   Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.DATE, day);
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        String format = sdf.format(calendar.getTime());
	        return format;
	   }
}
