package com.yiwg.plp.dao.impl;

import com.yiwg.plp.dao.BaseDaoI;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class BaseDaoImpl<T> implements BaseDaoI<T> {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public Serializable save(T o) throws Exception{
		return this.getCurrentSession().save(o);
	}

	public T get(Class<T> c, Serializable id) throws Exception{
		return (T) this.getCurrentSession().get(c, id);
	}

	public T get(String hql) throws Exception{
		logger.info("数据库操作get(hql)：hql=[" + hql + "]");
		Query q = this.getCurrentSession().createQuery(hql);
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	public T get(String hql, Map<String, Object> params) throws Exception{
		logger.info("数据库操作get(hql,params)：hql=[" + hql + "],params=[" + params + "]");
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}
	
	public T getAsNew(String hql, Map<String, Object> params) throws Exception{
		logger.info("数据库操作getAsNew(hql,params)：hql=[" + hql + "],params=[" + params + "]");
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> l = q.list();
//		sessionFactory.close();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	public void delete(T o) throws Exception{
		this.getCurrentSession().delete(o);
	}

	public void update(T o) throws Exception{
		this.getCurrentSession().update(o);
	}

	public void saveOrUpdate(T o) throws Exception{
		this.getCurrentSession().saveOrUpdate(o);
	}

	public List<T> find(String hql) throws Exception{
		logger.info("数据库操作find(hql)：hql=[" + hql + "]");
		Query q = this.getCurrentSession().createQuery(hql);
		return q.list();
	}

	public List<T> find(String hql, Map<String, Object> params) throws Exception{
		logger.info("数据库操作find(hql,params)：hql=[" + hql + "],params=[" + params + "]");
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				if (params.get(key) instanceof Object[]) {
					q.setParameterList(key, (Object[])params.get(key));
				} else {
					q.setParameter(key, params.get(key));
				}
			}
		}
		return q.list();
	}

	public List<T> find(String hql, Map<String, Object> params, int page, int rows) throws Exception{
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public List<T> find(String hql, int page, int rows) throws Exception{
		Query q = this.getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	public Long count(String hql) throws Exception{
		Query q = this.getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}

	public Long count(String hql, Map<String, Object> params) throws Exception{
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}

	public int executeHql(String hql) throws Exception{
		logger.info("数据库操作executeHql(hql)：hql=[" + hql + "]");
		Query q = this.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	public int update(String hql, Map<String, Object> params) throws Exception {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}
	
	public SQLQuery createSQLQuery(String sql, Map<String, Object> params) throws Exception {
		SQLQuery query = this.getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query;
	}

	public void clear() throws Exception {
		this.getCurrentSession().clear();
	}
	
	public void flush() throws Exception {
		this.getCurrentSession().flush();
	}

}
