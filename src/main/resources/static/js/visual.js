/**
 * 비주얼 이미지 컨트롤
 */

//var size=415;//이미지사이즈(400)+15

var marginLeft=415;
var basePos=marginLeft*6;
var speed=1000;
var timmer=3000;
var myTimeout;
//ready()
$(function(){
	$(".visuals").css("margin-left", -basePos);
	start();
	
	$(".visuals").hover(function(){
		stop();
	},function(){
		start();
	});
	
});

//브라우저의 화면이 보여지냐 숨겨지냐에 따라 실행되는 이벤트
document.addEventListener("visibilitychange", function() {
	console.log( document.visibilityState );
	if(document.visibilityState=="hidden"){
		stop();
	}else if(document.visibilityState=="visible"){
		start();
	}
});

function start(){
	myTimeout = setTimeout(run, timmer);
}
function run(){
	console.log("타이머 시작");
	move();
	myTimeout = setTimeout(run, timmer);
}
function stop(){
	clearTimeout(myTimeout);
	console.log("타이머 멈춤");	
}

function move(){
	var imgWrap=$(".visuals");
	//marginLeft += size;
	imgWrap.animate({marginLeft: -(marginLeft+basePos)},speed, function(){
		var lis=$("ol.visuals li");
		//var lastLi=lis.last();
		//var firstLi=lis.first();
		//lastLi.after(firstLi);
		//첫번째 li태그가 마지막 li태그뒤로 이동
		lis.last().after(lis.first());
		imgWrap.css("margin-left", -basePos);
	});
}

