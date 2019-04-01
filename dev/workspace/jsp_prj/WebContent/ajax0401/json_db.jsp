<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="date0328.JsonService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String deptno = request.getParameter("deptno");
	
	JSONObject empData = null;
	try {
		int intDeptno = Integer.parseInt(deptno);
		JsonService js = new JsonService();
		empData = js.searchEmpData(intDeptno);
		
	} catch(NumberFormatException nfe) {
		// 성공하든 실패하든 무조건 JSON이 나와야 한다.
		empData = new JSONObject();
		empData.put("result",false);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		empData.put("pubDate", sdf.format(new Date()));
		empData.put("resultData",null);
	}
	out.println(empData.toJSONString());
%>