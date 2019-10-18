<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>Document</title>
</head>
<body>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript">
		sendPost("list", {'p':'1','s':'${pageSize}','b':'${blockSize}'} );
	</script>
</body>
</html>