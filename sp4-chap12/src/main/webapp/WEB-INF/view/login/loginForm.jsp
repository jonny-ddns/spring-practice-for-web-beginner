<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title" /></title>
</head>
<body>
	<form:form commandName="loginCommand">
	<form:errors></form:errors>
		<p>
			<label>
				<spring:message code="email" />
				<form:input path="email"/>
				<form:errors path="email" />			
			</label>
		</p>
		<p>
			<label>
				<spring:message code="password" />
				<form:input path="password"/>
				<form:errors path="password" />			
			</label>
		</p>
		<p>
			<label>
				<spring:message code="rememberEmail" />
				<form:checkbox path="rememberEmail" />
			</label>
		</p>
		<input type="submit" value="<spring:message code="login.btn" />" >
	</form:form>	
</body>
</html>