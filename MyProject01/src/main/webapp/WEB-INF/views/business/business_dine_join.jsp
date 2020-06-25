<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="business/business.js"></script>
<link href="css/memberStyle.css" rel="stylesheet">
<meta charset="UTF-8">
<title>새 식당 등록 화면</title>
</head>
<body>
<%@include file="../header.jsp" %>

<div class="main">
<h1>식당 등록 화면</h1>
<form method="POST" action="business_dine_join" enctype="multipart/form-data">
<table border="1">
<tr>
<th>식당명: </th>
<td><input type="text" name="dine_name"></td>
</tr>
<tr>
<th>위치(주소)</th>
<td><input type="text" name="location"></td>
</tr>
<tr>
<th>테이블 수(예약 가능 수): </th>
<td><input type="number" name="room"></td>
</tr>
<tr>
<th>식당 종류</th>
<td><input type="text" name="category"></td>
</tr>
<tr>
<th>테이블 위치(배치도) 이미지</th>
<td><input type="file" name="uploadFile"></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="식당 등록하기"></td>
</tr>
</table>
</form>
<br><br><br>
</div>

</body>

<%@ include file="../footer.jsp" %>
</html>










