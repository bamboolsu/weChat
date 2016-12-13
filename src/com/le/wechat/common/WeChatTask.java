package com.le.wechat.common;


import java.util.HashMap;
import java.util.Map;


import com.le.util.GlobalConstants;
import com.le.util.HttpUtils;

import net.sf.json.JSONObject;


public class WeChatTask {
	public void getToken_getTicket() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credential");
        params.put("appid", GlobalConstants.getInterfaceUrl("appid"));
        params.put("secret", GlobalConstants.getInterfaceUrl("appsecret"));
        String jstoken = HttpUtils.sendGet(GlobalConstants.getInterfaceUrl("tokenUrl"), params);
        String access_token = JSONObject.fromObject(jstoken).getString("access_token"); // 获取到 token 并赋值保存
        GlobalConstants.interfaceUrlProperties.put("access_token", access_token);
        
    }
}
