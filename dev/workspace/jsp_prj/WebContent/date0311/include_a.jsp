<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="include 연습"%>
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
<div>
	외부 JSP
	<%
		String name = "김정윤";
	%>
	<div>
		<%@ include file="include_b.jsp" %>
	</div>
	외부 JSP
	<br/>
	<!--  외부 JSP에서 끼워지는 JSP의 변수는 에러없이 사용할 수 있다. -->
	나이 : <%=age %>, 주소 : <%=addr %>
	<%= today() %>
</div>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>