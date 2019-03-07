package date0228;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class WhySessionB extends HttpServlet {
	
	private Map<String, String> loginMap;
	
	@Override
	public void init() throws ServletException {
		loginMap = new HashMap<String, String>();
		loginMap.put("kong","������");
		loginMap.put("rho", "������");
		loginMap.put("kim", "����û");
		loginMap.put("lee", "������");
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		out.write("#headerTitle{ font-family: HY�߰��, ���; font-size: 30px; font-weight: bold;text-align: center;\r\n");
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
		
		// ����ڰ� �Է��� �� �ޱ�
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		if (loginMap.containsKey(id) && "1234".equals(pass)) {
			String name = loginMap.get(id); // �ٸ� Servlet���� ���Ұ�
			
			out.println("<div>");
			out.print("<strong>");
			out.println(id);
			out.print("</strong>(");
			out.println(name);
			out.println(")�� �α��� �ϼ̽��ϴ�.<br/>");
			out.println("<a href='why_session_c?name="+name+"'>�۾��������� �̵�</a>");
			out.println("</div>");
		} else {
			out.println("���̵� ��й�ȣ�� Ȯ�����ּ���.");
			out.println("<a href='#void' click='history:back();'>�α���</a>");
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
