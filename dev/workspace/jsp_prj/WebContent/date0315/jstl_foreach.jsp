<%@page import="date0313.TestVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="반복문 forEach의 사용"
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
		
		
<%-- <%
	List<String> list = new ArrayList<String>();
	
	list.add("Java SE");
	list.add("Java EE");
	list.add("DBMS");
	list.add("HTML");
	
	pageContext.setAttribute("list", list);
%>
 		
<ul>
	<c:forEach var="subject" items="${ list }">
	<li><c:out value="${ subject }"/></li>
	</c:forEach>
</ul> 		 --%>

<br/><br/>
  		
<%
	// List가 generic으로 VO를 가진 경우
	// forEach안에서 "변수명.getter명"으로 값 사용
	List<TestVO> voList = new ArrayList<TestVO>();

	voList.add(new TestVO("정윤",30));
	voList.add(new TestVO("희철",27));
	voList.add(new TestVO("재찬",27));
	voList.add(new TestVO("택성",27));
	
	pageContext.setAttribute("vl", voList);
%>

<table border="1">
	<thead>
	<tr>
		<th width="50">번호</th>
		<th width="150">이름</th>
		<th width="50">번호</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="data" items="${ vl }">
	<c:set var="cnt" value="${ cnt+1 }"/>
	<tr>
		<!--  XSS를 막기위해 c:out JSTL 사용 -->
		<td><c:out value="${ cnt }"/></td>
		<td><c:out value="${ data.firstName }"/></td>
		<td><c:out value="${ data.age }"/></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
  
   <%-- 	
   <%
    //List가 generic으로 vo를 가진 경우 사용
    //forEach안에서 "변수명.getter명" 
    List<TestVO> voList=new ArrayList<TestVO>();
    voList.add(new TestVO("정윤",30));
    voList.add(new TestVO("희철",27));
    voList.add(new TestVO("재찬",28));
    voList.add(new TestVO("택성",27));
    
    pageContext.setAttribute("vl",voList);
   %>
   <table border="1">
   <thead>
	<tr>
		<th width="50">번호</th>
		<th width="100">이름</th>
		<th width="50">나이</th>
	</tr>   
	</thead>
   	<tbody>
  	 <c:forEach var="data" items="${vl }">
 	 <c:set var="cnt" value="${cnt+1 }"/>
  	 <tr>
   		<td><c:out value="${cnt }"/></td><!--c:out==>xss막기위해  -->
   		<td><c:out value="${data.firstName }"/></td><!--c:out==>xss막기위해  -->
   		<td><c:out value="${data.age }"/></td><!--c:out==>xss막기위해  -->
   	</tr>
    </c:forEach>
   </tbody>
   </table>
    --%>
</div>

</body>
</html>













