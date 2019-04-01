<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; min-height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#btn").click(function() {
		var name=$("#name").val();
		var queryString="name="+encodeURI(name);
		
		$.ajax({
			url:"text_result.jsp",
			type:"get",
			data: queryString,
			dataType:"TEXT",
			async:"false",
			error: function(xhr) { 
				// XMLHttpRequest -> xhr을 사용하면 error의 이유를 확인 가능
				// 200 - 서버가 정상 실행되어 응답 성공하였으나 응답의 형태가
				// 			 처리 가능한 데이터가 아닐 때 
				alert("에러코드 : "+xhr.status+",에러 메세지 : "+xhr.statusText);
			},
			success: function(text_data) {
				var output="<strong>"+name+"</strong>조장의 조원</ul>";
				var data = text_data.split(",");
				for(var i=0; i < data.length; i++) {
					output+="<li>"+data[i]+(data[i] == "김건하"?" CEO":"")+"</li>";
				}
				output+="</ul>";
				$("#memberDiv").html(output);
			}
		});
	});
}); // ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
		<div style="padding-top:100px;">
		<c:import url="http://localhost:8080/jsp_prj/diary/main_menu.jsp"></c:import>
		</div>
	</div>
	<div id="container">
	<br/><br/>
	
<div>
	조장 : <input type="text" id="name" class="inputBox"/>
	<input type="button" value="입력" class="btn" id="btn"/>
</div>
<div id="memberDiv">
</div>
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>