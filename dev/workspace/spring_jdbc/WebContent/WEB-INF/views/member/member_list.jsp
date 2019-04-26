<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_jdbc/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/spring_jdbc/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; min-height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">



</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	<br><br>
	
	
<div>
	<c:forEach var="ml" items="${ requestScope.memberList }">
	<table>
		<tr>
			<td rowspan="4">
				<img src="http://localhost:8080/spring_jdbc/upload/${ ml.img }" width="100" height="100"/>
			</td>
		</tr>
		<tr>
			<td width="80">이름</td>
			<td>
				<a href="detail_member.do?num=${ ml.num }"><c:out value="${ ml.name }"/></a>
			</td>
		</tr>
	</table>
	</c:forEach>
	<c:if test="${ empty memberList }">
		조회된 회원이 존재하지 않습니다. 회원정보를 추가해주세요.<br/>
		<div>
		<ul>
			<li><a href="add_form.do">정보추가</a></li>
			<li><a href="search_member.do">정보조회</a></li>
		</ul>
		</div>
	</c:if>
</div>



	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>