package com.le.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.le.biz.INumberOfSubscriptionsBiz;
import com.le.bizimpl.NumberOfSubscriptionsBizImpl;
import com.le.entity.NumberOfSubscriptions;
import com.le.icontroller.IEventDispatcher;

import com.le.util.DateUtil;
import com.le.util.MessageUtil;
/**
 * 事件分发处理
 * @author admin
 *
 */
@Repository
public class EventDispatcher implements IEventDispatcher{
	@Autowired
	private  INumberOfSubscriptionsBiz nosb;
	public  String processEvent(Map<String, String> map)  {
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //关注事件
            String date = DateUtil.TimeStampDate(map.get("CreateTime"),"yyyy-MM-dd HH:mm:ss");
            map.put("CreateTime", date);
            NumberOfSubscriptions ns=new NumberOfSubscriptions(map);
            nosb.add(ns);
            
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //取消关注事件
            //删除该用户(将用户的状态修改为0)
           this.nosb.delete(map.get("FromUserName"));
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //扫描二维码事件
            System.out.println("==============这是扫描二维码事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //位置上报事件
            System.out.println("==============这是位置上报事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //自定义菜单点击事件
            System.out.println("==============这是自定义菜单点击事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //自定义菜单 View 事件
            System.out.println("==============这是自定义菜单 View 事件！");
        }
        
        return null;
    }
	public INumberOfSubscriptionsBiz getNosbi() {
		return nosb;
	}
	public void setNosbi(INumberOfSubscriptionsBiz nosbi) {
		this.nosb = nosbi;
	}
	
}
