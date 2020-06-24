<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/memberStyle.css" rel="stylesheet">
<meta charset="UTF-8">
<title>예약 취소 화면</title>
</head>
<%@include file="../header.jsp" %>

<body>
<!-- r_seq를 받음 -->


<div class="main">

<h3>예약 취소 화면</h3>

<form action="reserveCancel" method="post">

<table border="1">

<tr>
<td>식당명: </td>
<th> ${reserve.dine_name }</th>
</tr>
<tr>
<td>예약 인원: </td>
<th>${reserve.people}</th>
</tr>
<tr>
<td>예약 날짜+시간</td>
<th>${reserve.r_date } + 
<fmt:formatDate value="${reserve.r_time}" pattern="HH:mm"/>
</th>
</tr>
<tr>
<td colspan="2">예약한 음식</td>

<c:forEach items="${reserveDetailList }" var="reserveVO">
<tr>
<td> ${reserveVO.menu_name } </td>
<td> ${reserveVO.quantity } </td>
</tr>
</c:forEach>
<tr>
<td colspan="2">
<input type="hidden" name="r_seq" value="${reserve.r_seq }">
<input type="submit" value="예약 취소하기">&nbsp;
<input type="button" value="뒤로 가기" onclick="window.history.go(-1);">
</table>
<br><br><br>
</form>
</div>
</body>

</html>
<%@ include file="../footer.jsp" %>









