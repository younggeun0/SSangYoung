<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="여러조건을 비교할 때 사용하는 choose"
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

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
  $( ".show-option" ).tooltip({
    show: {
      effect: "slideDown",
      delay: 250
    }
  });
  $( ".hide-option" ).tooltip({
    hide: {
      effect: "explode",
      delay: 250
    }
  });
  $( ".open-event" ).tooltip({
    show: null,
    position: {
      my: "left top",
      at: "left bottom"
    },
    open: function( event, ui ) {
      ui.tooltip.animate({ top: ui.tooltip.position().top + 10 }, "fast" );
    }
  });
} );
</script>
 
 
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	<br/><br/>
	
	
<%-- <%
	String[] tooltips = { "open-event", "hide-option", "show-option" };

	String random_tooltip = tooltips[new Random().nextInt(3)];
	pageContext.setAttribute("tooltip", random_tooltip);
%> 

<c:set var="tooltipClass" value="${ tooltip }"/>--%>

<%
	int randomNum = new Random().nextInt(3);
	pageContext.setAttribute("tooltip", randomNum);
%>

<c:choose>
	<c:when test="${ tooltip eq 0 }">
		<c:set var="tooltipClass" value="open-event"/>
	</c:when>
	<c:when test="${ tooltip eq 1 }">
		<c:set var="tooltipClass" value="show-option"/>
	</c:when>
	<c:otherwise>
		<c:set var="tooltipClass" value="hide-option"/>
	</c:otherwise>
</c:choose>

<div style="width:500px; height:200px; overflow:auto; border:1px solid #333;">
	1조는 PC방 프로그램을 아이템으로 구현하였고, 조장 
	<span class="${ tooltipClass }" title="좌석, 메시지">이봉현</span>, 조원 
	<span class="${ tooltipClass }" title="주문, 통계">이재찬</span>, 
	<span class="${ tooltipClass }" title="회원관리, 관리자">김정운</span>, 
	<span class="${ tooltipClass }" title="주문">박은영</span>,  
	<span class="${ tooltipClass }" title="회원조회, 마일리지">백인제</span>, 
	<span class="${ tooltipClass }" title="로그인, 회원관리">정택성</span>으로 구성되어 있습니다. 
	PC방 프로그램을 완벽하게 구현하기 위해서 조장 이하 모든 조원은 합심하여 
	PC방으로 전격 출근!!! 알바를 하였습니다.
</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
<%-- <div>
<form action="jstl_choose.jsp" method="get">
	<label>혈액형 선택</label>
	<select name="blood_type">
		<option value="a"${ param.blood_type eq 'a'?" selected='selected'":''}>A형</option>
		<option value="b"${ param.blood_type eq 'b'?" selected='selected'":''}>B형</option>
		<option value="o"${ param.blood_type eq 'o'?" selected='selected'":''}>O형</option>
		<option value="ab"${ param.blood_type eq 'ab'?" selected='selected'":''}>AB형</option>
	</select>
	<input type="submit" value="혈액형 선택" class="btn"/>
</form> 
</div>


<!-- 여러 조건을 비교할 때 choose 사용 -->
<c:choose>
	<c:when test="${ param.blood_type eq 'o' }">
		<c:set var="img" value="blood_type_o.png"/>
	</c:when>
	<c:when test="${ param.blood_type eq 'b' }">
		<c:set var="img" value="blood_type_b.png"/>
	</c:when>
	<c:when test="${ param.blood_type eq 'ab' }">
		<c:set var="img" value="blood_type_ab.png"/>
	</c:when>
	<c:otherwise>
		<c:set var="img" value="blood_type_a.png"/>
	</c:otherwise>
</c:choose>
<br/>
<img src="images/${ img }"/> --%>
		
	
		
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>