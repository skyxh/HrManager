package cn.yxh.dao.impl;

import org.hibernate.SessionFactory;

import cn.yxh.dao.IAdminDao;
import cn.yxh.entity.Admin;

public class AdminDao implements IAdminDao{
//IOC容器注入，sessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
		
	}
	//根据用户名和密码进行查询，因此要根据条件查询
	
	@Override
	public Admin findByAdmin(Admin admin) {
		
		return (Admin) sessionFactory.getCurrentSession()
				.createQuery("from Admin where adminName=? and pwd=?")
				.setString(0,admin.getAdminName())
				.setString(1,admin.getPwd())
				.uniqueResult();//若用户名密码不会同时重复则可以用uniqueResult(),反之要使用list()
	}

}
