<%@page import="org.json.simple.JSONObject"%>
<%@page import="date0328.JsonService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String deptno = request.getParameter("deptno");

	if (deptno == null) {
		deptno = "10";
	}
	
	int intDeptno = Integer.parseInt(deptno);
	JsonService jsonService = new JsonService();
	
	JSONObject jsonObj = jsonService.searchEmpData(intDeptno);
	
	out.println(jsonObj.toJSONString());
%>
