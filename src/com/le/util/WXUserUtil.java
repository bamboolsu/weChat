package com.le.util;


import java.io.IOException;

import java.util.HashMap;
import java.util.Map;


import org.apache.http.client.ClientProtocolException;

import com.le.entity.WxUser;


import net.sf.json.JSONObject;

public class WXUserUtil {
	private static final String lang="zh_CN";
	/**
	 * 通过openId查询用户的详细信息
	 * @param openId
	 * @param accessToken
	 * @return
	 */
    public static WxUser getWeChatUser(String openId){
    	Map<String, String> params=new HashMap<String, String>();
    	params.put("access_token",(String) GlobalConstants.interfaceUrlProperties.get("access_token"));
    	params.put("openid", openId);
    	params.put("lang", lang);
    	try {
			 String result = HttpUtils.sendGet(GlobalConstants.getInterfaceUrl("UserInfoUrl"), params);
			 JSONObject js=JSONObject.fromObject(result);	
			WxUser wUser=new WxUser(js);
			return wUser;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 生成永久二维码
     * @param action_name
     * @param scene_str
     * @return
     */
    public static String getTwoDimensioncode(String action_name,String scene_str){
    	JSONObject jsonobj=new JSONObject();
    	jsonobj.put("action_name", action_name);
    	JSONObject node=new JSONObject();
    	node.put("scene_str", scene_str);
    	jsonobj.put("action_info", node);
    	    String url=GlobalConstants.getInterfaceUrl("createQrCode")+"?access_token="+ GlobalConstants.interfaceUrlProperties.get("access_token");
			String sendPostBuffer=null;
			String imageurl=null;
			try {
				sendPostBuffer = HttpUtils.sendPostBuffer(url, jsonobj.toString());
				System.out.println(sendPostBuffer);
				JSONObject fromObject = JSONObject.fromObject(sendPostBuffer);
				imageurl=GlobalConstants.getInterfaceUrl("image")+"?ticket="+fromObject.get("ticket").toString();
				return imageurl;
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return imageurl;

    }
}
