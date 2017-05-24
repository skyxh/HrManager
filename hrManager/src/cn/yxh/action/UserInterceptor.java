package cn.yxh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 校验用户是否登录，只有登录后才能进行操作 
 * 
 * @author Administrator
 *
 */
public class UserInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	//得到当前执行的方法
		String methodName=invocation.getProxy().getMethod();
	//得到ActionContext对象
		ActionContext ac = invocation.getInvocationContext();
		//获取session，从session中获取登录管理员账号
		Object object=ac.getSession().get("adminInfo");
	//判断：只有不是在执行登录时才执行验证,及没有访问list方法时才验证
		if(!"login".equals(methodName)&&!"list".equals(methodName)){
			if(object==null){
				//没有登录
				return "login";
			}else{
				//执行action
				return invocation.invoke();
			}
		}else{
			//允许访问登录、列表展示
			return invocation.invoke();
		}
		
	}

}
