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
	
	// ������ó�� �ڵ忡 �����ϱ����� Foward�� �������
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// nameArr�� list�� ó���� �����Ͷ� ����
		String[] nameArr = { "������","������","������","������","������","�����" };
		
		List<String> list = new ArrayList<String>();
		list.add("PC�� ���� ���α׷�");
		list.add("��ȭ�� ���� ���α׷�");
		list.add("������ ���α��� ���α׷�");
		
		// 1. ó���� �����͸� �̵��� �������� ������ ���� ��û��ü�� �Ӽ����� ����
		request.setAttribute("name", nameArr);
		request.setAttribute("project", list);
		
		// 2. �̵��� �������� ����
		RequestDispatcher rd = request.getRequestDispatcher("forward_b");
		
		// 3. �̵�
		rd.forward(request, response);
	}
}
