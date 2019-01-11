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
					JOptionPane.showMessageDialog(ctv, "이미 생성된 테이블명입니다.");
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
				JOptionPane.showMessageDialog(ctv, "테이블명을 입력해주세요.");
				ctv.getJtfTabName().requestFocus();
			}
		}
		
		if (e.getSource() == ctv.getJbAddCol() || e.getSource() == ctv.getJtfColName()
				|| e.getSource() == ctv.getJtfColSize() || e.getSource() == ctv.getJtfConstName()) {
			if (sql == null) {
				JOptionPane.showMessageDialog(ctv, "테이블을 먼저 생성해주세요.");
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
				JOptionPane.showMessageDialog(ctv, "테이블을 먼저 생성해주세요.");
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
				JOptionPane.showMessageDialog(ctv, "Query View가 이미 초기화되어 있습니다.");
			}
		}
	}
	
	public void createDefaultQuery(String tabName) {
		sql = new StringBuilder();
		sql.append("CREATE TABLE ").append(tabName).append("(");
	}
	
	public void addColumnQuery() {
		
		// 컬럼명 - 필수
		String colName = ctv.getJtfColName().getText().trim().toUpperCase();
		if (colName.isEmpty()) {
			JOptionPane.showMessageDialog(ctv, "컬럼명은 필수입니다.");
			ctv.getJtfColName().requestFocus();
			return;
		}

		// 컬럼명 - 필수, 콤보박스므로 무조건 선택됨
		String colType = ctv.getJcbColType().getSelectedItem().toString();
		
		String colSize = "";
		// Size - VARCHAR2, NUMBER일 때 필수, DATE 땐 필수X(empty)
		if (!colType.equals("DATE")) {
			colSize = ctv.getJtfColSize().getText().trim();
			if (colSize.isEmpty()) {
				JOptionPane.showMessageDialog(ctv, "VARCHAR2, CHAR, NUMBER의 크기는 필수입니다.");
				ctv.getJtfColSize().requestFocus();
				return;
			}
			
			try {
				if (colType.equals("NUMBER")) {
					if (Integer.parseInt(colSize) > 22) {
						JOptionPane.showMessageDialog(ctv, "NUMBER의 최대 크기는 22입니다.");
						ctv.getJtfColSize().setText("");
						ctv.getJtfColSize().requestFocus();
						return;
					}
				}
				if (colType.equals("CHAR")) {
					if (Integer.parseInt(colSize) > 2000) {
						JOptionPane.showMessageDialog(ctv, "CHAR의 최대 크기는 2000입니다.");
						ctv.getJtfColSize().setText("");
						ctv.getJtfColSize().requestFocus();
						return;
					}
				}
				if (colType.equals("VARCHAR2")) {
					if (Integer.parseInt(colSize) > 4000) {
						JOptionPane.showMessageDialog(ctv, "VARCHAR2의 최대 크기는 4000입니다.");
						ctv.getJtfColSize().setText("");
						ctv.getJtfColSize().requestFocus();
						return;
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(ctv, "크기는 숫자만 입력가능합니다.");
				ctv.getJtfColSize().setText("");
				ctv.getJtfColSize().requestFocus();
				return;
			}
		} else {
			if(!ctv.getJtfColSize().getText().isEmpty()) {
				JOptionPane.showMessageDialog(ctv, "DATE형은 크기가 없습니다.");
				ctv.getJtfColSize().setText("");
				ctv.getJtfColSize().requestFocus();
				return;
			}
		}
		
		// 제약사항 선택
		String colConstraint = ctv.getJcbConstraint().getSelectedItem().toString();
		
		// NULL, NOT NULL 일땐 제약사항명 없음, PK, FK, UNIQUE일 때 필수
		String colConstName = "";
		String fkTabName = "";
		String fkColName = "";
		if (!(colConstraint.equals("NULL") || colConstraint.equals("NOT NULL"))) {
			colConstName = ctv.getJtfConstName().getText().trim().toUpperCase();
			
			
			if (colConstName.equals("")) {
				JOptionPane.showMessageDialog(ctv, colConstraint+" 제약사항명은 필수입니다.");
				ctv.getJtfConstName().requestFocus();
				return;
			}
			
			if (colConstraint.equals("FOREIGN KEY")) {
				fkTabName = ctv.getJtfFkTab().getText().trim().toUpperCase();
				fkColName = ctv.getJtfFkCol().getText().trim().toUpperCase();
				
				if (fkTabName == null || fkTabName.isEmpty()) {
					JOptionPane.showMessageDialog(ctv, colConstraint+" 참조테이블명은 필수입니다.");
					ctv.getJtfFkTab().requestFocus();
					return;
				}
				
				for(int i=0; i<listTabNames.size(); i++) {
					if (fkTabName.equals(listTabNames.get(i))) {
						JOptionPane.showMessageDialog(ctv, "참조 가능한 테이블입니다.");
						ctv.getJtfFkCol().requestFocus();
						break;
					}
				}
				
				if (fkColName == null || fkColName.isEmpty()){
					JOptionPane.showMessageDialog(ctv, colConstraint+" 참조컬럼명은 필수입니다.");
					ctv.getJtfFkCol().requestFocus();
					return;
				}
				
			} else if (pkFlag) {
				JOptionPane.showMessageDialog(ctv, "PK는 이미 설정하셨습니다.");
				ctv.getJcbConstraint().requestFocus();
				return;
			}
			
		} else {
			if(!ctv.getJtfConstName().getText().isEmpty()) {
				JOptionPane.showMessageDialog(ctv, "NULL, NOT NULL은 제약사항명이 없습니다.");
				ctv.getJtfConstName().setText("");
				ctv.getJtfConstName().requestFocus();
				return;
			}
		}

		for(String addedColName : listColumnName) {
			if (colName.equals(addedColName)) {
				JOptionPane.showMessageDialog(ctv, "중복된 컬럼명입니다.");
				return;
			}
		}
		
		// 검증이 끝난 후 sql에 추가
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
