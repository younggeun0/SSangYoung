package kr.co.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.service.DeptService;
import kr.co.sist.vo.DeptVO;

/**
 * ��� �μ������� ��ȸ�ϴ� ��(��û �ϳ��� Ŭ���� �ϳ��� ó���Ѵ�.)
 */
public class DeptController implements Controller {
	
	private String url;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DeptService ds = new DeptService();
		
		List<DeptVO> deptList = ds.searchAllDept();
		
		// ó���� �����͸� JSP���� �����ֱ� ���� Scope��ü�� �����Ѵ�.
		request.setAttribute("deptList", deptList);
		
		url="dept/dept.jsp";
		forwardFlag = true;
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
