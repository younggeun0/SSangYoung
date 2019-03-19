<%@page import="org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#container { width:800px; height:600px; }
	#footer { width:800px; height:120px; }
	#footerTitle { float:right; font-weight:bold; font-size:15px; padding-top:20px; padding-right:20px }
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<div id="headerTitle">SIST Class4</div>
	</div>
	<div id="container">
	<br/><br/>

<!--  enctype="multipart/form-data"인 경우 parameter를 받을 수 없다 -->
<%-- <% request.setCharacterEncoding("UTF-8"); %>
이름 : <%= request.getParameter("uploader") %><br/>
나이 : <%= request.getParameter("age") %><br/> --%>
	
<%
	request.setCharacterEncoding("UTF-8"); // POST방식 한글처리
	// 파일업로드에 적합한 요청인지 확인
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	if(isMultipart) { // 파일 업로드에 적합한 요청
		File repository = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/jsp_prj/WebContent/upload");
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 업로드 파일이 메모리에 저장되는 최대 크기
		factory.setSizeThreshold(1024*1024*1); // 1mb씩 끊어 저장 
		factory.setRepository(repository); // 저장될 위치

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 업로드 파일의 최대 크기 설정
		upload.setSizeMax(1024*1024*5); // 5mb까지 저장

		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			String uploader = "", age="";
			String fieldName = "", fileName = "", contentType="";
			long sizeInBytes = 0;
			
			while (iter.hasNext()) {
		    FileItem item = iter.next();
	
		    if (item.isFormField()) { // 일반 HTML Form 컨트롤인지? <input type="file"이 아닌 것
		    	// Process a regular form field
		    	if (item.isFormField()) {
	    	    String controlName = item.getFieldName();
	    	    String controlValue = item.getString();
	    	    if ("uploader".equals(controlName)) { // 파라미터 처리가 까다로움
	    	    	uploader = HangulConv.toUTF(controlValue);
	    	    }
	    	    if ("age".equals(controlName)) {
	    	    	age = controlValue;
	    	    }
		    	}
		    } else { // File Upload Control인지? <input type="file"
		    	// File Control명, 여러 type="file" 존재 시 구분하기 위해 사용
	 		    fieldName = item.getFieldName(); // upfile
	 		    fileName = item.getName(); // File Control 값
	 		    contentType = item.getContentType(); // 업로드 파일의 종류
	 		    sizeInBytes = item.getSize(); // 크기
	 		    
	 		    File selectFile = new File(fileName);
	 		    File uploadedFile = new File(repository.getAbsoluteFile()+"/"+selectFile.getName()); // 업로드파일의 저장경로와 파일명 설정
	 		    item.write(uploadedFile); // 설정된 파일을 업로드
		    }
			}
	
			%>
			파일업로드 성공<br/>
			업로더명 : <%=uploader %><br/>
			연령대 : <%=age %><br/>
			업로드 파일명 : <%=fileName %><br/>
			크기 : <%=sizeInBytes %><br/>
			<a href="upload_form.jsp">업로드</a><br/>
			<a href="file_list.jsp">파일리스트</a><br/>
			<%
		
		} catch(SizeLimitExceededException slee) {
			out.println("예외");
		}
		
	} else {
		// 파일 업로드에 부적합한 요청(GET방식 요청 시)
		response.sendRedirect("upload_form.jsp");
	}
%>
	
	
	
	
	
	
	
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class4 </div>
	</div>
</div>
</body>
</html>