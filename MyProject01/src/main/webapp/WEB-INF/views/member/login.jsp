<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/memberStyle.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../header.jsp" %>

<body>

<div class="main">

<form method="post" action="login">
<div style="width: 20; float: left;">
<h3 style="text-align: center;">로그인</h3>
<table>
<tr>
<th>ID: </th>
<td><input type="text" name="id"></td>
</tr>
<tr>
<th>Password: </th>
<td><input type="password" name="pwd"></td>
</tr>
<tr></tr>
<tr>
<td colspan="2">
<input type="submit" value="로그인">&nbsp;&nbsp;
<input type="button" onclick="location='join_form'" value="회원가입">&nbsp;&nbsp;
<input type="button" onclick="history.go(-1)" value="뒤로 가기">&nbsp;&nbsp;
</td>
</tr>

</table>
<br><br><br>

</div>

</form>

</div>
<%@ include file="../footer.jsp" %>
</body>
</html>