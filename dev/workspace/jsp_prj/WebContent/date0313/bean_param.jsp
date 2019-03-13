<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="Web Parameter를 useBean action tag로 처리하는 방법"%>
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
	
	<% request.setCharacterEncoding("UTF-8"); // POST방식으로 전달되는 값 한글처리 %>
	<!-- HTML Form Control의 값 받기 -->
	<!-- 1.Java Bean 생성 -->
	<jsp:useBean id="bp_vo" class="date0313.BeanParamVO" scope="page" />
	
	<!-- 2.setter method를 호출하여 값 저장 -->
	<jsp:setProperty property="*" name="bp_vo"/>
	<table>
		<tr>
			<td colspan="2">입력한신 정보는 아래와 같습니다.</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><jsp:getProperty property="id" name="bp_vo"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><jsp:getProperty property="name" name="bp_vo"/></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><!-- 숫자로 변환되어 저장된 값 -->
				<jsp:getProperty property="b_year" name="bp_vo"/>-
				<jsp:getProperty property="b_month" name="bp_vo"/>-
				<jsp:getProperty property="b_day" name="bp_vo"/>
				(만 <%= 2019-bp_vo.getB_year() %>세)
			</td>
		</tr>
		<tr>
			<td>관심 언어</td>
			<td>
			<%
				String[] lang = bp_vo.getInterestlang();
				if (lang != null) {
					for(int i=0; i<lang.length; i++) {
						out.print(lang[i]);
						out.println(" ");
					}
				} else {
					out.println("관심 언어 없음..");
				}
			%>
			</td>
		</tr>
	</table>	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>