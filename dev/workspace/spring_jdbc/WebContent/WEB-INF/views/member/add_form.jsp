<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_jdbc/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/spring_jdbc/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; min-height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#upfile").change(function() {
			var upfile = $("#upfile").val();
			if (upfile == "") {
				alert("이미지 선택해주세요.");
				return;
			}
			
			readURL(this);
		});
		
	}); // ready

 function readURL(input) {
     if (input.files && input.files[0]) {
         var reader = new FileReader();
         reader.onload = function (e) {
             $('#img').attr('src', e.target.result);
         }//function
         reader.readAsDataURL(input.files[0]);
     }//end if
  }//readURL
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	<br><br>
	
	
	<form action="add_member_process.do" method="post" enctype="multipart/form-data">
	<table border="1" style="text-align:center;">
		<tr>
			<th colspan="3"><h2>회원정보 추가</h2></th>
		</tr>
		<tr>
			<td width="100">이미지</td>
			<td width="100">이름</td>
			<td width="100">
				<input type="text" name="name" class="inputBox"/>
			</td>
		</tr>
		<tr>
			<td rowspan="4">
				<img id="img" src="/spring_jdbc/common/images/default.png" style="width:100px; height:100px;"/>
				<input type="file" name="upfile" id="upfile"/>
			</td>
		</tr>
		<tr>
			<td>지역</td>
			<td><input type="text" name="loc" class="inputBox"/></td>
		</tr>
		<tr>
			<td>출신고</td>
			<td>
				<select type="text" name="highschool" class="inputBox">
					<option value="오지고">오지고</option>
					<option value="지리고">지리고</option>
					<option value="레리고">레리고</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="입력" class="btn"/>
			</td>
		</tr>
	</table>
	</form>
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>