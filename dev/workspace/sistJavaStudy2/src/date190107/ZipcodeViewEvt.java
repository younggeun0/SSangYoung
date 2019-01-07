package date190107;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ZipcodeViewEvt extends WindowAdapter implements ActionListener {

	private ZipcodeView zv;

	public ZipcodeViewEvt(ZipcodeView zv) {
		this.zv = zv;
	}

	public String blockSqlInjection(String sql) {
		return sql.replaceAll("'", "").replaceAll("--", "");
	}

	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();

		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		// 2. Connection 얻기
		try {

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url, id, pass);

			// 3. 쿼리문 생성객체 얻기
			stmt = con.createStatement();

			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode.append(" SELECT zipcode, sido, gugun, dong, NVL(bunji,' ') bunji ").append(" FROM zipcode ")
					.append(" WHERE dong LIKE '").append(blockSqlInjection(dong)).append("%'");

			// 4. 쿼리 수행 후 결과 얻기
			rs = stmt.executeQuery(selectZipcode.toString());

			ZipcodeVO zv = null;

			while (rs.next()) { // 조회된 레코드가 존재한다면
				// VO에 값을 할당하고
				zv = new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("bunji"));
				// 같은 이름의 객체를 여러개 관리하기 위해 List에 추가
				list.add(zv);
			}

		} finally {
			// 5. 연결끊기
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return list;
	}

	public void searchZipcode(String dong) {
		try {
			// DB에서 조회한 결과를 받아서
			List<ZipcodeVO> listZip = selectZipcode(dong);

			// DefaultTableModel에 추가 => JTable에 반영된다.
			DefaultTableModel dtm = zv.getDtmZipcode();

			// D.T.M 초기화
			dtm.setRowCount(0);

			String[] rowData = null;
			// D.T.M에 행(Row : 우편번호, 주소 ) 추가
			// 조회된 결과를 가지고
			for (ZipcodeVO zv : listZip) {
				// 배열에 넣고
				rowData = new String[2];
				rowData[0] = zv.getZipcode();
				rowData[1] = zv.getSido() + " " + zv.getGugun() + " " + zv.getDong() + " " + zv.getBunji();
				dtm.addRow(rowData);
			}

			if (listZip.isEmpty()) {
				rowData = new String[2];
				rowData[0] = "";
				rowData[1] = "해당 동은 존재하지 않습니다.";
				dtm.addRow(rowData);
			}

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(zv, "DB에서 문제 발생");
			se.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String dong = zv.getJtfDong().getText().trim();

		if (!dong.equals("")) {
			searchZipcode(dong);
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		zv.dispose();
	}
}
