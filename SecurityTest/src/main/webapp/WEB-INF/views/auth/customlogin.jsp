<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
</head>
<body>

	<!-- cumstomlogin.jsp -->
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Custom Login Page</h2>
	
	<!-- 아이디, 비밀번호 name은 예약어라 바꾸면 안됨 -->
	<!-- 로그인 주소가 정해져 있음 -->
	<form method="POST" action="/security/login">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<th>암호</th>
				<td><input type="password" name="password" required></td>
			</tr>
		</table>
		<div>
			<button class="in">로그인</button>
		</div>
		
		
		<!-- <input type="hidden" name="_csrf" value="18b5dd90-aa22-4342-b016-2d3acf47599b"> -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
	</form>
	
</body>
</html>