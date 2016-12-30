package com.le.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;


public class MenuUtil {
	/**
	  * 创建Menu
	 * @Title: createMenu
	 * @Description: 创建Menu
	 * @param @return
	 * @param @throws IOException    设定文件
	 * @return int    返回类型
	 * @throws
	  */
	    public static String createMenu() {
String menu= "{\"button\":["
			    		//+ "{\"type\":\"view\",\"name\":\"乐交易\",\"url\":\"https:\\/\\/wx.wopapa.net\\/index.php?serial_code=066500677\",\"sub_button\":[]},"
			    		+ "{\"type\":\"view\",\"name\":\"乐交易\",\"url\":\"http:\\/\\/njjy.zfctc.net\\/OrgShare\\/ui\\/741\",\"sub_button\":[]},"
						//+ "{\"type\":\"view\",\"name\":\"账号绑定\",\"url\":\"https:\\/\\/wx.wopapa.net\\/index.php?r=site\\/vip\",\"sub_button\":[]},"
						+ "{\"type\":\"view\",\"name\":\"微信小店\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/bizmall\\/mallshelf?t=mall\\/list&biz=MzI4MzU0MzQ2OQ==&shelf_id=1&showwxpaytitle=1&scene=1#wechat_redirect\",\"sub_button\":[]},"
			    		
						+ "{\"name\":\"服务中心\","
						    + "\"sub_button\":["
						    			 // + "{\"type\":\"view\",\"name\":\"微信小店\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/bizmall\\/mallshelf?t=mall\\/list&biz=MzI4MzU0MzQ2OQ==&shelf_id=1&showwxpaytitle=1&scene=1#wechat_redirect\",\"sub_button\":[]},"
						                  //+ "{\"type\":\"view\",\"name\":\"交易规则\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/lSa-n7D2cA0Xf15UK4mctg\",\"sub_button\":[]},"
						                  + "{\"type\":\"media_id\",\"name\":\"客服微信\",\"media_id\":\"puIq1U9QBfNIsUdkDsVtGE_dA-d187K82jo-AJLt6v4\",\"sub_button\":[]},"
						                  //+ "{\"type\":\"view\",\"name\":\"关于我们\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/uBKISJiHsaM3e8ZxMTty5w\",\"sub_button\":[]},"
						                  //+ "{\"type\":\"media_id\",\"name\":\"秒变经纪人\",\"media_id\":\"puIq1U9QBfNIsUdkDsVtGNPQIuHlOmDKSqCZwqQbZQ4\",\"sub_button\":[]},"
						                  //+ "{\"type\":\"media_id\",\"name\":\"100元券\",\"media_id\":\"puIq1U9QBfNIsUdkDsVtGIVJ6IqpNdTrmzDo5UtYyUw\",\"sub_button\":[]}"
						                 // + "{\"type\":\"view\",\"name\":\"交易规则\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/lSa-n7D2cA0Xf15UK4mctg\",\"sub_button\":[]},"
						                  + "]}]}";


	        //此处改为自己想要的结构体，替换即可
	        String access_token=  (String) GlobalConstants.interfaceUrlProperties.get("access_token");

	        String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+access_token;
	        try {
	           URL url = new URL(action);
	           HttpURLConnection http =   (HttpURLConnection) url.openConnection();    

	           http.setRequestMethod("POST");        
	           http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
	           http.setDoOutput(true);        
	           http.setDoInput(true);
	           System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
	           System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒

	           http.connect();
	           OutputStream os= http.getOutputStream();    
	           os.write(menu.getBytes("UTF-8"));//传入参数    
	           os.flush();
	           os.close();

	           InputStream is =http.getInputStream();
	           int size =is.available();
	           byte[] jsonBytes =new byte[size];
	           is.read(jsonBytes);
	           String message=new String(jsonBytes,"UTF-8");
	           return "返回信息"+message;
	           } catch (MalformedURLException e) {
	               e.printStackTrace();
	           } catch (IOException e) {
	               e.printStackTrace();
	           }    
	        return "createMenu 失败";
	   }
}
