<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<Style>
	table{
		border-collapse: collapse;
		margin-bottom: 20px;
	}
	tr,th,td{
		border:1px solid black;
		text-align: center;
	}
	th{
		background-color: #EAEAEA;
		width: 180px;
	}
</Style>
</head>
<body>
<jsp:include page="header.jsp"/>
		<h1><프로젝트 리스트></h1>
		<table>
			<tr>
				<th>프로젝트명</th>
				<th>시작날짜</th>
				<th>종료날짜</th>
				<th>상태</th>
			</tr>
			
				<c:if test="${list.size() == 0 }">
					<tr>
					<td colspan="4">프로젝트가 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${list.size() > 0 }">
					<c:forEach var="items" items="${list }">
						<tr>
						<td><a href="projectread.do?no=${items.number }">${items.name }</a></td>
						<td><fmt:formatDate value="${items.startdate }" pattern="yy-MM-dd"/></td>
						<td><fmt:formatDate value="${items.enddate }" pattern="yy-MM-dd"/></td>
						<td>${items.progress }</td>
						</tr>
					</c:forEach>
				</c:if>
			<tr>
				<td colspan="4"><a href="write.do">[새 프로젝트 등록]</a></td>
			</tr>
		</table>
	
<jsp:include page="footer.jsp"/>
</body>
</html>