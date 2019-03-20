<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css"/>
<!-- summernote 관련 library 시작 -->
<link href="../common/summernote/bootstrap.css" rel="stylesheet">
<script src="../common/summernote/jquery.js"></script>
<script src="../common/summernote/bootstrap.js"></script> 

<link href="../common/summernote/summernote.css" rel="stylesheet">
<script src="../common/summernote/summernote.js"></script>
<!-- include summernote-ko-KR -->
<script src="../common/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	  $('#summernote').summernote({
      placeholder: '서머노트 우왕굳',
      tabsize: 2,
      height: 150,
      width: 700,
      lang: 'ko-KR'
    });
	});
</script>
<!-- summernote 관련 library 끝 -->
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			  $("form").submit();
		});
	});
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	<br/><br/>
	
<form method="post" action="summernote_process.jsp">
	<label>작성자</label>
	<input type="text" name="name" class="inputBox"/><br/>
	<label>제목</label>
	<input type="text" name="subject" class="inputBox"/><br/>
	<label>내용</label>
 	<textarea id="summernote" name="content"></textarea>
 	<input type="button" value="글쓰기" class="btn" id="btn"/>
</form>
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>