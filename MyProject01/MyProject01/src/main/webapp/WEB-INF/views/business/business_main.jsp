<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="business/business.js"></script>
<link href="css/memberStyle.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Welcome to business page</title>
<script type="text/javascript">
function displayOldRes(){
	var x = document.getElementById("oldRes");
	
	if(x.style.display== "none"){
		x.style.display = "inline-block";
	}else{
		x.style.display = "none";
	}
}

function displayallRes(){
	var x = document.getElementById("allRes");
	
	if(x.style.display== "none"){
		x.style.display = "inline-block";
	}else{
		x.style.display = "none";
	}
}

function displayMenuPerDay(){
	var x = document.getElementById("menuPerDay");
	
	if(x.style.display== "none"){
		x.style.display = "inline-block";
	}else{
		x.style.display = "none";
	}
}
</script>

</head>


<body>
<%@include file="../header.jsp" %>
<%@include file="business_sidebar.jsp" %>


<div class="main">
안녕하세요 ${loginUser.name} 사장님

<form name="formm">

<c:choose>
<c:when test="${empty dine }">
<a href="business_dine_join">식당 등록하기</a>
</c:when>

<c:otherwise>
<h3 id="dineInfo">등록된 식당 정보</h3>
<table border="1" >
<tr>
<th>식당 이름: </th>
<td>${dine.dine_name}
<input type="hidden" name="dine_name" value="${dine.dine_name}"></td>
</tr>
<tr>
<th>식당 위치(주소): </th>
<td>${dine.location }
<input type="hidden" name="location" value="${dine.location}"></td>
</tr>
<tr>
<th>식당 종류: </th>
<td>${dine.category}
<input type="hidden" name="category" value="${dine.category}"></td>
</tr>
<tr>
<th>예약 가능 테이블 수(총): </th>
<td>${dine.room - 1}
<input type="hidden" name="room" value="${dine.room - 1}"></td>
</tr>
<tr>
<th>테이블 배치도</th>
<td><img alt="" src="dine_image/${dine.seat_image}" width="200" height="200"></td>
</tr>

<tr>
<td colspan="2">
<a href="#" onclick="business_update()">식당 정보 수정하기</a>&nbsp;
<a href="#" onclick="business_menuList()">등록된 메뉴 보기(수정 및 추가)</a>
</td>
</tr>
</table>
</c:otherwise>

</c:choose>
</form>

<h4 id="todayRes">오늘 예약 리스트</h4>
<table border="1" >
<tr>
<th>예약 시간</th>
<th>예약 인원 수</th>
<th>테이블 번호 (0=미정)</th>
<th>예약한 회원</th>
<th>상세(삭제)</th>
</tr>

<c:choose>
<c:when test="${empty nowReserves  }">
<tr><td colspan="5">오늘 예약이 없습니다</td></tr>
</c:when>
<c:otherwise>

<c:forEach items="${nowReserves}" var="nowRes">
<tr>
<td>
<fmt:formatDate value="${nowRes.r_time}" pattern="HH:mm"/>
</td>
<td>${nowRes.people }</td>
<td>${nowRes.room }</td>
<td>${nowRes.id}</td>
<td><a href="business_reserveDetail?r_seq=${nowRes.r_seq}">상세 페이지 이동</a></td>
</tr>
</c:forEach>
<c:if test="${empty nowReserves }">
<tr>
<td colspan="5">오늘 예약 없음</td>
</c:if>
</c:otherwise>

</c:choose>

</table>




<h4 id="laterRes">내일 이후 예약</h4>
<table border="1" >
<tr>
<th>예약 날짜</th>
<th>예약 시간</th>
<th>인원 수</th>
<th>예약한 테이블 번호(없으면 0)</th>
<th>예약한 회원</th>
<th>상세(삭제)</th>
</tr>

<c:forEach items="${newReserves}" var="newRes">
<tr>
<td>${newRes.r_date}</td>
<td>
<fmt:formatDate value="${newRes.r_time}" pattern="HH:mm"/>
</td>
<td>${newRes.people}</td>
<td>${newRes.room}</td>
<td>${newRes.id}</td>
<td><a href="business_reserveDetail?r_seq=${newRes.r_seq}">상세 페이지 이동</a></td>
</tr>
</c:forEach>
<c:if test="${empty newReserves }">
<td colspan="6">새로운 예약이 없습니다.</td>
</c:if>

</table>

<h4 >지난 예약</h4>
<button onclick="displayOldRes()">show/hide</button><br>
<table border="1" id="oldRes" style="display: none;">
<tr>
<th>예약 날짜</th>
<th>예약 시간</th>
<th>인원 수</th>
<th>예약한 테이블 번호(없으면 0)</th>
<th>예약한 회원</th>
<th>상세(삭제)</th>
</tr>
<c:forEach items="${oldReserves}" var="oldRes">
<tr>
<td>${oldRes.r_date}</td>
<td>
<fmt:formatDate value="${oldRes.r_time}" pattern="HH:mm"/>
</td>
<td>${oldRes.people}</td>
<td>${oldRes.room}</td>
<td>${oldRes.id}</td>
<td><a href="business_reserveDetail?r_seq=${oldRes.r_seq}">상세 페이지 이동</a></td>
</tr>
</c:forEach>
<c:if test="${empty oldRes }">
<tr><td colspan="6">지난 예약이 없습니다</td></tr>
</c:if>

</table>

<h4 >모든 예약 정보</h4> 
<button onclick="displayallRes()">show/hide</button><br>
<table border="1"  id="allRes" style="display: none;">
<tr>
<th>예약 날짜</th>
<th>예약 시간</th>
<th>인원 수</th>
<th>예약한 테이블 번호(없으면 0)</th>
<th>예약한 회원</th>
<th>상세(삭제)</th>
</tr>


<c:choose>
<c:when test="${empty reserveList }">
<tr>
<td colspan="6">예약이 없습니다.</td>
</tr>
</c:when>

<c:otherwise>

<c:forEach items="${reserveList}" var="reserve">
<tr>
<td>${reserve.r_date}</td>
<td>
<fmt:formatDate value="${reserve.r_time}" pattern="HH:mm"/>
</td>
<td>${reserve.people}</td>
<td>${reserve.room}</td>
<td>${reserve.id}</td>
<td><a href="business_reserveDetail?r_seq=${reserve.r_seq}">상세 페이지 이동</a></td>
</tr>
</c:forEach>

</c:otherwise>

</c:choose>

</table>

<h4 id="todayMenu">오늘 예약된 메뉴(변동)</h4>
<table border="1" >
<tr>
<th>메뉴 명: </th>
<th>총 수량: </th>
</tr>
<c:forEach items="${menuQuantityListToday }" var="menuToday">
<tr>
<td>${menuToday.menu_name }</td>
<td>${menuToday.quantity_sum }</td>
</tr>
</c:forEach>
<c:if test="${empty menuQuantityListToday }">
<tr>
<td colspan="2">
오늘 예약된 음식이 없습니다
</td>
</tr>
</c:if>
</table>

<h4>날짜별 예약 메뉴 수량(변동)</h4>
<button onclick="displayMenuPerDay()">show/hide</button><br>
<table border="1" style="display: none;"  id="menuPerDay">
<tr>
<th>날짜: </th>
<th>메뉴 명: </th>
<th>총 수량: </th>
</tr>
<c:forEach items="${menuQuantityList}" var="menu">
<tr>
<td>${menu.r_date}</td>
<td>${menu.menu_name}</td>
<td>${menu.quantity_sum}</td>
</tr>
<tr></tr>
</c:forEach>
<c:if test="${empty menuQuantityList }">
<tr><td colspan="3">예약된 메뉴가 없습니다</td></tr>
</c:if>

</table>


<br>
<a href="logout">로그 아웃</a>
</div>
</body>
<%@ include file="../footer.jsp" %>
</html>









