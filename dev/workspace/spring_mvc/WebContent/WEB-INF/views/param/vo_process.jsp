<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<ul>
	<li> VO로 값 처리</li>
	<li>${ param.name }(${ nameData })님 안녕하세요.</li>
	<li>${ param.age }(${ ageData })살</li>
	<li>
	<c:if test="${ empty langData }">
		관심 언어가 없습니다.
	</c:if>
<c:forEach var="lang" items="${ requestScope.langData }">
	<c:out value="${ lang }"/> 
</c:forEach>
	</li>
	<li>
		<a href="#void" onclick="history.back();">다시입력</a>
		<a href="#void" onclick="location.href='request_form.do';">다시입력</a>
	</li>
</ul>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>