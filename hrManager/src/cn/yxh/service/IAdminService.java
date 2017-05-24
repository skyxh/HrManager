package cn.yxh.service;

import cn.yxh.entity.Admin;

/**
 * 管理员业务逻辑层接口
 * @author Administrator
 *
 */
public interface IAdminService {
	/**
	 * 注册
	 * @param admin
	 */
	void register(Admin admin);
	/**
	 * 登录
	 * @param admin
	 */
	Admin  login(Admin admin);
}
