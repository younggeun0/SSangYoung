<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="EL에서 제공하는 변수관련 태그"
    %>
<!--  JSTL을 사용하려면 지시자 선언이 필요 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<%
		// EL은 변수를 직접사용할 수 없다.
		// EL에서 변수를 사용하는 방법
		// 1. 변수를 c:set JSTL로 할당 후 사용
		int month = 3; 
	
		// 2. scope객체에 attribute로 할당 후 사용
		pageContext.setAttribute("month", month);
	%>
	
	<!-- 변수의 선언 -->
	<c:set var="i" value="14"/>
	<c:set var="mon" value="<%= month %>"/>
	<c:set var="name" value="기미철"/>
	
	<!--  출력 -->
	<!-- c:set으로 만든 변수는 EL로 직접출력이 가능,
		scriptlet에 만든 변수 직접출력은 불가능하다 -->
	<!-- XSS 취약점을 막기위해 EL은 항상 c:out으로 출력처리를 해야 한다 -->
	i = <c:out value="${ i }"/><br/>
	<strong><c:out value="${ name }"/></strong><br/>
	<strong>=== EL에서 변수 사용 ===</strong><br/>
	&lt;c:set&gt; 사용 : <c:out value="${ mon }"/><br/>
	pageScope으로 사용 : <c:out value="${ pageScope.month }"/><br/>
	
	<!-- 변수의 삭제 : 삭제된 변수는 아무것도 출력되지 않는다. -->
	<c:remove var="i"/>
	<c:remove var="name"/>
	<br/>
	<strong>변수 삭제 후</strong><br/>
	i = <c:out value="${ i }"/><br/>
	name = <c:out value="${ name }"/><br/>	
	month = <c:out value="${ mon }"/><br/>

	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>