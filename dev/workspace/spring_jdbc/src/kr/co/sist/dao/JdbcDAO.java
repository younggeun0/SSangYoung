package kr.co.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.vo.MemberVO;

@Component
public class JdbcDAO {
	
	@Autowired(required=false)
	private JdbcTemplate jt;
	
	@RequestMapping()
	public void insertMember(MemberVO mv) throws DataAccessException {
		
		StringBuffer insertMember = new StringBuffer();
		insertMember
		.append(" insert into test_like(num, name, loc, highschool, img) ")
		.append(" values(seq_reply.nextval, ?, ?, ?, ?) ");
		
		jt.update(insertMember.toString(),
			mv.getName(), mv.getLoc(), mv.getHighschool(), mv.getImg());
	}
}
