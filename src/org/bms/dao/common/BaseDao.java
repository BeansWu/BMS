package org.bms.dao.common;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: BaseDao
 * @author: Andrew 
 * @date:   2017-05-23
 */
@Component("baseDao")
public class BaseDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	/**
	 * @Title: add   
	 * @Description: 添加数据  
	 * @param: @param object
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean add (Object object) {
		try {
			getSession().save(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * @Title: queryForBean   
	 * @Description: 查询实体
	 * @param: @param hql
	 * @param: @param objects
	 * @param: @return      
	 * @return: T      
	 * @throws
	 */
	public <T> T queryForBean (String hql, Object ...objects) {
		Query query = getSession().createQuery(hql);
		try{
			for (int i = 0; i < objects.length && objects[i] != null; i++) {
				query.setParameter(i, objects[i]);
			}
			@SuppressWarnings("unchecked")
			T bean = (T) query.getSingleResult();
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @Title: update   
	 * @Description: 更新数据
	 * @param: @param object
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean update (Object object) {
		try {
			getSession().update(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * @Title: update   
	 * @Description: 更新数据
	 * @param: @param hql
	 * @param: @param objects
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean update (String hql, Object ...objects) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < objects.length && objects[i] != null; i++) {
			query.setParameter(i, objects[i]);
		}
		try {
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * @Title: delete   
	 * @Description: 删除数据 
	 * @param: @param hql
	 * @param: @param objects
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public Boolean delete (String hql, Object ...objects) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < objects.length && objects[i] != null; i++) {
			query.setParameter(i, objects[i]);
		}
		try {
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * @Title: query   
	 * @Description: 查询实体集合
	 * @param: @param hql
	 * @param: @param objects
	 * @param: @return      
	 * @return: List<T>
	 * @throws
	 */
	public <T> List<T> query (String hql, Object ...objects) {
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < objects.length && objects[i] != null; i++) {
			query.setParameter(i, objects[i]);
		}
		@SuppressWarnings("unchecked")
		List<T> list = query.getResultList();
		return list;
	}
}
