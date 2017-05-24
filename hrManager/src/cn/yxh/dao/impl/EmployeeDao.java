package cn.yxh.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.yxh.dao.IEmployeeDao;
import cn.yxh.entity.Employee;

public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao{

	/*private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	/*@Override
	public void save(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
		
	}

	
	@Override
	public void update(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);
		
	}

	@Override
	public void delete(int id) {
		//HQL查询区分大小写，完成删除功能
		sessionFactory.getCurrentSession().createQuery("delete from Employee where id=?")
			.setParameter(0, id)
			.executeUpdate();
	}*/

	@Override
	public Employee findById(int id) {
		
		return (Employee) getSessionFactory().getCurrentSession().get(Employee.class, id);
	}

	

	/*@Override
	public List<Employee> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}*/

	@Override
	public List<Employee> getAll(String employeeName) {
		
		return getSessionFactory().getCurrentSession().createQuery("from Employee where empName=?")
					.setParameter(0, employeeName)
					.list();
		/*
		模糊查询
		  return sessionFactory.getCurrentSession().createQuery("from Employee where empName like ?")
					.setParameter(0, "%"+employeeName+"%")
					.list();
		 */
	}

}
