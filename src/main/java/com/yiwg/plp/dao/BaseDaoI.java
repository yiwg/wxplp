package com.yiwg.plp.dao;

import org.hibernate.SQLQuery;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

	
	public interface BaseDaoI<T> {

		public Serializable save(T o) throws Exception;

		public void delete(T o) throws Exception;

		public void update(T o) throws Exception;

		public void saveOrUpdate(T o) throws Exception;

		public T get(Class<T> c, Serializable id) throws Exception;

		public T get(String hql) throws Exception;

		public T get(String hql, Map<String, Object> params) throws Exception;
		
		public T getAsNew(String hql, Map<String, Object> params) throws Exception;

		public List<T> find(String hql) throws Exception;

		public List<T> find(String hql, Map<String, Object> params) throws Exception;

		public List<T> find(String hql, int page, int rows) throws Exception;

		public List<T> find(String hql, Map<String, Object> params, int page, int rows) throws Exception;

		public Long count(String hql) throws Exception;

		public Long count(String hql, Map<String, Object> params) throws Exception;

		public int executeHql(String hql) throws Exception;
		
		public int update(String hql, Map<String, Object> params) throws Exception;
		
		public SQLQuery createSQLQuery(String sql, Map<String, Object> params) throws Exception;

		public void clear() throws Exception;
		
		public void flush() throws Exception;
	}

