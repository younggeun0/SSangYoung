package date0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. HttpServlet ���
@SuppressWarnings("serial")
public class LifeCycle extends HttpServlet {
	
	// �����ֱ� method
	public void init() {
		System.out.println("===> init method : ���� �����ڿ� ���� 1�� ȣ��(������ ����) ");
	}
	
	public void destroy() {
		System.out.println("===> destroy method : Web Container�� ����� �� ��ü�� ������鼭 1�� ȣ��");
	}

	// 2. �����Ŀ� ���� ó�� method�� Override
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 3. ������ ����(MIME-TYPE ����)
		resp.setContentType("text/html;charset=UTF-8");
		
		// 4. ��½�Ʈ�� ���
		PrintWriter out = resp.getWriter();
		
		// 5. ���䳻�� ����
		out.println("<strong>�湮�� ����</strong><br/>");
		out.print("<strong>������ ip : </strong>");
		out.print(req.getRemoteAddr());
		out.println("���� �����ϼ̽��ϴ�.");
		out.flush();
		
		System.out.println("---> service, doGet, doPost : ��� �����ڿ��� ȣ��. ������ ȣ�� "+req.getRemoteAddr());
	}
}
