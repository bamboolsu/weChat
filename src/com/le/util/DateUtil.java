package com.le.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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
	   
	   
	   public static String getString(String filepath){
		   String str=null;
		   File file = new File(filepath);
		  
		  
	        Reader reader = null;
	        try {
	            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
	            // 一次读一个字符
	            reader = new InputStreamReader(new FileInputStream(file));
	            int tempchar;
	            while ((tempchar = reader.read()) != -1) {
	                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
	                // 但如果这两个字符分开显示时，会换两次行。
	                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
	                if (((char) tempchar) != '\r') {
	                	str+=(char) tempchar;
	                    System.out.print((char) tempchar);
	                    
	                }
	            }
	           
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	        	 try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        return str;
	   }
}
