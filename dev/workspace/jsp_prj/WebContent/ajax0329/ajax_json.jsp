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
		
		$("#setValue").click(function() {
			
			$.ajax({
				url:"json_result.jsp",
				type:"post",
				dataType:"json",
				error:function(xhr) {
					alert(xhr.status+" / "+xhr.statusText);
				},
				success: function(jsonObj) {
					
					$("#name").val(jsonObj.name);
					$("#age").val(jsonObj.age);
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
	<a href="#void" id="setValue">값 설정</a>
</div>
<div>
	이름 : <input type="text" name="name" id="name" class="inputBox"/><br/>
	나이 : <input type="text" name="age" id="age" class="inputBox"/>
</div>

	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>