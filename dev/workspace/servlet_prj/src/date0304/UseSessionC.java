package date0304;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class UseSessionC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 세션 삭제 페이지
		// 1. 세션 얻기
		HttpSession session = request.getSession();
		
		// 2. 세션 값 삭제
		session.removeAttribute("id");
		session.removeAttribute("user_name");
		
		// 3. 브라우저에 할당된 세션자체 무효화
		session.invalidate();

		// String id = (String)session.getAttribute("id");
		// String name = (String)session.getAttribute("user_name");
		// 세션이 무효화 된 이후에는 세션에서 값을 얻을 수 없다.

		out.println("<script type='text/javascript'>");
		out.println("window.onload = function() {");
		out.println("\tlocation.replace('date0304/use_session.html');");
		out.println("}");
		out.println("</script>");
	}
}
