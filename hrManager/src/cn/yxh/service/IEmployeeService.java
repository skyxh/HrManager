package cn.yxh.service;

import java.util.List;
import java.util.function.IntPredicate;

import cn.yxh.entity.Employee;

public interface IEmployeeService {
	/**
	 * 保存员工信息
	 * @param emp
	 */
	void save(Employee emp);
	/**
	 * 更新员工信息
	 * @param emp
	 */
	void update(Employee emp);
	
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
	Employee findById(int id);
	
	List<Employee> getAll();
	
	/**
	 * 根据员工姓名查询所有员工
	 * @param employeeName
	 * @return
	 */
	List<Employee> getAll(String employeeName);
	/**
	 * 删除多个
	 * @param ids
	 */
	void deleteMany(int[] ids);
}
