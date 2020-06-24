<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Worker Main Page</title>
<link href="css/memberStyle.css" rel="stylesheet">
</head>

<%@include file="worker_header.jsp" %>

<body>

<div class="main">

<h1>worker main page</h1>
<br>hello ${sessionScope.admin.w_name}<br>

<a href="w_logout">logout</a>
<br><br>

<h5>사장님 목록</h5>
<table border="1">
<tr>
<th>ID: </th>
<th>이름: </th>
<th>Email: </th>
<th>전화번호: </th>
<th>상세정보(식당정보+예약정보)</th>
</tr>
<c:forEach items="${allBusinessOwner}" var="ownerMem">
<tr>
<td>${ownerMem.id }</td>
<td>${ownerMem.name }</td>
<td>${ownerMem.email }</td>
<td>${ownerMem.phone }</td>
<td><a href="worker_businessDetail?id=${ownerMem.id}">상세 페이지로</a></td>
</tr>
</c:forEach>
</table>
<br><br>

<h5>손님 목록</h5>
<table border="1">
<tr>
<th>ID: </th>
<th>이름: </th>
<th>Email: </th>
<th>전화번호: </th>
<th>상세정보(예약 정보)</th>
</tr>
<c:forEach items="${allMember}" var="member">
<tr>
<td>${member.id }</td>
<td>${member.name }</td>
<td>${member.email }</td>
<td>${member.phone }</td>
<td><a href="worker_memberDetail?id=${member.id}">회원 상세 페이지로</a></td>
</tr>
</c:forEach>
</table>
<br><br><br>
</div>
<%@ include file="../footer.jsp" %>

</body>
</html>