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
		return 0;
	}

	public List<WxParticular> init() {
		return null;
		// TODO Auto-generated method stub
		
	}

	/**
	 * 初始化
	 */
	public List<WxParticular> init(int page, int pageCount) {
		// TODO Auto-generated method stub
		int startLine=(page-1)*pageCount;
		List<WxParticular> all = iwp.getAll(startLine, pageCount);
		return all;
	}

	
	
	/**
	 * 检查对象数据的完整性，合法性
	 */
	public void check(WxParticular wp) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 获取总页数
	 */
	public Long getSumPage(int pageCount) {
		// TODO Auto-generated method stub
		//总条目数
		Long count = iwp.getCount();
		if(count%pageCount==0){
			return count/pageCount;
		}else{
			return count/pageCount+1;
		}
	}

	/**
	 * 根据id删除WxParticular对象
	 */
	public boolean deleteWxParticularById(int id) {
		// TODO Auto-generated method stub
		int deleteById = iwp.deleteById(id);
		return deleteById>0;
	}

	/**
	 * 根据id修改二维码图片地址
	 */
	public boolean setImageUrl(String imageUrl, int id) {
		// TODO Auto-generated method stub
		int setImageUrl = this.iwp.setImageUrl(imageUrl, id);
		return setImageUrl>0;//false--修改失败  true---修改成功
	}

	/**
	 * 修改WxParticular对象
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

	public List<LeType> getAll() {
		// TODO Auto-generated method stub
		List<LeType> leTypes = ild.getAll();
		return leTypes;
	}

	public void test() {
		// TODO Auto-generated method stub
		//iwp.test();
		Integer eventKey=123;
		Integer state=1;
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String someTime = DateUtil.SomeTime(-30);
		//String date=sdf.format(new Date());
		//System.out.println(date);
		System.out.println(someTime);
		Object values[]={eventKey,state,someTime};
		String hql="select count(user.openId) from NumberOfSubscriptions nos , WxUser  user   where nos.eventKey=? and nos.state=? and user.subscribeTime>=?";
		iwp.countByEventKey(hql, values);
	}

	/**
	 * 统计某段时间关注人数
	 */
	public Long getCount(Integer eventKey, Integer date, Integer state) {
		// TODO Auto-generated method stub
		String someTime = DateUtil.SomeTime(date);
		Object values[]={eventKey,state,someTime};
		String hql="select count(user.openId) from NumberOfSubscriptions nos , WxUser  user   where nos.eventKey=? and nos.state=? and user.subscribeTime>=?";
		Long countByEventKey = iwp.countByEventKey(hql, values);
		return countByEventKey;
	}

}
