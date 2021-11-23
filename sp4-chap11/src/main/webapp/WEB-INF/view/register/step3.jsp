<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step3-가입 완료</title>
</head>
<body>
	<h2>가입 완료</h2>
	<h3>회원 가입을 축하합니다 [${registerRequest.name}] 님</h3>
	<p>
		<a href="<c:url value='/main' />" >첫화면으로 이동하기</a>
	</p>
</body>
</html>