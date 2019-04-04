<%@page import="kr.co.sist.exam.domain.DeptInfo"%>
<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyBatisService mbs = new MyBatisService();

	DeptInfo di = mbs.deptInfo();
%>

10번 부서정보<br/>
부서명 : <strong><%= di.getDname() %></strong>
위치 : <strong><%= di.getLoc() %></strong>