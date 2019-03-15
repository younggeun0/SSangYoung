<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="반복문 forEach의 사용"
    %>
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
	
	
<%-- 	<select>
		<!--  증가하는 값을 반복시킬 때 -->
		<c:forEach var="i" begin="1" end="100" step="10">
			<option value="${ i }"><c:out value="${ i }"/></option>
		</c:forEach>
	</select> --%>
		
<%
	String[] movies = { "시네마 천국", "주토피아", "코어", "7인의 사무라이", "트루먼쇼", "인셉션" };
	pageContext.setAttribute("movies", movies);
%>

<ul>
<c:forEach var="movie" items="${ movies }">
	<c:set var="idx" value="${ idx+1 }"/><!-- set이 0으로 초기화 -->
	<li>${ idx } ${ movie }</li>
</c:forEach>
</ul>
	
	
	
	
	
	
	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>