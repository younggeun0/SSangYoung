package date0304;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class UseSessionA extends HttpServlet {
	private Map<String, String> loginMap;
	
	public void init() {
		loginMap = new HashMap<String, String>();
		loginMap.put("kim", "김정윤");
		loginMap.put("lee", "이재찬");
		loginMap.put("park", "박영민");
		loginMap.put("roh", "노진경");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 방식을 설정
		response.setContentType("text/html;charset=UTF-8");
		// 출력스트림 얻기
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
		
		out.println("<script type='text/javascript'>");
		out.println("window.onload = function() {");
		out.println("\tdocument.getElementById('job').addEventListener('click',movePage);");
		out.println("}");
		out.println("function movePage() {");
		out.println("\tlocation.replace('use_session_b');");
		out.println("}");
		out.println("</script>");
		
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<div\tid=\"wrap\">\r\n");
		out.write("\t<div id=\"header\">\r\n");
		out.write("\t\t<div id=\"headerTitle\">SIST Class4</div>\r\n");
		out.write("\t</div>\r\n");
		out.write("\t<div id=\"container\">\r\n");
		
		
		// 접속자가 입력한 parameter 받기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		if(loginMap.containsKey(id) && "123".equals(pass)) {
			// 로그인 성공
			String name = loginMap.get(id);
			
			// 로그인 정보를 세션에 추가
			// 1. 세션 얻기
			HttpSession session = request.getSession();
			
			// 2. 세션 생존시간 설정(Tomcat 기본은 30분)
			session.setMaxInactiveInterval(60*2);
			
			// 3. 세션에 값 설정
			session.setAttribute("id", id);
			session.setAttribute("user_name", name);
			
			out.println("<h2>세션사용 로그인</h2>");
			out.print("<strong>");
			out.print(id);
			out.print("</strong>(");
			out.print(name);
			out.println(")님 로그인 하셨습니다.<br/>");
			out.println("<a id='job'>작업페이지로 이동</a>");
			
		} else {
			out.println("<strong>아이디나 비밀번호를 확인해주세요.</strong><br/>");
			out.println("다시 <a href='date0304/use_session.html'>로그인</a>");
		}
		
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
