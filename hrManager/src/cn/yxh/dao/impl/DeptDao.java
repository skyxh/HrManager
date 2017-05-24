package cn.yxh.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.yxh.dao.IDeptDao;
import cn.yxh.entity.Dept;

public class DeptDao implements IDeptDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Override
	public List<Dept> getAll() {
		
		return (List<Dept>)sessionFactory.getCurrentSession().createQuery("from Dept").list();
	}

	@Override
	public Dept findById(int id) {
		
		return (Dept) sessionFactory.getCurrentSession().get(Dept.class, id);
	}
	
	
	
}
