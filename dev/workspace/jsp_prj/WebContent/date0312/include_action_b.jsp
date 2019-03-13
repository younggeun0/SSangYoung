<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="내부 JSP의 페이지 지시자"
    %>
<div>
	<% String msg = "오늘은 미세먼지 없는 깨끗한 공기"; %>
	<img src="../common/images/img.png"/>
	<br/>
	내부 JSP
	<%= msg %>
</div>