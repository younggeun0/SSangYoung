<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- SmartMenus 시작 -->
<!-- SmartMenus core CSS (required) -->
<link href="http://localhost:8080/jsp_prj/common/smartmenus/css/sm-core-css.css" rel="stylesheet" type="text/css" />

<!-- "sm-mint" menu theme (optional, you can use your own CSS, too) -->
<link href="http://localhost:8080/jsp_prj/common/smartmenus/css/sm-simple/sm-simple.css" rel="stylesheet" type="text/css" />

<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="http://localhost:8080/jsp_prj/common/smartmenus/jquery.smartmenus.js"></script>

<!-- SmartMenus jQuery init -->
<script type="text/javascript">
	$(function() {
		$('#main-menu').smartmenus({
			subMenusSubOffsetX: 6,
			subMenusSubOffsetY: -8
		});
	});
</script>
<!-- SmartMenus 끝 -->   

<nav id="main-nav">
	<ul id="main-menu" class="sm sm-simple">
    <li><a href="#void">홈으로</a></li>
    <li><a href="#void">쿼리보기</a>
      <ul>
        <li><a href="main.jsp?page=date0404/single_column">컬럼 하나에 레코드 하나 조회</a></li>
        <li><a href="main.jsp?page=date0404/multi_row">컬럼 하나에 레코드 여러개 조회</a></li>
        <li><a href="main.jsp?page=date0404/multi_column">컬럼 여러개에 레코드 하나 조회</a></li>
        <li><a href="main.jsp?page=date0405/multi_column_row">컬럼 여러개에 레코드 여러개 조회</a></li>
        <li><a href="main.jsp?page=date0405/multi_param">WHERE의 값이 여러개인 경우</a></li>
        <li><a href="main.jsp?page=date0405/less_than">&lt;의 비교</a></li>
        <li><a href="main.jsp?page=date0405/greater_than">&gt;의 비교</a></li>
        <li><a href="main.jsp?page=date0405/like">LIKE의 조회</a></li>
        <li><a href="main.jsp?page=date0408/subquery">서브쿼리를 사용한 조회</a></li>
        <li><a href="main.jsp?page=date0408/union">UNION를 사용한 조회</a></li>
        <li><a href="main.jsp?page=date0408/join">JOIN을 사용한 조회</a></li>
      </ul>
    </li>
  </ul>
</nav>	
