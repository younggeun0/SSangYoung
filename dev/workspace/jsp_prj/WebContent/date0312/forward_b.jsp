<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="업무처리페이지에서 처리한 결과를 받아 화면을 구성하는 일" %>
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
	<%
		// 이전페이지에서 처리된 결과 받기
		String[] member = (String[])request.getAttribute("group3");
	%>
	<% 
		if (member == null) { 
		 	response.sendRedirect("forward_a.jsp");
		 	// sendRedirect는 아래줄의 코드를 실행한다. return으로 막아야 함.
		 	return;
		} 
	%>
		<table border="1">
		<tr>
			<th width="100">이름</th>
		</tr>
		<% for(int i=0; i<member.length; i++) { %>
		<tr>
			<td><%=member[i] %></td>
		</tr>
		<% } %>
		</table>
		
		<a href="forward_a.jsp?name=jungyun&age=30">parameter 요청</a>
		<!-- forward로 이동한 페이지에서 이전페이지의 Parameter를 사용할 수 있다. -->
		<br/>
		파라미터 이름 : <%=request.getParameter("name") %><br/>
		파라미터 나이 : <%=request.getParameter("age") %>
		
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>