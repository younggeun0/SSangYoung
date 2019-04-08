<%@page import="kr.co.sist.exam.domain.EmpJoin"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String mgr = request.getParameter("mgr");

	if(mgr != null) {
		int intMgr = Integer.parseInt(mgr);
		MyBatisService1 mbs = new MyBatisService1();
		List<EmpJoin> list = mbs.join(intMgr);
		
		pageContext.setAttribute("empList", list);
	}
%>
<div>
	<c:set var="mgr" value="7566,7698,7839,7902,7788"/>
	<c:forTokens var="mgr" items="${ mgr }" delims="," >
		[<a href="main.jsp?page=date0408/join&mgr=${ mgr }">
			<c:out value="${ mgr }"/>
		</a>]
	</c:forTokens>
</div>
<div>
	<table border="1">
		<tr>
			<th width="60">사원번호</th>
			<th width="100">사원명</th>
			<th width="80">연봉</th>
			<th width="150">입사일</th>
			<th width="60">부서번호</th>
			<th width="100">부서명</th>
			<th width="80">위치</th>
		</tr>
		<c:if test="${ empty empList }">
			<tr>
				<td colspan="7">조회된 결과가 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach items="${ empList }" var="emp">
			<tr>
				<td><c:out value="${ emp.empno }"/></td>
				<td><c:out value="${ emp.ename }"/></td>
				<td><c:out value="${ emp.sal }"/></td>
				<td><c:out value="${ emp.hiredate }"/></td>
				<td><c:out value="${ emp.deptno }"/></td>
				<td><c:out value="${ emp.dname }"/></td>
				<td><c:out value="${ emp.loc }"/></td>
			</tr>
		</c:forEach>
	</table>
</div>