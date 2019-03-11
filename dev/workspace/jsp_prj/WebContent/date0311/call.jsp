<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="HTML에서 JSP를 요청"%>
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
	<% if("GET".equals(request.getMethod())) { %>
	#method { font-weight: bold; font-size:14px; color:#00FFFF; }
	<% } else {%>
	#method { font-weight: bold; font-size:16px; color:#FF00FF; }
	<% } %>
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
<div id="container">
<ul>
	<li><strong>요청방식</strong> : <span id="method"><%=request.getMethod() %></span></li>
	<li><strong>접속자의 IP Address</strong> : <%=request.getRemoteAddr() %></li>
	<li><a href="javascript:history.back();">뒤로</a></li>
</ul>
</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>