<%@page import="java.util.Random"%>
<%!
/**
	라디오버튼을 생성하는 method
	createRadio(라디오버튼개수, 라디오버튼이름, 기본체크값)
*/
	public String createRadio(int rCnt, String rName, int rDefault) {  
		StringBuilder radio = new StringBuilder();

		if(rCnt < rDefault) {
			rDefault = 0;
		}
		
		for(int i=0; i<=rCnt; i++) {
			radio.append("<input type='radio' name='").append(rName)
			.append("' value='").append(i).append("'");
			
			if (i == rDefault) {
				radio.append(" checked='checked'");
			}
			
			radio.append(">").append(i).append("점&nbsp;");
		}
		
		return radio.toString();
	}
%>    
    
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
	#nameTitle { width:100px; }
	#scoreTitle { width: 430px; }
	table { border-top:2px solid #333; }
	th { height:30px; }
	th, td { border-bottom: 1px dotted #4F4F4F; }
	td { text-align:center; }
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
	String[] names = { "공선의","김건하","이재찬","정택성","김희철" };
%>	
<table>
	<tr>
		<th id="nameTitle">이름</th>
		<th id="scoreTitle">점수</th>
	</tr>
	<% for(int i=0; i<names.length; i++) { %>
	<tr>
			<td><%=names[i] %></td>
			<td>
				<%= createRadio(2, "name_"+i, 3) %>
			</td>
	</tr>
	<%} %>
</table>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>