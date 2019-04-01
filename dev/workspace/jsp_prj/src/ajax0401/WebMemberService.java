package ajax0401;

import java.sql.SQLException;

import org.json.simple.JSONObject;

public class WebMemberService {
	
	public JSONObject searchId(String id) {
		JSONObject json = new JSONObject();
		
		WebMemberDAO wm_dao = WebMemberDAO.getInstance();
		
		boolean flag = false;
		try {
			flag = wm_dao.selectId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// DB조회 결과를 JSONObject에 추가
		json.put("idResult", flag);
		
		return json;
	}

}
