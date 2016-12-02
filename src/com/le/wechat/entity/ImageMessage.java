package com.le.wechat.entity;

public class ImageMessage extends BaseMess{
   private String PicUrl;//图片链接
   private String MediaId;//图片消息媒体id
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
