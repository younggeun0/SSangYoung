<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] nameArr = {"김희철","김정윤","노진경","공선의"};
	String[] addrArr = {"서울시 동작구","서울시 역삼동","서울시 방화동","서울시 신정동"};
	int[] ageArr = {30,28,31,29};

	JSONArray jsonArr = new JSONArray();
	
	JSONObject jsonObj = null;
	for(int i=0; i<nameArr.length; i++) {
		jsonObj = new JSONObject();
		jsonObj.put("name", nameArr[i]);
		jsonObj.put("addr", addrArr[i]);
		jsonObj.put("age",ageArr[i]);
		
		jsonArr.add(jsonObj);
	}
	
	out.println(jsonArr.toJSONString());
%>
