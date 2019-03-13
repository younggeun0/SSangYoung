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
	
	<!--  
		page : 기본 속성, 요청할 때마다 객체가 생성되며, 생성된 객체는 현재페이지에서만 사용
		request : 요청할 때마다 객체가 생성되며, 생성된 객체는 현재 페이지와
			forward로 이동한 페에지에서 사용
		session : 접속자 마다 하나의 객체가 생성되며, 생성된 객체는 모든 JSP에서 사용가능
			접속을 종료하면 사라진다.
		application : 최초 접속자에 의해 하나의 객체가 생성된다. 생성된 객체는 모든 JSP에서
			모든 접속자가 사용한다.(공용) Container가 종료되면 사라진다.
	-->
	<jsp:useBean id="cnt_vo" class="date0313.CounterVO" scope="application"/>
	<jsp:setProperty name="cnt_vo" property="cnt" value="1"/>
		안녕하세요?<br/>
		이 페이지의 [<strong><jsp:getProperty property="cnt" name="cnt_vo"/></strong>]
		번째 방문자입니다.
		
	<!-- 접속자의 숫자를 images/에 저장된 이미지파일로 보여주기 -->
	<div>
	<%
		String cnt = String.valueOf(cnt_vo.getCnt());
	
		String c = "";
		for(int i=0; i<cnt.length(); i++) {
			c = cnt.substring(i,i+1);
	%>
		<img src="images/num_<%= c %>.png">
	<%
		}
	%>
	</div>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>