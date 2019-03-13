<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="localhost 또는 ip를 식별하여 다른 언어를 사용하는 페이지로 이동하는 일"
    %>
<%
	request.setCharacterEncoding("UTF-8");
	String ip = request.getRemoteAddr();
	String url = "eng.jsp";
	String lang = "English";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	String[] loc = {"서울","경기","강원","충청","경상","전라","제주"};
	request.setAttribute("loc",loc);
	
	if("0:0:0:0:0:0:0:1".equals(ip)) { // 한국어 페이지로 이동 
		url="kor.jsp";
		lang="한국어";
	}
%>
<%-- 이 페이지에서 생성한 파라미터가 없을 때 
	<jsp:forward page="<%= url %>"/>	
--%>
<%-- 이 페이지에서 생성한 파라미터가 있을 때 --%>
<%-- jsp액션태그안에 주석을 넣으면 500 에러발생 --%>
<jsp:forward page="<%= url %>">
	<jsp:param value="<%= lang %>" name="lang" />
	<jsp:param name="date" value="<%= sdf.format(new Date()) %>"/>
</jsp:forward>
