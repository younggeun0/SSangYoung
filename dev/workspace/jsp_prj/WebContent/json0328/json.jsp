<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	String name = "오영근";
	int age = 30;
%>
{ "name":"<%= name %>", "age": <%=age %> }<br/><br/>
 --%>
<%-- <%
	// 1. 객체 생성
	JSONObject jo = new JSONObject();
	
	// 2. 값 할당
	jo.put("key1", 10);
	jo.put("key2", false);
	jo.put("key3", "value3");
	
	// 3. JSON 객체가 가진 값을 문자열로 생성
	
	String jsonObjString = jo.toJSONString();
%>

<%= jsonObjString %>
 --%>


<%-- <%
	String name="오영근";
	int age = 30;
	
	JSONObject json = new JSONObject(); // { }
	json.put("name", name); // { "name":"오영근" }
	json.put("age", age); // { "name":"오영근", "age",30 }
	
	out.println(json.toJSONString());	
%> --%>

<%
	String[] nameArr={"김정윤","김희철","박영민","노진경"};
	int[] ageArr = {30,28,27,32};
%>

<%-- <%
	JSONArray jsonArr = new JSONArray();

	JSONObject jsonObj = null;
	for(int i=0; i<nameArr.length;i++) {
		// 배열이 존재한다면 JSONObject를 생성
		jsonObj = new JSONObject();
		
		jsonObj.put("name", nameArr[i]);
		jsonObj.put("age", ageArr[i]);
		
		// 생성된 JSONObject를 JSONArray에 추가
		jsonArr.add(jsonObj);
	}
	
	out.println(jsonArr.toJSONString());
%> --%>

[
<%
	for(int i=0; i<nameArr.length;i++) {
		if (i != 0) {
			out.println(",");
		}
	%>
		{"name":"<%= nameArr[i] %>","age":<%= ageArr[i] %>}
	<%
		/* i++;
		if (nameArr.length != i) { // 마지막 콤마 없애기
			out.println(",");
		} */
	}
%>
]


<%-- <%
	// 1. JSON Array 생성
	JSONArray jsonArr = new JSONArray();

	// 2. 값 할당 (JSON Object)
	JSONObject jo1 = new JSONObject();
	jo1.put("이름1-1", "값1");
	jo1.put("이름1-2", "값2");

	jsonArr.add(jo1);
	
	JSONObject jo2 = new JSONObject();
	jo2.put("이름2-1", "값1");
	jo2.put("이름2-2", "값2");
	
	// 값이 순차적으로 들어가지 않음
	jsonArr.add(jo2);
	
	out.println(jsonArr.toJSONString());
%> --%>