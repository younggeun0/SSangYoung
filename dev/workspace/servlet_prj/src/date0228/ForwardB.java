package date0228;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ForwardB extends HttpServlet {
	
	// �����ο� �����Ѵ�.
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
		out.write("#headerTitle{ font-family: HY�߰��, ���; font-size: 30px; font-weight: bold;text-align: center;\r\n");
		out.write("\t\t\t\t\tposition: absolute; top:30px; left:290px}\r\n");
		out.write("#container{  width:800px; height: 600px; }\r\n");
		out.write("#footer{  width:800px; height: 120px; }\r\n");
		out.write("#footerTitle{ float:right; font-size: 15px; padding-top:20px; padding-right: 20px }\r\n");
		out.write("</style>\r\n");
		
		
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\"></script>");
		out.println("<script type=\"text/javascript\">");
		out.println("\t$(document).ready(function() {");
		out.println("\t\t$('#btnAdd').click(function() {");
		
		// select�� ��
		out.println("\t\t\tvar prj_name = $('#prj').val();");
		out.println("\t\t\tvar output = ''");
		
		out.println("\t\t\toutput='������Ʈ��['+prj_name+']<br/>�����ο� : ';");
		
		//  checkbox���� �����ͼ� 
		out.println("\t\t\t$.each($(\"[name='name']\"),function(idx, obj){");
		out.println("\t\t\t\tif($(obj).is(':checked')) {");
		out.println("\t\t\t\t\toutput+=$(obj).val()+' ';");
		out.println("\t\t\t\t}");
		out.println("\t\t\t});");
		
		// div ���
		out.println("\t\t\t$('#prj_member').html(output);");
		out.println("\t\t});");
		out.println("\t});");
		out.println("</script>");
		
		
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");
		
		// ������ ó�� ���������� ó���� ����� �޾ƿ�
		String[] nameArr = (String[])request.getAttribute("name");
		List<String> list = (List<String>)request.getAttribute("project");
		
		if (nameArr != null) {
			// ��ºκ��� ����
			out.println("<label>������Ʈ ����</label>");
			out.println("<select id='prj'>");
			for(String prj : list) {
				out.print("\t<option value='");
				out.print(prj);
				out.print("'>");
				out.print(prj);
				out.println("</option>");
			}
			out.println("</select>");
		}

		if (list != null) {
			out.println("<div>");
			out.println("<h3>�����η�</h3>");
			for(String name : nameArr) {
				out.print("<input type='checkbox' name='name' value='");
				out.print(name);
				out.print("'>");
				out.print(name);
				out.print("&nbsp;");
			}
			out.println("<input type='button' value='�߰�' class='btn' id='btnAdd'/>");
			out.println("</div>");
			out.println("<div id='prj_member'></div>");
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
