package cn.yxh.service.impl;

import cn.yxh.dao.IAdminDao;
import cn.yxh.entity.Admin;
import cn.yxh.service.IAdminService;

public class AdminService implements IAdminService{
	//这里必须要用接口因为其使用JDK代理对象
	//spring生成代理对象原则，若没有实现接口则使用cglib代理没有问题，若实现了接口
	//则使用JDK代理。
	private IAdminDao adminDao;
	
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void register(Admin admin) {
		adminDao.save(admin);
		
	}

	@Override
	public Admin login(Admin admin) {
		return adminDao.findByAdmin(admin);
		
	}

}
