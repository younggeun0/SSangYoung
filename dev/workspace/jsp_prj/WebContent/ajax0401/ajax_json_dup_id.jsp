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
		$("#id").keyup(function() {
			var id = $("#id").val();
			if(id.length > 2) { // 세자부터 체크
				if(id.trim() == "") {
					$("#idResult").text("아이디를 입력해주세요!").css("color","#FF0000");
					$("#id").val("");
					return;
				}
			
				// ID중복확인을 비동기로 처리
				$.ajax({
					url:"json_dup_id.jsp",
					type:"get",
					async:false,
					data:"id="+id,
					dataType:"json",
					error:function(xhr) {
						alert("서비스가 원활하지 못합니다. 잠시 후 다시 시도해주세요.");
						console.log(xhr.status+" / "+xhr.statusText);
					},
					success:function(jsonObj) {
						var output = "[<strong>"+id+"</strong>]는 사용불가";
						var color="#FF0000";
						if (jsonObj.idResult) {
							output = "[<strong>"+id+"</strong>]는 사용가능";
							color="#0000FF";
						}
						
						$("#idResult").html(output).css("color",color);
						if (id.length > 3) {
							for(var i=0; i<4; i++) {
								$("#idResult").fadeIn(1000).fadeOut(1000).fadeIn(1000);
							}
						}
					}
				}); // ajax	
			} else {
				$("#idResult").html("");
				// 3자 이상일 때부터 
				/* if (id.length < 3) {
					var output = "아이디를 입력해주세요.";
					var color="#00FF00";
					$("#idResult").html(output).css("color",color);
				}  */
			}
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
	
	
<strong>회원가입</strong><br/>
<table>
	<tr>
		<td>아이디</td>
		<td width="500"><input type="text" name="id" class="inputBox" id="id"/>
		<span id="idResult"></span><br/>
		<span style="color:#333">아이디는 3자이상 입력하셔야 합니다.</span>
		</td>
	</tr>
</table>



	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>