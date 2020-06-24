<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="member/member.js"></script>
<meta charset="UTF-8">
<title>Join Member Here</title>
<link href="css/memberStyle.css" rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>

<div class="main">

<h3>회원 가입</h3>
<form method="post" action="join" name="formm">
<input type="hidden" name="reid">
<table border="1">
<tr>
<th>id: </th>
<td><input type="text" name="id">
<input type="button" value="중복 체크" onclick="idcheck()"></td>
</tr>
<tr>
<th> pwd: </th>
<td><input type="password" name="pwd"></td>
</tr>
<tr>
<th> pwd again: </th>
<td><input type="password" name="pwdCheck"></td>
</tr>
<tr>
<th>email: </th>
<td><input type="email" name="email"></td>
</tr>
<tr>
<th>name: </th>
<td><input type="text" name="name"></td>
</tr>
<tr>
<th>phone: </th>
<td><input type="text" name="phone"></td>
</tr>
<tr>
<th>사업자입니까?</th>
<td>
<select name="businessyn">
	<option value="N">일반 회원</option>
	<option value="Y">식당 사업자</option>
</select>

</tr>
<tr>
<td colspan="2">
<input type="button" onclick="joinCheck()" value="회원가입">&nbsp;
<input type="reset" value="다시 입력">&nbsp;
<input type="button" onclick="history.go(-1)" value="뒤로 가기">&nbsp;
</td>


</table>
<br><br><br>
</form>

</div>

</body>
<%@ include file="../footer.jsp" %>

</html>