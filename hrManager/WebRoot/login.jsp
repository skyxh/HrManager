<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  uri="/struts-tags" prefix="s" %>
<%--
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>登录</title>
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
    <s:form action="admin_login" method="post" theme="simple">
    	<table border="1" align="center" cellpadding="5">
    		<tr>
    			<td>管理员账号</td>
    			<td>
    				<s:textfield name="adminName" id="adminName" value=""></s:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td>
    				<s:textfield name="pwd" id="pwd" value=""></s:textfield>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<s:submit value="登录"></s:submit>
    			</td>
    		
    		</tr>
    	
    	</table>
    </s:form>
  </body>
</html>
