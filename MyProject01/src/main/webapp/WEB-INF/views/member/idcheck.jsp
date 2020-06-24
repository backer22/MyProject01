<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<script type="text/javascript">
function idUse(){
	opener.formm.id.value="${id}";
	opener.formm.reid.value="${id}";
	self.close();
}

</script>
</head>
<body>

<form action="id_check_form" method=post name=formm>

ID &nbsp; <input type="text" name="id" value="${id }"> &nbsp;
			<input type="submit" value="검색" class="submit"><br>
			
<c:if test="${message==1 }">
<script type="text/javascript">
opener.document.formm.id.value="";
</script>
${id }는 이미 사용중인 아이디입니다.
</c:if>

<c:if test="${message== -1 }">
${id}는 사용 가능한 ID 입니다.
<input type="button" value="사용" class="cancel" onclick="idUse()">
</c:if>

</form>




</body>
</html>