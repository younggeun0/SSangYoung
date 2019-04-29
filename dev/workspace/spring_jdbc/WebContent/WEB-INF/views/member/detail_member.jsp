<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/spring_jdbc/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/spring_jdbc/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; min-height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnUpdate").click(function() {
			
			if($("#btnUpdate").val() == "수정") {
				var updateView = 
					"이름 : <input type='text' name='name' value='"+$('#name').text()+"'/><br/>"
					+"출신고 : <input type='text' name='highschool' value='"+$('#highschool').text()+"'/><br/>"
					+"지역 : <input type='text' name='loc' value='"+$('#loc').text()+"'/><br/>";
					
				$("#btnUpdate").val("수정실행");
				$("#view").html(updateView);
			} else {
				// 유효성 검증 후 submit
				document.frm.action='update_member.do';
				$("#frm").submit();
			}
		});
		
		$("#btnDelete").click(function() {
			if(confirm("[ "+$("#name").text()+" ] 회원을 삭제 하시겠습니까?")) {
				document.frm.action='delete_member.do';
				$("#frm").submit();
			}
		});
	});
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	<br><br>
	
	
	
	
	
<c:choose>
	<c:when test="${ empty detailMember }">
		<h2>조회된 회원이 존재하지 않습니다.</h2>
	</c:when>
	<c:otherwise>
		<form name='frm' id='frm' action='update_member.do' method='post'>
		<input type="hidden" name="num" value="${ param.num }"/>
		<div id="view">
			<table border="1" style="text-align:center;">
				<tr>
					<th colspan="3"><h2>상세 회원정보</h2></th>
				</tr>
				<tr>
					<td width="100">이미지</td>
					<td width="100">이름</td>
					<td width="100">
						<span id="name"><c:out value="${ detailMember.name }"/></span>
					</td>
				</tr>
				<tr>
					<td rowspan="4">
						<img id="img" src="/spring_jdbc/upload/${ detailMember.img }" style="width:100px; height:100px;"/>
					</td>
				</tr>
				<tr>
					<td>지역</td>
					<td><span id="loc"><c:out value="${ detailMember.loc }"/></span></td>
				</tr>
				<tr>
					<td>출신고</td>
					<td>
						<span id="highschool"><c:out value="${ detailMember.highschool }"/></span>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" onclick="history.back()" value="뒤로가기" class="btn"/>
					</td>
				</tr>
			</table>
		</div>
		<div>
			<input type="button" value="수정" id="btnUpdate"class="btn"/>
			<input type="button" value="삭제" id="btnDelete"class="btn"/>
		</div>
		</form>
	</c:otherwise>
</c:choose>	
	
	



	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>