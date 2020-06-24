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

<h3>메뉴 수정 페이지</h3>
<form action="updateMenu" method="post" name="formm" enctype="multipart/form-data">
<table border="1">
<tr>
<th>메뉴 이름</th>
<th>${menu.menu_name}
<input type="hidden" name="menu_name" value="${menu.menu_name}">
</th>
</tr>
<tr>
<th>가격</th>
<td><input type="number" name="price" value="${menu.price}"></td>
</tr>
<tr>
<th>수정 전 이미지</th>
<td><img src="menu_image/${menu.menu_image}" width="200" height="200"></td>
</tr>
<tr>
<th>메뉴 이미지</th>
<td><input type="file" name="uploadFile"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="수정하기"> &nbsp;
<input type="button" onclick="history.go(-1)" value="뒤로 가기">&nbsp;

</table>
</form>

</div>

</body>
</html>

<%@ include file="../footer.jsp" %>
