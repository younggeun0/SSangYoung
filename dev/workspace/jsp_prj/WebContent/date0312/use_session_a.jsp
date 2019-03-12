<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"
    info="session 내장객체 사용" %>
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
<%!
	private Map<String, String> logMap = new HashMap<String, String>();
{
	// instance 영역 : 클래스가 실행될 때 자동 호출되며
	// 한번만 실행된다. (이름이 없으므로 개발자가 직접 호출할 수 없다.)
	logMap.put("kim","김희철");
	logMap.put("lee","이재찬");
	logMap.put("son","손솔잎");
	logMap.put("gong","공선의");
} 
%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	if (logMap.containsKey(id) && "1234".equals(pass)) {
		// 로그인 성공
		// 세션에 값 설정(아이디, 이름)
		session.setAttribute("user_id", id);
		session.setAttribute("user_name", logMap.get(id));
		
		// 세션 생존시간 설정
		session.setMaxInactiveInterval(60*1);
		
		// Servlet이나 JSP에서 Console로 출력할 때 log method 사용.
		log("----------- 로그!!!!!"+session.getAttribute("user_id"));
		
		String name=(String)session.getAttribute("user_name");
%>
		로그인 성공<br/> <a href="use_session_c.jsp">로그아웃</a>
		<%=name %>님 로그인 하셨습니다.<br/>
		<a href="job_a.jsp">작업페이지</a>
<%
	} else {
		// 로그인 실패
%>
	아이디나 비밀번호를 확인해주세요.<br/>
	<a href="use_session.html">로그인</a>
<%
	}
%>
</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>