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

	<!-- cumstomlogout.jsp -->
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Custom Logout Page</h2>
	
	<!-- 아이디, 비밀번호 name은 예약어라 바꾸면 안됨 -->
	<!-- 로그인 주소가 정해져 있음 -->
	<form method="POST" action="/security/customlogout.do">

		<div>
			<button class="out">로그아웃</button>
		</div>		
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
	</form>

</body>
</html>