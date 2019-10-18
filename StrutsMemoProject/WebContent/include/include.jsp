<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	//넘어온 인수 받아 현재 페이지 번호 받기
	int currentPage = 1;
	try {
		currentPage = Integer.parseInt(request.getParameter("p"));
	} catch(Exception e){
		
	}
	//페이지 사이즈 받기
	int pageSize = 10;
	try {
		pageSize = Integer.parseInt(request.getParameter("s"));
	} catch(Exception e){ }

	//블록 사이즈 받기
	int blockSize = 10;
	try {
		blockSize = Integer.parseInt(request.getParameter("b"));
	} catch(Exception e){ }
	
	// 글번호도 받기
	int idx = 0;
	try {
		idx = Integer.parseInt(request.getParameter("idx"));
	} catch(Exception e){ }
	//아래와 같이 자주 사용하는 것은 리퀘스트로 빼놓자
	request.setAttribute("newLine", "\n");
	request.setAttribute("br", "<br />");
	
	request.setAttribute("lt", "&lt;");
	request.setAttribute("less", "<");
	
	request.setAttribute("gt", "&gt;");
	request.setAttribute("greater", ">");
	
	request.setAttribute("sol", "&sol;");
	request.setAttribute("slash", "/");

	request.setAttribute("quot", "&quot;");
	request.setAttribute("dQuot", "\"");
	
	request.setAttribute("p", currentPage);
	request.setAttribute("s", pageSize);
	request.setAttribute("b", blockSize);
	request.setAttribute("idx", idx);
%>