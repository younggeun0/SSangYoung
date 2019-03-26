<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URISyntaxException"%>
<%@page import="java.net.URI"%>
<%@page import="java.io.File"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.IOException"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="kr.co.sist.vo.DiaryDetailVO"%>
<%@page import="java.sql.SQLException"%>
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
	
<%!
public List<String> xmlParsing() throws IOException {
	
	List<String> list = new ArrayList<String>();

	BufferedReader br = null;
	
	try {
		// 1. XML과 연결
		
		File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/jsp_prj/WebContent/xml0326/names.xml");
		br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		
		String temp = "";
		String name = "";

		// 2. 줄단위로 읽어들인다.
		while((temp = br.readLine()) != null) {
			if (temp.contains("<name>")) { // 줄 단위로 읽어들인 내용에 '<name>' 이 있다면
				name = temp.substring(temp.indexOf(">")+1, temp.lastIndexOf("<"));
				
				list.add(name);
			}
		}
		
	} finally {
		if (br != null) { br.close(); }
	}
	
	return list;
}
%>


<br/><br/>

<table border="1">
<tr>
	<th width="100">이름</th>
</tr>	
<c:forEach var="name" items="<%= xmlParsing() %>">
<tr>
	<td style="text-align: center;"><c:out value="${ name }"/></td>
</tr>
</c:forEach>
</table>


	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>