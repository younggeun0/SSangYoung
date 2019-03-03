package date0228;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ForwardA extends HttpServlet {
	
	// 데이터처리 코드에 집중하기위해 Foward가 만들어짐
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// nameArr와 list는 처리된 데이터라 가정
		String[] nameArr = { "오영근","이재현","공선의","박정미","최혜원","김건하" };
		
		List<String> list = new ArrayList<String>();
		list.add("PC방 관리 프로그램");
		list.add("영화관 예매 프로그램");
		list.add("개발자 구인구직 프로그램");
		
		// 1. 처리된 데이터를 이동한 페이지로 보내기 위해 요청객체에 속성으로 설정
		request.setAttribute("name", nameArr);
		request.setAttribute("project", list);
		
		// 2. 이동할 페이지를 설정
		RequestDispatcher rd = request.getRequestDispatcher("forward_b");
		
		// 3. 이동
		rd.forward(request, response);
	}
}
