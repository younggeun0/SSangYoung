<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="JSTL의 if문"
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
	
	<%--
		조건은 true | false가 들어간다.
	<c:if test="false">
		오늘은 목요일입니다.
	</c:if>
	 --%>
	
	<a href="#void">공지사항 읽기</a>	
	<c:if test="${ param.user_role eq 'admin' }">
		<a href="#void">공지사항 쓰기</a>	
		<a href="#void">공지사항 수정</a>	
		<a href="#void">공지사항 삭제</a>	
	</c:if>	
	
	<div>
		<a href="use_if.jsp?user_role=user">일반사용자</a>
		<a href="use_if.jsp?user_role=admin">관리자</a>
	</div>
	
	<br/><br/>
	
<form action="jstl_if.jsp">
	<label>이름</label> : <input type="text" name="name" class="inputBox"/>
	<input type="submit" value="입력" class="btn"/>
</form><br/>
<div>
	위의 Form Control에서 입력된 이름을 출력하는데 이름이 '이재찬'이라면<br/>
	이름이 흘러가도록 만들어보세요.<br/><br/> 
</div>
입력한 이름 : 
<c:if test="${ param.name eq '이재찬' }">
	<marquee>
</c:if>
<c:out value="${ param.name }"/>
<c:if test="${ param.name eq '이재찬' }">
	</marquee>
</c:if>




<%-- 
<c:choose>
	<c:when test="${ param.name eq '이재찬' }">
		<marquee><c:out value="${ param.name }"/></marquee>
	</c:when>
	<c:otherwise>
		<c:out value="${ param.name }"/>
	</c:otherwise>
</c:choose> --%>
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>