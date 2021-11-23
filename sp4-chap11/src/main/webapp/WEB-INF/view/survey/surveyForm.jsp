<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문-입력</title>
</head>
<body>
	<h2>설문조사</h2>
	<!-- <form method="post">
		<p>
			1. 당신의 역할 ?
			<label>
				<input type="radio" name="responses[0]" value="server" >서버개발자
			</label>
			<label>
				<input type="radio" name="responses[0]" value="front" >프론트개발자
			</label>
			<label>
				<input type="radio" name="responses[0]" value="back" >백엔드개발자
			</label>
			<label>
				<input type="radio" name="responses[0]" value="fullStack" >풀스택개발자
			</label>
		</p>
		<p>
			2. 주로 사용하는 IDE ?
			<label>
				<input type="radio" name="responses[1]" value="server" >Eclipse
			</label>
			<label>
				<input type="radio" name="responses[1]" value="front" >IntelliJ
			</label>
			<label>
				<input type="radio" name="responses[1]" value="back" >Sublime
			</label>
		</p>	
		<p>
			3. 하고 싶은 말 ?
			<label>
				<input type="text" name="responses[2]" >
			</label>
		</p>		
		<p>
			4. 응답자 위치
			<label>
				<input type="text" name="res.location" >
			</label>
		</p>		
		<p>
			5. 응답자 나이
			<label>
				<input type="number" name="res.age" >
			</label>
		</p>
		<input type="submit" value="설문조사 제출">
	</form> -->
	<form method="post">
	<c:forEach var="q" items="${ questions }" varStatus="status">
		<p>			
			${ status.index + 1 }.${ q.title }<br>			
			<c:if test="${ q.choice }">
				<c:forEach var="option" items="${ q.options }">
					<label><input type="radio" name="responses[${ status.index }]" value="${ option }">${ option }</label>
				</c:forEach>
			</c:if>			
			<c:if test="${! q.choice }">
				<input type="text" name="responses[${ status.index }]">
			</c:if>
		</p>
	</c:forEach>
	
	<p>
		<label >응답자 위치 : <input type="text" name="res.location"></label>
	</p>
	<p>
		<label>응답자 나이 : <input type="text" name="res.age"></label>
	</p>

	<input type="submit" value="전송">
	</form>
</body>
</html>