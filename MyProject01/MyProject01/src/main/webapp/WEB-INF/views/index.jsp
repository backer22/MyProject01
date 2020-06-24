<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp" %>
<link href="css/memberStyle.css" rel="stylesheet">

<body>
<hr>
<div class="main">
<br>
<h1>this is index</h1>

<c:choose>
<c:when test="${empty sessionScope.loginUser }">
	<a href="login_form">login</a>
</c:when>

<c:when test="${not empty sessionScope.admin }">
	<a href="worker_main">어드민 메인 화면으로</a>
</c:when>

<c:otherwise>

	<c:choose>
	<c:when test="${sessionScope.businessyn=='Y' }">
		<a href="login_business">비즈니스 화면으로</a>
	</c:when>
	
	<c:otherwise>
		<a href="memberMain">마이 페이지로 가기</a>
	</c:otherwise>
	</c:choose>
	
</c:otherwise>

</c:choose>

<br>

<c:choose>
<c:when test="${empty sessionScope.loginUser }">
	<a href="login_worker_form">login worker</a>
</c:when>

<c:otherwise>
	<a href="logout">다른 아이디로 로그인 하기(logout)</a>
</c:otherwise>
</c:choose>



<br><br><br>
</div>
</body>
<%@ include file="footer.jsp" %>











