<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="Controller에서 HttpServletRequest를 사용하여 전달된 값을 처리하는 Page"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="http://211.63.89.144/common/css/main_v190130.css">
<style type="text/css">
#wrap{ margin:0px auto; width:800px; height:860px; }
#header{  width:800px; height:140px; background: #FFFFFF url(http://211.63.89.144/common/images/header_bg.png) repeat-x;
			position: relative;	}
#headerTitle{ font-family: HT견고딕,고딕; font-size: 30px; font-weight: bold;text-align: center;
				position:absolute; top: 40px;left: 290px; }
#container{  width:800px; min-height:600px; }
#footer{  width:800px; height:120px; }
#footerTitle{ float: right;font-size: 15px; padding-top: 20px; padding-right: 20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
	});//ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
	<div id="headerTitle">SIST Class4 </div>
	<div style="padding-top: 100px">
		<c:import url="/common/diary/main_menu.jsp"/>
	</div>
	</div>
	<div id="container">
	<br/><br/>

<strong>chain_b.do로 응답된 내용</strong><br/>
<c:choose>
	<c:when test="${ empty lunch }">
		햄버거 목록을 받아오세요<br/>
		(chain_a를 거쳐서 오세요.)<br/>
	</c:when>
	<c:otherwise>
		좋아하는 햄버거 선택<br/>
		<c:forEach var="menu" items="${ lunch }">
			<input type="checkbox" name="menu" value="${ menu }"/>
			<c:out value="${ menu }" escapeXml="false"/>
			<!-- checkbox를 체크하고 value가 없이 전달하면 'on'이 넘어간다 -->
		</c:forEach>		
	</c:otherwise>		
</c:choose>
<br/>
<a href="#" onclick="history.back()">뒤로</a>

	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








