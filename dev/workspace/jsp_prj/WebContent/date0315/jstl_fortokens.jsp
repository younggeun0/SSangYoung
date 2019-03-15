<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="for문과 StringTokenizer가 결합된 태그인 forTokens 사용"
    %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css">
<style type="text/css">
#wrap{ margin:0px auto; width: 800px; height:860px;}
#header{ width: 800px; height:140px;background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png); 
            position:relative;}
#headerTitle{ font-family: HY견고딕,고딕; font-size: 35px; font-weight: bold; text-align: center; 
               position: absolute; top:40px; left:290px}
#container{ width: 800px; height:600px; }
#footer{ width: 800px; height:120px;}
#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }
</style>
</head>
<body>
<div id="wrap">

<%
	String csvData = "Java SE,Java EE,DBMS.Oracle,HTML5,JavaScript,CSS3.jQuery";
	pageContext.setAttribute("csv", csvData);
%>

<ul>
	<c:forTokens var="data" items="${ csv }" delims=",.">
	<li><c:out value="${ data }"/></li>
	</c:forTokens>
</ul>

<%-- 	<%
		String csvData="Java SE,Java EE,DBMS.Oracle,HTML5,JavaScript,CSS3,JQuery";
		pageContext.setAttribute("csv", csvData);
	%>
	<ul>
	<c:forTokens var="data" items="${csv }" delims=",.">
		<li><c:out value="${data }"></c:out></li>
	</c:forTokens>
	
	</ul> --%>
	
</div>





















