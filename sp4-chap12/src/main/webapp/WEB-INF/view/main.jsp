<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN</title>
</head>
<body>
	<h2>MAIN</h2>
	
 	<c:if test="${empty authInfo}">
		<p>
			<a href="<c:url value='register/step1' />" >[회원가입하기]</a>&emsp;
			<a href="<c:url value='login' />" >[로그인하기]</a>
		</p>	
	</c:if>
	
	<c:if test="${!empty authInfo}">
		<p>[${authInfo.name}] 님, 환영합니다</p>
		<p>
			<a href="edit/changePassword">[비밀번호 변경]</a>&emsp;
			<a href="logout">[로그아웃]</a>
		</p>
	</c:if>
	<hr>
	<p>
		<a href="<c:url value='survey' />" >설문조사 응하기</a>
	</p>
</body>
</html>