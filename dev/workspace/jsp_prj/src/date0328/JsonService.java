package date0328;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonService {
	
	public JSONObject searchEmpData(int deptno) {
		JSONObject jsonObj = new JSONObject();
		
		JsonEmpSearchDAO j_dao = JsonEmpSearchDAO.getInstance();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			jsonObj.put("pubDate", sdf.format(new Date()));

			List<EmpVO> list = j_dao.selectEmpList(deptno);
			jsonObj.put("result", !list.isEmpty()); // ��ȸ�� ����Ǹ� true
			
			EmpVO evo = null;
			JSONArray jsonArr = new JSONArray();
			JSONObject tempObj = null;
			for(int i=0; i<list.size(); i++) {
				tempObj = new JSONObject();
				evo = list.get(i);
				
				tempObj.put("empno", evo.getEmpno());
				tempObj.put("ename", evo.getEname());
				tempObj.put("job", evo.getJob());
				tempObj.put("hiredate", evo.getHiredate());
				tempObj.put("sal", evo.getSal());
				
				// JSONArry�� JSONObject���� �߰�
				jsonArr.add(tempObj);
			}
			
			// ��ȸ�� ����� ���� JSONArry�� JSONObject�� �ߤ���
			jsonObj.put("resultData", jsonArr);
		} catch (SQLException e) {
			jsonObj.put("result", false);
			e.printStackTrace();
		}
		
		return jsonObj;
	}
}
