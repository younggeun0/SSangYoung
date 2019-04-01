<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css"/>
<style type="text/css">
	#wrap { margin:0px auto; width:800px; height:860px; }
	#header { position:relative; width:800px; height:140px; background:#FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x; }
	#headerTitle { position:absolute; top:45px; left:280px; font-size:35px; font-family:monaco, HY견고딕, 고딕; font-weight:bold; color:white; }
	#container { width:800px; min-height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#btn").click(function() {
			var deptno = $("#deptno").val();
			
			if(deptno == "") {
				alert("부서번호는 필수 입력입니다.");
				$("#deptno").focus();
				return;
			}
			
			var queryString = "deptno="+deptno;
			
			$.ajax({
				url:"json_db.jsp",
				type:"get",
				data:queryString,
				dataType:"json",
				error:function(xhr) {
					alert(xhr.status());
				},
				success:function(jsonObj) {
					var result = jsonObj.result;
					
					if (result) {
						var output="<strong>"+deptno+"</strong>번 부서사원 조회 결과<br/>";
						var jsonArr=jsonObj.resultData;
						
						$.each(jsonArr, function(idx, jsonEmpData) {
							output+="<div style='margin-bottom:10px;'>"
								+"<table border='1'><tr><td width='100'>사원번호</td><td width='50'>"
								+jsonEmpData.empno+"</td><td width='120'>사원명</td><td width='120'>"
								+jsonEmpData.ename+"</td><td width='120'>입사일</td><td width='150'>"
								+jsonEmpData.hiredate+"</td></tr>"
								+"<tr><td width='80'>연봉</td><td>"+"<input type='text' name='sal' value='"
								+jsonEmpData.sal+"'/></td><td>직무</td><td colspan='3'>"
								+"<input type='text' name='job' value='"+jsonEmpData.job+"'/>"
								+"</td></tr></table></div>";
						});
						output+="데이터 생성일자 : "+jsonObj.pubDate+"<br/>";
						$("#empView").html(output);
					} else {
						var img="<img src='../common/images/sist_log.jpg'/>"
						img += "<br/>잘못된 입력값이거나 잠시 문제가 발생하였습니다.";
						$("#empView").html(img);
					}
				}
			});
		});
	}); // ready
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
		<div style="padding-top:100px;">
		<c:import url="http://localhost:8080/jsp_prj/diary/main_menu.jsp"></c:import>
		</div>
	</div>
	<div id="container">
	
<div>
	<label>부서번호:</label>
	<input type="text" name="deptno" id="deptno" class="inputBox"/>
	<input type="button" value="사원조회" id="btn" class="btn"/>
</div>
<div id="empView">
	
	</div>
	
	
	
	
	
	

	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>