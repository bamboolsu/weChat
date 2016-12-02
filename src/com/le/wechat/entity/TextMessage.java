package com.le.wechat.entity;
/**
 * ClassName:TextMessage
 * 文本消息类
 * @author admin
 *
 */
public class TextMessage extends BaseMess{
   private String Content;//文本消息内容

public String getContent() {
	return Content;
}

public void setContent(String content) {
	Content = content;
}
}
