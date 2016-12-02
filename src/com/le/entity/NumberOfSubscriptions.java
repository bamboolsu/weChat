package com.le.entity;

import java.util.Map;

public class NumberOfSubscriptions {
   @Override
	public String toString() {
		return "NumberOfSubscriptions [openID=" + openID + ", MsgType=" + MsgType + ", Event=" + Event + ", EventKey="
				+ EventKey + ", Ticket=" + Ticket + ", CreateTime=" + CreateTime + "]";
	}

private String openID;
   
   private String MsgType;//消息类型
   
   private String Event;//事件类型
   
   private String EventKey;//事件KEY值，qrscene_为前缀，后面为二维码的参数值
   
   public String getOpenID() {
	return openID;
}

public void setOpenID(String openID) {
	this.openID = openID;
}

public String getMsgType() {
	return MsgType;
}

public void setMsgType(String msgType) {
	MsgType = msgType;
}

public String getEvent() {
	return Event;
}

public void setEvent(String event) {
	Event = event;
}

public String getEventKey() {
	return EventKey;
}

public void setEventKey(String eventKey) {
	EventKey = eventKey;
}

public String getTicket() {
	return Ticket;
}

public void setTicket(String ticket) {
	Ticket = ticket;
}

public String getCreateTime() {
	return CreateTime;
}

public void setCreateTime(String createTime) {
	CreateTime = createTime;
}

public NumberOfSubscriptions(){}

public NumberOfSubscriptions(String openID){
	this.openID=openID;
}

public NumberOfSubscriptions(Map<String, String> map){
	this.CreateTime=map.get("CreateTime");
	this.EventKey=map.get("EventKey");
	this.Event=map.get("Event");
	this.openID=map.get("FromUserName");
	this.MsgType=map.get("MsgType");
	this.Ticket=map.get("Ticket");
}

private String Ticket;//二维码的ticket，可用来换取二维码图片
   
   private String  CreateTime;//消息创建时间
   
   private int state;//状态

public int getState() {
	return state;
}

public void setState(int state) {
	this.state = state;
}

//WxUser
private WxUser wxUser;

public WxUser getWxUser() {
	return wxUser;
}

public void setWxUser(WxUser wxUser) {
	this.wxUser = wxUser;
}
}
