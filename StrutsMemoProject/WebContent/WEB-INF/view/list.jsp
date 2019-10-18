<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%

	// include 덕분에 사용가능
	//Paging<MemoVO> pvo = MemoService.getInstance().selectList(currentPage, pageSize, blockSize);
	//el 사용을 위해 request 영역에 저장
	//request.setAttribute("pvo", pvo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="axicon/axicon/axicon.min.css" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#listValue").change(function() {
			//alert($(this).val());
			var pageSize = $(this).val();			
			sendPost('list',{'p':'${p}','s':pageSize,'b':'${b}'});
		});
	});
	function updateForm(idx) {
		var name = $("#name"+idx).html().trim();
		var memo = $("#memo"+idx).html().trim();
		$("#myForm").attr("action","updateOk");
		
		$("#idx").val(idx);
		
		$("#name").val(name);
		$("#name").attr("readonly","readonly");
		
		$("#memo").val(memo);
		$("#memo").removeAttr("readonly");
		
		$("#submitBtn").html("수정");
		$("#password").focus();
	};
	function deleteForm(idx) {
		var name = $("#name"+idx).html().trim();
		var memo = $("#memo"+idx).html().trim();
		$("#myForm").attr("action","deleteOk");
		
		$("#idx").val(idx);
		
		$("#name").val(name);
		//console.log($("#name"+idx).html());
		$("#name").attr("readonly","readonly");
		
		$("#memo").val(memo);
		$("#memo").attr("readonly","readonly");
		
		$("#submitBtn").html("삭제");
		$("#password").focus();
	};
	function resetForm() {
		$("#myForm").attr("action","insertOk");
		
		$("#idx").val(0);
		
		$("#name").val("");
		$("#name").removeAttr("readonly");
		
		$("#password").val("");
		
		$("#memo").val("");
		$("#memo").removeAttr("readonly");
		
		$("#submitBtn").html("작성");
		$("#name").focus();
	};
	function formCheck() {
		var value = $("#name").val();
		if (value.trim().length == 0) {
			alert("이름을 비워둘 수 없습니다.");
			$("#name").val("");
			$("#name").focus();
			return false;
		} else {
			$("#name").val(value.trim());
		}
		var value = $("#password").val();
		if (value.trim().length == 0) {
			alert("password를 비워둘 수 없습니다.");
			$("#password").val("");
			$("#password").focus();
			return false;
	
		} else {
			$("#password").val(value.trim());
		}
		
		var value = $("#memo").val();
		if (value.trim().length == 0) {
			alert("텍스트 상자를 비워둘 수 없습니다.");
			$("#memo").val("");
			$("#memo").focus();
			return false;
		} else {
			$("#memo").val(value.trim());
		}
		return true;
	};
</script>
<style type="text/css">
table {
	width: 1000px;
	border: none;
	margin: auto;
}

.title {
	font-size: 18pt;
	text-align: center;
	border: none;
}

.subTitle {
	font-size: 10pt;
	text-align: right;
	border: none;
}

th {
	border: 1px solid gray;
	padding: 3px;
	text-align: center;
	background-color: silver;
}

td {
	border: 1px solid gray;
	padding: 3px;
}
#list:hover{
	background-color: skyblue;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="5" class="title">게시판 v0.0.9</td>
		</tr>
		<tr>
			<td colspan="5" class="subTitle">
				${pvo.pageInfo }
				<select id="listValue">
					<option value="1" ${pvo.pageSize==1 ? "selected='selected'" : "" }>
						1개씩 보기
					</option>
					<option value="5" ${pvo.pageSize==5 ? "selected='selected'" : "" }>
						5개씩 보기
					</option>
					<option value="10" ${pvo.pageSize==10 ? "selected='selected'" : "" }>
						10개씩 보기
					</option>
				</select>
			</td>
		</tr>
		<tr>
			<th width="8%">No</th>
			<th width="12%">이름</th>
			<th width="60%">메모</th>
			<th width="10%">작성일</th>
			<th width="10%">IP</th>
		</tr>
		<c:if test="${pvo.totalCount==0 }">
			<tr>
				<td colspan="5" align="center" style="border: 1px solid gray;">게시글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${pvo.totalCount>0 }">
			<c:set var="num" value="${pvo.totalCount - ((pvo.currentPage - 1)*pvo.pageSize)}" />
			<c:forEach var="vo" items="${pvo.list }" varStatus="vs">
				<c:set var="No" value="${num - vs.index }" />
				<tr id="list">
					<td align="center">${No }</td>
					<td align="center">
						<span id="name${vo.idx }"><c:out value="${vo.name }"/></span>	
					</td>
					<td>
						<span id="memo${vo.idx }"><c:out value="${vo.memo }"/></span>
						<%-- 수정 삭제 버튼 생성해야함 --%>
						<i onclick="updateForm(${vo.idx})" style="font-size: 9pt; cursor: pointer;" class="axi axi-edit"></i>
						<i onclick="deleteForm(${vo.idx})" style="font-size: 9pt; cursor: pointer;" class="axi axi-delete2"></i>
					</td>
					<td align="center"><fmt:formatDate value="${vo.reg_date }"
							pattern="MM-dd hh:mm" /></td>
					<td align="center">${vo.ip }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="center" style="border: none;">
					${pvo.pageList}
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="5" align="left" style="border: none;">
				<form action="insertOk" method="post" id="myForm" onsubmit="return formCheck()">
					<input type="hidden" name="p" value="${currentPage }" /> 
					<input type="hidden" name="s" value="${pageSize }" /> 
					<input type="hidden" name="b" value="${blockSize }" /> 
					<input type="hidden" name="idx" id="idx" value="0"/> 		
	
					<input type="text" name="name" id="name" placeholder="이름" required="required" size="10" /> 
					<input type="password" name="password" id="password" placeholder="비밀번호" required="required" size="10" />
					<br /> 
					<input type="text" name="memo" id="memo" placeholder="바른말 고운말을 써주세요.^^" required="required" style="width: 890px;" />
					<button id="submitBtn" type="submit" class="btn btn-success btn-sm">
						작성
					</button>
					<button id="cancelBtn" type="button" onclick="resetForm()" class="btn btn-secondary btn-sm">
						취소
					</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>