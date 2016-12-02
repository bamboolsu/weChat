package com.le.wechat.entity;

public class VoiceMessage extends BaseMess{
   private String MediaId;//语音消息媒体id
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
private String Format;//语音格式，如amr，speex等
}
