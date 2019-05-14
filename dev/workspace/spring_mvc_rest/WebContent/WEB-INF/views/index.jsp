<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$("#put").click(function() {
			
$.ajax({
	url:"method/put/blablah",
	type:"put",
	dataType:"json",
	data:JSON.stringify({ name:'김정윤', age:31, job:'코잘잘' }),
	contentType:"application/json",
		error:function(xhr) {
			alert("코드 : "+xhr.status+", 메시지 : "+xhr.statusText);
			alert(xhr.responseText);
		},
		success:function(json) {
			alert(json.put);
			
			var output ="";
			
			output += "이름 : <strong>"+json.name+"</strong><br/>";
			output += "나이 : <strong>"+json.age+"</strong><br/>";
			output += "직업 : <strong>"+json.job+"</strong><br/>"
			
			$("#putView").html(output);
		}
});

		});
	}); // ready
</script>
</head>
<body>
<div id="wrap">
	<div id="container">




<!-- index.jsp -->
	
<a href="method/get/?name=nojinkyung">GET방식</a>
<form action="method/post" method="post">
	<input type="submit" value="post 전송"/>
</form>
<input type="button" id="put" value="put 전송"/>
	
<div id="putView"></div>	




	
	
	</div>
</div>
</body>
</html>