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
	<!-- 객체 생성 -->
	<jsp:useBean id="t_vo" class="date0313.TestVO" scope="page"></jsp:useBean>
	
	<!-- setter 호출, set을 제외한 method명을 소문자로 시작(뒤는 대소문자구분) -->
	<jsp:setProperty name="t_vo" property="firstName" value="영근"/>
	<jsp:setProperty name="t_vo" property="age" value="30"/>
	
	<!--  getter 호출, get을 제외한 method명을 소문자로 시작(뒤는 대소문자 구분) 
		Expression을 사용하지 않아도 화면 출력이 된다. -->
	이름 : <jsp:getProperty name="t_vo" property="firstName" /><br/>
	나이 : <jsp:getProperty name="t_vo" property="age" /><br/>
		
	<%
		// <jsp:useBean>으로 생성된 객체는 자바코드로 접근하여 사용할 수 있다.
		// setter 호출
		t_vo.setFirstName("정윤");
		t_vo.setAge(30);
	%>
	
	<!-- getter 호출 -->
	<div>
	재설정 이름 : <%= t_vo.getFirstName() %><br/>
	재설정 나이 : <%= t_vo.getAge() %><br/>
	</div>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>