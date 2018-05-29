<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#save").click(function(){

		var nameVal = $("input[name='name']").val();
		var startDateVal = $("input[name='startdate']").val();
		var endDateVal = $("input[name='enddate']").val();
		var stateVal = $("select[name='progress']").val();
		var contentVal = $("textarea").val();
		
		console.log(nameVal+"/"+startDateVal+"/"+endDateVal+"/"+stateVal+"/"+contentVal);
		
		
		var sendData = {
			name:nameVal,
			startdate:startDateVal,
			enddate:endDateVal,
			progress:stateVal,
			content:contentVal
		};
		//@RequestBody, JSon.stringify, headers-Context-Type 세트
			$.ajax({    
				type : "post",
				url : "${pageContext.request.contextPath}/manager/projectWrite",
				data : JSON.stringify(sendData), //json string으로 바꿔줌
				dataType : "text", //xml, text, json
				headers : {
					"Content-Type" : "application/json;charset=UTF-8"
				},
				success : function(result) {
					console.log(result);
					if(result == "success"){
						alert("등록되었습니다.");
						location.href="${pageContext.request.contextPath}/manager/projectList";
					}
				}
			})
		});
})
</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1><프로젝트 등록하기></h1>
		<p><label>프로젝트 이름</label>
		<input type="text" name="name"></p>
		<p><label>프로젝트 내용</label>
			<textarea rows="20" cols="100" name="content"></textarea></p>
		<p><label>시작 날짜</label>
			<input type="date" name="startdate"></p>
		<p><label>마감 날짜</label>
			<input type="date" name="enddate"></p>
		<p><label>상태</label>
			<select name="progress">
				<option value="준비">준비</option>
				<option value="진행중">진행중</option>
				<option value="보류">보류</option>
				<option value="종료">종료</option>
			</select>
		</p>
		<p>
			<input type="submit" value="저장" id="save"><a href="${pageContext.request.contextPath}/manager/projectList"><input type="reset" value="취소"></a>
		</p>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>