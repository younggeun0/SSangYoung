package date0227;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.util.HangulConv;

/**
 * HTML Form Control의 값 받기
 * @author owner
 */
@SuppressWarnings("serial")
public class UseWebParameter extends HttpServlet {
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter();
		
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
		out.write("</style>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");
		
		// Parameter 값 받기 : Tomcat 8.0부터는 GET방식의 Parameter는 한글이 깨지지 않는다.
		String name = req.getParameter("name"); // text
		String age = req.getParameter("age"); // password
		String mailing = req.getParameter("mailing"); // checkbox
		String gender = req.getParameter("gender"); // radio
		String addr = req.getParameter("addr"); // hidden
		String email = req.getParameter("email"); // select
		String greeting = req.getParameter("greeting"); // textarea
		
		out.println("\t<div>");
		out.println("\t<h2>GET방식으로 요청한 파라미터 값 처리</h2>");
		out.println("\t<div>");
		out.println("\t\t<ul>");
		
		out.print("\t\t\t<li> 이름 : <strong>");
		// out.print(HangulConv.toUTF(name)); Tomcat 8.x 이하 일때는 한글 처리를 해야한다.
		out.print(name);
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 나이 : <strong>");
		out.print(age);
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 메일링 여부 : <strong>");
		out.print(mailing); // value 속성이 없는 checkbox는 check되면 on, check되지 않으면 null
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 성별 : <strong>");
		// out.print(HangulConv.toUTF(gender));
		out.print(gender);
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 주소 : <strong>");
		// out.print(HangulConv.toUTF(addr));
		out.print(addr);
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 이메일 : <strong>");
		out.print(email);
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 가입인사 : <strong>");
		// out.print(HangulConv.toUTF(greeting));
		out.print(greeting);
		out.println("<strong></li>");
		
		out.println("\t\t</ul>");
		out.println("\t</div>");
		out.println("\t<a href='date0227/test_param.html'>뒤로</a>");
		out.println("\t</div>");
		
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"footer\">\r\n");
		out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
		out.write("\t</div>\r\n");
		out.write("</div>\r\n");
		out.write("\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 방식의 한글 처리
		// Tomcat 모든 버전에 동일하게 적용
		
		resp.setContentType("text/html;charset=utf-8");

		PrintWriter out = resp.getWriter();
		
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
		out.write("</style>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");
		
		// Parameter 값 받기 : Tomcat 8.0부터는 GET방식의 Parameter는 한글이 깨지지 않는다.
		String name = req.getParameter("name"); // text
		String age = req.getParameter("age"); // password
		req.setCharacterEncoding("UTF-8");
		String mailing = req.getParameter("mailing"); // checkbox
		String gender = req.getParameter("gender"); // radio
		String addr = req.getParameter("addr"); // hidden
		String email = req.getParameter("email"); // select
		String greeting = req.getParameter("greeting"); // textarea
		
		out.println("\t<div>");
		out.println("\t<h2 style='color:blue;'>POST방식으로 요청한 파라미터 값 처리</h2>");
		out.println("\t<div>");
		out.println("\t\t<ul>");
		
		out.print("\t\t\t<li> 이름 : <strong>");
		out.print(name);
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 나이 : <strong>");
		out.print(age);
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 메일링 여부 : <strong>");
		out.print(mailing); // value 속성이 없는 checkbox는 check되면 on, check되지 않으면 null
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 성별 : <strong>");
		out.print(gender);
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 주소 : <strong>");
		out.print(addr);
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 이메일 : <strong>");
		out.print(email);
		out.println("<strong></li>");
		
		out.print("\t\t\t<li> 가입인사 : <strong>");
		out.print(greeting);
		out.println("<strong></li>");
		
		out.println("\t\t</ul>");
		out.println("\t</div>");
		out.println("\t<a href='date0227/test_param.html'>뒤로</a>");
		out.println("\t</div>");
		
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
