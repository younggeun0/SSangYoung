<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="session값을 사용하는 페이지"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.144/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://211.63.89.144/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; min-height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		<c:if test="${ cookieFlag }">
			alert("${ msg }");
		</c:if>
	}); // ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
		<div style="padding-top:100px;">
		<c:import url="http://211.63.89.144/common/diary/main_menu.jsp"></c:import>
		</div>
	</div>
	<div id="container">
	<br/><br/>
	

<div>
	<strong>Model에 들어있는 쿠키들 읽기</strong><br/>
	<c:if test="${ empty requestScope.rCookie }">
		쿠키가 존재하지 않습니다.<br/>
		<a href="add_cookie.do">쿠키 심기</a>
	</c:if><br/>
	<%-- <c:forEach var="cookie" items="${ rCookie }">
		쿠키명 : <c:out value="${ cookie.name }"/><br/>
		쿠키값 : <c:out value="${ cookie.value }"/><br/>
	</c:forEach> --%>
	<%
		Cookie[] rCookie = (Cookie[])request.getAttribute("rCookie");
		if (rCookie != null) {
			for (Cookie temp : rCookie) {
				out.println(temp.getName()+" "+temp.getValue()+"<br/>");
			}
		}
	%>
	<c:if test="${ not empty requestScope.rCookie }">
		쿠키가 존재합니다.<br/>
		<strong>쿠키 값</strong><br/>
		<c:out value="${ requestScope.name }" escapeXml="false"/><br/>
		<strong>태어난 해</strong> : <c:out value="${ requestScope.birth }"/>
		<br/>
		<a href="remove_cookie.do">쿠키 삭제</a>
	</c:if><br/>
</div>
	
	
	
	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>