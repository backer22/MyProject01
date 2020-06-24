

function idcheck(){
	
	if(document.formm.id.value == ""){
		alert("id를 입력하세요");
		document.formm.id.focus();
		return;
	}
	
	var url = "id_check_form?id="+document.formm.id.value;
	
	window.open(url, "_blank_1" ,"toolbar=no, menubar=no, " +
			"scrollbars=yes, resizable=no, width=330, height=200");
	
}

function idUse(){
	document.formm.action = "id_check_confirmed";
	document.formm.submit();
	
}



function joinCheck(){
	
	if(document.formm.id.value == ""){
		alert("id를 입력하세요");
		document.formm.id.focus();
	}else if(document.formm.id.value != document.formm.reid.value){
		alert("아이디 중복확인을 실행해주세요");
		document.formm.id.focus();
	}else if(document.formm.pwd.value==""){
		alert("비밀번호를 입력해 주세요");
		document.formm.pwd.focus();
	}else if(document.formm.pwd.value != document.formm.pwdCheck.value){
		alert("비밀번호가 일치하지 않습니다");
		document.formm.pwdCheck.focus();
	}else if(document.formm.name.value==""){
		alert("이름을 입력해 주세요");
		document.formm.name.focus();
	}else if(document.formm.email.value==""){
		alert("이메일을 입력해 주세요");
		document.formm.email.focus();
	}else{
		document.formm.action="join";
		document.formm.submit();		
	}
}









