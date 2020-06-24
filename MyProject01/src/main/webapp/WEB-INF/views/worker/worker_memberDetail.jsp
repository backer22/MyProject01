<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 페이지</title>
<link href="css/memberStyle.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>

<div class="main">

<h3>회원 상세 정보</h3>
<table border="1">
<tr>
<th>아이디: </th>
<td>${member.id }</td>
</tr>
<tr>
<th>비밀버호: </th>
<td>${member.pwd }</td>
</tr>
<tr>
<th>이메일: </th>
<td>${member.email }</td>
</tr>
<tr>
<th>이름: </th>
<td>${member.name }</td>
</tr>
<tr>
<th>전화번호: </th>
<td>${member.phone }</td>
</tr>
</table>
<br><br>


<h3>회원 예약 정보</h3>
<table border="1">
<tr>
<th>주문 번호: </th>
<th>식당 이름: </th>
<th>인원 수: </th>
<th>시간: </th>
<th>날짜: </th>
<th>테이블 번호(테이블 위치): </th>
<th>주문 상세로 이동 </th>
</tr>
<c:forEach items="${reserveList }" var="reserve">
<tr>
<td>${reserve.r_seq }</td>
<td>${reserve.dine_name }</td>
<td>${reserve.people }</td>
<td><!-- 시간 -->
<fmt:formatDate value="${reserve.r_time}" pattern="HH:mm"/>
</td>
<td>${reserve.r_date }</td>
<td>${reserve.room }</td>
<td><a href="worker_reserveDetail?r_seq=${reserve.r_seq}">상세 페이지로</a></td>
</tr>
</c:forEach>

</table>

<br>
<input type="button" value="뒤로 가기" onclick="window.history.go(-1);">
<br><br><br>
</div>

</body>
<%@ include file="../footer.jsp" %>
</html>