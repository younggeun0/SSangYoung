<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@page import="kr.co.sist.exam.domain.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MyBatisService1 mbs = new MyBatisService1();

	String sal = request.getParameter("sal");
	
	if(sal != null) {
		List<Emp> list = mbs.greaterThan(Integer.parseInt(sal));
		pageContext.setAttribute("empList", list);
	}
%>
<form name="frm" action="main.jsp">
<label>연봉</label>
<input type="text" name="sal" class="inputBox"/>
<input type="hidden" name="page" value="date0405/greater_than"/>
<input type="submit" value="사원조회" class="btn"/>
</form>
<div>
<c:if test="${ not empty param.sal }">
	<div>
		${ param.sal } 보다 연봉을 많이 받는 사원 정보
	</div>
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
				<strong>${ param.sal }</strong>보다 적게 받는 사원은 존재하지 않습니다.
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