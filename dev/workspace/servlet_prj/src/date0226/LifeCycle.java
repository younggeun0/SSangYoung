package date0226;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. HttpServlet 상속
@SuppressWarnings("serial")
public class LifeCycle extends HttpServlet {
	
	// 생명주기 method
	public void init() {
		System.out.println("===> init method : 최초 접속자에 의해 1번 호출(생성자 역할) ");
	}
	
	public void destroy() {
		System.out.println("===> destroy method : Web Container가 종료될 때 객체가 사라지면서 1번 호출");
	}

	// 2. 응답방식에 대한 처리 method를 Override
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 3. 응답방식 설정(MIME-TYPE 설정)
		resp.setContentType("text/html;charset=UTF-8");
		
		// 4. 출력스트림 얻기
		PrintWriter out = resp.getWriter();
		
		// 5. 응답내용 생성
		out.println("<strong>방문자 정보</strong><br/>");
		out.print("<strong>접속자 ip : </strong>");
		out.print(req.getRemoteAddr());
		out.println("에서 접속하셨습니다.");
		out.flush();
		
		System.out.println("---> service, doGet, doPost : 모든 접속자에게 호출. 여러번 호출 "+req.getRemoteAddr());
	}
}
