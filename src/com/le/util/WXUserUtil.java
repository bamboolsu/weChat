package com.le.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
}
