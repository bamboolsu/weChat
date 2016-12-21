package com.le.controller;


import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.le.biz.INumberOfSubscriptionsBiz;

import com.le.entity.NumberOfSubscriptions;
import com.le.icontroller.IEventDispatcher;

import com.le.util.DateUtil;
import com.le.util.MessageUtil;

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
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //��ע�¼�
        	
        	/*Set<String> keys = map.keySet();
        	for (String key : keys) {
				System.out.println(key);
			}*/
        	
            String date = DateUtil.TimeStampDate(map.get("CreateTime"),"yyyy-MM-dd HH:mm:ss");
            map.put("CreateTime", date);
            NumberOfSubscriptions ns=new NumberOfSubscriptions(map);
            nosb.add(ns);
            
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //ȡ����ע�¼�
            //ɾ�����û�(���û���״̬�޸�Ϊ0)
        	System.out.println("ȡ����ע�¼�");
           this.nosb.delete(map.get("FromUserName"));
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //ɨ���ά���¼�
            System.out.println("==============����ɨ���ά���¼���");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //λ���ϱ��¼�
            System.out.println("==============����λ���ϱ��¼���");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //�Զ���˵�����¼�
            System.out.println("==============�����Զ���˵�����¼���");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //�Զ���˵� View �¼�
            System.out.println("==============�����Զ���˵� View �¼���");
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
