<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");

	// HTML로 응답
	String[] temp = {""};
	if("이봉현".equals(name)) {
		temp="이재찬,정택성,백인재".split(",");
	} else if ("박영민".equals(name)){
		temp="김정윤,노진경,최지우,김희철".split(",");;
	} else if (("오영근").equals(name)) {
		temp="이재현,공선의,박정미,최혜원".split(",");;
	} else {
		temp="김건하,박소영".split(",");;
	}
%>
<table>
	<tr>
		<th width="80">번호</th>
		<th width="120">이름</th>
	<% for(int i=0; i < temp.length; i++) { %>
	</tr>
		<td><%= i+1 %></td>
		<td><%= temp[i] %></td>
	<tr>
	<% } %>
	</tr>
</table>