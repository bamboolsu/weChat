package com.le.wechat.entity;

public class ImageMessage extends BaseMess{
   private String PicUrl;//ͼƬ����
   private String MediaId;//ͼƬ��Ϣý��id
public String getMediaId() {
	return MediaId;
}

public void setMediaId(String mediaId) {
	MediaId = mediaId;
}

public String getPicUrl() {
	return PicUrl;
}

public void setPicUrl(String picUrl) {
	PicUrl = picUrl;
}
}
