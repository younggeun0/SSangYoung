<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 응답 방식 설정
	response.setContentType("application/octet-stream"); // 8bit Stream

	// 2. 응답 헤더 설정, 저장할 파일명
	String data = request.getParameter("file_name");
	
	if (data == null || "".equals(data)) { // 전달된 file_name이 없으면 
		response.sendRedirect("file_list.jsp");
		return;
	}
	
	response.setHeader("Content-Disposition", "attachment;fileName="+
		URLEncoder.encode(data,"UTF-8")); // 한글파일명 처리
	
	// 3. FileStream을 연결
	File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/jsp_prj/WebContent/upload/"+data);
	FileInputStream fis = null;
	OutputStream os = null;
	
	try {
		if (file.exists()) { // 파일이 존재하는지
			fis = new FileInputStream(file);
		
			// 4. 파일 내용을 읽어들여 byte[]에 저장
			byte[] fileArr = new byte[(int)file.length()]; // 파일의 내용을 저장하기 위한 배열
			
			int read = 0, idx = 0;
			while((read = fis.read()) != -1) { // 읽어들일 내용이 있을 때까지
				fileArr[idx] = (byte)read;
				idx++;
			}
			
			// 5. 출력 스트림 초기화
			out.clear();	
			
			// 6. 현재 페이지의 내용으로 출력스트림을 변경
			out = pageContext.pushBody();
			
			// 7. 출력 스트림을 8bit Stream으로 재설정
			os = response.getOutputStream();
			
			// 8. 출력 스트림에 파일 내용을 기록
			os.write(fileArr);
			
			// 9. 분출
			os.flush();
		}
	} finally {
		if (fis != null) { fis.close(); }
		if (os != null) { os.close(); }
	}
%>