<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- SmartMenus 시작 -->
<!-- SmartMenus core CSS (required) -->
<link href="http://localhost:8080/spring_mvc/common/smartmenus/css/sm-core-css.css" rel="stylesheet" type="text/css" />

<!-- "sm-mint" menu theme (optional, you can use your own CSS, too) -->
<link href="http://localhost:8080/spring_mvc/common/smartmenus/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />

<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="http://localhost:8080/spring_mvc/common/smartmenus/jquery.smartmenus.js"></script>

<!-- SmartMenus jQuery init -->
<script type="text/javascript">
	$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX: 6,
			subMenusSubOffsetY: -8
		});
	});
	
	function sendPost() {
		document.hidFrm.action="request_post.do";
		$("#hidFrm").submit();
	}
	
	function requestAll() {
		var method="";
		
		if(confirm("GET방식으로 요청 하시겠습니까?")) {
			method="GET";
		} else {
			alert("POST 방식으로 요청합니다.");
			method="POST";
		}
		
		document.hidFrm.method=method;
		document.hidFrm.action="request_all.do";
		document.hidFrm.submit();
	}
</script>
<!-- SmartMenus 끝 -->   
<form action="request_post.do" name="hidFrm" method="post" id="hidFrm">
	<input type="hidden" />
</form>
<nav id="main-nav">
	<ul id="main-menu" class="sm sm-simple">
    <li><a href="#void">홈으로</a></li>
    <li><a href="#void">Spring MVC 사용</a>
      <ul>
        <li><a href="request_get.do">GET방식 요청</a></li>
        <li><a href="#void" onclick="sendPost()">POST방식 요청</a></li>
        <li><a href="#void" onclick="requestAll()">GET/POST 모두 요청</a></li>
        <li><a href="request_form.do">HttpServletRequest로 파마리터 처리</a></li>
        <li><a href="vo_form.do">VO 파마리터 처리</a></li>
      </ul>
    </li>
    <li><a href="#">자동차 조회</a></li>
  </ul>
</nav>	
