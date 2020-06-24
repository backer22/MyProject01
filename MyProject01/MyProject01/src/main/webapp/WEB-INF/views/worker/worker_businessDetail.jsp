<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사장님의 상세 페이지</title>
</head>
<body>
// member, dine, dineReserves(list)

<h5>사장님의 정보</h5>
<table border="1">
<tr>
<th>ID: </th>
<th>PWD: </th>
<th>Email: </th>
<th>Name: </th>
<th>Phone: </th>
</tr>
<tr>
<td>${member.id }</td>
<td>${member.pwd }</td>
<td>${member.email }</td>
<td>${member.name }</td>
<td>${member.phone }</td>
</tr>
</table>
<br><br>

<h5>식당 정보</h5>
<table border="1">
<tr>
<th>식당 이름: </th>
<th>위치/주소: </th>
<th>식당 종류: </th>
<th>예약 가능 수: </th>
</tr>
<tr>
<td>${dine.dine_name }</td>
<td>${dine.location }</td>
<td>${dine.category }</td>
<td>${dine.room }</td>
</tr>
<tr>
<th>테이블 위치</th>
<td colspan="3"><img src="dine_image/${dine.seat_image }" alt=""></td>
</tr>
</table>
<br><br>

<h5>식당 메뉴 목록</h5>
<table border="1">
<tr>
<th>메뉴 이름 </th>
<th>가격 </th>
<th>이미지 </th>
</tr>
<c:forEach items="${menuList }" var="menu">
<tr>
<td>${menu.menu_name }</td>
<td>${menu.price }</td>
<td><img src="menu_image/${menu.menu_image }" alt="" width="100" height="100"></td>
</tr>
</c:forEach>

</table>

<h5>모든 예약 정보</h5>
<table border="1">
<tr>
<th>예약 번호: </th>
<th>식당명: </th>
<th>예약자 ID: </th>
<th>예약자 인원: </th>
<th>예약 시간: </th>
<th>예약 날짜: </th>
<th>테이블 번호(위치): </th>
<th>예약항 음식(페이지 이동)</th>
</tr>
<c:forEach items="${dineReserves }" var="reserve">
<tr>
<td>${reserve.r_seq}</td>
<td>${reserve.dine_name}</td>
<td>${reserve.id}</td>
<td>${reserve.people}</td>
<td>${reserve.r_time}</td>
<td>${reserve.r_date}</td>
<td>${reserve.room}</td>
<td><a href="?r_seq=${reserve.r_seq}">예약 상세 페이지로</a></td>
</tr>
</c:forEach>
</table>

<input type="button" onclick="history.go(-1)" value="뒤로 가기">&nbsp;


</body>
</html>














