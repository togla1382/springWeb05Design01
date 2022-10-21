/**
 * 
 */
 //문서가 로딩되면 함수가 실행해요
 $(function(){
	saleGoodsLoading();
	//var tabMenu=$(".tab-menu li");	
	
	//클릭이벤트 등록: 								
	$(".tab-menu li").click(tabMenuClicked);
});

//메뉴가 클릭되면 실행되는 함수
function tabMenuClicked(){
	$(".tab-menu li").removeClass("target");
	$(this).addClass("target");
	//서버로 요청
	saleGoodsLoading();
}

//클래스 이름이 target 해당하는 세일상품을 server에서 읽어오는 함수
//그결과를 HTML문서를 결과로 받아서 #display 영역에 HTML로 출력
function saleGoodsLoading(){
	var saleKind=$(".target").val();
	
	$.ajax({
		url:"/goods/sale/"+saleKind,
		//data:{kind: saleKind },
		success:function(result){
			$("#display").html(result);
		}
	});
}