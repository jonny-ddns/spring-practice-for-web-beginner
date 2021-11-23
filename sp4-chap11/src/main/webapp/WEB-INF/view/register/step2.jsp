<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step2-정보입력</title>
</head>
<body>
	<h2>회원정보 입력</h2>
	<!-- <form action="step3" method="post">
		<p>
			<label>이메일 : <br>
				<input type="text" name="email" id="email">
			</label>
		</p>
		<p>
			<label>이름 : <br>
				<input type="text" name="name" id="name">
			</label>
		</p>
		<p>
			<label>비밀번호 : <br>
				<input type="password" name="password" id="password">
			</label>
		</p>
		<p>
			<label>비밀번호 확인 : <br>
				<input type="password" name="confirmPassword" id="confirmPassword">
			</label>
		</p>	
		<input type="submit" value="가입하기">
	</form> -->	
	
	<!-- 폼 태그 라이브러리 활용 -->
	<!-- 전에 입력한 정보가 찍히도록 설정 -->
	<form:form action="step3" commandName="registerRequest">
		<p>
			<label>이메일 : <br>
			<form:input path="email"/>
			</label>
		</p>
		<p>
			<label>이름 : <br>
				<form:input path="name"/>
			</label>
		</p>
		<p>
			<label>비밀번호 : <br>
				<form:password path="password"/>
			</label>
		</p>
		<p>
			<label>비밀번호 확인 : <br>
			<form:password path="password"/>
			</label>
		</p>
		<input type="submit" value="가입하기">
	</form:form>

</body>
</html>