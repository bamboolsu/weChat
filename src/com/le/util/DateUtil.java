package com.le.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

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
	   
	   public static String c(String xml){
		   try {
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			List<Element> elements = root.elements("CreateTime");
			for (Element element : elements) {
				
				if("CreateTime".equals(element.getName())){
					element.setText(Long.toString(new Date().getTime()));
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return xml;
	   }
}
