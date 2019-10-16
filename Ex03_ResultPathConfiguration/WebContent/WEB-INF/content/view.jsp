<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${pageContext.request.contextPath }</h1>
	<h1>${pageContext.request.requestURI }</h1>
	<h1>${pageContext.request.requestURL }</h1>
	<h1>${pageContext.request.queryString }</h1>
	<h1>${pageContext.request.remoteAddr }</h1>
	<c:set var="path" value="${pageContext.request.contextPath }"/>
	<c:set var="uri" value="${pageContext.request.requestURI }"/>
	<c:set var="start" value="${fn:length(path) }"/>
	<c:set var="end" value="${fn:length(uri) }"/>
	<c:set var="file" value="${fn:substring(uri,start,end) }"/>
	<h1>fileName : ${file }</h1>
</body>
</html>