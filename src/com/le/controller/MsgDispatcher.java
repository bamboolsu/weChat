package com.le.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import com.le.wechat.entity.ImageNews;
import com.le.wechat.entity.ImageNewsDetail;
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
      	
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // �ı���Ϣ
           // System.out.println("文字回复");
            //Set<String> keySet = map.keySet();
            /*for (String string : keySet) {
				System.out.println("key    "+string+"    value    "+map.get(string));
			}*/
        	String content = map.get("Content");
        	if("图文消息".equals(content)){
        		ImageNews imageNews=new ImageNews();
        		imageNews.setFromUserName(mpid);
        		imageNews.setToUserName(openid);
        		imageNews.setCreateTime(new Date().getTime());
        		imageNews.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        		List<ImageNewsDetail> details=new ArrayList<ImageNewsDetail>();
        		ImageNewsDetail detail=new ImageNewsDetail();
        		detail.setTitle("这是我的第一个图文消息");
        		detail.setDescription("这个内容很精彩");
        		detail.setPicUrl("http://oywtwechattest.nat123.net/WeChat/image/test.jpg");
        		detail.setUrl("http://ouyangwenting.com/");
        		details.add(detail);
        		ImageNewsDetail detail2=new ImageNewsDetail();
        		detail2.setTitle("第二条图文消息");
        		detail2.setDescription("这个内容很精彩");
        		detail2.setPicUrl("http://oywtwechattest.nat123.net/WeChat/image/test2.jpg");
        		detail2.setUrl("http://ouyangwenting.com/");
        		details.add(detail2);
        		imageNews.setArticles(details);
        		imageNews.setArticleCount(details.size());
        		String imageNewsToXml = MessageUtil.ImageNewsToXml(imageNews);
        		return imageNewsToXml;
        	}else{
        		  TextMessage textMess=new TextMessage();
                	textMess.setFromUserName(mpid);
                	textMess.setToUserName(openid);
                	textMess.setCreateTime(new Date().getTime());
              	textMess.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
              	textMess.setContent("您好，乐积分客服已经上线啦，有任何关于“乐积分”“乐交易”的问题都可以通过添加乐积分客服微信：17317200971 进行咨询哦！\n在左下角“乐交易”中完成注册，就可以在交易首页的右下角“设置”-“我的礼券”中领取现金券啦\n回复“交易规则”查看交易方法，\n回复“使用规则”查看现金券使用规则，\n回复“经纪人”查看“秒变经纪人”方法");
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
