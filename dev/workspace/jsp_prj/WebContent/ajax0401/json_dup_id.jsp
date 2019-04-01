<%@page import="org.json.simple.JSONObject"%>
<%@page import="ajax0401.WebMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");

	WebMemberService wms = new WebMemberService();
	JSONObject json = wms.searchId("asdf");
	out.println(json.toJSONString());
%>