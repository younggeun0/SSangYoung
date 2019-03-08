<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	td:hover { background-color: limegreen; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	$(".val").click(function() {
		alert($(this).lastchildren().val());
	});
	
	var d = new Date();
	var time = "";
	
	time += d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
	
	$("#clientTime").text(time);
	
	$("#btnDate").click(function() {
		$("#serverTime").fadeOut(3000);
	});
});

</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	
		<br/><br/>
		
<!-- 년-월-일요일 시:분을 서버의 시간으로 얻어와서 
	흘러가는 문자열로 보여주세요.
	버튼을 클릭하면 일자가 3초동안 서서히 사라지도록 만들 것
-->
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
	String date = sdf.format(new Date());
%>

<div>
	서버 시간 : <span id="serverTime"><%=date%></span><br/>
	접속자 시간 : <span id="clientTime"></span>
</div>
<input type="button" value="클릭" id="btnDate"/>
		
		
		
		
		<br/><br/>
			
		<table border="1">
		<% for(int j=1; j<10; j++) { %>
			<tr>
				<% for(int k=2; k<10; k++) { %>
				<%-- <td class="val" width="40" align="center" onclick="alert('<%=k*j%>')" > --%>
				<td class="val" width="40" align="center">
					<%=k %>x<%=j %>
					<input name="sum" type="hidden" value="<%=k*j%>">
				</td>
				<%} %>
			</tr>
		<%} %>
		</table>
		
		<br/><br/>
	
		<%
			// scriptlet은 _jspService method내에 코드가 생성된다.
			int i=3; // 지역변수 : 자동 초기화가 되지 않는다.
		%>
		<%= i %>
		<% for(int j=1; j<7; j++) { %><!-- scriptlet은 한줄로도 많이 쓴다. --> 
				<h<%=j %>>오늘은 불금입니다.</h<%=j %>>
		<%}%>
	
		<%
			String[] names = { "노지견", "김정윤", "박영민", "김희철", "박소영", "이지수" };
		%>
	
		<table border='1'>
			<tr>
				<th width="100">이름</th>
			</tr>
			<%for(int j=0; j<names.length; j++){ %>
			<tr>
				<td><%=names[j] %></td>
			</tr>
			<%} %>
		</table>
		
		<!-- 1~100까지 합만 출력하는 scriptlet -->
		<%! int sum = 0; %>
		<% for(int k=1;k<101;k++) {
		   	sum += k; 
			 }
		%>
		<h1>1~100 합 : <%=sum %></h1>
		
		
		<!-- 구구단 3단 출력 -->
		<table border='1'>
		<% for(int k=1; k<9; k++) {%>
			<tr>
				<td>3*<%= k%>=<%=3*k %></td>
			</tr>
		<% } %>
		</table>
		
		<br/><br/>
		
		<table border='1'>
			<tr>
			<% for(int k=1; k<9; k++) {%>
				<td>3*<%= k%>=<%=3*k %></td>
			<% } %>
			</tr>
		</table>
				
		
		<br/><br/>
		
		
		
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>