package date0228;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UseWebParameterValues extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
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
		out.write("</style>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");
		
		// HTML Form Control의 값 받기
		// 이름이 유일 <input type="text" ..
		String name = request.getParameter("name");

		// 이름이 중복 <input type="checkbox" ..
		String[] hobbies = request.getParameterValues("hobby");

		out.print("\t<strong>");
		out.print(name);
		out.println("\t</strong>님 께서 입력하신 취미는 아래와 같습니다.");
		out.print("\t<ul>");
		
		if (hobbies != null) {
			for(int i=0; i<hobbies.length; i++) {
				out.print("\t\t<li>");
				out.print(hobbies[i]);
				out.println("</li>");
			}
		} else {
			out.println("<li>취미 없음.</li>");
		}
		out.print("\t</ul>");
		out.print("\t<a href='date0228/test_param_value.html'>뒤로</a>");
		out.print("\t<a href='javascript:history.back()'>뒤로</a>");
		
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"footer\">\r\n");
		out.write("\t\t<div id=\"footerTitle\">copyright&copy; all right reserved. class 4 </div>\r\n");
		out.write("\t</div>\r\n");
		out.write("</div>\r\n");
		out.write("\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // POST 한글처리
		
		response.setContentType("text/html;charset=UTF-8");
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
		out.write("</style>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");
		
		
		// HTML Form Control의 값 받기
		// 이름이 유일 <input type="text" ..
		String name = request.getParameter("name");

		// 이름이 중복 <input type="checkbox" ..
		String[] hobbies = request.getParameterValues("hobby");

		out.println("\t<h2>POST방식의 요청처리</h2>");
		out.print("\t<strong>");
		out.print(name);
		out.println("\t</strong>님 께서 입력하신 취미는 아래와 같습니다.");
		out.print("\t<ul>");
		
		try {
			for(int i=0; i<hobbies.length; i++) {
				out.print("\t\t<li>");
				out.print(hobbies[i]);
				out.println("</li>");
			}
		} catch (NullPointerException e) {
			out.println("<li>취미 없음.</li>");
		}
		
		out.print("\t</ul>");
		out.print("\t<a href='date0228/test_param_value.html'>뒤로</a>");
		out.print("\t<a href='javascript:history.back()'>뒤로</a>");
		
		
		
		
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
