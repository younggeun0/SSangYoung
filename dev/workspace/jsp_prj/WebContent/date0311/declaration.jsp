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
	
	<br/><br/>
	

<%-- <%
	//int i; // instance 변수
	
	/* public String test() {
		return "공선의";
	} */
%> --%>

<%-- i=<%= i %><br/><br/> --%>

<%-- 이름 : <%=test() %> --%>
	<br/>
	
<%
	// request : 내장(내재)객체 - _jspService method안에서 선언되어있는 객체
	String ip = request.getRemoteAddr();
%>

접속자 IP Address : <%=ip %>
	
<%-- <%!
	public String ip() {
		// declaration에서는 내장객체를 사용할 수 없다.
		String ip = request.getRemoteAddr();
		
		return ip;
	}
%> --%>

	<%!
		public void test() {
			int j = 0;
	%>
		<%-- <%= j %> declaration 사이에서 정의된 코드지만 생성되는 위치가 달라 출력할 수 없다.--%>
	<%!			
		}
	%>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>