/**
 * 
 */

function menuList(){	// 메뉴판, 새창 뛰움 
	
	var url = "menuList?dine_name="+document.formm.dine_name.value;
	
	window.open(url, "_blank_1" , "toolbar=no, menubar=no, " +
			"scrollbars=yes, resizable=no, width=400, height=300");
}

function reserveList(){//incomplete
	
	document.formm.action="reserveAction";
	document.formm.submit();
}

function reserveCheck(){		// 예약전 빈칸 확인
	
	if(document.formm.r_date.value==null){
		alert("날짜를 선택해 주세요");
		document.formm.id.forcus();
	}else if(document.formm.people.value==""){
		alert("인원 수를 정해주세요");
		document.formm.people.focus();
	}else{
		document.formm.action="reserveAction";
		document.formm.submit();
	}

}

function dateRooms(){//add option test
	//alert("dateRooms() triggered 2");
	
	var op = new Option();
	op.value="option value100";
	op.text="option text100";
	
	document.formm.room.add(op);
	
}


function dateRoom(){
	
	// 버튼 구역 초기화
	
	//alert("dateRoom() triggered");
	checkRoomSize();
		
	$.ajax({
		type:'POST',
		url:'searchDateRoom', 		// 요청 url >> ReserveDateRoomController, seachDateRoom
		dataType:"json",
		data:$("#formm").serialize(),		// form 내의 입력 데이터 전송 (id)
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			var count = data.length;
			
			//if (count > 0) {alert("데이터 수신");} else {alert("데이터 수신 못함");}
			var room = document.getElementById("room");
			
			if(room.length > 1){	// 테이블 수 초기화
				//console.log("clearing options")
				while(room.length > 1){	
					room.remove(1);	// 반복적으로 1번째 삭제 (0번 살려둠)
				}
			}
			
			//var html = "";
			for (var i = 1; i<=data.length; i++){		// i=0 -> option 이미 있음, 
				if( data[i]  == 0){
					//html+= "<option value=\""+ i +"\">"+i+" 번 방 </option>";
					var op = new Option();
					op.value=i;
					op.text=i+" 번 방";
					
					document.formm.room.add(op);
				}	// 테이블 가능 수 추가			
			}
			
		},
		error: function(request, status, error){
			alert("dateRoom() error: "+ error);
		}
	});
	
	
}


function checkRoomSize(){
	
	//alert("checkRoomSize() triggered");
	
	$.ajax({
		type:'POST',
		url: 'checkCountReserve',
		dataType:"json",
		data:$("#formm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data){
			var rcount = data;
			// 0==예약 가능, 1==예약 꽉참
			//console.log(rcount);	// 2020-05-30 >> 1
			if(rcount==1){
				//hide button
				document.getElementById('submitButton').value= "해당 날짜 예약은 더이상 안됩니다";
				document.getElementById('submitButton').onclick = "";
			}else{
				// reset
				//alert("button reset");
				document.getElementById('submitButton').value= "예약하기";
				//document.getElementById('submitButton').onClick = reserveCheck();//바로 실행
				document.getElementById('submitButton').setAttribute("onClick", "javascript:reserveCheck()");
			}
			
		},
		error: function(request, status, error){
			alert("checkRoomSize() error: "+ error);
		}			
	});
	
}












