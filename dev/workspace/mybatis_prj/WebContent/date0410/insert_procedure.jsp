<%@page import="kr.co.sist.exam.vo.TestProcVO"%>
<%@page import="kr.co.sist.exam.domain.Car"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String empno = request.getParameter("empno");
	String ename = request.getParameter("ename");
	String sal = request.getParameter("sal");
	String job = request.getParameter("job");

	if(empno != null) {
		MyBatisService1 mbs = new MyBatisService1();
		TestProcVO tp = new TestProcVO(ename, job, "",
				Integer.parseInt(empno), Integer.parseInt(sal), 0);
		tp = mbs.insertProcedure(tp);
		
		pageContext.setAttribute("tp", tp);
	}
%>

<div style="margin-top:25px;">
<form action="main.jsp" method="get" id="frm">
<input type="hidden" name="page" value="date0410/insert_procedure"/>
	사원번호:
	<input type="text" name="empno" class="inputBox"/><br/>
	사원명:
	<input type="text" name="ename" class="inputBox"/><br/>
	직급:
	<input type="text" name="job" class="inputBox"/><br/>
	연봉:
	<input type="text" name="sal" class="inputBox"/><br/>
	<input type="submit" value="사원추가" class="btn"/>
</form>
</div>

<div style="margin-top:25px;">
	<c:if test="${ not empty param.empno }">
		<c:out value="${ tp.rowCnt }"/>건 수행 되었습니다.<br/>
		<c:out value="${ tp.msg }"/>
	</c:if>
</div>