package date0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. HttpServlet 상속
@SuppressWarnings("serial")
public class TestCall extends HttpServlet {

	// 2. 요청방식을 처리할 수 있는 method Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3. 응답방식 설정
		response.setContentType("text/html;charset=UTF-8");
		
		// 4. 출력스트림 얻기
		PrintWriter out = response.getWriter();
		
		// 5. 출력 내용 생성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>GET 방식의 요청처리</title>");
		out.println("<style type='text/css'>");
		out.println("span { font-weight:bold; font-size:20px; color:#0000FF } ");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<span>GET방식 요청처리</span><br/>");
		out.println("<a href='date0226/call_servlet.html'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
	}

	// 2. 요청방식을 처리할 수 있는 method Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3. 응답방식 설정
		response.setContentType("text/html;charset=UTF-8");
		
		// 4. 출력스트림 얻기
		PrintWriter out = response.getWriter();
		
		// 5. 출력 내용 생성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>POST 방식의 요청처리</title>");
		out.println("<style type='text/css'>");
		out.println("span { font-weight:bold; font-size:15px; color:#FF0000 } ");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<span>POST방식 요청처리</span><br/>");
		out.println("<a href='javascript:history.back()'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
