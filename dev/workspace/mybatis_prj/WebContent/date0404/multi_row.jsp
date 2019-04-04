<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MyBatisService mbs = new MyBatisService();

	List<Integer> deptnoList = mbs.multiRow();
	pageContext.setAttribute("deptnoList", deptnoList);
%>
<label>부서번호</label>
<select name="deptno">
	<c:forEach var="deptno" items="${ deptnoList }">
	<option value="${ deptno }"><c:out value="${ deptno }" escapeXml="false"/></option>	
	</c:forEach>
</select>