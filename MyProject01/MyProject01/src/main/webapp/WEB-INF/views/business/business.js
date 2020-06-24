/**
 * 
 */

function business_update(){	//update form
	if(document.formm.dine_name == null){
		alert("식당을 먼저 등록해 주세요");
		return;
	}
	
	document.formm.action = "business_dine_update_form";
	document.formm.submit();
	
}

function business_menuList(){
	
	document.formm.action="business_menuList_form";
	document.formm.submit();
	
}

function updateCheck(){
	if(document.formm.dine_name.value==""){
		alert("식당 이름을 입력해주세요");
		document.formm.dine_name.focus();
	}else if(document.formm.location.value==""){
		alert("식당 위치를 입력해주세요");
		document.formm.location.focus();
	}else if(document.formm.room.value==""){
		alert("식당 종류를 입력해주세요");
		document.formm.category.focus();
	}else if(document.formm.category.value==""){
		alert("카테고리 입력해주세요");
		document.formm.category.focus();
	}
}






















