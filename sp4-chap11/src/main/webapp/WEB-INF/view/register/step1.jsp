<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step1-약관동의</title>
</head>
<body>
	<h2>약관 동의</h2>
	<form action="step2" method="post">
		<label>
			<input type="checkbox" name="agree" value="true">
		</label>
		<input type="submit" value="동의">
	</form>
</body>
</html>