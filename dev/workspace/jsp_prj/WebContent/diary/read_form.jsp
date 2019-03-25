<%@page import="java.io.IOException"%>
<%@page import="kr.co.sist.vo.DiaryDetailVO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="readFrm">
<%
	DiaryDAO d_dao = DiaryDAO.getInstance();
	
	try{
		int num = Integer.parseInt(request.getParameter("num"));
		DiaryDetailVO ddvo = d_dao.selectDetailEvent(num);
%>
<form action="diary.jsp" method="post" name="readFrm">
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
			<span style="float:right; padding:5px;">
				<a href="#void" id="btnCloseFrm"><img src="images/btn_close.png"/></a>
			</span>
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
			<textarea name="content" id="summernote">
				<%= ddvo.getContent() %>
			</textarea> 
		</td>
	</tr>
	<tr>
		<td style="width:80px;">이벤트 일</td>
		<td style="width:400px">
			<div id="evtDate">${ param.param_year }-${ param.param_month
				}-${ param.param_date }</div>
		</td>
	</tr>
	<tr>
		<td style="width:80px;">작성자</td>
		<td style="width:400px">
			<div id="writer"><strong><%= ddvo.getWriter() %></strong></div>
		</td>
	</tr>
	<tr>
		<td style="width:80px;">비밀번호</td>
		<td style="width:400px">
			<input type="password" name="pass" id="pass" class="inputBox"
				style="width:200px;"/>
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
			<input type="button" value="이벤트 수정" class="btn" id="btnUpdate"/>
			<input type="button" value="이벤트 삭제" class="btn" id="btnRemove"/>
			<input type="button" value="닫기" class="btn" id="btnWriteClose"/>
		</td>
	</tr>
</table>
</form>
<%
	} catch (IOException ie) {
%>
	<img src="images/construction.jpg" title="죄송합니다."/>
<%
	} catch (SQLException se) {
%>
	<img src="images/construction.jpg" title="죄송합니다."/>
<%
	}
%>
</div>

