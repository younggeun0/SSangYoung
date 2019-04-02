package kr.co.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.EmpService;
import kr.co.sist.vo.EmpVO;

public class EmpController implements Controller {
	private String url;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String deptno = request.getParameter("deptno");
		int intDeptno = Integer.parseInt(deptno);
		
		EmpService es = new EmpService();
		List<EmpVO> empList = es.searchEmp(intDeptno);
		
		request.setAttribute("empList", empList);
		
		url="emp/emp.jsp";
		forwardFlag=true;
	}

	@Override
	public String moveURL() {
		return url;
	}

	@Override
	public boolean isForward() {
		return forwardFlag;
	}
}
