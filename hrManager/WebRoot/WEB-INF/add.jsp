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
    
    <title>添加</title>
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
  <s:form action="emp_save.action" method="post" theme="simple">
   <table border="1" align="center" width="80%" cellpadding="5">
   		<tr>
   			<td>员工姓名</td>
   			<td>
   				<s:textfield name="empName" id="empName" value=""></s:textfield>
   			</td>
   		</tr>
   		<tr>
   			<td>员工薪水</td>
   			<td>
   				<s:textfield name="salary" id="salary" value=""></s:textfield>
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
   				<s:select
   					name="deptId"
   					headerKey="-1"
   					headerValue="请选择"
   					list="#request.listDept"
   					listKey="id"
   					listValue="name"
   					value="-1"	
   				>
   				</s:select>
   			
   			</td>
   		</tr>
   		<tr>
   			<td colspan="2">
   				<s:submit value="添加员工"></s:submit>
   			</td>
   		</tr>
   </table>
   </s:form>
  </body>
</html>
