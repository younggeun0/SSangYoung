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
			var name = $("[name='name']:checked").val();
			var queryString = "name="+name;
			
		$.ajax({
			url:"xml_result.jsp",
			type:"get",
			data:queryString,
			dataType:"text",
			async:"true",
			error:function(xhr) {
				alert(xhr.status);
			},
			success:function(xml_data) {
					var nameNodes = $(xml_data).find("name"); // 배열
					var output = "";
					
					$.each(nameNodes,function(idx, nameNode) {
						output+="<input type='checkbox' name='name' value='"
							+$(this).text()+"'/>"+$(this).text()+"</br>";
					});
					
					$("#memberView").html(output);
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
	<input type="radio" name="name" value="이봉현" checked="checked"/>1조
	<input type="radio" name="name" value="박영민"/>2조
	<input type="radio" name="name" value="오영근"/>3조
	<input type="radio" name="name" value="김건하"/>조기취업
	<input type="button" value="조회" class="btn" id="btn"/>
</div>
<div id="memberView">
</div>

	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>