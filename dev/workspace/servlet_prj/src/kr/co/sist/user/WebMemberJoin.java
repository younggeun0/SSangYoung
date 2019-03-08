package kr.co.sist.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.user.dao.WebMemberDAO;
import kr.co.sist.user.vo.WebMemberVO;
import kr.co.sist.util.ShaUtil;

@SuppressWarnings("serial")
public class WebMemberJoin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//post��� �ѱ�ó��
		request.setCharacterEncoding("UTF-8");
		//����ڰ� �Է��� ��(HTML Form Control)�� �ޱ�(getParameter)
		String id=request.getParameter("id");
		String pass1=request.getParameter("pass1");
		String name=request.getParameter("name");
		String ssn1=request.getParameter("ssn1");
		String ssn2=request.getParameter("ssn2");
		String gender=request.getParameter("gender");
		String b_year=request.getParameter("b_year");
		String b_month=request.getParameter("b_month");
		String b_day=request.getParameter("b_day");
		String age=request.getParameter("age");
		String[] interestlang=request.getParameterValues("interestlang");
		String marriageFlag=request.getParameter("marriageFlag");
		String m_year=request.getParameter("m_year");
		String m_month=request.getParameter("m_month");
		String m_day=request.getParameter("m_day");
		String zipcode=request.getParameter("zipcode");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String greetings=request.getParameter("greetings");
		
		//�Ķ���Ͱ��� VO�� ����
		WebMemberVO wm_vo = new WebMemberVO(id, ShaUtil.shaEncoding(pass1), name, ShaUtil.shaEncoding(ssn1+"-"+ssn2), 
				gender, b_year+"-"+b_month+"-"+b_day, age, marriageFlag, m_year+"-"+m_month+"-"+m_day, 
				zipcode, addr1, addr2, greetings, request.getRemoteAddr(), interestlang);
		
	      out.write("<!DOCTYPE html>\r\n");
	      out.write("<html>\r\n");
	      out.write("<head>\r\n");
	      out.write("<meta charset=\"UTF-8\">\r\n");
	      out.write("<title>ȸ������</title>\r\n");
	      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/servlet_prj/common/css/main_v190130.css\"/>\r\n");
	      out.write("<style type=\"text/css\">\r\n");
	      out.write("\t#joinTitle{ font-weight: bold; font-size: 20px;  }\r\n");
	      out.write("\t.tdAlign{ text-align: center  }\r\n");
	      out.write("\ttable{ margin: 0px auto }\r\n");
	      out.write("\ttr{ height: 25px}\r\n");
	      out.write("\t\r\n");
	      out.write("\t#wrap{ width: 1007px; margin:0px auto }\r\n");
	      out.write("\t#joinHeader{ width: 1007px; height: 195px; \r\n");
	      out.write("\t\t\t\t\tbackground: #FFFFFF url(http://localhost:8080/servlet_prj/web_member/images/header.png) no-repeat; }\t\r\n");
	      out.write("\t\t\t\t\t\r\n");
	      out.write("\t.span{ color: #FF0000 }\r\n");
	      out.write("\t#joinContent{ position: relative;\r\n");
	      out.write("\t\t\twidth:773px ; height:369px ; background:#FFFFFF url(http://localhost:8080/servlet_prj/web_member/images/welcome_background.png) no-repeat; }\r\n");
	      out.write("\t#resultTitle{ position: absolute;top:130px; left:320px}\r\n");
	      out.write("\t#resultInput{ position: absolute;top:150px; left:330px;}\r\n");
	      out.write("</style>\r\n");
	      out.write("<script type=\"text/javascript\">\r\n");
	      out.write("\t\r\n");
	      out.write("</script>\r\n");
	      out.write("</head>\r\n");
	      out.write("<body>\r\n");
	      out.write("<div id=\"wrap\">\r\n");
	      out.write("<div id=\"joinHeader\"></div>\r\n");
	      out.write("<div id=\"joinContent\">\r\n");
	      try {
	    	  //�񿬰Ἲ�� �ذ��ϱ����� 
	    	  //�߰� ���� ���̵� ��������� �ٽ� ����ȸ�� �Ͽ� ó���Ѵ�.
	    	  
	    	  addWebMember(wm_vo);
		      out.write("\t<div id=\"resultTitle\">\r\n");
		      out.write("\t\t<span>");
		      out.print(name);
		      out.print("</span>�Բ��� �Է��Ͻ� ������ �Ʒ��� �����ϴ�.\r\n");
		      out.write("\t</div>\r\n");
		      out.write("\t<div id=\"resultInput\">\r\n");
		      out.write("\t\t<ul>\r\n");
		      out.write("\t\t\t<li>���̵� : <strong>");
		      out.print(id);
		      out.print("</strong></li>\r\n");
		      out.write("\t\t\t<li>���� : <strong>");
		      out.print(gender);
		      out.print("</strong></li>\r\n");
		      out.write("\t\t\t<li>������� : <strong>");
		      out.print(b_year+" "+b_month+" "+b_day);
		      out.print("</strong></li>\r\n");
		      out.write("\t\t\t<li>��ȥ���� : <strong>");
		      out.print(marriageFlag);
		      out.print("</strong></li>\r\n");
		      out.write("\t\t\t<li>���ɾ�� : \r\n");
		      out.write("\t\t\t\t\t<strong>");
		      
		      
		      if(interestlang!=null) {
		    	  for(int i=0; i<interestlang.length;i++) {
		    		  out.write("\t\t\t\t\t<strong>");
		    		  out.print(interestlang[i]);
		    		  out.print(" <strong>\r\n");
		    	  }
		    	  
		      }
		      
		      out.print("</strong>\r\n");
		      out.write("\t\t\t</li>\r\n");
		      out.write("\t\t\t<li><a href=\"#void\">�α���</a></li>\r\n");
		      out.write("\t\t</ul>\r\n");
		      out.write("\t</div>\r\n");
	      }catch(RuntimeException re) {
	    	  out.println("���̵� �̹� ������Դϴ�. <br/>");
	    	  out.println("<a href='#void' onclick='history.back();'>�ٽ� �Է�<a/>. <br/>");
	      }catch(SQLException se) {
	    	  se.printStackTrace();
	    	  out.println("ȸ�������� ���������� �̷������ �ʾҽ��ϴ�.<br/>");
	    	  out.println("���񽺰� ��Ȱ���� ������ �˼��մϴ�.<br/>");
	    	  out.println("�������� ���񽺸� ���ؼ� ���� ���������� �ּ��� ���ϰ� �ֽ��ϴ�.<br/>");
	    	  out.println("�ż��ϰ� �����ϰڽ��ϴ�. ����� ������ ���� 010-�����߿��� �������ּ���.<br/>");
	      }//end catch
	      out.write("\t\t\r\n");
	      out.write("\t</div>\r\n");
	      out.write("</div>\r\n");
	      out.write("</body>\r\n");
	      out.write("</html>\r\n");
		
		
	}//doPost

	private void addWebMember(WebMemberVO wm_vo)throws SQLException,RuntimeException {
		
		WebMemberDAO wm_dao = WebMemberDAO.getInstance();
		//�߰����� ���� ���̵� �����ϴ��� �ٽ� �˻��Ͽ� ó��(�񿬰Ἲ�� ó��)
		
		if(!wm_dao.selectId(wm_vo.getId())){
			throw new RuntimeException();
		}//end if
		
		wm_dao.insertMember(wm_vo);
		
	}//addWebMember

}
