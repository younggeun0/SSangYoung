package kr.co.sist.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.sist.dao.JdbcDAO;
import kr.co.sist.domain.DetailMember;
import kr.co.sist.domain.Member;
import kr.co.sist.domain.MemberImg;
import kr.co.sist.vo.MemberUpdateVO;
import kr.co.sist.vo.MemberVO;

@Component
public class JdbcService {

	@Autowired(required=false)
	private JdbcDAO jdao;
	
	public boolean fileUploadProcess(HttpServletRequest request, Model model) throws IOException {
		boolean flag = false;
		
		// ���� ���ε�
		MultipartRequest mr = new MultipartRequest(request,
			"C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/spring_jdbc/WebContent/upload/",
			1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		
		// �ٲ���� �̸����� �߰��Ǿ�� �ϹǷ� DefaultFileNamePolicy�� �������
		// ���ο� �̸��� getFilesystemName�� ���� ��� img���� �ִ´�
		MemberVO mv = new MemberVO(mr.getParameter("name"),
				mr.getFilesystemName("upfile"), mr.getParameter("loc"), 
				mr.getParameter("hightschool"));
		
		try {
			jdao.insertMember(mv);
			model.addAttribute("inputData",mv);
			flag = true;
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		return flag;
	}
	
	public List<Member> searchAllMember() {
		List<Member> list = null;
		try {
			list = jdao.selectAllMember();
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		return list;
	}
	
	public DetailMember searchOneMember(int num) {
		DetailMember dm = null;
		try {
			dm = jdao.selectOneMember(num);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		return dm;
	}
	
	public boolean updateMember(MemberUpdateVO muvo) {
		boolean flag = false;
		try {
			flag = jdao.updateMember(muvo) == 1;
		} catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean deleteMember(int num) {
		boolean flag = false;
		
		try {
			MemberImg mi = jdao.deleteMember(num);
			flag = mi.getCnt() == 1;
			if (flag) { // ������ ���ڵ尡 �����ϸ�
				// ���� ����
				if (!"default.png".equals(mi.getImg())) {
					File file = new File("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/spring_jdbc/WebContent/upload/"
									+mi.getImg());
					System.out.println("---- ������ �̹��� : "+mi.getImg());
					file.delete();
				}
			}
		} catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		return flag;
	}
}
