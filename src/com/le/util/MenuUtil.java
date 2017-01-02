package com.le.util;



import org.apache.http.client.ClientProtocolException;

import com.wechat.menu.Button;
import com.wechat.menu.ClickButton;
import com.wechat.menu.Menu;
import com.wechat.menu.ViewButton;

import net.sf.json.JSONObject;

import java.io.IOException;



public class MenuUtil {
	/**
	 * @throws IOException 
	 * @throws ClientProtocolException 
	  * 创建Menu
	 * @Title: createMenu
	 * @Description: 创建Menu
	 * @param @return
	 * @param @throws IOException    设定文件
	 * @return int    返回类型
	 * @throws
	  */
	    public static String createMenu() throws ClientProtocolException, IOException {
             Menu menu=new Menu();
             
             //Button button=new Button();
            // button.setName("主菜单");
            ViewButton viewButton=new ViewButton();
            viewButton.setName("欧阳文霆的博客");
            viewButton.setType("view");
            viewButton.setUrl("http://ouyangwenting.com/");
            
            ViewButton viewButton2=new ViewButton();
            viewButton2.setName("去百度");
            viewButton2.setType("view");
            viewButton2.setUrl("https://www.baidu.com/");
            
            ClickButton clickButton=new ClickButton();
            clickButton.setKey("clicl_oywtTest");
            clickButton.setName("点点点");
            clickButton.setType("click");
            
            ViewButton viewButton3=new ViewButton();
            viewButton3.setName("去百度");
            viewButton3.setType("view");
            viewButton3.setUrl("https://www.baidu.com/");
            
            Button button=new Button();
            button.setName("主菜单");
            button.setSub_button(new Button[]{viewButton3,viewButton});
            //button.setType("click");
           // button.setSub_button(buttons);
           // Button[] menus={button};
            menu.setButton(new Button[]{clickButton,button});
            JSONObject menuJosn=JSONObject.fromObject(menu);
            System.out.println(menuJosn);
            String createMenuUrl = (String) GlobalConstants.interfaceUrlProperties.get("createMenu");
            createMenuUrl=createMenuUrl+"?access_token="+(String) GlobalConstants.interfaceUrlProperties.get("access_token");
            String sendPostBuffer = HttpUtils.sendPostBuffer(createMenuUrl, menuJosn.toString());
            JSONObject resultMess=JSONObject.fromObject(sendPostBuffer);
            System.out.println(resultMess);
	    	return "";
	   }
}
