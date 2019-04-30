<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="spring_orm/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(spring_orm/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; min-height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
	#detailView { position: fixed; background-color:#FFFFFF; width:244px; height:200px; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var img="";
		$(".detailView").mousemove(function(evt) {
			$("#detailView").css({ top:(evt.clientY+5), left:(evt.clientX+5) });
			$("#detailView").show();
			alert($(this).children("input").val()); // hidden 태그 값 구하기(코드)
			
			$.ajax({
				url:"lunch_detail.do",
				dataType:"json",
				data:"lunch_code="+$(this).children("input").val(),
				type:"get",
				error:function(xhr) {
					alert("잠시 후에 다시 시도해주세요");
					console.log(xhr.status);
				},
				success:function(json) {
					alert(json.img+"/"+json.spec);
				}
			});
		});
		
		$(".detailView").mouseout(function() {
			img="";
			$("#detailView").hide();
		});
	}); // ready
</script>
</head>
<body>
<div id="wrap">
	<div id="container">
	<br/><br/>
	
	
	
<table>
	<tr>
		<th style="width:80px;">번호</th>
		<th style="width:123px;">이미지</th>
		<th style="width:250px;">도시락명</th>
		<th style="width:130px;">가격</th>
		<th style="width:180x;">입력일</th>
	</tr>
	<c:forEach var="lunch" items="${ lunchList }">
	<c:set var="i" value="${ i+1 }"></c:set>
		<tr>
			<td><c:out value="${ i }"/></td>
			<td class="detailView">
				<img src="http://localhost:8080/spring_orm/common/lunch_0430/${ lunch.img }"/>
				<input type="hidden" name="lunchCode" value="${ lunch.lunch_code }"/>
			</td>
			<td><c:out value="${ lunch.lunch_name }"/></td>
			<td><c:out value="${ lunch.price }"/></td>
			<td><c:out value="${ lunch.input_date }"/></td>
		</tr>
	</c:forEach>
	<c:if test="${ empty lunchList }">
		<tr>
			<td colspan="5" style="text-align:center">존재하는 데이터가 없습니다</td>
		</tr>
	</c:if>
</table>
<div id="detailView">
</div>
	
	
	
	
	
	
	
	
	
	
	


	
	</div>
</div>
</body>
</html>