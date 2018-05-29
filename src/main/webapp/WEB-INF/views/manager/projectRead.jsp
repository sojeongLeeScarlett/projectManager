<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
		width: 800px;
	}
	tr,th,td{
		border:1px solid black;
	}
	th{
		background-color: #EAEAEA;
		width: 120px;
	}
	td{
		text-align: justify;
	}
	a{
		color:black;
		text-decoration: none;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".del").click(function(){
			var result = confirm("정말 삭제하시겠습니까?");
			if(result){
				location.href= "${pageContext.request.contextPath}/manager/delete?number="+${project.number };
			}
		})
	})
</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
		<table>
			<tr>
				<th>프로젝트명</th>
				<td>${project.name }</td>
			</tr>
			<tr>
				<th colspan="2">프로젝트 내용</th>
			</tr>
			<tr>
				<td colspan="2">${project.content }</td>
			</tr>
			<tr>
				<th>시작날짜</th>
				<td><fmt:formatDate value="${project.startdate }" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<th>종료날짜</th>
				<td><fmt:formatDate value="${project.enddate }" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<th>상태</th>
				<td>${project.progress }</td>      
			</tr>
		</table>
		<div class="buttons">
			<a href="${pageContext.request.contextPath}/manager/projectModify?number=${project.number }">[수정]</a>
			<a class="del">[삭제]</a>
			<a href="${pageContext.request.contextPath}/manager/projectList">[돌아가기]</a>
		</div>
		
	<jsp:include page="footer.jsp"/>

</body>
</html>