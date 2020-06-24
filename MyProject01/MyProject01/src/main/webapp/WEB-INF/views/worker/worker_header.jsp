<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/memberStyle.css" rel="stylesheet">
</head>


<div class="topnav">
<header>
<nav>
	<a href="index">
		<img src="" width="150" height="150" alt="gotoIndex">
	</a>

<c:choose>

<c:when test="${empty sessionScope.admin }">
	<a href="login_worker_form">어드민 로그인</a>
</c:when>
<c:otherwise>
	<a href="worker_main">어드민 메인화면</a>
</c:otherwise>

</c:choose>

</nav>
</header>

</div>


</html>