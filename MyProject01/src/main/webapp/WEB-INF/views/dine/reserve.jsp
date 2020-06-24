<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript" src="dine/dine.js"></script>
<meta charset="UTF-8">
<title>예약 화면</title>
<link href="css/memberStyle.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>

<div class="main">

<h4>${dine.dine_name} 예약 페이지</h4>
<form name="formm" method="post" action="reserveAction" id="formm">
<input type="hidden" name="dine_name" value="${dine.dine_name }">
<table border="1">
<tr>
<th>예약 날짜</th>
<td><input type="date" name="r_date" onchange="dateRoom()" ></td>
</tr>
<tr>
<th>예약 시간</th>
<td>
<c:set var="now" value="<%=new java.util.Date() %>" />
<fmt:formatDate value="${now}" type="date" var="nowDate" pattern="YYYY-MM-dd"/>
<select name="r_time" >
<option value="${nowDate} 18:00:00">18시 00분</option>
<option value="${nowDate} 18:30:00">18시 30분</option>
<option value="${nowDate} 19:00:00">19시 00분</option>
<option value="${nowDate} 19:30:00">19시 30분</option>
<option value="${nowDate} 20:00:00">20시 00분</option>
</select>
</td>
</tr>
<tr>
<th>예약 인원: </th>
<td><input type="number" name="people" value="0"></td>
</tr>
<tr>
<th>원하는 테이블: </th>
<td>

<select name="room" id="room">
<option value="0">원하는 테이블 없음</option>


</select>

</td>
<tr>
<th colspan="2">미리 예약할 음식</th>
</tr>
<c:forEach items="${menuList}" var="menuVO">
<tr>
<th>${menuVO.menu_name}
<input type="hidden" name="menu_name" value="${menuVO.menu_name }">
</th>
<td><input type="number" name="quantity" value="0"></td>
</tr>
</c:forEach>

<tr>
<td>현장에서 언제든지 메뉴 추가할 수 있습니다</td>
</tr>
<tr>
<td colspan="2">
<input type="button" value="예약하기" onclick="reserveCheck()" id="submitButton">
<input type="button" value="뒤로 가기" onclick="javascript:history.go(-1)">&nbsp;
</td>
</tr>
</table>
</form>
<br><br><br>
</div>

</body>
<%@ include file="../footer.jsp" %>
</html>