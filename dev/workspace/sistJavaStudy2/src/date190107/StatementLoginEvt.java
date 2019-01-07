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

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StatementLoginEvt extends WindowAdapter implements ActionListener {
	
	private StatementLogin sl;
	
	public StatementLoginEvt(StatementLogin sl) {
		this.sl = sl;
	}
	
	// SQL Injection ����ڵ�
	// ȸ������ ���� �� ���� ����, ���� ����ǥ, ������ �� ���� ���ƾ� �Ѵ�.
	public String blockSqlInjection(String data) {
		return data.replaceAll(" ", "").replaceAll("'","").replaceAll("--", "");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sl.getJtfId() || e.getSource() == sl.getJpfPass() 
				|| e.getSource() == sl.getJbtLogin()) {
			
			String id = sl.getJtfId().getText().trim();
			String pass = new String(sl.getJpfPass().getPassword()).trim();
			
			if (chkNull(id, pass)) {
				try {
					String name = login(id, pass);
					
					if (name.isEmpty()) {
						JOptionPane.showMessageDialog(sl, "���̵� ��й�ȣ�� Ȯ�����ּ���.");
						sl.getJtfId().setText("");
						sl.getJpfPass().setText("");
						sl.getJtfId().requestFocus();
						return;
					} 
					
					JDialog jd = new JDialog(sl, "�α��� ����", true);
					jd.add(new JLabel(name+"�� �α��� �ϼ̽��ϴ�."));
					jd.setBounds(sl.getX()+100,sl.getY()+100, 300, 200);
					jd.setResizable(false);
					jd.setVisible(true);
					jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					
				} catch (SQLException se) {
					JOptionPane.showMessageDialog(sl, "DB�۾� �� ������ �߻��߽��ϴ�.");
					se.printStackTrace();
				}
			}
		}
		if (e.getSource() == sl.getJbtCancel()) {
			sl.getJtfId().setText("");
			sl.getJpfPass().setText("");
			sl.getJtfId().requestFocus();
		}
	}

	public String login(String id, String pass) throws SQLException {
		String name = "";
		
		// 1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// 2. Connection ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dbo_id = "scott";
		String dbo_pass = "tiger";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, dbo_id, dbo_pass);
			// 3. ������ ������ü ���
			stmt = con.createStatement();
			
			StringBuilder selectName = new StringBuilder();
			selectName
			.append("SELECT name ")
			.append("FROM test_login ")
			.append("WHERE id='").append(blockSqlInjection(id)).append("' AND ")
			.append("pass='").append(blockSqlInjection(pass)).append("'");
			
			// 4. ������ ���� �� ��� ���
			rs = stmt.executeQuery(selectName.toString());
			
			if (rs.next()) { // �Էµ� ���̵�� ��й�ȣ�� �´� �̸��� ���� => �α��� ����
				name = rs.getString("name");
			}
		
		} finally {
			// 5. ���� ����
			if (rs != null) { rs.close(); }
			if (stmt != null) { stmt.close(); }
			if (con != null) { con.close(); }
		}
		
		return name;
	}
	
	public boolean chkNull(String id, String pass)  { // *****
		boolean flag = false;
		
		try {
			if (id.equals("")) {
				JOptionPane.showMessageDialog(sl, "���̵�� �ʼ� �Է�");
				sl.getJtfId().requestFocus();
				flag = true;
				// ���ܸ� ������ �߻�, throw new ����ó��Ŭ������(); *****
				throw new LoginException("���̵� ����");
			}

			if (pass.equals("")) {
				JOptionPane.showMessageDialog(sl, "��й�ȣ�� �ʼ� �Է�");
				sl.getJpfPass().requestFocus();
				flag = true;
				throw new LoginException("��й�ȣ ����");
			}
		} catch (LoginException le) {
			le.printStackTrace();
		}
		
		return !flag;
	}
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		sl.dispose();
	}
}
