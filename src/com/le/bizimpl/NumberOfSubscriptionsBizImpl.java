package com.le.bizimpl;



import com.le.biz.INumberOfSubscriptionsBiz;
import com.le.dao.INumberOfSubscriptionsDao;
import com.le.entity.NumberOfSubscriptions;
import com.le.entity.WxUser;
import com.le.util.WXUserUtil;


public class NumberOfSubscriptionsBizImpl implements INumberOfSubscriptionsBiz{

	
	public INumberOfSubscriptionsDao getInos() {
		return inos;
	}

	public void setInos(INumberOfSubscriptionsDao inos) {
		this.inos = inos;
	}

	private INumberOfSubscriptionsDao inos;
	

	

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

}
