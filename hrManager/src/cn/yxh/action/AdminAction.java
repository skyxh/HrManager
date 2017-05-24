package cn.yxh.action;

import org.apache.struts2.interceptor.RequestAware;

import cn.yxh.entity.Admin;
import cn.yxh.service.IAdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 管理员登录注册模块
 * @author Administrator
 *
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

	private Admin admin=new Admin();
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}
	private IAdminService adminService;
	
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 登录
	 * @return
	 */
	public String login(){
		//登录验证
		Admin adminInfo=adminService.login(admin);
		if(adminInfo==null){
			//登录失败
			return "loginFailed";
		}else {
			//保存数据
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "index";
		}
	}

}
