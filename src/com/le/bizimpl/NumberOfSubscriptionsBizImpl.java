package com.le.bizimpl;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.le.biz.INumberOfSubscriptionsBiz;
import com.le.dao.INumberOfSubscriptionsDao;
import com.le.entity.NumberOfSubscriptions;
import com.le.entity.WxUser;
import com.le.util.WXUserUtil;

@Repository
public class NumberOfSubscriptionsBizImpl implements INumberOfSubscriptionsBiz{

	private Logger log=Logger.getLogger(NumberOfSubscriptionsBizImpl.class) ;
	public INumberOfSubscriptionsDao getInos() {
		return inos;
	}

	public void setInos(INumberOfSubscriptionsDao inos) {
		this.inos = inos;
	}

	@Autowired
	private INumberOfSubscriptionsDao inos;
	

	
   /**
    * 根据openId修改对象的状态
    */
	public void delete(String openId) {
		// TODO Auto-generated method stub
		log.info("openId"+openId);
		try {
			NumberOfSubscriptions nos = inos.findById(openId);
			log.info("nos   "+nos);
			if(nos!=null){
				nos.setState(0);
				inos.update(nos);
			}
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			log.error("修改状态出错",e);
			throw e;
		}
		
	}

	public void add(NumberOfSubscriptions nos) {
		// TODO Auto-generated method stub
		log.info("nos  "+nos);
		try {
			nos.setState(1);
			 WxUser weChatUser = WXUserUtil.getWeChatUser(nos.getOpenID());
			 log.info("weChatUser    "+weChatUser);
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
