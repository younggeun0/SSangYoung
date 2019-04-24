package kr.co.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDAO {
	
	@Autowired(required=false)
	private JdbcTemplate jt;
	
	public JdbcTemplate getJt() {
		return jt;
	}
}
