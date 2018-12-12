package date181212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

public class PIManager extends Frame {

	private Button btnAdd, btnDel, btnEdit, btnClose;
	private TextField tfName, tfAge, tfAddr;
	private List listPi;
	
	public PIManager() {

		Label lblName = new Label("�̸�");
		Label lblAge = new Label("����");
		Label lblAddr = new Label("�ּ�");
		Label lblList = new Label("List");
		
		btnAdd = new Button("�߰�");
		btnDel = new Button("����");
		btnEdit = new Button("����");
		btnClose = new Button("�ݱ�");
		
		tfName = new TextField();
		tfAge = new TextField();
		tfAddr = new TextField();
		
		listPi = new List();
		
		setLayout(null);
		
		lblName.setBounds(40, 65, 30, 20);
		add(lblName);
		lblAge.setBounds(40, 115, 30, 20);
		add(lblAge);
		lblAddr.setBounds(40, 165, 30, 20);
		add(lblAddr);
		lblList.setBounds(200, 45, 30, 20);
		add(lblList);
		listPi.setBounds(200, 65, 200, 150);
		add(listPi);
		tfName.setBounds(70, 65, 80, 20);
		add(tfName);
		tfAge.setBounds(70, 115, 80, 20);
		add(tfAge);
		tfAddr.setBounds(70, 165, 80, 20);
		add(tfAddr);
		btnAdd.setBounds(80, 230, 60, 25);
		add(btnAdd);
		btnDel.setBounds(150, 230, 60, 25);
		add(btnDel);
		btnEdit.setBounds(220, 230, 60, 25);
		add(btnEdit);
		btnClose.setBounds(290, 230, 60, 25);
		add(btnClose);
		
		// �̺�Ʈ��ü�� ������Ʈ ����
		PIManagerEvt pime = new PIManagerEvt(this);
		tfName.addTextListener(pime);
		tfAge.addTextListener(pime);
		tfAddr.addTextListener(pime);
		listPi.addItemListener(pime);
		btnAdd.addActionListener(pime);
		btnDel.addActionListener(pime);
		btnEdit.addActionListener(pime);
		btnClose.addActionListener(pime);
		addWindowListener(pime);
		
		setBounds(400, 300, 450, 300);
		setVisible(true);
	}

	public Button getBtnAdd() {
		return btnAdd;
	}
	public Button getBtnDel() {
		return btnDel;
	}
	public Button getBtnEdit() {
		return btnEdit;
	}
	public Button getBtnClose() {
		return btnClose;
	}
	public TextField getTfName() {
		return tfName;
	}
	public TextField getTfAge() {
		return tfAge;
	}
	public TextField getTfAddr() {
		return tfAddr;
	}
	public List getListPi() {
		return listPi;
	}
}
