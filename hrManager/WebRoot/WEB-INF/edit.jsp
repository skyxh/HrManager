<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <s:form action="emp_update.action" method="post" theme="simple">
  	<!--修改操作需要隐藏域保存主键值  -->
  	<s:hidden name="id" id="id" value="%{id}"></s:hidden>
   <table border="1" align="center" width="80%" cellpadding="5">
   		<tr>
   			<td>员工姓名</td>
   			<td>
   				<s:textfield name="empName" id="empName"></s:textfield>
   			</td>
   		</tr>
   		<tr>
   			<td>员工薪水</td>
   			<td>
   				<s:textfield name="salary" id="salary"></s:textfield>
   			</td>
   		</tr>
   		<tr>
   			<td>选择部门</td>
   			<!--传统html标签创建下拉列表  -->
   			<%-- <td>
   				<select>
   					<option>请选择</option>
   					<option value="1">开发部</option>
   				</select>
   			</td> --%>
   			<!--struts下拉列表标签  -->
   			<td>
   			<!--value默认选择项的设置，即设置要显示对象的主键  -->
   				<s:select
   					name="deptId"
   					headerKey="-1"
   					headerValue="请选择"
   					list="#request.listDept"
   					listKey="id"
   					listValue="name"
   					value="dept.id"	
   				>
   				</s:select>
   			
   			</td>
   		</tr>
   		<tr>
   			<td colspan="2">
   				<s:submit value="修改员工"></s:submit>
   			</td>
   		</tr>
   </table>
   </s:form>
  </body>
</html>
