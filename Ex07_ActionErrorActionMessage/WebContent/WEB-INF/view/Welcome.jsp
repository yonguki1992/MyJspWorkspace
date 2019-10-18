<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
	<h3>Struts2 ActionMessage Example</h3>
	<s:if test="hasActionMessages()">
		<div class="welcome">
			<s:actionmessage />
		</div>
	</s:if>
	<br>
	<br>
	<s:property value="getText('msg.welcome')" />
	<s:property value="username" />
</body>
</html>