package cn.yxh.service;

import java.util.List;

import cn.yxh.entity.Dept;

public interface IDeptService {
	//部门service和部门dao一样
	
	/**
	  * 查询全部
	  */
		List<Dept> getAll();
		
		
		/**
		 * 根据主键查询
		 */
		Dept findById(int id);
}
