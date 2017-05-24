package cn.yxh.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import cn.yxh.dao.IBaseDao;

public class BaseDao<T> implements IBaseDao<T> {
	//当前操作的实际bean类型
	private Class<T> clazz;
	//获取类名称
	private String className;
	
	//反射泛型,该内容是重点
	 public BaseDao() {
		Type type=this.getClass().getGenericSuperclass();
		//转换为参数化类型
		ParameterizedType pt=(ParameterizedType) type;
		//得到实际类型
		Type types[]=pt.getActualTypeArguments();
		//获取实际类型
		clazz=(Class<T>) types[0];
		//获取类型对应的字符串
		className=clazz.getSimpleName();//例如Employee
	}
	 private SessionFactory sessionFactory;
	 
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	@Override
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(int id) {
		//写这种形式的HQL查询时必须保证各单词之间的空格不能忘掉。
		sessionFactory.getCurrentSession()
						.createQuery("delete from "+className+" where id=?")
						.setParameter(0, id).executeUpdate();
		
	}

	@Override
	public T findById(int id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> getAll() {
		
		return sessionFactory.getCurrentSession()
							.createQuery("from "+className).list();
	}

}
