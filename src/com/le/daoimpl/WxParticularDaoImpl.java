package com.le.daoimpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import org.springframework.stereotype.Repository;

import com.le.dao.IWxParticularDao;
import com.le.entity.WxParticular;
import com.le.entity.WxUser;
/**
 * WxParticular表的增删查改
 * @author ouyangwenting
 *
 */
@Repository
public class WxParticularDaoImpl extends BaseDao implements IWxParticularDao{

	
	public int add(WxParticular wxPar) {
		// TODO Auto-generated method stub
		try {
			 this.getHibernateTemplate().save(wxPar);
			 System.out.println("wxPar     "+wxPar);
			 return wxPar.getId();//新增成功，返回Id
		} catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;//新增失败
	}

	public int deleteById(int id) {
		// TODO Auto-generated method stub
		try {
			
			 this.getHibernateTemplate().delete(this.getHibernateTemplate().get(WxParticular.class, new Long(id)));
			 return 1;//删除成功
		} catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;//删除失败
	}

	public int updateById(WxParticular wxPar) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(wxPar);
			return 1;
		} catch (RuntimeException e) {
			// TODO: handle exception
		}
		
		return -1;
	}

	/**
	 * 分页查询
	 */
	public List<WxParticular> getAll(int startLine,int pageCount) {
		// TODO Auto-generated method stub
		Session currentSession = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = currentSession.createQuery("from WxParticular");
		query.setFirstResult(startLine);
		List<WxParticular> wxParticulars = query.setMaxResults(pageCount).list();
		return wxParticulars;
	}

	/**
	 * 获取总条目数
	 */
	public long getCount() {
		// TODO Auto-generated method stub
		List<Object> find = this.getHibernateTemplate().find("select count(wp.id) from WxParticular wp");
		Long count=(Long) find.get(0);
		return count;
	}

	/**
	 * 根据id查询二维码参数
	 */
	public int getEventKey(int id) {
		// TODO Auto-generated method stub
		List<Object> property = this.getHibernateTemplate().find("select eventKey  from WxParticular wp where wp.id=?",id);
		Integer eventKey=(Integer) property.get(0);
		return eventKey;
		
	}

	/**
	 * 修改二维码图片地址
	 */
	public int setImageUrl(String imageUrl,int id) {
		// TODO Auto-generated method stub
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		WxParticular wxParticular =(WxParticular) session.get(WxParticular.class,id);
		System.out.println(wxParticular);
		System.out.println(id);
		wxParticular.setImageUrl(imageUrl);//修改imageUrl
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		try {
			session.save(wxParticular);
			transaction.commit();
			return 1;//修改成功
		} catch (RuntimeException e) {
			// TODO: handle exception
			transaction.rollback();
		}
		return -1;
	}

	public WxParticular findWxParticularById(int id) {
		// TODO Auto-generated method stub
		WxParticular wxParticular = this.getHibernateTemplate().get(WxParticular.class, id);
		return wxParticular;
	}

	public void test() {
		// TODO Auto-generated method stub
		
			List<WxUser> find = this.getHibernateTemplate().find("from WxUser");
			System.out.println(find.size());
			for (WxUser wxParticular : find) {
				System.out.println(wxParticular);
				System.out.println(wxParticular.getNos()); 
			}
		
	}

	
	public int countByEventKey(Integer eventKey, String date,int state) {
		// TODO Auto-generated method stub
		/*Object values[]={eventKey,state,date};
		List<Object> count = this.getHibernateTemplate().find("select count(user.openId) from NumberOfSubscriptions nos inner join WxUser user where nos.EventKey=? and nos.state=? and user.subscribeTime>=?",values);
		return (Integer)count.get(0);*/
		return 01;
	}

	public int countByEventKey(Integer eventKey, String date) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 某段时间关注数量
	 * @param eventKey
	 * @param date
	 * @param state
	 * @return
	 */
	public Long countByEventKey(String hql, Object[] values) {
		// TODO Auto-generated method stub
		List<Object> count =this.getHibernateTemplate().find(hql,values);
		System.out.println("关注人数"+count.get(0));
		return (Long)count.get(0);
	}

	
}
