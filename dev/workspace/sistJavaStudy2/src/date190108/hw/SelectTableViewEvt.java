package date190108.hw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.connection.GetConnection;

public class SelectTableViewEvt extends WindowAdapter implements ActionListener {

	private SelectTableView stv;
	
	public SelectTableViewEvt(SelectTableView stv) {
		this.stv = stv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String tabName = (String) stv.getJcbTab().getSelectedItem();
		
		if (tabName.equals("���̺��")) {
			JOptionPane.showMessageDialog(stv, "���̺��� �������ּ���.");
			return;
		}
		
		try {
			getRecord(tabName);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void getRecord(String tabName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		GetConnection gc = GetConnection.getInstance();
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		try {
			// 1. ����̹� �ε�
			// 2. Connection ���
			con = gc.getConn(url, id, pass);
			
			// DB ����¥�� ��������...
			String selectTabInfo = "" + 
					"SELECT utc.column_name, utc.data_type, NVL(utc.data_precision,0) data_precision, NVL(ucc.constraint_name, ' ') constraint_name " + 
					"FROM user_tab_cols utc, user_cons_columns ucc " + 
					"WHERE utc.table_name=? " + 
					" AND utc.table_name = ucc.table_name(+) " + 
					" AND utc.column_name = ucc.column_name(+)";
			
			// 3. ������ ������ü ���
			pstmt = con.prepareStatement(selectTabInfo);
			// 4. ���ε� ���� ����
			pstmt.setString(1, tabName);
			
			// 5. ���� ���� ��� ���
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			
			// dtm �ʱ�ȭ
			stv.getDtm().setRowCount(0);
			
			int idx = 1;
			String[] rowData = new String[4];
			while(rs.next()) {
				rowData[0] = rs.getString("COLUMN_NAME");
				rowData[1] = rsmd.getColumnTypeName(2);
				rowData[2] = rs.getString(3);
				rowData[3] = rs.getString("CONSTRAINT_NAME");
				stv.getDtm().addRow(rowData);
				idx++;
			}
			
		} finally {
			// 6. ���� ����
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (con != null) { con.close(); }
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		stv.dispose();
	}
}
