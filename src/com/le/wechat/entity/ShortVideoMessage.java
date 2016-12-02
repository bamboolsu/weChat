package com.le.wechat.entity;

public class ShortVideoMessage extends BaseMess {
    private String MediaId;//视频消息媒体id
    private String ThumbMediaId;//视频消息缩略图的媒体id
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
