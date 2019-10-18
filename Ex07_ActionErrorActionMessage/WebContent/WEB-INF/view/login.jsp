<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.errorDiv {
	background-color: gray;
	border: 1px solid black;
	width: 400px;
	margin-bottom: 8px;
}
</style>
</head>
<body>
	<h3>Struts2 ActionError Example</h3>

	<%-- hasActionErrors() method is defined in ActionSupport --%>
	<s:if test="hasActionErrors()">
		<div class="errorDiv">
			<s:actionerror />
		</div>
	</s:if>

	<s:form action="welcome">
		<s:textfield name="username" key="label.username"></s:textfield>
		<s:password name="password" key="label.password"></s:password>
		<s:submit key="label.submit.login" align="center" name="submit"></s:submit>
	</s:form>
</body>
</html>