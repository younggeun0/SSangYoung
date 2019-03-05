package date0304;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GetCookie extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답방식 설정
		response.setContentType("text/html;charset=UTF-8");
		// 출력스트림 획득
		PrintWriter out = response.getWriter();
		
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
		out.write("#headerTitle{ font-family: HY견고딕, 고딕; font-size: 30px; font-weight: bold;text-align: center;\r\n");
		out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
		out.write("#container{  width:800px; height: 600px; }\r\n");
		out.write("#footer{  width:800px; height: 120px; }\r\n");
		out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
		out.write("#non_cookie{ color:#FF0000; font-size:15px; font-weight:bold; }\r\n");
		out.write("</style>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");
		
		// 접속자에게 심어진 쿠키 읽기
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			// Cookie가 있을 때
			
			Cookie temp = null;
			out.println("<ul>");
			for(int i=0; i<cookies.length; i++) {
				temp = cookies[i];
				out.print("<li>쿠키 이름 : <strong>");
				out.print(temp.getName());
				out.print("</strong> 쿠키 값 : ");
				out.print(temp.getValue());
				out.print("</li>");
			}
			out.println("</ul>");
			out.println("<div><a href='add_cookie'>쿠키 심기</a></div>");
			out.println("<div><a href='remove_cookie'>쿠키 삭제</a></div>");
		} else {
			// Cookie가 없을 때
			out.println("<div id='non_cookie'>쿠키가 존재하지 않습니다.</div>");
			out.println("<div><a href='add_cookie'>쿠키 심기</a></div>");
		}
		
		
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
