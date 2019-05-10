<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.144/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://211.63.89.144/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
	
	#reply{ display: none; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#replyView").click(function(){
				var txt = $("#replyView").text();
				
				if(txt == "열기") {
					txt="접기";
				} else {
					txt="열기";
				}
				
				$("#replyView").text(txt);
				$("#reply").toggle();
		});
		
		$("#replyBtn").click(function() {
			var writer = $("[name='writer']").val();
			if(writer == "") {
				alert("작성자는 필수 입력항목입니다.");
				$("[name='writer']").focus();
				return;
			}

			var reply = $("[name='reply']").val();
			if(reply == "") {
				alert("댓글내용은 필수 입력항목입니다.");
				$("[name='reply']").focus();
				return;
			}
			
			var queryString = "num_ref="+$("[name='num_ref']").val()
					+"&content="+reply+"&writer="+writer;
			
			$.ajax({
				url:"add_reply.do",
				data:queryString,
				type:"get",
				dataType:"json",
				error:function(xhr) {
					alert("댓글작성 실패");
					console.log(xhr.status+" / "+xhr.statusText);
				},
				success:function(json) {
					if (json.result) {
						
						// <div>의 자식 노드로 작성한 값을 추가(append())
						// 자식노드 전에 추가(prepend())
						var date = new Date();
						var output = "<div style='margin-top:10px; border:1px solid #dfdfdf; width:600px;'>"
								+reply+"<br/>"+writer+"("+date.getFullYear()+"-"+(date.getMonth()+1)+"-"
								+date.getDate()+"</div>";
						$("#reply").prepend(output);
								
						alert("댓글이 정상적으로 등록되었습니다.");
						
						$("[name='writer']").val("");
						$("[name='reply']").val("");
					}
				}
			});
			
		});
	});
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
		<div style="padding-top:100px;">
		<c:import url="/common/diary/main_menu.jsp"></c:import>
		</div>
	</div>
	<div id="container">
	<br/><br/>
	

<div id="readFrm">
	<table id="readTab">
		<tr>
			<th colspan="2" style="text-align: center;">
				<span style="font-size: 20px;">이벤트 읽기</span>
			</th>
		</tr>
		<tr>
			<td style="width:80px;">제목</td>
		<td style="width:400px">
			<div id="subject" ><strong>${ searchData.subject }</strong></div>
		</td>
		</tr>
		<tr>
			<td style="width:80px;">내용</td>
			<td style="width:400px">
				${ searchData.content }
			</td>
		</tr>
		<tr>
			<td style="width:80px;">작성자</td>
			<td style="width:400px">
				<div id="writer"><strong>${ searchData.writer }</strong></div>
			</td>
		</tr>
		<tr>
			<td style="width:80px;">작성일</td>
			<td style="width:400px">
				<div id="wDate"><strong>${ searchData.w_date }</strong></div>
			</td>
		</tr>
		<tr>
			<td style="width:80px;">작성IP</td>
			<td style="width:400px">
				<div id="ip"><strong>${ searchData.ip }</strong></div>
			</td>
		</tr>
		<tr>
		<td colspan="2" align="center">
			<a href="#void" onclick="history.back();">리스트</a>
		</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>댓글</td>
			<td>
				<input type="text" name="reply" class="inputBox" placeholder="내용을 입력하세요" style="width:400px;"/>
			</td>
			<td>
				<input type="text" name="writer" class="inputBox" placeholder="작성자" style="width:100px;"/>
				<input type="button" value="쓰기" class="btn" id="replyBtn"/>
				<input type="hidden" name="num_ref" value="${ param.num }"/>
			</td>
		</tr>
	</table>
	<a href="#" id="replyView">열기</a>
	<div id="reply">
		<c:forEach var="reply" items="${ replyList }">
		<div style="margin-top:10px; border:1px solid #dfdfdf; width:600px;">
			<c:out value="${ reply.content }"/><br/>
			<c:out value="${ reply.writer }"/> / <c:out value="${ reply.input_date }"/>
		</div>
		</c:forEach>
	</div>
</div>



	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>