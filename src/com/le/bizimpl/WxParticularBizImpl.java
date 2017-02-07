package com.le.bizimpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.le.biz.IWxParticularBiz;
import com.le.dao.ILeTypeDao;
import com.le.dao.IWxParticularDao;
import com.le.entity.LeType;
import com.le.entity.WxParticular;
import com.le.util.DateUtil;


@Repository
public class WxParticularBizImpl implements IWxParticularBiz{

	@Autowired
	private IWxParticularDao iwp;
	
	@Autowired
	private ILeTypeDao ild;
	
	public IWxParticularDao getIwp() {
		return iwp;
	}

	public void setIwp(IWxParticularDao iwp) {
		this.iwp = iwp;
	}

	public ILeTypeDao getIld() {
		return ild;
	}

	public void setIld(ILeTypeDao ild) {
		this.ild = ild;
	}

	public int add(WxParticular wp) {
		// TODO Auto-generated method stub
		int add = iwp.add(wp);
		return add;
	}

	public List<WxParticular> init() {
		return null;
		// TODO Auto-generated method stub
		
	}

	/**
	 *
	 */
	public List<WxParticular> init(int page, int pageCount) {
		// TODO Auto-generated method stub
		int startLine=(page-1)*pageCount;
		List<WxParticular> all = iwp.getAll(startLine, pageCount);
		return all;
	}

	
	
	/**
	 * 检查WxParticular数据完整性
	 */
	public void check(WxParticular wp) {
		// TODO Auto-generated method stub
		
	}

	/**
	 *总人数
	 */
	public Long getSumPage(int pageCount) {
		// TODO Auto-generated method stub
		//����Ŀ��
		Long count = iwp.getCount();
		if(count%pageCount==0){
			return count/pageCount;
		}else{
			return count/pageCount+1;
		}
	}

	/**
	 *根据id 删除WxParticular用户
	 */
	public boolean deleteWxParticularById(int id) {
		// TODO Auto-generated method stub
		int deleteById = iwp.deleteById(id);
		return deleteById>0;
	}

	/**
	 * 二维码地址ַ
	 */
	public boolean setImageUrl(String imageUrl, int id) {
		// TODO Auto-generated method stub
		int setImageUrl = this.iwp.setImageUrl(imageUrl, id);
		return setImageUrl>0;//false-OK true---
	}

	/**
	 * 更新WxParticular信息
	 */
	public boolean updateWxParticular(WxParticular wp) {
		// TODO Auto-generated method stub
		int updateById = iwp.updateById(wp);
		return updateById>0;
	}

	public WxParticular findWxParticularById(int id) {
		// TODO Auto-generated method stub
		WxParticular findWxParticularById = iwp.findWxParticularById(id);
		return findWxParticularById;
	}

	public List<Object[]> getAll() {
		// TODO Auto-generated method stub
		List<Object[]> list = iwp.getAll();//����ͳ����ص���Ϣ
		return list;
	}

	

	/**
	 * 某段时间的总关注人数
	 */
	public Long getCount(Integer eventKey, Integer date, Integer state) {
		// TODO Auto-generated method stub
		String someTime = DateUtil.SomeTime(date);
		Object values[]={eventKey,state,someTime};
		String hql="select count(user.openId) from NumberOfSubscriptions nos , WxUser  user   where  nos.state=?  and nos.eventKey=?  and user.subscribeTime>=?";
		Long countByEventKey = iwp.countByEventKey(hql, values);
		return countByEventKey;
	}

	public List<LeType> getAllType() {
		// TODO Auto-generated method stub
		List<LeType> leTypes = ild.getAll();
		return leTypes;
	}

	public void test() {
		// TODO Auto-generated method stub
		
	}

}
