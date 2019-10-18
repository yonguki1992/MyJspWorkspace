<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.welcome {
	background-color: green;
	border: 1px solid black;
	width: 400px;
}
ul.actionMessage li {
	color: yellow;
}
</style>
</head>
<body>
	<h3>
		Welcome <s:property value="userName"></s:property><br/>
		Welcome ${userName }<br/>
	</h3>
</body>
</html>