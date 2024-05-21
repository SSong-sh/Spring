<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nontiles</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
</head>
<body>
	
	<header>
		<h1>Nontile</h1>
		<%@include file="/WEB-INF/views/inc/main_menu.jsp" %>
		<%@include file="/WEB-INF/views/inc/admin_menu.jsp" %>
	</header>
	
	<h1>관리자 <small>로그</small></h1>
	
	<pre style="padding:lrem; white-space:pre-wrap;">
	INFO : org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
	INFO : org.springframework.web.servlet.handler.SimpleUrlHandlerMapping
	INFO : org.springframework.web.servlet.DispatcherServlet - FrameworkServlet 
	</pre>
</body>
</html>