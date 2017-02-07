package com.le.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.le.dao.ILeTypeDao;
import com.le.entity.LeType;
import com.le.entity.WxParticular;
/**
 * LeType
 * @author ouyangwenting
 *
 */
@Repository
public class LeTypeDaoImpl extends BaseDao implements ILeTypeDao{

	public int add(LeType leType) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(leType);
			return 0;//�����ɹ�
		} catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;//����ʧ��
	}

	public int deleteById(int id) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(this.getHibernateTemplate().get(WxParticular.class,new Long(id)));
			return 0;//ɾ���ɹ�
		} catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;//ɾ��ʧ��
	}

	public int updateById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<LeType> getAll() {
		// TODO Auto-generated method stub
		List<LeType> leTypes = this.getHibernateTemplate().find("from LeType");
		return leTypes;
	}

}
