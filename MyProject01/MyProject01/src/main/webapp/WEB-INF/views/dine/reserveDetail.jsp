<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/memberStyle.css" rel="stylesheet">

<script type="text/javascript" src="dine/dine.js"></script>
<meta charset="UTF-8">
<title>예약 상세 페이지</title>
</head>
<body>
<%@include file="../header.jsp" %>
<%@include file="../member/member_sidebar.jsp" %>


<div class="main">

<h1>예약 상세 정보</h1>
<form name="formm">
<table border="1">
<tr>
<td>식당명: </td>
<th> ${reserve.dine_name } <input type="hidden" name="dine_name" value="${reserve.dine_name }"></th>
</tr>
<tr>
<td>예약 인원: </td>
<th>${reserve.people} <input type="hidden" name="people" value="${reserve.people}"> </th>
</tr>
<tr>
<td>예약 날짜+시간</td>
<th>${reserve.r_date }  
<fmt:formatDate value="${reserve.r_time}" pattern="HH:mm"/>

</th>
</tr>

<c:choose>

<c:when test="${empty reserveDetailList }">
<tr>
<td>
현장에서 주문 예정 (예약 수정 페이지에서 음식 예약 가능)
</td>
</tr>
</c:when>

<c:otherwise><!-- 예약한 메뉴가 있을 경우 -->
<tr>
<td colspan="2">예약한 음식</td>
</tr>
<c:forEach items="${reserveDetailList }" var="reserveVO">
<tr>
<td> ${reserveVO.menu_name } </td>
<td> ${reserveVO.quantity }  </td>
</tr>
</c:forEach>

</c:otherwise>

</c:choose>

</table>


<a href="reserveCancel?r_seq=${reserve.r_seq }">예약 취소하기</a>
<a href="reserveUpdate?r_seq=${reserve.r_seq }">예약 수정하기</a>
<a href="memberMain">메인 페이지로 가기 </a>
</form>
<br><br><br>
</div>

</body>
</html>
<%@ include file="../footer.jsp" %>