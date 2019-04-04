<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyBatisService mbs = new MyBatisService();

	int deptno = 10;
	String dname = mbs.deptName(deptno);
%>

<%= deptno %>번 부서는 <strong><%=dname %></strong>입니다.