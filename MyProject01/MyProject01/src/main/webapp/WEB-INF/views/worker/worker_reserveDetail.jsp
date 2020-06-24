<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세 페이지</title>
</head>
<body>



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
<th>${reserve.r_date } + ${reserve.r_time}</th>
</tr>

<c:choose>

<c:when test="${empty reserveDetailList }">
<tr>
<td>
현장에서 주문 예정
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

</form>
<input type="button" value="뒤로 가기" onclick="window.history.go(-1);">






</body>
</html>