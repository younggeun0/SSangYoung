<%@page import="date0326.RssVO"%>
<%@page import="date0326.JtbcRssParsing"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URISyntaxException"%>
<%@page import="java.net.URI"%>
<%@page import="java.io.File"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.vo.DiaryDetailVO"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#container { width:800px; min-height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
	
	td {
		padding-left:3px;
	}
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
	
	
	<br/><br/>
	
	<div id="subject" style="text-align:center;">
	[ <a href="jtbc_rss.jsp?title=newsflash">속보</a>	|
	<a href="jtbc_rss.jsp?title=politics">정치</a> |	
	<a href="jtbc_rss.jsp?title=economy">경제</a>	|
	<a href="jtbc_rss.jsp?title=society">사회</a> |
	<a href="jtbc_rss.jsp?title=international">국제</a> |	
	<a href="jtbc_rss.jsp?title=culture">문화</a>	|
	<a href="jtbc_rss.jsp?title=entertainment">연예</a> |	
	<a href="jtbc_rss.jsp?title=sports">스포츠</a> |
	<a href="jtbc_rss.jsp?title=fullvideo">풀영상</a> |	
	<a href="jtbc_rss.jsp?title=newsrank">뉴스랭킹</a>	|
	<a href="jtbc_rss.jsp?title=newsroom">뉴스룸</a>	|
	<a href="jtbc_rss.jsp?title=morningand">아침&amp;</a> |	
	<a href="jtbc_rss.jsp?title=newssite">뉴스현장</a>	|
	<a href="jtbc_rss.jsp?title=politicaldesk">정치부회의</a> ]	
	</div>
	<div id="newsView">
	<%
		String rssName = request.getParameter("title");
	
		if (rssName == null) {
			rssName = "newsflash";
		}
	
		List<RssVO> list = JtbcRssParsing.getInstance().getNews(rssName);
		
		pageContext.setAttribute("newsList", list);
	%>
<c:if test="${ empty newsList }">
네트워크가 연결이 불안정합니다. 잠시 후 다시 시도해주세요.
</c:if>
<c:forEach var="news" items="${ newsList }">
<table style="border:1px solid #333; border-spacing:0px; margin:0px auto; margin-top:6px; ">
<tr>
	<td style="width:50px; text-align:center; border-right:1px solid #333;">제목</td>
	<td colspan="3" style="width:650px; text-align:center">
		<c:out value="${ news.title }" />
	</td>
</tr>
<tr>
	<td style="width:50px; text-align:center; border-right:1px solid #333;">링크</td>
	<td><a href="${ news.link }" target="_new">뉴스이동</a></td>
	<td style="width:50px; text-align:left;">작성일</td>
	<td><c:out value="${ news.pubDate }"/></td>
</tr>
<tr>
	<td style="width:50px; text-align:center; border-right:1px solid #333;">내용</td>
	<td colspan="3" style="width:650px;">
		<c:out value="${ news.description }" escapeXml="false"/>
	</td>
</tr>
</table>
</c:forEach>

	</div>
	
	

	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>