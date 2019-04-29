package kr.co.sist.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.domain.DetailMember;
import kr.co.sist.domain.Member;
import kr.co.sist.domain.MemberImg;
import kr.co.sist.vo.MemberUpdateVO;
import kr.co.sist.vo.MemberVO;

@Component
public class JdbcDAO {
	
	@Autowired(required=false)
	private JdbcTemplate jt;
	
	@RequestMapping()
	public void insertMember(MemberVO mv) throws DataAccessException {
		
		StringBuffer insertMember = new StringBuffer();
		insertMember
		.append(" INSERT INTO test_like(num, name, loc, highschool, img) ")
		.append(" VALUES(seq_reply.nextval, ?, ?, ?, ?) ");
		
		jt.update(insertMember.toString(),
			mv.getName(), mv.getLoc(), mv.getHighschool(), mv.getImg());
	}
	
	public List<Member> selectAllMember() throws DataAccessException {
		List<Member> list = null;
		
		// 조회결과를 Domain에 저장하는 객체 생성(RowMapper)
		RowMapper<Member> rm = new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getInt("num"), rs.getString("name"),
						rs.getString("img"));
				return member;
			}
		};
		
		// SQL문 작성
		String selectMember = "SELECT name, img, num FROM test_like";
		
		// 실행
		list = jt.query(selectMember, rm);
		
		return list;
	}
	
	public DetailMember selectOneMember(int num) throws DataAccessException {
		DetailMember dm = null;
		
		RowMapper<DetailMember> rm = new RowMapper<DetailMember>() {
			@Override
			public DetailMember mapRow(ResultSet rs, int rowNum) throws SQLException {
				DetailMember dm = new DetailMember(rs.getString("name"),
						rs.getString("img"), rs.getString("loc"), rs.getString("highschool"));
				return dm;
			}
		};
		
		String selectOneMember = "SELECT name, img, loc, highschool FROM test_like WHERE num=?";
		
		dm = jt.queryForObject(selectOneMember, rm, num);
		System.out.println("=========================="+dm);
		
		return dm;
	}
	
	public int updateMember(MemberUpdateVO muvo) throws DataAccessException {
		int cnt = 0;

		String updateMember = 
			"UPDATE test_like SET name=?, highschool=?, loc=? WHERE num=?";
		cnt = jt.update(updateMember,muvo.getName(), muvo.getHighschool(),
				muvo.getLoc(), muvo.getNum());
		
		return cnt;
	}
	
	public MemberImg deleteMember(int num) throws DataAccessException {
		MemberImg mi = null;
		int cnt = 0;
		String img = "";
		
		// 삭제할 이미지 조회
		String selectImg = "SELECT img FROM test_like WHERE num=?"; 
		RowMapper<String> rm = new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String img = rs.getString("img");
				return img;
			}
		};
		
		img = jt.queryForObject(selectImg, rm, num);
		
		String deleteMember = "DELETE FROM test_like WHERE num=?";
		cnt = jt.update(deleteMember,num);
		
		mi = new MemberImg(cnt, img);
		
		return mi;
	}
}
