<%@page import="kr.co.sist.exam.domain.DynamicIf"%>
<%@page import="kr.co.sist.exam.vo.DeptNo"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@page import="kr.co.sist.exam.domain.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MyBatisService1 mbs = new MyBatisService1();

	String deptno = request.getParameter("deptno");
	
	if(deptno != null) {
		List<DynamicIf> list = mbs.dynamicChoose(new DeptNo(Integer.parseInt(deptno)));
		pageContext.setAttribute("empList", list);
	}
%>
<form name="frm" action="main.jsp">
<label>부서번호</label>
<input type="text" name="deptno" class="inputBox"/>
<input type="hidden" name="page" value="date0410/dynamic_choose"/>
<input type="submit" value="사원 조회" class="btn"/><br/>
* 10~30번 부서의 사원을 조회, 없는 부서번호가 입력되면 30번 부서 사원을 조회
</form>
<div>
<c:if test="${ not empty param.deptno }">
	<div>
		${ param.deptno } 번 부서 사원조회결과
	</div>
	<table border="1">
		<tr>
			<th width="80">번호</th>
			<th width="80">사원번호</th>
			<th width="120">사원명</th>
			<th width="80">부서번호</th>
			<th width="100">직무</th>
			<th width="150">입사일</th>
		</tr>
		<c:if test="${ empty empList }">
		<tr>
			<td colspan="6" align="center">
				입력하신 부서에는 부서가 존재하지 않거나 사원이 없습니다.
			</td>
		</tr>
		</c:if>
		<c:forEach var="emp" items="${ empList }">
		<c:set var="i" value="${ i+1 }"/>
		<tr>
			<td><c:out value="${ i }"/></td>
			<td><c:out value="${ emp.empno }"/></td>
			<td><c:out value="${ emp.ename }"/></td>
			<td><c:out value="${ emp.deptno }"/></td>
			<td><c:out value="${ emp.job }"/></td>
			<td><c:out value="${ emp.hiredate }"/></td>
		</tr>
		</c:forEach>
	</table>
</c:if>
</div>