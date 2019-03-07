package date0225;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. HttpServlet ���
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 2. ��û����� ó���� �� �ִ� method�� Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 3. ���� ��ļ���(MIME-TYPES) - �����ڿ��� ������ ����
		response.setContentType("text/html;charset=UTF-8");
		
		// 4. �����ڿ��� ������ ������ �����ϱ� ���� Stream ��� 
		PrintWriter out = response.getWriter();
		
		// 5. ��³����� ��Ʈ���� ���
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>�ȳ� Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("��û : "+request+"<br/>");
		out.println("���� : "+response+"<br/>");
		out.println("<strong>Hello Servlet</strong><br/>");
		out.println("�� �������̶����<br/>");
		out.println("2019�� 02�� 25�� �Դϴ�.<br/>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}
}
