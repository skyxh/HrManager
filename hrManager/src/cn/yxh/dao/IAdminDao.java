package cn.yxh.dao;

import cn.yxh.entity.Admin;

/**
 * 管理员模块接口
 * @author Administrator
 *
 */
public interface IAdminDao {
	void save(Admin admin);
	/**
	 * 根据管理员信息查询
	 * @param admin
	 * @return
	 */
	Admin findByAdmin(Admin admin);
}
