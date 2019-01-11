package date190110.create_table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateTableViewEvt extends WindowAdapter implements ActionListener {
	
	private CreateTableView ctv;
	private StringBuilder sql;
	private String tabName;
	private boolean firstColumnFlag;
	private boolean pkFlag;
	private List<String> listColumnName;
	private List<String> listTabNames;

	public CreateTableViewEvt(CreateTableView ctv, List<String> listTabNames) {
		this.ctv = ctv;
		this.listTabNames = listTabNames;
		listColumnName = new ArrayList<String>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ctv.getJbAddTab() || e.getSource() == ctv.getJtfTabName()) {
			tabName = ctv.getJtfTabName().getText().trim().toUpperCase();
			
			for (int i=0; i<listTabNames.size(); i++) {
				if (tabName.equals(listTabNames.get(i))) {
					JOptionPane.showMessageDialog(ctv, "�̹� ������ ���̺���Դϴ�.");
					ctv.getJtfTabName().setText("");
					ctv.getJtfTabName().requestFocus();
					return;
				}
			}
			
			if (tabName != null && !tabName.equals("")) {
				createDefaultQuery(tabName);
				
				JTextArea jta = ctv.getJtaQueryView();
				jta.setText(sql.toString());
				jta.append(");");
				
				ctv.getJtfColName().requestFocus();
			} else {
				JOptionPane.showMessageDialog(ctv, "���̺���� �Է����ּ���.");
				ctv.getJtfTabName().requestFocus();
			}
		}
		
		if (e.getSource() == ctv.getJbAddCol() || e.getSource() == ctv.getJtfColName()
				|| e.getSource() == ctv.getJtfColSize() || e.getSource() == ctv.getJtfConstName()) {
			if (sql == null) {
				JOptionPane.showMessageDialog(ctv, "���̺��� ���� �������ּ���.");
				ctv.getJtfTabName().requestFocus();
				return;
			}

			addColumnQuery();
			
			JTextArea jta = ctv.getJtaQueryView();
			jta.setText(sql.toString());
			jta.append("\n);");
		}
		
		if (e.getSource() == ctv.getJbCreateTab()) {
			if (ctv.getJtaQueryView().getText().isEmpty()) {
				JOptionPane.showMessageDialog(ctv, "���̺��� ���� �������ּ���.");
				ctv.getJtfTabName().requestFocus();
				return;
			}
			
			String createTable = sql.append(")").toString();
			try {
				new CreateTableDAO(createTable, ctv);
			} catch (SQLException se) {
				String errMsg = "";
				
				errMsg = se.getMessage();
				JOptionPane.showMessageDialog(ctv, errMsg);
				se.printStackTrace();
			}
			
		}
		
		if (e.getSource() == ctv.getJbClean()) {
			if (!ctv.getJtaQueryView().getText().isEmpty()) {
				sql.setLength(0);
				ctv.getJtaQueryView().setText("");
				listColumnName.clear();
				firstColumnFlag = false;
				pkFlag = false;
			} else {
				JOptionPane.showMessageDialog(ctv, "Query View�� �̹� �ʱ�ȭ�Ǿ� �ֽ��ϴ�.");
			}
		}
	}
	
	public void createDefaultQuery(String tabName) {
		sql = new StringBuilder();
		sql.append("CREATE TABLE ").append(tabName).append("(");
	}
	
	public void addColumnQuery() {
		
		// �÷��� - �ʼ�
		String colName = ctv.getJtfColName().getText().trim().toUpperCase();
		if (colName.isEmpty()) {
			JOptionPane.showMessageDialog(ctv, "�÷����� �ʼ��Դϴ�.");
			ctv.getJtfColName().requestFocus();
			return;
		}

		// �÷��� - �ʼ�, �޺��ڽ��Ƿ� ������ ���õ�
		String colType = ctv.getJcbColType().getSelectedItem().toString();
		
		String colSize = "";
		// Size - VARCHAR2, NUMBER�� �� �ʼ�, DATE �� �ʼ�X(empty)
		if (!colType.equals("DATE")) {
			colSize = ctv.getJtfColSize().getText().trim();
			if (colSize.isEmpty()) {
				JOptionPane.showMessageDialog(ctv, "VARCHAR2, CHAR, NUMBER�� ũ��� �ʼ��Դϴ�.");
				ctv.getJtfColSize().requestFocus();
				return;
			}
			
			try {
				if (colType.equals("NUMBER")) {
					if (Integer.parseInt(colSize) > 22) {
						JOptionPane.showMessageDialog(ctv, "NUMBER�� �ִ� ũ��� 22�Դϴ�.");
						ctv.getJtfColSize().setText("");
						ctv.getJtfColSize().requestFocus();
						return;
					}
				}
				if (colType.equals("CHAR")) {
					if (Integer.parseInt(colSize) > 2000) {
						JOptionPane.showMessageDialog(ctv, "CHAR�� �ִ� ũ��� 2000�Դϴ�.");
						ctv.getJtfColSize().setText("");
						ctv.getJtfColSize().requestFocus();
						return;
					}
				}
				if (colType.equals("VARCHAR2")) {
					if (Integer.parseInt(colSize) > 4000) {
						JOptionPane.showMessageDialog(ctv, "VARCHAR2�� �ִ� ũ��� 4000�Դϴ�.");
						ctv.getJtfColSize().setText("");
						ctv.getJtfColSize().requestFocus();
						return;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(ctv, "ũ��� ���ڸ� �Է°����մϴ�.");
				ctv.getJtfColSize().setText("");
				ctv.getJtfColSize().requestFocus();
				return;
			}
		} else {
			if(!ctv.getJtfColSize().getText().isEmpty()) {
				JOptionPane.showMessageDialog(ctv, "DATE���� ũ�Ⱑ �����ϴ�.");
				ctv.getJtfColSize().setText("");
				ctv.getJtfColSize().requestFocus();
				return;
			}
		}
		
		// ������� ����
		String colConstraint = ctv.getJcbConstraint().getSelectedItem().toString();
		
		// NULL, NOT NULL �϶� ������׸� ����, PK, FK, UNIQUE�� �� �ʼ�
		String colConstName = "";
		String fkTabName = "";
		String fkColName = "";
		if (!(colConstraint.equals("NULL") || colConstraint.equals("NOT NULL"))) {
			colConstName = ctv.getJtfConstName().getText().trim().toUpperCase();
			
			
			if (colConstName.equals("")) {
				JOptionPane.showMessageDialog(ctv, colConstraint+" ������׸��� �ʼ��Դϴ�.");
				ctv.getJtfConstName().requestFocus();
				return;
			}
			
			if (colConstraint.equals("FOREIGN KEY")) {
				fkTabName = ctv.getJtfFkTab().getText().trim().toUpperCase();
				fkColName = ctv.getJtfFkCol().getText().trim().toUpperCase();
				
				if (fkTabName == null || fkTabName.isEmpty()) {
					JOptionPane.showMessageDialog(ctv, colConstraint+" �������̺���� �ʼ��Դϴ�.");
					ctv.getJtfFkTab().requestFocus();
					return;
				}
				
				for(int i=0; i<listTabNames.size(); i++) {
					if (fkTabName.equals(listTabNames.get(i))) {
						JOptionPane.showMessageDialog(ctv, "���� ������ ���̺��Դϴ�.");
						ctv.getJtfFkCol().requestFocus();
						break;
					}
				}
				
				if (fkColName == null || fkColName.isEmpty()){
					JOptionPane.showMessageDialog(ctv, colConstraint+" �����÷����� �ʼ��Դϴ�.");
					ctv.getJtfFkCol().requestFocus();
					return;
				}
				
			} else if (pkFlag) {
				JOptionPane.showMessageDialog(ctv, "PK�� �̹� �����ϼ̽��ϴ�.");
				ctv.getJcbConstraint().requestFocus();
				return;
			}
			
		} else {
			if(!ctv.getJtfConstName().getText().isEmpty()) {
				JOptionPane.showMessageDialog(ctv, "NULL, NOT NULL�� ������׸��� �����ϴ�.");
				ctv.getJtfConstName().setText("");
				ctv.getJtfConstName().requestFocus();
				return;
			}
		}

		for(String addedColName : listColumnName) {
			if (colName.equals(addedColName)) {
				JOptionPane.showMessageDialog(ctv, "�ߺ��� �÷����Դϴ�.");
				return;
			}
		}
		
		// ������ ���� �� sql�� �߰�
		if (firstColumnFlag) {
			sql.append(", ");
		} 
		
		sql
		.append("\n     ").append(colName).append(" ")
		.append(colType);
		
		if (!colSize.isEmpty()) {
			sql.append("(").append(colSize).append(") ");
		} else {
			sql.append(" ");
		}
		
		if (!colConstName.isEmpty()) {
			if (colConstraint.equals("PRIMARY KEY")) {
				sql
				.append("CONSTRAINT ")
				.append(colConstName)
				.append(" PRIMARY KEY");
				pkFlag = true;
			}
			if (colConstraint.equals("FOREIGN KEY")) {
				sql
				.append("CONSTRAINT ")
				.append(colConstName)
				.append(" REFERENCES ")
				.append(fkTabName)
				.append("(").append(fkColName).append(")");
			}
		} else {
			sql.append(colConstraint);
		}

		listColumnName.add(colName);
		
		firstColumnFlag = true;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		ctv.dispose();
	}
}
