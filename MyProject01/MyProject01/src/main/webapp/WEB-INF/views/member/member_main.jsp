<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>

<link href="css/memberStyle.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Member Main Page</title>
</head>
<%@include file="../header.jsp" %>

<%@include file="member_sidebar.jsp" %>
<script type="text/javascript">
function displayAllRes(){
	//allRes show/hide
	var x = document.getElementById("allRes");
	
	if(x.style.display == "none"){
		x.style.display = "inline-block";
	}else{
		x.style.display = "none";
	}
}

function displayOldRes(){
	//allRes show/hide
	var x = document.getElementById("oldRes");
	
	if(x.style.display == "none"){
		x.style.display = "inline-block";
	}else{
		x.style.display = "none";
	}
}

</script>

<body>

<div class="main">

<h1 id="top">${sessionScope.loginUser.name} 님 안녕하세요</h1>

<div id="todayRes">
<h3>오늘 예약</h3>
<table border="1">
<c:choose>

<c:when test="${empty nowReserveList}">
<tr>
<td>오늘은 예약이 없습니다</td>
</tr>
</c:when>

<c:otherwise>
<c:forEach items="${nowReserveList}" var="nowReserve">
<tr>
	<th>예약 번호: ${nowReserve.r_seq }</th>
	<td>식당명: ${nowReserve.dine_name }</td>
	<td>예약 인원: ${nowReserve.people }</td>
	<td>예약 시간: 
	<fmt:formatDate value="${nowReserve.r_time}" pattern="hh:mm"/>
	</td>
	<td>약속 날짜: 
	<fmt:formatDate value="${nowReserve.r_date }" pattern="yyyy.MM.dd"/>
	</td>
	<td><a href="reserve_detail?r_seq=${nowReserve.r_seq}">자세히</a></td>
</tr>
</c:forEach>
</c:otherwise>

</c:choose>

</table>
</div>


<h5>다가오는 예약</h5>
<table border="1" id="newRes">
<c:choose>

<c:when test="${empty newReserveList}">
<tr>
<td>다가오는 예약이 없습니다</td>
</tr>
</c:when>
<c:otherwise>
<c:forEach items="${newReserveList}" var="newReserve">
<tr>
	<th>예약 번호: ${newReserve.r_seq }</th>
	<td>식당명: ${newReserve.dine_name }</td>
	<td>예약 인원: ${newReserve.people }</td>
	<td>예약 시간: 
	<fmt:formatDate value="${newReserve.r_time}" pattern="hh:mm"/>
	</td>
	<td>약속 날짜: 
	<fmt:formatDate value="${newReserve.r_date }" pattern="yyyy.MM.dd"/>
	</td>
	<td><a href="reserve_detail?r_seq=${newReserve.r_seq}">자세히</a></td>
</tr>
</c:forEach>
</c:otherwise>
</c:choose>
</table>


<h5>지나간 예약</h5>
<button onclick="displayOldRes()">show/hide</button><br>
<table border="1" id="oldRes" style="display: none">
<c:choose>

<c:when test="${empty oldReserveList}">
<tr>
<td>예약한적이 없습니다</td>
</tr>
</c:when>
<c:otherwise>
<c:forEach items="${oldReserveList}" var="oldReserve">
<tr>
	<th>예약 번호: ${oldReserve.r_seq }</th>
	<td>식당명: ${oldReserve.dine_name }</td>
	<td>예약 인원: ${oldReserve.people }</td>
	<td>예약 시간: 
	<fmt:formatDate value="${oldReserve.r_time}" pattern="hh:mm"/>
	</td>
	<td>약속 날짜: 
	<fmt:formatDate value="${oldReserve.r_date }" pattern="yyyy.MM.dd"/>
	</td>
	<td><a href="reserve_detail?r_seq=${oldReserve.r_seq}">자세히</a></td>
</tr>
</c:forEach>
</c:otherwise>
</c:choose>
</table>


<h4>모든 예약 </h4>
<button onclick="displayAllRes()">show/hide</button><br>
<table border="1" style="display: none;" id="allRes">
 <!-- 전체예약 -->
<c:choose>
<c:when test="${not empty reserveList}">
	<c:forEach items="${reserveList}" var="reserveVO">
	<tr>
	<th>예약 번호: ${reserveVO.r_seq }</th>
	<td>식당명: ${reserveVO.dine_name }</td>
	<td>예약 인원: ${reserveVO.people }</td>
	<td>예약 시간: 
	
	<fmt:formatDate value="${reserveVO.r_time}" pattern="hh:mm"/>
	
	</td>
	<td>약속 날짜: 
	<fmt:formatDate value="${reserveVO.r_date }" pattern="yyyy.MM.dd"/>
	</td>
	<td><a href="reserve_detail?r_seq=${reserveVO.r_seq}">자세히</a></td>
	</tr>
	</c:forEach>
</c:when>

<c:otherwise>
<tr>
<th>예약이 없습니다.</th>
</tr>
</c:otherwise>


</c:choose>
</table>
<br><br>




<br><br>
DineList (예약 가능한 식당 리스트) 해당 식당 클릭시 식당 상세로
<table border="1" id="dineList">
<c:forEach items="${dineList}" var="dineVO">
<tr>
<th><a href="dine_detail?dine_name=${dineVO.dine_name}">${dineVO.dine_name }
<input type="hidden" name="dine_name" value="${dineVO.dine_name}"></a></th>
<td>총 테이블 수: ${dineVO.room }</td>
</tr>
</c:forEach>

</table>



<br>
<a href="logout">로그 아웃</a>

</div>
<br><br><br>
</body>
<%@ include file="../footer.jsp" %>
</html>








