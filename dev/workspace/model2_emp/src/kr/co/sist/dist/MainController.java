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
 * 진입점 : 모든 요청을 받고 요청을 처리할 Controller를 찾아서 실행을 한다.
 * 			View로 이동
 */
@SuppressWarnings("serial")
public class MainController extends HttpServlet {

	private static Map<String, Controller> distMap;
	
	static { // static영역
		distMap = new HashMap<String, Controller>();
		
		distMap.put("D001", new DeptController()); // 부서조회 업무
		distMap.put("E001", new EmpController()); // 사원조회 업무
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response); // GET방식의 요청이 있어도 doPost로 처리
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		if (cmd == null || "".equals(cmd)) { // cmd가 없을 때
			cmd = "D001";
		}
		
		
		Controller controller  = distMap.get(cmd);
		
		if (controller == null) { // cmd를 외부에서 임의로 변경했을 때 처리 
			controller = distMap.get("D001"); // 외부에서 임의로 변경하면 메인을 제공한다.
		}
		
		// 웹 파라미터 처리, 관계유지, 업무처리 결과를 Scope객체에 설정하는 일을 수행
		controller.execute(request, response); 
		
		// 이동할 페이지의 URL받기
		String url = controller.moveURL();
		// 이동방식 받기
		boolean forwardFlag = controller.isForward();
		
		pageMove(request, response, url, forwardFlag);
	}
	
	public void pageMove(HttpServletRequest request, HttpServletResponse response, String url, boolean forwardFlag) 
			throws ServletException, IOException {
		
		if (forwardFlag) { // forward 이동
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} else { // redirect 이동
			response.sendRedirect(url);
		}
	}
}
