<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome User, please login below</h3>
	<s:form action="loginOk2">
		<s:textfield name="userID" label="User Name"></s:textfield>
		<s:textfield name="password" label="Password" type="password"></s:textfield>
		<s:submit value="Login"></s:submit>
	</s:form>
</body>
</html>