package kr.co.sist.dist;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.controller.Controller;
import kr.co.sist.controller.DeptController;
import kr.co.sist.controller.EmpController;

/**
 * ������ : ��� ��û�� �ް� ��û�� ó���� Controller�� ã�Ƽ� ������ �Ѵ�.
 * 			View�� �̵�
 */
@SuppressWarnings("serial")
public class MainController extends HttpServlet {

	private static Map<String, Controller> distMap;
	
	static { // static����
		distMap = new HashMap<String, Controller>();
		
		distMap.put("D001", new DeptController()); // �μ���ȸ ����
		distMap.put("E001", new EmpController()); // �����ȸ ����
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response); // GET����� ��û�� �־ doPost�� ó��
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		if (cmd == null || "".equals(cmd)) { // cmd�� ���� ��
			cmd = "D001";
		}
		
		
		Controller controller  = distMap.get(cmd);
		
		if (controller == null) { // cmd�� �ܺο��� ���Ƿ� �������� �� ó�� 
			controller = distMap.get("D001"); // �ܺο��� ���Ƿ� �����ϸ� ������ �����Ѵ�.
		}
		
		// �� �Ķ���� ó��, ��������, ����ó�� ����� Scope��ü�� �����ϴ� ���� ����
		controller.execute(request, response); 
		
		// �̵��� �������� URL�ޱ�
		String url = controller.moveURL();
		// �̵���� �ޱ�
		boolean forwardFlag = controller.isForward();
		
		pageMove(request, response, url, forwardFlag);
	}
	
	public void pageMove(HttpServletRequest request, HttpServletResponse response, String url, boolean forwardFlag) 
			throws ServletException, IOException {
		
		if (forwardFlag) { // forward �̵�
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} else { // redirect �̵�
			response.sendRedirect(url);
		}
	}
}
