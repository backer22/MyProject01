<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 식당 등록 화면</title>
</head>
<body>

<form method="POST" action="business_dine_join" enctype="multipart/form-data">
<table>
<tr>
<th>식당명: </th>
<td><input type="text" name="dine_name"></td>
</tr>
<tr>
<th>위치(주소)</th>
<td><input type="text" name="location"></td>
</tr>
<tr>
<th>테이블 수(예약 가능 수): </th>
<td><input type="number" name="room"></td>
</tr>
<tr>
<th>식당 종류</th>
<td><input type="text" name="category"></td>
</tr>
<tr>
<th>테이블 위치(배치도) 이미지</th>
<td><input type="file" name="uploadFile"></td>
</tr>

<tr>
<td><input type="submit" value="식당 등록하기"></td>
</tr>
</table>
</form>


</body>
</html>










