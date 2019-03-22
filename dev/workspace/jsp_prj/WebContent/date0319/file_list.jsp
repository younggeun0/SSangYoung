<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
		<div style="padding-top:100px;">
		<c:import url="http://localhost:8080/jsp_prj/diary/main_menu.jsp"></c:import>
		</div>
	</div>
	<div id="container">
	<br/><br/>
	
<%
	File uploadDir = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/jsp_prj/WebContent/upload");
	File[] uploadedFiles = uploadDir.listFiles();
%>
<a href="upload_form.jsp">업로드</a><br/>
<table border='1'>
	<tr>
		<th width="60">번호</th>
		<th width="350">파일명</th>
		<th width="150">업로드 일시</th>
		<th width="120">크기</th>
	</tr>
	<%
	if (uploadedFiles.length != 0) {
		File temp = null;
		for(int i=0; i<uploadedFiles.length; i++) { 
			temp = uploadedFiles[i];
	%>
	<tr>
		<td><%=i+1 %></td>
		<!-- 한글파일명을 link로 전송할 때에는 encoding을 해줘야 값이 올바르게 전송된다. -->
		<!-- form태그로 넘길 때에는 브라우저에서 인코딩을 해주므로 개발자가 인코딩할 필요가 없다. -->
		<td><a href="download.jsp?file_name=<%=temp.getName()%>"><%=temp.getName() %></a></td>
		<td><%=new SimpleDateFormat("yyyy-MM-dd a HH:mm").format(temp.lastModified()) %></td>
		<td><%=new DecimalFormat("#,###,###,###,###").format(temp.length()) %> byte</td>
	</tr>
	<% } 
	} else {
		out.println("<tr><td colspan='4' align='center'>업로드된 파일이 존재하지 않습니다.</td></tr>");
	}
%>
</table>
	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>