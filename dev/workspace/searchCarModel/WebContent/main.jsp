<%@page import="domain.CarDomain"%>
<%@page import="java.util.List"%>
<%@page import="service.CarService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String country = request.getParameter("country");
	String maker = request.getParameter("maker");
	String model = request.getParameter("model");

	if(country == null || "".equals(country)) {
		country="국산";
	}
	
	if(maker == null || "".equals(maker)) {
		maker="현대";
	}
	
	CarService cs = new CarService();
	List<String> makerList = cs.searchCarMaker(country);
	List<String> modelList = cs.searchCarModel(maker);
	
	if (model != null) {
		List<CarDomain> carList = cs.searchCarDetail(model);
		pageContext.setAttribute("carList", carList);
	}
	
	pageContext.setAttribute("makerList", makerList);
	pageContext.setAttribute("modelList", modelList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자동차 조회</title>
<style type="text/css">
	#wrap { margin:0px auto; width:500px; height:400px;}
	#selectCarDiv { margin-top:50px; text-align:center; height:60px; }
	#resultDiv { height:440px; text-align:center;	}
	#carTab { width:500px; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#country").change(function() {
			location.href="main.jsp?country="+$("#country").val();
		});
		
		$("#maker").change(function() {
			location.href="main.jsp?country="+$("#country").val()+"&maker="+$("#maker").val();
		});
		
		$("#btn").click(function() {
			location.href="main.jsp?country="+$("#country").val()+"&maker="+$("#maker").val()
					+"&model="+$("#model").val();
		});
	}); 
</script>
</head>
<body>
<div id="wrap">
	<div id="selectCarDiv">
		<label><strong>제조국 : </strong></label>
		<select id="country">
			<option value="국산" ${ param.country eq '국산' ? 'selected="selected"' : '' }>국산</option>
			<option value="수입" ${ param.country eq '수입' ? 'selected="selected"' : '' }>수입</option>
		</select>
		&nbsp;&nbsp;
		<label><strong>제조사 : </strong></label>
		<select id="maker">
		<c:if test="${ empty makerList }">
			<option>결과없음</option>
		</c:if>
		<c:forEach items="${ makerList }" var="maker">
			<option value="${ maker }" ${ maker eq param.maker ? 'selected="selected"' : '' }><c:out value="${ maker }"/></option>
		</c:forEach>
		</select>
		&nbsp;&nbsp;
		<label><strong>모델명 : </strong></label>
		<select id="model">
		<c:if test="${ empty modelList }">
			<option>결과없음</option>
		</c:if>
		<c:forEach items="${ modelList }" var="model">
			<option value="${ model }" ${ model eq param.model ? 'selected="selected"' : '' }><c:out value="${ model }"/></option>
		</c:forEach>
		</select>
		<input type="button" value="조회" id="btn"/>
	</div>
	<div id="resultDiv">
		<c:if test="${ not empty carList }">
			<table id="carTab">
				<tr>
					<th width="80">이미지</th>
					<th width="300">옵션</th>
					<th width="120">연식</th>
					<th width="100">가격</th>
				</tr>
				<c:forEach var="car" items="${ carList }">
					<tr>
						<td><img src="http://localhost:8080/searchCarModel/car_images/${ car.carImg }" width="80" height="60"/></td>
						<td><c:out value="${ car.carOption }"/></td>
						<td style="text-align:center"><c:out value="${ car.cc }"/></td>
						<td style="text-align:center"><c:out value="${ car.price }"/></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${ empty carList }">
			조회된 결과가 없거나 조회버튼을 누르지 않았습니다.
		</c:if>
	</div>
</div>

</body>
</html>