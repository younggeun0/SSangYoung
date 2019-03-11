<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="include 연습 "%>
    
<!-- 끼워지는 JSP에서는 코드가 들어가는 태그의 자식 태그로 들어가기 때문에 
	<html>은 가지지 않고 포함되는 태그로만 구성한다.
 -->

<%!
	public String today() {
		String today = "";
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd EEEE a HH:mm:ss");
		today = sdf.format(new Date());
	
		return today;
	}
%>
<% 
	// 끼워지는 모든 JSP에서의 공통코드를 정의
	int age = 30;
	String addr = "서울시 강남구 역삼동";
%>
<div>
	<strong>끼워지는 JSP</strong>
	나이 : <%=age %><br/>
	주소 : <%=addr %><br/>
</div>

