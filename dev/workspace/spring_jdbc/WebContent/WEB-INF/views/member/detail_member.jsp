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
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	<br><br>

<c:choose>
	<c:when test="${ empty detailMember }">
		<h2>조회된 회원이 존재하지 않습니다.</h2>
	</c:when>
	<c:otherwise>
		<table border="1" style="text-align:center;">
			<tr>
				<th colspan="3"><h2>상세 회원정보</h2></th>
			</tr>
			<tr>
				<td width="100">이미지</td>
				<td width="100">이름</td>
				<td width="100">
					<c:out value="${ detailMember.name }"/>
				</td>
			</tr>
			<tr>
				<td rowspan="4">
					<img id="img" src="/spring_jdbc/upload/${ detailMember.img }" style="width:100px; height:100px;"/>
				</td>
			</tr>
			<tr>
				<td>지역</td>
				<td><c:out value="${ detailMember.loc }"/></td>
			</tr>
			<tr>
				<td>출신고</td>
				<td>
					<c:out value="${ detailMember.highschool }"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" onclick="history.back()" value="뒤로가기" class="btn"/>
				</td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>	
	
	



	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>