<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="Web Parameter 처리" %>
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
		// POST방식의 요청일 때 한글 처리
		request.setCharacterEncoding("UTF-8");
		String method = request.getMethod();
	%>
	<strong><%= method %></strong>
	<%
		// Web Parameter 받기(사용자가 HTML Form Control에 입력한 값 받기.)
		// Tomcat 8.X이상은 GET방식일 때 한글처리가 된다. 
		////////////// parameter name이 유일한 경우 => String으로 처리 /////////////////////////
		String name = request.getParameter("name"); // text
		String age = request.getParameter("age"); // password
		String mailing = request.getParameter("mailing"); // checkbox가 하나인 경우 체크 시 on, 체크 안할 시 null
		String gender = request.getParameter("gender"); // radio
		String addr = request.getParameter("addr"); // hidden
		String email = request.getParameter("email"); // select
		String greeting = request.getParameter("greeting"); // textarea
		
		////////////// parameter name이 중복된 경우 => String[]처리 /////////////////////////
		String[] hobby = request.getParameterValues("hobby");
	%>
	<div>
		<ul>
			<li>--- HTML Form Control에 name속성이 유일한 경우 ---</li>
			<li>이름 : <%=name %></li>
			<li>나이 : <%=age %></li>
			<li>메일링여부 : <%=mailing %></li>
			<li>성별 : <%=gender %></li>
			<li>주소 : <%=addr %></li>
			<li>이메일 : <%=email %></li>
			<li>가입인사 : <textarea style="width:300px; height:100px;"><%=greeting %></textarea></li>
			<li>가입인사 : <%=greeting.replaceAll("\n","<br/>") %></li>
			<li>--- HTML Form Control에 name속성이 중복된 경우 ---</li>
			<li>
			<% if(hobby != null) { // 취미 있음 
					for(int i=0; i<hobby.length; i++) {
						// 출력 내장객체 : out
						out.print(hobby[i]);
						out.println(" ");
					}
				} else { 
				  out.print("선택하신 취미가 없습니다.");
			  } %>
			</li>
		</ul>
	</div>
</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>