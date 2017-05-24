package cn.yxh.dao;

import java.util.List;

import cn.yxh.entity.Dept;

/**
 * 部门模块Dao设计
 * @author Administrator
 *
 */
public interface IDeptDao {
 /**
  * 查询全部
  */
	List<Dept> getAll();
	
	
	/**
	 * 根据主键查询
	 */
	Dept findById(int id);
}
