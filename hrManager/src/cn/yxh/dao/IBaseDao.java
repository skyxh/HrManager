package cn.yxh.dao;

import java.util.List;

import cn.yxh.entity.Employee;

/**
 * 所有dao的通用操作接口定义
 * @author Administrator
 *
 */
public interface IBaseDao<T> {
	/**
	 * 保存
	 * @param emp
	 */
	void save(T emp);
	/**
	 * 更新对象信息
	 * @param emp
	 */
	void update(T emp);
	
	/**
	 * 根据主键删除
	 * @param id
	 */
	void delete(int id);
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	T findById(int id);
	
	/**
	 * 查询全部
	 * @return
	 */
	List<T> getAll();
	
	
}
