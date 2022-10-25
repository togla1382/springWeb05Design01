/**
 * 
 */
$(function(){
	$("#terms-all").click(termsAllClicked);
	$(".terms :checkbox").not("#terms-all").click(termsEachClicked);
}); 


function termsAllClicked(){
	// $(this).attr("checked") //HTML태그기준으로 읽어들인다.
	//console.log("attr:"+$(this).prop("checked"));
	if($(this).prop("checked")){
		$(".terms :checkbox").prop("checked", true);
	}else{
		$(".terms :checkbox").prop("checked", false);
	}
}

function termsEachClicked(){
	
	
	if($(this).prop("checked")){
		//true일떄는 다른 checked도 모두true이면 
		//console.log("체크박스 ture일때 나머지 체크");
		//체크박스 전체개수
		var tot=$(".terms :checkbox").not("#terms-all").length;
		//체크된 체크박스개수
		var checkdTot=$(".terms :checkbox:checked").not("#terms-all").length
			
		//나머지도 모두 true가 확인
		if(tot==checkdTot){
			//모두 true이면 전제동의 체크박스도 checked 설정
			$("#terms-all").prop("checked", true);
		}else{
			//모두 true아닌경우 전제동의 체크박스도 checked 해제
			$("#terms-all").prop("checked", false);
		}
		
	}else{
		console.log("체크박스 false일때 전체박스 무조건 false");
		$("#terms-all").prop("checked", false);
	}
}
