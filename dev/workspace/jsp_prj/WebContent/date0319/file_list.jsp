<%@page import="java.io.FileInputStream"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
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