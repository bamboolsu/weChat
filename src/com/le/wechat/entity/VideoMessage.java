package com.le.wechat.entity;

public class VideoMessage extends BaseMess{
    private String MediaId;//��Ƶ��Ϣý��id
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
	private String ThumbMediaId;//��Ƶ��Ϣ����ͼ��ý��id

}
