<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.green.biz.reserve.ReserveVO" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/memberStyle.css" rel="stylesheet">
<meta charset="UTF-8">
<title>예약 수정 화면 </title>
</head>
<%@include file="../header.jsp" %>
<body>

<div class="main">

<h1>예약 수정 페이지 </h1>

<!-- r_seq를 받음 -->
<h3>예약 수정 화면</h3>
<form action="reserveUpdate" method="POST" name="formm">

<table border="1">
<tr>
<th>식당명: </th>
<td> ${reserve.dine_name }</td>
</tr>
<tr>
<th>예약 인원: </th>
<td>
<input type="number" name="people" value="${reserve.people}">
</td>
</tr>
<tr>
<td>예약 날짜 </td>
<th>
<input type="date" name="r_date" value="${reserve.r_date }">
</th>
</tr>

<tr>
<td>예약 시간</td>
<th>


<c:set var="now" value="<%=new java.util.Date() %>" />
<fmt:formatDate value="${now}" type="date" var="nowDate" pattern="YYYY-MM-dd"/>
<fmt:formatDate value="${reserve.r_time }" pattern="HH" var="rh" />
<fmt:formatDate value="${reserve.r_time }" pattern="mm" var="rm" />
<select name="r_time" >
<option value="${reserve.r_time}">${rh}시 ${rm}분</option>
<option value="${nowDate} 18:00:00">18시 00분</option>
<option value="${nowDate} 18:30:00">18시 30분</option>
<option value="${nowDate} 19:00:00">19시 00분</option>
<option value="${nowDate} 19:30:00">19시 30분</option>
<option value="${nowDate} 20:00:00">20시 00분</option>
</select>
</th>
</tr>


<tr>
<td colspan="2">예약한 음식</td>
</tr>
<c:forEach items="${reserveDetailList }" var="reserveVO">
<tr>
<td> ${reserveVO.menu_name }
	<input type="hidden" name="menu_name" value="${reserveVO.menu_name }"> </td>
<td>
	<input type="number" name="quantity" value="${reserveVO.quantity }">
	<input type="hidden" name="rd_seq" value="${reserveVO.rd_seq }">
</td>
</tr>
</c:forEach>


<tr>
<td colspan="2">
<input type="submit" value="예약 수정하기">
</td>
</table>
<input type="hidden" name="r_seq" value="${reserve.r_seq }">
<input type="button" value="뒤로 가기" onclick="window.history.go(-1);">
</form>
<br><br><br>



</div>
</body>
<%@ include file="../footer.jsp" %>
</html>











