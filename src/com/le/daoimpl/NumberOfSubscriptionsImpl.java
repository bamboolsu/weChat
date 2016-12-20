package com.le.daoimpl;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.le.dao.INumberOfSubscriptionsDao;
import com.le.entity.NumberOfSubscriptions;
import com.le.entity.WxUser;


@Repository
public class NumberOfSubscriptionsImpl extends BaseDao implements INumberOfSubscriptionsDao{

	/**
	 * Ìí¼ÓNumberOfSubscriptions£¬WxUser
	 */
	public void save(com.le.entity.NumberOfSubscriptions nos,WxUser wx) {
		// TODO Auto-generated method stub
		nos.setWxuser(wx);
		System.out.println(wx);
		Session currentSession = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction beginTransaction = currentSession.beginTransaction();
		beginTransaction.begin();
		try {
		NumberOfSubscriptions findById = findById(nos.getOpenID());
		if(findById!=null){
			findById.setState(1);
			currentSession.update(findById);
		}else{
			currentSession.save(nos);
		}
			currentSession.saveOrUpdate(wx);
			beginTransaction.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			beginTransaction.rollback();
			throw e;
		}
		
	}

	
	
	public NumberOfSubscriptions findById(String openId) {
		// TODO Auto-generated method stub
		NumberOfSubscriptions nos=this.getHibernateTemplate().get(NumberOfSubscriptions.class, openId);
		return nos;
	}

	public void delete(String openId) {
		// TODO Auto-generated method stub
		try {
			
			this.getHibernateTemplate().delete(this.getHibernateTemplate().get(NumberOfSubscriptions.class, openId));
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		}
	}

	public void update(NumberOfSubscriptions nos) {
		// TODO Auto-generated method stub
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		try {
			session.update(nos);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public int getWxEventCount(String date) {
		// TODO Auto-generated method stub
		List find = this.getHibernateTemplate().find("SELECT count(we.openID) from NumberOfSubscriptions we where we.createTime>=?", date);
		String str = find.get(0).toString();
		System.out.println(str);
		return Integer.parseInt(str);
	}

}
