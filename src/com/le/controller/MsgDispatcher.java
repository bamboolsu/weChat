package com.le.controller;

import java.util.Map;
import java.util.Set;

import com.le.icontroller.IMessageDispatcher;
import com.le.util.MessageUtil;

/**
 * ��ͨ��Ϣ�ַ�
 * @author admin
 *
 */
public class MsgDispatcher implements IMessageDispatcher{
	public  String processMessage(Map<String, String> map) {
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // �ı���Ϣ
            System.out.println("==============�����ı���Ϣ��");
            Set<String> keySet = map.keySet();
            for (String string : keySet) {
				System.out.println("key    "+string+"    value    "+map.get(string));
			}
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // ͼƬ��Ϣ
            System.out.println("==============����ͼƬ��Ϣ��");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // ������Ϣ
            System.out.println("==============����������Ϣ��");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // λ����Ϣ
            System.out.println("==============����λ����Ϣ��");
        }

        /*if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // ��Ƶ��Ϣ
            System.out.println("==============������Ƶ��Ϣ��");
        }*/

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // ������Ϣ
            System.out.println("==============����������Ϣ��");
        }

        return null;
    }

	
}
