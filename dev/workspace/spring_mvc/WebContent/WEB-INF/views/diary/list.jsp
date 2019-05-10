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
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://211.63.89.144/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
	
	/* 게시판 CSS */
	#diary { margin-top: 20px; }
	#diaryHeader { font-size: 20px; font-weight: bold; text-align: center; height: 40px; }
	#diaryContent { height: 340px; }
	#diarySearch { height: 100px; text-align:center; }
	#diaryIndexList { height: 10px; text-align:center; }
	
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
	
	
	
	
<div>
	<div id="diary">
		<div id="diaryHeader">
		이벤트 목록
		</div>
		<div id="diaryContent">
			<table id="listTab">
				<tr>
					<th id="numTitle">번호</th>
					<th id="subjectTitle">이벤트 제목</th>
					<th id="writerTitle">작성자</th>
					<th id="eDateTitle">이벤트일자</th>
					<th id="wDateTitle">작성일자</th>
				</tr>
				<c:if test="${ empty diaryList }">
				<tr>
					<td colspan="5">
						이벤트가 존재하지 않습니다.<br/>
						<a href="diary.jsp">이벤트 작성</a>
					</td>
				</tr>
				</c:if>
				<c:forEach var="data" items="${ diaryList }">
				<c:set var="i" value="${ i+1 }"/>
				<tr>
					<td><c:out value="${ (totalCnt-(currentPage-1)*pageScale-i)+1 }"/></td>
					<td><a href="bbs_read.do?num=${ data.num }"><c:out value="${ data.subject }"/></a></td>
					<td><c:out value="${ data.writer }"/></td>
					<td><c:out value="${ data.e_year }-${ data.e_month }-${ data.e_date }"/></td>
					<td><c:out value="${ data.w_date }"/></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div id="diaryIndexList">
		<c:out value="${ indexList }" escapeXml="false"/>
		</div>
	</div>
</div>
<div id="view"></div>
	
	
	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>