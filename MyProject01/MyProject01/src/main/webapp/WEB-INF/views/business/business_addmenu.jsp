<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/memberStyle.css" rel="stylesheet">
<script type="text/javascript" src="business/business.js"></script>
</head>
<%@include file="../header.jsp" %>
<%@include file="business_sidebar.jsp" %>

<body>

<div class="main">
<h3>메뉴 추가하기</h3>
<form name="formm" action="addMenuAction" method="POST" enctype="multipart/form-data">
<table border="1">
<tr>
<th>메뉴 이름: </th>
<td><input type="text" name="menu_name"></td>
</tr>
<tr>
<th>가격:</th>
<td><input type="number" name="price"></td>
</tr>
<tr>
<th>이미지: </th>
<td><input type="file" name="uploadFile"></td>
</tr>
<tr>
<td colspan="2">
<input type="hidden" name="dine_name" value="${dine.dine_name }">
<input type="submit" value="메뉴 추가">
<input type="button" onclick="history.go(-1)" value="뒤로 가기">&nbsp;
</td>
</tr>
</table>

</form>

</div>

</body>
</html>

<%@ include file="../footer.jsp" %>