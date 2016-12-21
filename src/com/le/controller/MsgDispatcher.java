package com.le.controller;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Repository;

import com.le.icontroller.IMessageDispatcher;
import com.le.util.MessageUtil;
import com.le.wechat.entity.TextMessage;

/**
 * ��ͨ��Ϣ�ַ�
 * @author admin
 *
 */
@Repository
public class MsgDispatcher implements IMessageDispatcher{
	public  String processMessage(Map<String, String> map) {
		String openid=map.get("FromUserName"); //用户openid
		String mpid=map.get("ToUserName");   //公众号原始ID
      	TextMessage textMess=new TextMessage();
      	textMess.setFromUserName(openid);
      	textMess.setToUserName(mpid);
      	textMess.setCreateTime(new Date().getTime());
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // �ı���Ϣ
            System.out.println("文字回复");
            Set<String> keySet = map.keySet();
            for (String string : keySet) {
				System.out.println("key    "+string+"    value    "+map.get(string));
			}
          
        	textMess.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
        	textMess.setContent("aaaa");
        	String textMessageToXml = MessageUtil.textMessageToXml(textMess);
        	String asXML=null;
        	try {
				Document parseText = DocumentHelper.parseText(textMessageToXml);
				Element root = parseText.getRootElement();
				Element CreateTimeNode = root.element("CreateTime");
				CreateTimeNode.setText(Long.toString(new Date().getTime()));
			    asXML = root.asXML();
				System.out.println("asxml is    ======================== "+asXML);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return asXML;
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
