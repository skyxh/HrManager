package cn.yxh.service.impl;

import java.util.List;

import cn.yxh.dao.IDeptDao;
import cn.yxh.dao.impl.DeptDao;
import cn.yxh.entity.Dept;
import cn.yxh.service.IDeptService;

public class DeptService implements IDeptService{

	private IDeptDao deptDao;
	
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public List<Dept> getAll() {
		
		return deptDao.getAll();
	}

	@Override
	public Dept findById(int id) {
		
		return deptDao.findById(id);
	}

}
