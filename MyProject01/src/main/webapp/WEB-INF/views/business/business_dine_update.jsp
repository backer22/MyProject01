<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="business/business.js"></script>
<link href="css/memberStyle.css" rel="stylesheet">
<meta charset="UTF-8">
<title>식당 정보 수정</title>
</head>
<%@include file="../header.jsp" %>
<%@include file="business_sidebar.jsp" %>

<body>

<div class="main">
<h3>식당 정보 수정</h3>
<form method="post" action="business_dine_update_action" name="formm" enctype="multipart/form-data">
<table border="1">
<tr>
<th>식당명: </th>
<td><input type="text" name="dine_name" value="${dine.dine_name}"></td>
</tr>
<tr>
<th>위치(주소)</th>
<td><input type="text" name="location" value="${dine.location}"></td>
</tr>
<tr>
<th>테이블 수(예약 가능 수): </th>
<td><input type="number" name="room" value="${dine.room - 1}"></td>
</tr>
<tr>
<th>식당 종류(카테고리):</th>
<td><input type="text" name="category" value="${dine.category }"></td>
</tr>
<tr>
<th>식당 배치도</th>
<td>
<img src="dine_image/${dine.seat_image}" width="200" id="imageView">
<br>
<input type="file" name="uploadFile" >
<input type="hidden" name="image" value="${dine.seat_image }">
</td>
<tr>
<td colspan="2">
<input type="submit" value="수정하기" onclick="updateCheck()">&nbsp;
</td>
</tr>
</table>
<br>
<input type="button" onclick="history.go(-1)" value="뒤로 가기">&nbsp;


</form>
<br><br>
</div>

</body>
</html>
<%@ include file="../footer.jsp" %>













