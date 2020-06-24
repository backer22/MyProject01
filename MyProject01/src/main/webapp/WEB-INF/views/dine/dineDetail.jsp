<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/memberStyle.css" rel="stylesheet">
<title>${dineVO.dine_name}에 오신걸 환영합니다</title>
</head>
<body>
<%@include file="../header.jsp" %>
<%@include file="../member/member_sidebar.jsp" %>

<div class="main">
<h3>식당 정보</h3>
<table border="1">
<tr>
<th>식당 명</th>
<td>${dine.dine_name }</td>
</tr>
<tr>
<th>식당 위치</th>
<td>${dine.location }</td>
</tr>
<tr>
<th>식당 종류</th>
<td>${dine.category }</td>
</tr>
<tr>
<th>예약 가능 규모</th>
<td>${dine.room }</td>
</tr>
<tr>
<th>예약 배치도</th>
<td><img src="dine_image/${dine.seat_image }" width="300"></td>

</tr>

</table>



<h3>메뉴 목록</h3>

<table border="1">
<c:choose>
<c:when test="${empty menuList }">
<tr>
<th>등록된 메뉴 정보가 없습니다.</th>
</tr>
</c:when>
<c:otherwise>

<c:forEach items="${menuList }" var="menuVO">
<tr>
<td><img alt="" src="menu_image/${menuVO.menu_image }" width="100" height="100"></td>
<th>${menuVO.menu_name}</th>
<td>가격: ${menuVO.price}</td>
</tr>
</c:forEach>

</c:otherwise>
</c:choose>

</table>

<br><br>
<input type="button" value="뒤로" onclick="javascript:history.go(-1)">&nbsp;
<input type="button" value="예약하기" onclick="location.href='reserve_form?dine_name=${dineVO.dine_name}'">
<br><br><br>
</div>

</body>
</html>
<%@ include file="../footer.jsp" %>






