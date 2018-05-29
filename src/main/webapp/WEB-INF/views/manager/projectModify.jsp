<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<style>
	p{
		overflow: hidden;
	}
	
	label{
		width: 120px;
		float: left;
		text-align: right;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#resave").click(function(){
		var nameVal = $("input[name='name']").val();
		var startDateVal = $("input[name='startdate']").val();
		var endDateVal = $("input[name='enddate']").val();
		var stateVal = $("select[name='progress']").val();
		var contentVal = $("textarea").val();
		var numberVal = $("input[name='numNo']").val();
		
		console.log(nameVal+"/"+startDateVal+"/"+endDateVal+"/"+stateVal+"/"+contentVal);
		
		
		var sendData = {
			name:nameVal,
			startdate:startDateVal,
			enddate:endDateVal,
			progress:stateVal,
			content:contentVal,
			number:numberVal
		};
		//@RequestBody, JSon.stringify, headers-Context-Type 세트
			$.ajax({    
				type : "post",
				url : "${pageContext.request.contextPath}/manager/projectModify",
				data : JSON.stringify(sendData), //json string으로 바꿔줌
				dataType : "text", //xml, text, json
				headers : {
					"Content-Type" : "application/json;charset=UTF-8"
				},
				success : function(result) {
					console.log(result);
					if(result == "success"){
						alert("수정되었습니다.");
						location.href="${pageContext.request.contextPath}/manager/projectRead?number="+${project.number};
					}
				}
			});
	});
	
	$("#cancel").click(function(){
		location.href="${pageContext.request.contextPath}/manager/projectRead?number="+${project.number};
	});
})
</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<input type="hidden" value="${project.number }" name="numNo">
		<p><label>프로젝트 이름</label>
		<input type="text" name="name" value="${project.name }"></p>
		<p><label>프로젝트 내용</label>
			<textarea rows="20" cols="100" name="content">${project.content }</textarea></p>
		<p><label>시작 날짜</label>
			
			<input type="date" name="startdate" value="<fmt:formatDate value="${project.startdate }" pattern="yyyy-MM-dd"/>"></p>
		<p><label>마감 날짜</label>
			<input type="date" name="enddate" value="<fmt:formatDate value="${project.enddate }" pattern="yyyy-MM-dd"/>"></p>
		<p><label>상태</label>
			<select name="progress" id="sel">
				<option value="준비"
					<c:if test="${project.progress == '준비'}">
						selected="selected"
					</c:if>
				>준비</option>
				<option value="진행중"
					<c:if test="${project.progress == '진행중'}">
						selected="selected"
					</c:if>
				>진행중</option>
				<option value="보류"
					<c:if test="${project.progress == '보류'}">
						selected="selected"
					</c:if>
				>보류</option>
				<option value="종료"
					<c:if test="${project.progress == '종료'}">
						selected="selected"
					</c:if>
				>종료</option>
			</select>
		</p>
		<p>
			<input type="submit" value="저장" id="resave"><input type="reset" value="취소" id="cancel">
		</p>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>