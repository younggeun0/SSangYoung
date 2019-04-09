<%@page import="kr.co.sist.exam.domain.DynamicEmp"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.vo.TableName"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String tname=request.getParameter("tname");
 	if (tname != null) {
 		MyBatisService1 mbs = new MyBatisService1();
 		List<DynamicEmp> list = mbs.dynamicTable(new TableName(tname));
 		pageContext.setAttribute("tname", tname);
 		pageContext.setAttribute("empList", list);
 	}
%>
<form action="main.jsp" method="get">
	<input type="hidden" name="page" value="date0409/dynamic_table"/>
	<input type="radio" name="tname" value="cp_emp2" ${ tname eq 'cp_emp2' or empty tname ? 'checked="checked"' : "" }/>한국본사
	<input type="radio" name="tname" value="emp" ${ tname eq 'emp' ? 'checked="checked"' : "" } />미국지사
	<input type="submit" value="조회" class="btn"/>
</form>
<c:if test="${ not empty empList }">
	<table>
	<tr>
		<th colspan="4">
			<c:out value="${ param.tname eq 'emp' ? '미국지사' : '한국본사' }"/>의
			사원정보 조회 결과
		</th>
	</tr>
	<tr>
		<th width="80">사원번호</th>
		<th width="120">사원명</th>
		<th width="80">연봉</th>
		<th width="150">입사일</th>
	</tr>
	<c:if test="${ empty empList }">
	<tr>
		<td colspan="4" style="text-align:center;">
			사원이 존재하지 않습니다.
		</td>
	</tr>
	</c:if>
	<c:forEach var="emp" items="${ empList }">
	<tr align="center">
		<td><c:out value="${ emp.empno }"/></td>
		<td><c:out value="${ emp.ename }"/></td>
		<td><c:out value="${ emp.sal }"/></td>
		<td><c:out value="${ emp.hiredate }"/></td>
	</tr>
	</c:forEach>
	</table>
</c:if>