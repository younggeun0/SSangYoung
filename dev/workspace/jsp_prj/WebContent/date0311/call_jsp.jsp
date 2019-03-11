<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#container { width:800px; height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnGet").click(function() {
			$("[method='get']").submit();
		});
		$("#btnPost").click(function() {
			$("[method='post']").submit();
		});
		$("#btnLoc1").click(function() {
			location.href="call.jsp";
		});	
		$("#btnLoc2").click(function() {
			location.replace("call.jsp");
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
<div>
	<strong>GET방식으로 JSP 요청</strong>
	<ul>
		<li><a href="call.jsp">GET 요청</a></li>
		<li>
			<form action="call.jsp" method="get">
				<input type="button" value="GET방식 요청" class="btn" id="btnGet">
			</form>
		</li>
		<li><input type="button" value="location.href사용 요청" class="btn" id="btnLoc1"/></li>
		<li><input type="button" value="location.replace사용 요청" class="btn" id="btnLoc2"/></li>
	</ul>
</div>
<div>
	<strong>POST방식으로 JSP 요청</strong>
	<ul>
		<li>
			<form action="call.jsp" method="post">
				<input type="button" value="POST방식 요청" class="btn" id="btnPost">
			</form>
		</li>
	</ul>
</div>
</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>