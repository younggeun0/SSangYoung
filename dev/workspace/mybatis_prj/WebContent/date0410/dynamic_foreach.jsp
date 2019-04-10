<%@page import="kr.co.sist.exam.domain.Car"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] makerArr = request.getParameterValues("maker");

	MyBatisService1 mbs = new MyBatisService1();
	List<Car> list = mbs.dynamicForEach(makerArr);
	
	pageContext.setAttribute("carList", list);
%>

<div style="margin-top:25px;">
<form action="main.jsp" method="get" id="frm">
<input type="hidden" name="page" value="date0410/dynamic_foreach"/>
	<c:set var="maker" value="현대,기아,삼성,쌍용,BMW,BENZ,AUDI"/>
	제조사 선택
	<c:forTokens items="${ maker }" delims="," var="maker">
		<input type="checkbox" value="${ maker }" name="maker"/>
		<c:out value="${ maker }" escapeXml="false"/>
	</c:forTokens>
	<input type="submit" value="조회"/>
</form>
</div>

<div style="margin-top:25px;">
	<table style="border-top:2px solid #333; border-bottom:1px solid #333; margin:0px auto;">
		<tr>
			<th width="80">이미지</th>
			<th width="400">차량정보</th>
			<th width="150">등록일</th>
		</tr>
		<c:if test="${ empty carList }">
		<tr>
			<td colspan="3" style="text-align:center;">등록된 차량이 존재하지 않습니다..</td>
		</tr>
		</c:if>
		<c:forEach var="car" items="${ carList }">
		<tr>
			<td><img src="http://localhost:8080/mybatis_prj/date0409/images/<c:out value="${ car.img }"/>" style="width:80px; height:60px;"/></td>
			<td>
				<div>
					<c:out value="${ car.maker }"/> <c:out value="${ car.model }"/>
				</div>
				<div>
					<c:out value="${ car.carYear }"/>년식 <c:out value="${ car.price }"/>
				</div>
				<div>
					<c:out value="${ car.carOption }"/>
				</div>
			</td>
			<td><c:out value="${ car.hiredate }"/></td>
		</tr>
		</c:forEach>
	</table>
</div>