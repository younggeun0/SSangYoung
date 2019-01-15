package kr.co.sist.lunch.user.model;

public class LunchClientDAO {
	
	private static LunchClientDAO lc_dao;
	
	public static LunchClientDAO getInstance() {
		if (lc_dao == null) {
			lc_dao = new LunchClientDAO();
		}
		return lc_dao;
	}
	
}
