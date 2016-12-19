package com.le.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
     * 永久二维码生成
     * @param eventKey
     * @return
     */
    public static String getImageUrl(Integer eventKey){
    	String url=(String) GlobalConstants.interfaceUrlProperties.get("createImageUrl")+"?access_token="+GlobalConstants.interfaceUrlProperties.get("access_token");
    	JSONObject jsonObj=new JSONObject();
    	jsonObj.put("action_name", "QR_LIMIT_SCENE");
    	jsonObj.put("action_info", eventKey);
    	String imageUrl=null;
    			try {
					String sendPostBuffer = HttpUtils.sendPostBuffer(url, jsonObj.toString());
					JSONObject str=JSONObject.fromObject(sendPostBuffer);
					imageUrl=(java.lang.String) GlobalConstants.interfaceUrlProperties.get("getImageUrl")+"?ticket=?"+str.getString("ticket");
					System.out.println(imageUrl);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	
    	
    	return imageUrl;
    }
}
