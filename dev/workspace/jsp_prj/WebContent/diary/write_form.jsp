<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	session.setAttribute("writeFlag",false);
%>    
    
<div id="writeFrm">
<form action="diary.jsp" method="post" name="writeFrm">
<!-- post방식이므로 쿼리스트링에 pageFlag 파라미터를 전송 못함!! -->
<!-- 히든으로 해결 -->
<input type="hidden" name="pageFlag" value="write_process"/>
<input type="hidden" name="param_year" value="${ param.param_year }"/>
<input type="hidden" name="param_month" value="${ param.param_month }"/>
<table id="writeTab">
	<tr>
		<th colspan="2" style="text-align: center;">
			<span style="font-size: 20px;">이벤트 작성</span>
			<span style="float:right; padding:5px;">
				<a href="#void" id="btnCloseFrm"><img src="images/btn_close.png"/></a>
			</span>
		</th>
	</tr>
	<tr>
		<td style="width:80px;">제목</td>
		<td style="width:400px">
			<input type="text" name="subject" class="inputBox"
				style="width:350px;" id="subject"/>
		</td>
	</tr>
	<tr>
		<td style="width:80px;">내용</td>
		<td style="width:400px">
			<textarea name="content" id="summernote"></textarea> 
		</td>
	</tr>
	<tr>
		<td style="width:80px;">이벤트 일</td>
		<td style="width:400px">
			<input type="text" name="e_year" class="inputBox"
				style="width:40px;" readonly="readonly" value="${ param.param_year }"/>-
			<input type="text" name="e_month" class="inputBox"
				style="width:20px;" readonly="readonly" value="${ param.param_month }"/>-
			<input type="text" name="e_date" class="inputBox"
				style="width:20px;" readonly="readonly" value="${ param.param_date }"/>
		</td>
	</tr>
	<tr>
		<td style="width:80px;">작성자</td>
		<td style="width:400px">
			<input type="text" name="writer" id="writer" class="inputBox"
				style="width:120px;"/>
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
			<fmt:formatDate value="<%= new Date() %>" pattern="yyyy-MM-dd a EEEE HH:mm"/>
		</td>
	</tr>
	<tr>
		<td style="width:80px;">작성IP</td>
		<td style="width:400px">
			<%= request.getRemoteAddr() %>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="이벤트 작성" class="btn" id="btnWrite"/>
			<input type="button" value="닫기" class="btn" id="btnWriteClose"/>
		</td>
	</tr>
</table>
</form>
</div>