package com.le.bizimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.le.biz.INumberOfSubscriptionsBiz;
import com.le.dao.INumberOfSubscriptionsDao;
import com.le.entity.NumberOfSubscriptions;
import com.le.entity.WxUser;
import com.le.util.WXUserUtil;

@Repository
public class NumberOfSubscriptionsBizImpl implements INumberOfSubscriptionsBiz{

	
	public INumberOfSubscriptionsDao getInos() {
		return inos;
	}

	public void setInos(INumberOfSubscriptionsDao inos) {
		this.inos = inos;
	}

	@Autowired
	private INumberOfSubscriptionsDao inos;
	

	
   /**
    * 根据id将event对象的状态修改为0---取消关注
    */
	public void delete(String openId) {
		// TODO Auto-generated method stub
		try {
			NumberOfSubscriptions nos = inos.findById(openId);
			if(nos!=null){
				nos.setState(0);
				inos.update(nos);
			}
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	public void add(NumberOfSubscriptions nos) {
		// TODO Auto-generated method stub
		
		try {
			nos.setState(1);
			
			 WxUser weChatUser = WXUserUtil.getWeChatUser(nos.getOpenID());
			 
			 inos.save(nos,weChatUser);
		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		}
	}

	public int getWxEventCount(String date) {
		// TODO Auto-generated method stub
		int count = inos.getWxEventCount(date);
		return count;
	}

}
