<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="business/business.js"></script>
<link href="css/memberStyle.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>예약 상세 페이지</title>
</head>
<%@include file="../header.jsp" %>
<%@include file="business_sidebar.jsp" %>
<body>

<div class="main">
<h3>상세 예약 정보</h3>
<table border="1">
<tr>
<th>예약한 식당</th>
<td>${reserve.dine_name}</td>
</tr>
<tr>
<th>예약 인원</th>
<td>${reserve.people}</td>
</tr>
<tr>
<th>예약한 날짜 + 시간</th>
<td> ${reserve.r_date } 
<fmt:formatDate value="${reserve.r_time}" pattern="HH:mm"/>
</td>
</tr>
<tr>
<th>예약한 테이블 번호: </th>
<td>
<c:choose>
<c:when test="${reserve.room == 0 }">
테이블 안 정함
</c:when>
<c:otherwise>
${reserve.room } 번 테이블
</c:otherwise>
</c:choose>
</td>
</tr>

<tr>
<th colspan="2">예약한 음식</th>
</tr>
<c:choose>
<c:when test="${empty reserveDetailList }">
<tr>
<th colspan="2">현장에서 예약할 예정</th>
</tr> 
</c:when>
<c:otherwise>
<c:forEach items="${reserveDetailList }" var="reserveD">
<tr>
<th>예약한 메뉴 이름: </th>
<td>${reserveD.menu_name }</td>
</tr>
<tr>
<th>주문 량: </th>
<td>${reserveD.quantity }</td>
</tr>
</c:forEach>

</c:otherwise>

</c:choose>

</table>
<form action="reserveCancelByB" method="post">
<input type="hidden" name="r_seq" value="${reserve.r_seq }">
<input type="submit" value="예약 삭제하기">
<input type="button" onclick="history.go(-1)" value="뒤로 가기">&nbsp;
</form>

</div>








</body>
<%@ include file="../footer.jsp" %>
</html>