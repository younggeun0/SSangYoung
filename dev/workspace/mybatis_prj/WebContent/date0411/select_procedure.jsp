<%@page import="kr.co.sist.exam.domain.EmpProcedure"%>
<%@page import="kr.co.sist.exam.vo.CursorVO"%>
<%@page import="kr.co.sist.exam.vo.TestProcVO"%>
<%@page import="kr.co.sist.exam.domain.Car"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String deptno = request.getParameter("deptno");

	if(deptno != null && !"".equals(deptno)) {
		MyBatisService1 mbs = new MyBatisService1();
		CursorVO cv = new CursorVO();
		cv.setDeptno(Integer.parseInt(deptno));
		
		mbs.selectProcedure(cv);
		
		pageContext.setAttribute("empList", cv.getEmpList());
	}
%>
<form name="frm" action="main.jsp">
<input type="hidden" name="page" value="date0411/select_procedure"/>
<label>부서번호</label>
<input type="text" name="deptno" class="inputBox"/>
<input type="submit" value="부서별 사원조회" class="btn"/>
</form>
<div>
<c:if test="${ not empty param.deptno }">
	<table border="1">
		<tr>
			<th width="80">번호</th>
			<th width="80">사원번호</th>
			<th width="120">사원명</th>
			<th width="80">연봉</th>
			<th width="80">부서번호</th>
			<th width="150">부서명</th>
			<th width="100">지역</th>
		</tr>
		<c:if test="${ empty empList }">
		<tr>
			<td colspan="6" align="center">
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
			<td><c:out value="${ emp.sal }"/></td>
			<td><c:out value="${ emp.deptno }"/></td>
			<td><c:out value="${ emp.dname }"/></td>
			<td><c:out value="${ emp.loc }"/></td>
		</tr>
		</c:forEach>
	</table>
</c:if>
</div>