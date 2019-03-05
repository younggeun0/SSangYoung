package date0305;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PopupBody extends HttpServlet {

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
		
		// 쿠키가 존재하고 오늘 날짜와 같다면 팝업창을 띄우지 않는다.
		boolean popupFlag = false;
		
		// 1. 쿠키 읽기
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) { // 쿠키가 존재
			Cookie readCookie = null;
			for(int i=0; i<cookies.length; i++) {
				readCookie = cookies[i];
				if("popup_date".equals(readCookie.getName())) {
					String value = readCookie.getValue();
					String nowDate = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
					if(nowDate.equals(value)) {
						popupFlag = true;
					}
				}
			}
		}
		
		out.println("<script type='text/javascript'>");
		out.println("\t window.onload = function() {");
		
		if (!popupFlag) {
			out.println("\t\t window.open('date0305/popup.html','popup','width=755, height=510, top=100, left=250')");
		}
		
		out.println("\t }");
		out.println("</script>");
		
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");
		
		out.println("<h2>정윤이의 철권세상에 잘 오셨습니다.</h2>");
		out.println("<img src='common/images/img.png' title='게임은 수업시간에 해야 제맛'><br/>");
		out.println("<h3>이번 주 정모는 강남역 지하 게임센터에서 화요일 19:00시부터 진행됩니다.</h3>");
		out.println("<h3>많은 참여 부탁드립니다..</h3>");
		out.println("<img src='date0304/images/job.png'>");
		
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
