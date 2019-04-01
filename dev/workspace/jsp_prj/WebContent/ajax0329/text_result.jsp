<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	String name = request.getParameter("name");
	// 텍스트 응답(CSV)
	String temp = "";
	if("이봉현".equals(name)) {
		temp="이재찬,정택성,백인재";
	} else if ("박영민".equals(name)){
		temp="김정윤,노진경,최지우,김희철";
	} else if (("오영근").equals(name)) {
		temp="이재현,공선의,박정미,최혜원";
	} else {
		temp="김건하,박소영";
	}
%><%= temp %>