package date0228;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class WhySessionC extends HttpServlet {
       
	// 링크로 이동, GET방식
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
		
		// WhySessionC 서블릿에서는 이전페이지인 WhySessionB 서블릿 내의 값을 사용할 수 없다.
		// 이전페이지에서 사용한 이름을 이동한 페이지에서 사용할 수 없다.
		String name = req.getParameter("name");
		
		out.println(name+"님의 작업페이지입니다.");
		
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
