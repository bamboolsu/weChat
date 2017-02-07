package com.le.controller;


import java.util.Date;

import java.util.Map;
import java.util.Set;


import org.springframework.stereotype.Repository;

import com.le.icontroller.IMessageDispatcher;
import com.le.util.MessageUtil;
import com.le.wechat.entity.ImageMessage;

import com.le.wechat.entity.TextMessage;

/**
 * 
 * @author admin
 *
 */
@Repository
public class MsgDispatcher implements IMessageDispatcher{
	public  String processMessage(Map<String, String> map) {
		String openid=map.get("FromUserName"); //用户openid
		String mpid=map.get("ToUserName");   //公众号原始ID
      	
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { 
           // System.out.println("文字回复");
            Set<String> keySet = map.keySet();
            for (String string : keySet) {
				System.out.println("key    "+string+"    value    "+map.get(string));
			}
        	String content = map.get("Content");
        	if("交易规则".equals(content)){
        		System.out.println("交易规则");
        		ImageMessage imageMess=new ImageMessage();
        		imageMess.setFromUserName(mpid);
        		imageMess.setToUserName(openid);
      		  imageMess.setCreateTime(new Date().getTime());
      		  imageMess.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);
      		  imageMess.setMediaId("o7rUNxOkEVRFTpGSSvOhZGF1s6Qdg6Y-GPCljY31YKVkc-oTQZ-ak7NM0-b_hu7J");
      		  String imageMessageToXml = MessageUtil.imageMessToXml(imageMess);
      		  System.out.println(imageMessageToXml);
      		  return imageMessageToXml;
        	}else if(content!=null&&content.contains("经纪人")){
        		  ImageMessage imageMess=new ImageMessage();
        		  imageMess.setFromUserName(mpid);
          		imageMess.setToUserName(openid);
        		  imageMess.setCreateTime(new Date().getTime());
        		  imageMess.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);
        		  imageMess.setMediaId("4FWmAGkGDD6jbbxorEubDJphk2QblwVmOhjS9iCfpzF98UZdCs3ykJqqNsFGm8pe");
        		  String imageMessageToXml = MessageUtil.imageMessToXml(imageMess);
        		  return imageMessageToXml;
        	}else if(content!=null&&content.contains("现金券使用规则")){
        		TextMessage textMessage=new TextMessage();
        		textMessage.setFromUserName(mpid);
        		textMessage.setToUserName(openid);
        		textMessage.setCreateTime(new Date().getTime());
        		textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
        		textMessage.setContent("注册即送100元现金券，现金券可用于“乐交易”进行使用\n2，现金券在“乐交易”-“交易首页右下角?设置”-“我的礼券”中领取\n3，100元现金券将分为10个交易日发放，每张现金券的使用日期为当天，过期作废\n4，对于现金券使用的一切解释权归上海乐玑信息科技有限公司所有\n5，其他疑问请留言，乐积分客服将竭诚为您解答");
        		String textMessageToXml = MessageUtil.textMessageToXml(textMessage);
        		return textMessageToXml;
        	}else{
        		TextMessage textMess=new TextMessage();
            	textMess.setFromUserName(mpid);
            	textMess.setToUserName(openid);
            	textMess.setCreateTime(new Date().getTime());
          	textMess.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
          	textMess.setContent("您好，乐积分客服已经上线啦，有任何关于“乐积分”“乐交易”的问题都可以通过添加乐积分客服微信：17317200971 进行咨询哦!");
          	String textMessageToXml = MessageUtil.textMessageToXml(textMess);
              return textMessageToXml;
        	}
          
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            System.out.println("==============这是图片消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            System.out.println("==============这是链接消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            System.out.println("==============这是位置消息！");
        }

        /*if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
            System.out.println("==============这是视频消息！");
        }*/

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            System.out.println("==============这是语音消息！");
        }


        return null;
    }

	
}
