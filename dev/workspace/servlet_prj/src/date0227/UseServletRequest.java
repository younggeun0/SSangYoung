package date0227;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. HttpServlet 상속
@SuppressWarnings("serial")
public class UseServletRequest extends HttpServlet {

	// 2. 요청방식에 대한 처리 method Override
	// service method는 요청방식이 GET/POST 모두 처리
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 3. 응답방식 설정(MIME Type)
		resp.setContentType("text/html;charset=UTF-8");
		
		// 4. 출력 스트림 얻기
		PrintWriter out = resp.getWriter();
		
		/*String clientIp = req.getRemoteAddr();
		String[] blockIp = { "133","141","149","157","144","152" };
		
		boolean moveFlag = false;
		for(String ip : blockIp) {
			if (clientIp.endsWith(ip)) {
				moveFlag = true;
			}
		}
		
		if(moveFlag) {
			resp.sendRedirect("http://www.police.go.kr/main.html");
		}*/
		
		// 5. 출력 내용 작성
		out.write("<!DOCTYPE html>\r\n");
		out.write("<html>\r\n");
		out.write("<head>\r\n");
		out.write("<meta charset=\"UTF-8\">\r\n");
		out.write("<title>Insert title here</title>\r\n");
		out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v190130.css\"/>\r\n");
		out.write("<style type=\"text/css\">\r\n");
		out.write("#wrap{ margin:0px auto; width:800px; height: 860px;  }\r\n");
		out.write("#header{  width:800px; height: 140px; background: #FFFFFF url(http://localhost:8080/servlet_prj/common/images/header_bg.png) repeat-x;\r\n");
		out.write("\t\t\tposition: relative; }\r\n");
		out.write("#headerTitle{ font-family: HY견고딕, 고딕; color:white; font-size: 30px; font-weight: bold;text-align: center;\r\n");
		out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
		out.write("#container{  width:800px; height: 600px; }\r\n");
		out.write("#footer{  width:800px; height: 120px; }\r\n");
		out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
		out.write("</style>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");
		
		out.println("\t\t<ul>");
		
		out.print("\t\t\t<li><strong>요청 방식</strong> : ");
		out.print(req.getMethod());
		out.println("</li>");
		out.print("\t\t\t<li><strong>요청 URL</strong> : ");
		out.print(req.getRequestURL());
		out.println("</li>");
		out.print("\t\t\t<li><strong>요청 URI</strong> : ");
		out.print(req.getRequestURI());
		out.println("</li>");
		out.print("\t\t\t<li><strong>요청 프로토콜</strong> : ");
		out.print(req.getProtocol());
		out.println("</li>");
		out.print("\t\t\t<li><strong>요청 서버 이름</strong> : ");
		out.print(req.getServerName());
		out.println("</li>");
		out.print("\t\t\t<li><strong>요청 서버 포트</strong> : ");
		out.print(req.getServerPort());
		out.println("</li>");
		// Servlet Path는 Context Path를 제외한 하위 경로
		out.print("\t\t\t<li><strong>요청 서블릿 경로</strong> : ");
		out.print(req.getServletPath());
		out.println("</li>");
		out.print("\t\t\t<li><strong>접속자의 IP</strong> : ");
		out.print(req.getRemoteAddr());
		out.print(req.getRemoteHost());
		out.println("</li>");
		out.print("\t\t\t<li><strong>접속자의 PORT</strong> : ");
		out.print(req.getRemotePort());
		out.println("</li>");
		
		out.print("\t\t\t<li><strong>요청 Query String</strong> : ");
		out.print(req.getQueryString());
		out.println("</li>");
		out.print("\t\t\t<li><strong>Parameter 값 받기</strong> : ");
		out.print(req.getParameter("name"));
		out.println("</li>");
		
		out.print("\t\t\t<li><strong>이름이 같은 Parameter 값 받기</strong> : ");
		String[] ages = req.getParameterValues("age");
		if (ages != null) {
			for(String age : ages) {
				out.print(age+"살&nbsp;");
			}
		} else {
			out.print("나이 없음.");
		}
		out.println("</li>");
		
		out.print("\t\t\t<li><strong>Parameter의 이름받기</strong> : ");
		Enumeration<String> paramNames = req.getParameterNames();
		
		while(paramNames.hasMoreElements()) { // 파라미터 이름이 있다면
			out.print(paramNames.nextElement()+"&nbsp;"); // 값을 가져오고 다음 요소로 포인터를 이동
		}
		out.println("</li>");

		out.println("\t\t</ul>");
		out.println("\t\t<a href='use_request?name=young&age=30&name=geun&age=31'>GET 요청</a>");
		out.println("\t\t<form action='use_request' method='post'>");
		out.println("\t\t\t<input type='hidden' name='name' value='공선의' class='btn'>");
		out.println("\t\t\t<input type='hidden' name='age' value='28' class='btn'>");
		out.println("\t\t\t<input type='hidden' name='age' value='26' class='btn'>");
		out.println("\t\t\t<input type='submit' value='POST 전송' class='btn'>");
		out.println("\t\t</form>");
		
		out.write("\t\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"footer\">\r\n");
		out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
		out.write("\t</div>\r\n");
		out.write("</div>\r\n");
		out.write("\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
	}
}
