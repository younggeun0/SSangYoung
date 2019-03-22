<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="MultipartRequest 사용 파일업로드 폼"%>
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
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HYê²¬ê³ ë, ê³ ë; font-weight:bold; color:white; }
	#container { width:800px; height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#btnUpload').click(function() {
			
			var uploader = $("#uploader").val();
			
			if(uploader == "") {
				$("#uploader").focus();
				return;
			}
			
			var file = $("#upfile").val();
			
			if (file == "") {
				alert("업로드할 파일을 선택해주세요.");
				return;
			}
			
			// 확장자가 .jsp, .java, .class, .xml은 업로드 하지 못하도록 막는다
			var bannedExt = [ "jsp", "java", "class", "xml" ];
			var extFlag = false;
			var fileExt = file.substring(file.lastIndexOf(".")+1).toLowerCase();
			
			for(var i=0; i<bannedExt.length; i++) {
				if(bannedExt[i] == fileExt) {
					extFlag = true;
				}
			}
			
			if (extFlag) {
				alert("확장자가 jsp, java, class, xml인 파일은 업로드하실 수 없습니다.");
				return;
			}
			
			<%-- <%
			String name="기미철";
			%>
			alert(<%=name%>); --%>

			$('#uploadFrm').submit();
		});
	});
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


<!-- HTML 폼 기반 파일 업로드 
	1. enctype="multipart/form-data"
	2. method="post"
-->
<a href="../date0319/file_list.jsp">파일리스트</a><br/>
<form id="uploadFrm" action="mr_upload_process.jsp" method="post" enctype="multipart/form-data">
	<label>이름</label>
	<input type="text" name="uploader" id="uploader" class="inputBox"/><br/>
	<label>나이</label>
	<select name="age" id="age">
		<c:forEach var="i" begin="10" end="80" step="10">
		<option value="${ i }"><c:out value="${ i }"/></option>
		</c:forEach>
	</select>
	<br/>
	<label>파일</label>
	<input type="file" name="upfile" id="upfile" class="inputBox" style="width:200px;"/><br/>
	<input type="button" value="upload" class="btn" id="btnUpload" style="width:200px;"/>
</form>



	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>