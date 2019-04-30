package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.Lunch;
import kr.co.sist.domain.LunchDetail;

@Component
public class OrmDAO {
	
	@Autowired(required=false)
	private SqlSessionTemplate sst;
	
	public List<Lunch> selectAllLunch() throws SQLException {
		List<Lunch> list = null;
		
		list = sst.selectList("selectAllLunch");
		
		return list;
	}
	
	public LunchDetail selectDetailLunch(String lunchCode) throws SQLException {
		LunchDetail ld = null;
		
		ld = sst.selectOne("selectDetailLunch", lunchCode);
		
		return ld;
	}
}
