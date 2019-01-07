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

		// 1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		// 2. Connection ���
		try {

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url, id, pass);

			// 3. ������ ������ü ���
			stmt = con.createStatement();

			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode.append(" SELECT zipcode, sido, gugun, dong, NVL(bunji,' ') bunji ").append(" FROM zipcode ")
					.append(" WHERE dong LIKE '").append(blockSqlInjection(dong)).append("%'");

			// 4. ���� ���� �� ��� ���
			rs = stmt.executeQuery(selectZipcode.toString());

			ZipcodeVO zv = null;

			while (rs.next()) { // ��ȸ�� ���ڵ尡 �����Ѵٸ�
				// VO�� ���� �Ҵ��ϰ�
				zv = new ZipcodeVO(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("bunji"));
				// ���� �̸��� ��ü�� ������ �����ϱ� ���� List�� �߰�
				list.add(zv);
			}

		} finally {
			// 5. �������
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
			// DB���� ��ȸ�� ����� �޾Ƽ�
			List<ZipcodeVO> listZip = selectZipcode(dong);

			// DefaultTableModel�� �߰� => JTable�� �ݿ��ȴ�.
			DefaultTableModel dtm = zv.getDtmZipcode();

			// D.T.M �ʱ�ȭ
			dtm.setRowCount(0);

			String[] rowData = null;
			// D.T.M�� ��(Row : �����ȣ, �ּ� ) �߰�
			// ��ȸ�� ����� ������
			for (ZipcodeVO zv : listZip) {
				// �迭�� �ְ�
				rowData = new String[2];
				rowData[0] = zv.getZipcode();
				rowData[1] = zv.getSido() + " " + zv.getGugun() + " " + zv.getDong() + " " + zv.getBunji();
				dtm.addRow(rowData);
			}

			if (listZip.isEmpty()) {
				rowData = new String[2];
				rowData[0] = "";
				rowData[1] = "�ش� ���� �������� �ʽ��ϴ�.";
				dtm.addRow(rowData);
			}

		} catch (SQLException se) {
			JOptionPane.showMessageDialog(zv, "DB���� ���� �߻�");
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
