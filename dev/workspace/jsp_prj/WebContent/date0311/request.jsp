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
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
<div id="container">
	<ul>
		<li><strong>접속 URL</strong> : <%=request.getRequestURL() %></li>
		<li><strong>요청 Protocol</strong> : <%=request.getProtocol() %></li>
		<li><strong>요청 서버명</strong> : <%=request.getServerName() %></li>
		<li><strong>요청 서버명</strong> : <%=request.getServerPort() %></li>
		<li><strong>요청 URI</strong> : <%=request.getRequestURI() %></li>
		<li><strong>요청 Servlet Path</strong> : <%=request.getServletPath() %></li>
		<li><strong>요청 Context Path</strong> : <%=request.getContextPath() %></li>
		<li><a href="request.jsp?name=jinkyung&addr=강서구&age=30">JSP QueryString 요청</a></li>
		<li><strong>요청 Query String</strong> : <%=request.getQueryString() %></li>
		<li><strong>요청 Parameter</strong> : <%=request.getParameter("name") %></li>
		<li><strong>요청 방식</strong> : <%=request.getMethod() %></li>
		<li><strong>접속자 IP Address</strong> : <%=request.getRemoteAddr() %></li>
		<li><strong>접속자 PORT</strong> : <%=request.getRemotePort() %></li>
	</ul>
</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>