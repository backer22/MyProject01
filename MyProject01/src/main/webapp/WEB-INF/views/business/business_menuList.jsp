<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<link href="css/memberStyle.css" rel="stylesheet">
<meta charset="UTF-8">
<title>내 식당 메뉴 리스트</title>
</head>
<body>

<%@include file="../header.jsp" %>

<%@include file="business_sidebar.jsp" %>

<div class="main">

<table border="1">
<tr>
<th colspan="4">식당 메뉴 리스트</th>
</tr>
<tr>
<th>메뉴 이름: </th>
<td>가격:</td>
<td>이미지: </td>
<td>메뉴 수정/삭제</td>
</tr>
<c:forEach items="${menuList}" var="menu">
<tr>
<td>${menu.menu_name}</td>
<td>${menu.price}</td>
<td><img alt="" src="menu_image/${menu.menu_image}" width="100" height="100"></td>
<td><a href="updateMenuForm?menu_name=${menu.menu_name }">수정</a>&nbsp;/&nbsp;<a href="deleteMenuAction?menu_name=${menu.menu_name}">삭제(즉시 실행)</a></td>
</tr>
</c:forEach>
<tr>
<td colspan="4"><a href='business_addmenu_form'>메뉴 추가하기</a></td>
</tr>
</table>

<input type="button" onclick="history.go(-1)" value="뒤로 가기">&nbsp;

</div>
</body>
</html>

<%@ include file="../footer.jsp" %>
