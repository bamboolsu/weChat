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
			 System.out.println("wxuserInfo   is"+js);
			WxUser wUser=new WxUser(js);
			return wUser;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 永久二维码生成
     * @param eventKey
     * @return
     */
    public static String getImageUrl(Integer eventKey){
    	String url=(String) GlobalConstants.interfaceUrlProperties.get("createImageUrl")+"?access_token="+GlobalConstants.interfaceUrlProperties.get("access_token");
    	JSONObject jsonObj=new JSONObject();
    	JSONObject actionInfo=new JSONObject();
    	JSONObject scene=new JSONObject();
    	scene.put("scene_id", eventKey);
    	actionInfo.put("scene", scene);
    	jsonObj.put("action_name", "QR_LIMIT_SCENE");
    	jsonObj.put("action_info", actionInfo);
    	System.out.println(jsonObj);
    	String imageUrl=null;
    			try {
					String sendPostBuffer = HttpUtils.sendPostBuffer(url, jsonObj.toString());
					JSONObject str=JSONObject.fromObject(sendPostBuffer);
					
					imageUrl=(java.lang.String) GlobalConstants.interfaceUrlProperties.get("getImageUrl")+"?ticket="+str.getString("ticket");
					
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	
    	
    	return imageUrl;
    }
    
    /**
     * 解决跨域问题
     * @param callback  
     * @param jsonObj  json数据
     * @return
     */
    public static String crossDomain(String callback,JSONObject jsonObj){
    	
    	if(callback==null){
    		return jsonObj.toString();
    	}else{
    		String resposeStr=callback+"("+jsonObj.toString()+")";
    		return resposeStr;
    	}
    	
    }
}
