package date0225;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. HttpServlet 상속
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 2. 요청방식을 처리할 수 있는 method를 Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 3. 응답 방식설정(MIME-TYPES) - 접속자에게 보내줄 형식
		response.setContentType("text/html;charset=UTF-8");
		
		// 4. 접속자에게 보내줄 내용을 전달하기 위해 Stream 얻기 
		PrintWriter out = response.getWriter();
		
		// 5. 출력내용을 스트림에 기록
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>안녕 Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("요청 : "+request+"<br/>");
		out.println("응답 : "+response+"<br/>");
		out.println("<strong>Hello Servlet</strong><br/>");
		out.println("난 오영근이라고해<br/>");
		out.println("2019년 02월 25일 입니다.<br/>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}
}
