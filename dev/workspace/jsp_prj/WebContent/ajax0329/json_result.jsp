<%@page import="org.json.simple.JSONObject"
%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%><%
	
  String name="김정윤";
  int age = 30;
    
  JSONObject jsonObj = new JSONObject();
    
  jsonObj.put("name", name);
  jsonObj.put("age", age);
  
  out.println(jsonObj.toJSONString());
%>
