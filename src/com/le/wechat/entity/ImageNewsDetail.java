package com.le.wechat.entity;

/**
 * 图文消息详细，item标签内的内容
 * @author ouyangwenting
 *
 */
public class ImageNewsDetail {
    private String Title;//图文消息标题
    private String Description;//图文消息描述
    private String PicUrl;//图片地址
    private String Url;//跳转地址
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
}
