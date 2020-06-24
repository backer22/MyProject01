<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
<link href="css/memberStyle.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Welcome to food district</title>
</head>
<body>


<div class="topnav">
<header>
	<div><!-- logo to index -->
	<a href="index" style="top: 0px">
		<img src="images/logoSample.jpg" width="45" height="45" alt="gotoIndex">
	</a>
	</div>
	<nav >
		
			<c:choose>
			
			<c:when test="${not empty sessionScope.admin }">
				<a href="worker_main">어드민 메인 화면으로</a>
			</c:when>
			
			<c:when test="${empty sessionScope.loginUser}">
			<a href="login_form">로그인</a>
		 	&nbsp;&nbsp; 
			<a href="join_form">회원가입</a><br>
			</c:when>
			
			
			<c:otherwise>
			
				<c:choose>
				<c:when test="${sessionScope.businessyn=='Y' }">
					<a href="login_business">My Business Page</a>
				</c:when>
				<c:otherwise>
					<a href="memberMain">MY PAGE</a>&nbsp;&nbsp;
				</c:otherwise>
				
				</c:choose>
			
			<a href="logout">${sessionScope.loginUser.id} :&nbsp;LOGOUT</a>
			
			</c:otherwise>
			
			
			</c:choose>
		
		<br>
	</nav>
	
</header>
</div>
</body>
</html>





