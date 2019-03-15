package date0314;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TestForward extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = "이재찬";
		String[] hobby = { "집에가기", "점심먹기", "낮잠자기" };
		
		request.setAttribute("name", name);
		request.setAttribute("hobby", hobby);
		
		RequestDispatcher rd = request.getRequestDispatcher("date0314/use_forward.jsp");
		rd.forward(request, response);
	}
}
