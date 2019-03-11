<!--  지시자 하나에 여러 속성을 사용하는 경우 -->
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="Page Directive 연습"%>
<!--  지시자 하나 당 한 속성을 사용하는 경우 -->
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat,java.util.Calendar" %>
<%@ page buffer="8kb" autoFlush="true" %>
<%@ page isThreadSafe="true" %>
<%@ page isELIgnored="false" %>
<%@ page errorPage="page_directive1.jsp" %>
<%@ page session="true" %>
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
	
	<br/><br/>
	
<%@ page session="false" %>
<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String currDate = sdf.format(new Date());
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		if(new Random().nextBoolean()) {
			throw new Exception("예외 강제 발생");
		}
		
		// session.setAttribute("name", "정택성");
%>
	<%=currDate %>,<%=year %>
	
	<div>
<strong>EL(Expression Language)</strong>
<br/>
3+11 = ${ 3+11 }<br/>
		
		web parameter : <%=request.getParameter("name") %><br/>
		web parameter(EL) : ${param.name}<br/>
		<a href="page_directive.jsp?name=heechul">요청</a>
		<br/>
	</div>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>