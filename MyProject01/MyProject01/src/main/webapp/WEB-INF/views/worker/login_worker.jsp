<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Worker Login here</title>
<link href="css/memberStyle.css" rel="stylesheet">

</head>

<body>
<%@include file="worker_header.jsp" %>

<div class="main">


<form id="formm" method="post" action="login_worker">
<table>
<tr>
<th>w_id: </th>
<td><input type="text" name="w_id" value="admin1"></td>
</tr>
<tr>
<th>w_pwd: </th>
<td><input type="password" name="w_pwd" value="1234"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="로그인" ></td>
</tr>
	
</table>

</form>

</div>

</body>
</html>