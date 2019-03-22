<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 일정관리</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
	
	/* 게시판 CSS */
	#diary { margin-top: 20px; }
	#diaryHeader { font-size: 20px; font-weight: bold; text-align: center; height: 40px; }
	#diaryContent { height: 400px; }
	#diarySearch { height: 100px; text-align:center; }
	#diaryIndexList { height: 30px; }
	
	#listTab {
		border-top:3px solid #333;
		margin:0px auto;
		border-spacing: 0px;
	}
	
	#numTitle{ width:50px; height:25px; background-color: #F3F3F3; }
	#subjectTitle { width:350px; height:25px; background-color: #F3F3F3; }
	#writerTitle { width:120px; height:25px; background-color: #F3F3F3; }
	#eDateTitle { width:150px; height:25px; background-color: #F3F3F3; } 
	#wDateTitle { width:150px; height:25px; background-color: #F3F3F3; }
	
	th,td { border-bottom:1px solid #EEEEEE }
	td { height:27px; }
	
	tr:HOVER { background-color: #F3F3F3; }
	
	.center { text-align: center; }
	
	
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>


</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
		<div style="padding-top:100px;">
		<c:import url="http://localhost:8080/jsp_prj/diary/main_menu.jsp"></c:import>
		</div>
	</div>
	<div id="container">
	
	<div id="diary">
		<div id="diaryHeader">이벤트 목록</div>
		<div id="diaryContent">
			<table id="listTab">
				<tr>
					<th id="numTitle">번호</th>
					<th id="subjectTitle">이벤트 제목</th>
					<th id="writerTitle">작성자</th>
					<th id="eDateTitle">이벤트일자</th>
					<th id="wDateTitle">작성일자</th>
				</tr>
			</table>
		</div>
		<div id="diaryIndexList">
			
		</div>
		
		<div id="diarySearch">
		<form action="list.jsp" method="post" id="searchFrm" name="searchFrm">
			<select name="fieldName" class="inputBox" id="fieldName">
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="writer">작성자</option>
			</select>
			<input type="text" name="keyword" class="inputBox" style="width:150px" id="keyword"/>
			<input type="button" value="검색" class="btn" style="width:30px;"/>
		</form>
		</div>
	</div>
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>