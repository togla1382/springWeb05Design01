/**
 * 
 */
$(function(){
	  $(".summernote").summernote();
	  //$("input[type=file]").change(fileChanged);
});
  
  /* 파라미터 변수 fileEl=this */
function fileChanged(fileEl){
	  var formData = new FormData();
	  var inputFile=$(fileEl);
	  var name=$(fileEl).attr("name");
	  console.log("name:"+name);
	  formData.append("img", inputFile[0].files[0]);
	  //* 
	  $.ajax({
		  url:"/goods/upload",
		  type: "post",
		  contentType: false,
		  processData: false,
		  data : formData,
		  success:function(urlInfo){
			  //console.log(filetag);
			  // alert("비동기로 서버통신완료:"+ url); 
			  inputFile.next().css("background-image", "url("+urlInfo +")" );
			  if(name=="addImg"){
			  	$(".btn-add").show();
			  	var num=$(".add-file-wrap").length;//현재 file태그 개수
				//console.log(num);
				if(num>=3){
					$(".btn-add").hide();
				}
			  }
			  
		  }
	  });
	  //*/
}


//파일태그 동적 생성하는 함수
function btnAddClieked(btnel){
	var btn=$(btnel);
	var num=$(".add-file-wrap").length;//현재 file태그 개수
	/* `` backtick(`) 문자열 사용하면 ${} 사용가능 jsp에서는 \${} */
	var html=`
		<!-- 동적태그 -->
		<div class="add-file-wrap">
			<input type="file" name="addImg" id="file-add-${num}" onchange="fileChanged(this)" />
			<label for="file-add-${num}" >+</label>
		</div>
	`;
	//버튼태그 앞에 동적태그 삽입
	btn.before(html);
	
	//추가버튼 안보이게..
	$(".btn-add").hide();
	
	//새로 생성된 태그 change 이벤트 등록
	//$("input[type=file]").change(fileChanged);
	//불편하면 태그에 이벤트를 직접 등록하면 됨
	

}
