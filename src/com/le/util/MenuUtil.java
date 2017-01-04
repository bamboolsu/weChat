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
            ViewButton viewButton=new ViewButton();
            viewButton.setName("欧阳文霆的博客");
            viewButton.setType("view");
            viewButton.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx234a559f20c403ed&redirect_uri=http://oywt.tunnel.qydev.com/WeChat/st/snsapiBase&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
            
            ViewButton viewButton2=new ViewButton();
            viewButton2.setName("去百度");
            viewButton2.setType("view");
            viewButton2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx234a559f20c403ed&redirect_uri=http://oywt.tunnel.qydev.com/WeChat/st/snsapiBase&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect");
            
            ClickButton clickButton=new ClickButton();
            clickButton.setKey("clicl_oywtTest");
            clickButton.setName("点点点");
            clickButton.setType("click");
            
            ViewButton viewButton3=new ViewButton();
            viewButton3.setName("授权");
            viewButton3.setType("view");
            viewButton3.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx234a559f20c403ed&redirect_uri=http%3a%2f%2foywt.tunnel.qydev.com%2fWeChat%2fst%2fsnsapiBase&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
            
            Button button=new Button();
            button.setName("主菜单");
            button.setSub_button(new Button[]{viewButton3,viewButton});
            menu.setButton(new Button[]{clickButton,button});
            JSONObject menuJosn=JSONObject.fromObject(menu);
            System.out.println(menuJosn);
            String createMenuUrl = (String) GlobalConstants.interfaceUrlProperties.get("createMenu");
            createMenuUrl=createMenuUrl+"?access_token="+(String) GlobalConstants.interfaceUrlProperties.get("access_token");
            String sendPostBuffer = HttpUtils.sendPostBuffer(createMenuUrl, menuJosn.toString());
            JSONObject resultMess=JSONObject.fromObject(sendPostBuffer);
	    	return "";
	   }
}
