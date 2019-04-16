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
	
	function requestString() {
		var url = "request_string.do";
		
		if (confirm("문자열의 매개변수를 전송 하시겠습니까?")){
			url += "?name=jungyun";
		}
		location.href=url;
	}
	function requestInt() {
		var url = "request_int.do";
		
		if (confirm("정수형의 매개변수를 전송 하시겠습니까?")){
			url += "?age=30";
		}
		location.href=url;
	}
</script>
<!-- SmartMenus 끝 -->   
<form action="request_post.do" name="hidFrm" method="post" id="hidFrm">
	<input type="hidden" />
</form>
<nav id="main-nav">
	<ul id="main-menu" class="sm sm-simple">
    <li><a href="http://localhost:8080/spring_mvc/index.html">홈으로</a></li>
    <li><a href="#void">Spring MVC 사용</a>
      <ul>
        <li><a href="request_get.do">GET방식 요청</a></li>
        <li><a href="#void" onclick="sendPost()">POST방식 요청</a></li>
        <li><a href="#void" onclick="requestAll()">GET/POST 모두 요청</a></li>
        <li><a href="request_form.do">HttpServletRequest로 파마리터 처리</a></li>
        <li><a href="vo_form.do">VO 파마리터 처리</a></li>
        <li><a href="#void" onclick="requestString()">단일 파라미터(문자열) 처리</a></li>
        <li><a href="#void" onclick="requestInt()">단일 파라미터(정수형) 처리</a></li>
       <li><a href="view_request.do">HttpServletRequest사용 데이터 전달</a></li>
       <li><a href="view_model.do">Model사용 데이터 전달</a></li>
       <li><a href="view_modelandview.do">ModelAndView사용 데이터 전달</a></li>
       <li><a href="use_redirect.do">redirect 페이지 이동</a></li>
       <li><a href="http://localhost:8080/spring_mvc/session/use_session.do">HttpSession 사용</a></li>
       <li><a href="http://localhost:8080/spring_mvc/session/use_session_att.do">@SessionAttribute 사용</a></li>
      </ul>
    </li>
    <li><a href="#">자동차 조회</a></li>
  </ul>
</nav>	
