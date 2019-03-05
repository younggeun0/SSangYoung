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
public class PopupClose extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// checkbox�� value�� ���� �� üũ�ϰ� submit �Ǹ� "on"�� ������ ***
		// checkbox�� �������� �ʰ� submit�Ǹ� "null"�� �Էµȴ�.
		String popupFlag = request.getParameter("popupFlag");
		
		if(popupFlag != null) { // üũ�ڽ��� ���õ� ��� "on"
			
			// ��Ű �ɱ� : �˾�â�� �������� ���� �������� ��¥�� ���� ��Ű�� �ɴ� �� 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			
			// 1. ��� ����
			Cookie popupCookie = new Cookie("popup_date",sdf.format(new Date()));
			
			// 2. ��Ű�� �����ð�
			popupCookie.setMaxAge(60*60*24);
			
			// 3. ��Ű �ɱ�
			response.addCookie(popupCookie);
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script type='text/javascript'>");
		out.println("\twindow.onload = function() {");
		out.println("\t\tself.close();");
		out.println("\t}");
		out.println("</script>");
	}
}
