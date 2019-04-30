package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.OrmDAO;
import kr.co.sist.domain.Lunch;
import kr.co.sist.domain.LunchDetail;

@Component
public class OrmService {
	
	@Autowired(required=false)
	private OrmDAO odao;
	
	public List<Lunch> searchAllList() {
		List<Lunch> list = null;
		try {
			list = odao.selectAllLunch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public JSONObject searchDetailLunch(String lunchCode) {
		JSONObject json = null;
		try {
			LunchDetail ld = odao.selectDetailLunch(lunchCode);
			json = new JSONObject();
			json.put("img", ld.getImg());
			json.put("spec", ld.getSpec());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return json;
	}
}
