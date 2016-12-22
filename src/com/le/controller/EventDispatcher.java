package com.le.controller;


import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.le.biz.INumberOfSubscriptionsBiz;

import com.le.entity.NumberOfSubscriptions;
import com.le.icontroller.IEventDispatcher;

import com.le.util.DateUtil;
import com.le.util.MessageUtil;
import com.le.wechat.entity.TextMessage;

/**
 * �¼��ַ�����
 * @author admin
 *
 */
@Repository
public class EventDispatcher implements IEventDispatcher{
	@Autowired
	private  INumberOfSubscriptionsBiz nosb;
	public  String processEvent(Map<String, String> map)  {
		String openid=map.get("FromUserName"); //用户openid
		String mpid=map.get("ToUserName");   //公众号原始ID
      	TextMessage textMess=new TextMessage();
      	textMess.setFromUserName(mpid);
      	textMess.setToUserName(openid);
      	textMess.setCreateTime(new Date().getTime());
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //关注事件
        	
        	Set<String> keys = map.keySet();
        	for (String key : keys) {
				System.out.println("========key======"+key+"=======valuse======="+map.get(key));
			}
        	
            String date = DateUtil.TimeStampDate(map.get("CreateTime"),"yyyy-MM-dd HH:mm:ss");
            map.put("CreateTime", date);
            NumberOfSubscriptions ns=new NumberOfSubscriptions(map);
            nosb.add(ns);
            textMess.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
        	textMess.setContent("终于找到组织了？组织用红包欢迎你！\n点击下方“乐交易”完成注册即可领取10元现金体验券\n回复“交易规则”查看交易方法，\n回复“使用规则”查看现金券使用规则，\n回复“经纪人”查看“秒变经纪人”方法");
        	String textMessageToXml = MessageUtil.textMessageToXml(textMess);
            return textMessageToXml;
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //取消关注事件
        	System.out.println("关注事件");
        	
           this.nosb.delete(map.get("FromUserName"));
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //扫描二维码事件
            System.out.println("==============这是扫描二维码事件！");
            return "";
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //位置上报事件
            System.out.println("==============这是位置上报事件！");
            return "";
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //自定义菜单点击事件
            System.out.println("==============这是自定义菜单点击事件！");
            return "";
            
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //自定义菜单 View 事件
            System.out.println("==============这是自定义菜单 View 事件！");
            return "";
        }
        
        return "";
    }
	public INumberOfSubscriptionsBiz getNosbi() {
		return nosb;
	}
	public void setNosbi(INumberOfSubscriptionsBiz nosbi) {
		this.nosb = nosbi;
	}
	
}
