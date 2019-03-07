package date0306;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SelectEmp extends HttpServlet {

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
		
		out.println("table { border-spacing:0px; }");
		out.println("th { background-color: #0C4F7F; }");
		out.println("span { color:#FFFFFF; font-size:14px; }");
		out.println("td { border:1px solid #141650; text-align:center; }");
		
		out.write("</style>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");
		out.print("<br/><br/>");
		
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("\t<th width='80'><span>번호</span></th>");
		out.println("\t<th width='120'><span>사원번호</span></th>");
		out.println("\t<th width='150'><span>사원명</span></th>");
		out.println("\t<th width='80'><span>매니저번호</span></th>");
		out.println("\t<th width='100'><span>직무</span></th>");
		out.println("\t<th width='100'><span>연봉</span></th>");
		out.println("\t<th width='150'><span>입사일</span></th>");
		out.println("</tr>");
		
		List<EmpVO> list = searchAllEmp();

		if(list == null) { // DB에 문제 발생한 경우
			out.println("<tr><td colspan='7'>데둉합니다.</td></tr>");
		} else {
			EmpVO evo = null;
			for(int i=0; i<list.size(); i++) {
				evo = list.get(i);
				out.println("<tr>");
				out.print("<td>");
				out.print(i+1);
				out.println("</td>");
				out.print("<td>");
				out.print(evo.getEmpno());
				out.println("</td>");
				out.print("<td>");
				out.print(evo.getEname());
				out.println("</td>");
				out.print("<td>");
				out.print(evo.getMgr());
				out.println("</td>");
				out.print("<td>");
				out.print(evo.getJob());
				out.println("</td>");
				out.print("<td>");
				out.print(evo.getSal());
				out.println("</td>");
				out.print("<td>");
				out.print(evo.getHiredate());
				out.println("</td>");
				out.println("</tr>");
			}
			
			if (list.isEmpty()) {
				out.print("<tr><td colspan='7'>사원정보가 존재하지 않습니다.<br/>");
				out.print("<img src='common/images/img2.jpg' title='#일안하냐? #사원관리'/>");
				out.println("</td></tr>");
			}
		}
		
		out.println("</table>");
		
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
	
	public List<EmpVO> searchAllEmp() {
		List<EmpVO> list = null;
		
		EmpDAO ed = new EmpDAO();
		
		try {
			list = ed.selectAllEmp();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
