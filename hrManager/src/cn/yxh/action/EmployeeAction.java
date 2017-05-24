package cn.yxh.action;



import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.yxh.entity.Dept;
import cn.yxh.entity.Employee;
import cn.yxh.service.IDeptService;
import cn.yxh.service.IEmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
/**
 * 员工模块控制器开发
 * @author Administrator
 *
 */
public class EmployeeAction extends ActionSupport implements  ModelDriven<Employee>,RequestAware{
	private IEmployeeService employeeService;

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	private IDeptService deptService;
	
	
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	//封装请求数据 ,使用模型驱动
	private Employee employee=new Employee();

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;//返回实例化后对象
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	//封装下拉列表的deptId
	private int deptId;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	/**
	 * 员工列表展示
	 */
	public String list(){
		List<Employee> listEmp=employeeService.getAll();
		//保存到request域
//		Map<String, Object>request=(Map<String, Object>) ActionContext.getContext().get("request");
		request.put("listEmp", listEmp);
		return "list";
	}
	
	/**
	 * 2.添加员工，首先跳转到添加页面
	 * @return
	 */
	 public String viewAdd(){
		 //查询所有部门，保存到request
		List<Dept> listDept = deptService.getAll();
		request.put("listDept", listDept);
		return "add";
		 
	 }
	 /**
	  * 2.添加员工，添加数据
	  * @return
	  */
	 public String save(){
		 //必须先根据下拉列表提交的deptId，即部门主键进行查询
		 Dept dept = deptService.findById(deptId);
		 employee.setDept(dept);
		 //这样可以使得表员工表自动维护与部门之间的关系
		 //保存员工
		 employeeService.save(employee);
		 return "listAction";//重定向到Action
	 }
	 
	 /**
	  * 3.修改员工信息-进入修改视图
	  * @return
	  */
	  
	 public String viewUpdate(){
		 //获取要修改记录的id
		 int id=employee.getId();
		 //根据员工的主键查询
		 Employee emp = employeeService.findById(id);
		 //查询所有的部门
		 List<Dept> listDept = deptService.getAll();
		 //数据回显
		 ValueStack vs=ActionContext.getContext().getValueStack();
		 vs.pop();//移除栈顶元素
		 vs.push(emp);
		 //保存部门
		 request.put("listDept",listDept);
		 
		 return "edit";
	 }
	 /**
	  * 3.修改员工信息确认修改
	  * @return
	  */
	 public String update(){
		 //根据部门id，查询部门对象，再设置到员工属性
		  Dept dept = deptService.findById(deptId);
		  employee.setDept(dept);
		  employeeService.update(employee);
		 return "listAction";//重定向到列表
	 }
	 public String delete(){
		 int empId=employee.getId();
		 employeeService.delete(empId);
		 return "listAction";
	 }
	 
	 
	 //接收struts运行时候创建的代表request的Map，这样可以避免重写代码
	 private Map<String, Object> request;
	 
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		
	}

	
}
