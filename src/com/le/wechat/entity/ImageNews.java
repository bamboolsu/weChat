package com.le.wechat.entity;

import java.util.List;

/**
 * 图文消息
 * @author ouyangwenting
 *
 */
public class ImageNews extends BaseMess{
     private int ArticleCount;
     private List<ImageNewsDetail> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<ImageNewsDetail> getArticles() {
		return Articles;
	}
	public void setArticles(List<ImageNewsDetail> articles) {
		Articles = articles;
	}
	
}
