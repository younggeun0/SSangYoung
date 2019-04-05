<%@page import="kr.co.sist.exam.vo.EmpVO"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@page import="kr.co.sist.exam.domain.Emp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String deptno = request.getParameter("deptno");
	String job = request.getParameter("job");
	
	if(deptno != null && job != null) {
		MyBatisService1 mbs = new MyBatisService1();
		EmpVO ev = new EmpVO(Integer.parseInt(deptno), job);
		List<Emp> empList = mbs.multiParam(ev);
		pageContext.setAttribute("empList",empList);
	}
%>
<form name="frm" action="main.jsp">
<label>부서번호</label>
<c:set var="deptno" value="10,20,30,40"/>
<c:forTokens items="${ deptno }" delims="," var="deptno">
	<input type="radio" name="deptno" value="${ deptno }" ${ deptno eq param.deptno ? "checked='checked'" : "" }/>
	<c:out value="${ deptno }" escapeXml="false"/>
</c:forTokens>
<br/>
<label>직무</label>
<c:set var="job" value="ANALYST,CLERK,MANAGER,SALESMAN,PRESIDENT"/>
<c:forTokens items="${ job }" delims="," var="job">
	<input type="radio" name="job" value="${ job}" ${ job eq param.job ? "checked='checked'" : "" }/>
	<c:out value="${ job }" escapeXml="false"/>
</c:forTokens>
<input type="hidden" name="page" value="date0405/multi_param"/><br/>
<input type="submit" value="부서별 사원조회" class="btn"/>
</form>
<div>
<c:if test="${ not empty param.deptno }">
	<table border="1">
		<tr>
			<th width="40">번호</th>
			<th width="80">사원번호</th>
			<th width="120">사원명</th>
			<th width="80">매니저번호</th>
			<th width="80">연봉</th>
			<th width="150">입사일</th>
			<th width="100">직무</th>
		</tr>
		<c:if test="${ empty empList }">
		<tr>
			<td colspan="7" align="center">
				<strong>${ param.deptno }</strong>번 부서에는 사원이 존재하지 않습니다.
			</td>
		</tr>
		</c:if>
		<c:forEach var="emp" items="${ empList }">
		<c:set var="i" value="${ i+1 }"/>
		<tr>
			<td><c:out value="${ i }"/></td>
			<td><c:out value="${ emp.empno }"/></td>
			<td><c:out value="${ emp.ename }"/></td>
			<td><c:out value="${ emp.mgr }"/></td>
			<td><c:out value="${ emp.sal }"/></td>
			<td><c:out value="${ emp.hiredate }"/></td>
			<td><c:out value="${ emp.job }"/></td>
		</tr>
		</c:forEach>
	</table>
</c:if>
</div>