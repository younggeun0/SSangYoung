<%@page import="kr.co.sist.diary.service.ListService"%>
<%@page import="kr.co.sist.vo.DiaryListVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.vo.ListRangeVO"%>
<%@page import="kr.co.sist.vo.SearchDataVO"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
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
	#diaryIndexList { height: 30px; text-align:center; }
	
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
<script type="text/javascript">
$(function() {
	$("#keyword").keydown(function(evt) {
		if(evt.which == 13) {
			if($("#keyword").val() == "") {
				$("#keyword").focus();
				alert("검색할 키워드를 입력해주세요.");
				return;
			}
		}
	});
	
	$("#searchBtn").click(function() {
		if($("#keyword").val() == "") {
			alert("검색할 키워드를 입력해주세요.");
			$("#keyword").focus();
			return;
		}
		
		$("#searchFrm").submit();
	});
});
</script>

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
	<c:catch var="e">
	<%
	
		ListService ls = ListService.getInstance();
	
		request.setCharacterEncoding("UTF-8");
	
		String keyword = request.getParameter("keyword");
		String fieldName = request.getParameter("fieldName");
		
		SearchDataVO sdvo = null;
		if (keyword != null && !"".equals(keyword)) { // 사용자가 검색값을 넣었을 때
			sdvo = new SearchDataVO(fieldName, keyword);
		}
		
		// 1. 전체 페이지 수를 얻기/ 검색에 맞는 게시물 수 얻기
		int totalCnt = ls.totalCount(sdvo);
		
		// 2. 한 화면에 보여질 게시물의 수
		int pageScale = ls.pageScale();
		
		// 3. 총 페이지 수 구하기
		int totalPage = ls.totalPage(totalCnt);
		
		// 4. 시작 게시글 번호 구하기
		String currentPage = request.getParameter("current_page"); 
		
		if (currentPage == null) {
			currentPage = "1";
		}

		int startNum = ls.startNum(currentPage);
		
		// 5. 끝 게시글 번호 구하기
		int endNum = ls.endNum(startNum);
		
		ListRangeVO lrvo = new ListRangeVO(startNum, endNum);
		List<DiaryListVO> list = ls.searchList(sdvo, lrvo);
		
		pageContext.setAttribute("list", list);
		pageContext.setAttribute("totalPage", totalPage);
		
		String indexList = ls.indexList("list.jsp", sdvo, totalPage);
		pageContext.setAttribute("indexList", indexList);
		
		pageContext.setAttribute("bbsIdx", totalCnt-(Integer.parseInt(currentPage)-1)*pageScale);
	%>
	</c:catch>
	<div id="diary">  
		<span style="float:left;"><a href="list.jsp"><img src="images/btn_all.png"/></a></span>
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
				<c:if test="${ not empty e }">
				<tr>
					<td colspan="5">서비스가 월활하지 못한점 죄송합니다.</td>
				</tr>
				</c:if>
				<c:if test="${ empty e and empty list }">
				<tr>
					<td colspan="5">
						이벤트가 존재하지 않습니다.<br/>
						<a href="diary.jsp">이벤트 작성</a>
					</td>
				</tr>
				</c:if>
				<c:forEach var="data" items="${ list }">
				<c:set var="bbsIdx" value="${ bbsIdx }"/>
				<%-- <c:set var="i" value="${ i+1 }"/> --%>
				<tr>
					<td><c:out value="${ bbsIdx }"/></td>
					<%-- <td><c:out value="${ (totalCount-(currentPage-1)*pageScale-i)+1 }"/></td> --%>
					<td><a href="read.jsp?num=${ data.num }"><c:out value="${ data.subject }"/></a></td>
					<td><c:out value="${ data.writer }"/></td>
					<td><c:out value="${ data.e_year }-${ data.e_month }-${ data.e_date }"/></td>
					<td><c:out value="${ data.w_date }"/></td>
					<c:set var="bbsIdx" value="${ bbsIdx-1 }"/>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div id="diaryIndexList">
		<c:out value="${ indexList }" escapeXml="false"/>
		</div>
		
		<div id="diarySearch">
		<form action="list.jsp" method="post" id="searchFrm" name="searchFrm">
			<select name="fieldName" class="inputBox" id="fieldName">
				<option value="subject"${ param.fieldName eq 'subject' ?" selected='selected'" : "" }>제목</option>
				<option value="content"${ param.fieldName eq 'content' ?" selected='selected'" : "" }>내용</option>
				<option value="writer"${ param.fieldName eq 'writer' ?" selected='selected'" : "" }>작성자</option>
			</select>
			<input type="text" name="keyword" class="inputBox" style="width:150px" id="keyword" value="${ param.keyword }"/>
			<input type="button" value="검색" id="searchBtn" class="btn" style="width:30px;"/>
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