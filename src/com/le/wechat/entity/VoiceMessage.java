package com.le.wechat.entity;

public class VoiceMessage extends BaseMess{
   private String MediaId;//������Ϣý��id
   public String getMediaId() {
	return MediaId;
}
public void setMediaId(String mediaId) {
	MediaId = mediaId;
}
public String getFormat() {
	return Format;
}
public void setFormat(String format) {
	Format = format;
}
private String Format;//������ʽ����amr��speex��
}
