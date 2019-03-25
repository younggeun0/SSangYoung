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
	#container { width:800px; height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
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
	
	
	
	
	<div id="readFrm">
		<%
			DiaryDAO d_dao = DiaryDAO.getInstance();
			
			try{
				int num = Integer.parseInt(request.getParameter("num"));
				DiaryDetailVO ddvo = d_dao.selectDetailEvent(num);
				
				if (ddvo == null) {
					throw new NullPointerException();
				}
		%>
		<form action="list.jsp" method="post" name="readFrm">
		<!-- post방식이므로 쿼리스트링에 pageFlag 파라미터를 전송 못함!! -->
		<!-- 히든으로 해결 -->
		<!-- pageFlag값은 수정,삭제에 따라 바뀜 -->
		<input type="hidden" name="pageFlag"/>
		<input type="hidden" name="num" value="<%= num %>"/>
		<!-- 다른 년월에서 유지하기 위한 Form Control -->
		<input type="hidden" name="param_year" value="${ param.param_year }"/>
		<input type="hidden" name="param_month" value="${ param.param_month }"/>
		<table id="writeTab">
			<tr>
				<th colspan="2" style="text-align: center;">
					<span style="font-size: 20px;">이벤트 읽기</span>
				</th>
			</tr>
			<tr>
				<td style="width:80px;">제목</td>
			<td style="width:400px">
				<div id="subject" ><strong><%= ddvo.getSubject() %></strong></div>
			</td>
			</tr>
			<tr>
				<td style="width:80px;">내용</td>
				<td style="width:400px">
					<%= ddvo.getContent() %>
				</td>
			</tr>
			<tr>
				<td style="width:80px;">작성자</td>
				<td style="width:400px">
					<div id="writer"><strong><%= ddvo.getWriter() %></strong></div>
				</td>
			</tr>
			<tr>
				<td style="width:80px;">작성일</td>
				<td style="width:400px">
					<div id="wDate"><strong><%= ddvo.getW_date() %></strong></div>
				</td>
			</tr>
			<tr>
				<td style="width:80px;">작성IP</td>
				<td style="width:400px">
					<div id="ip"><strong><%=ddvo.getIp() %></strong></div>(작성시 ip : <%= request.getRemoteAddr() %>)
				</td>
			</tr>
			<tr>
			<td colspan="2" align="center">
				<a href="#void" onclick="history.back();">글읽기</a>
			</td>
			</tr>
		</table>
		</form>
		<%
			} catch (IOException ie) {
		%>
			글의 내용을 읽어들이지 못했습니다.<br/>	
		<%
			} catch (NumberFormatException nfe) {
		%>
			유효하지 않은 파라미터가 입력되었습니다.<br/>	
		<%
			} catch (NullPointerException npe) {
		%>
			해당 글을 찾을 수 없습니다.<br/>	
		<%
			} catch (SQLException se) {
		%>
			<img src="images/construction.jpg" title="죄송합니다."/>
		<%
			}
		%>
	</div>
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>