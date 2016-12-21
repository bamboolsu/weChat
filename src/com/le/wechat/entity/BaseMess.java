package com.le.wechat.entity;
/**
 * ClassName:BaseMess
 * ΢��������Ϣ������
 * @author ŷ������
 *
 */
public class BaseMess {
    private String ToUserName;//������΢�ź�
    private String FromUserName;//���ͷ��ʺţ�һ��OpenID��
    private long CreateTime;//��Ϣ����ʱ��
    private String MsgType;//��Ϣ���� text��image��url��
   // private long MsgId;//��Ϣid
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
}
