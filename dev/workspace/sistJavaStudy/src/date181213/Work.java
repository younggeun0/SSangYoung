package date181213;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 12월12일자 숙제 재구현(is-a관계), 강사님이 제시한 클래스다이어그램 이용
public class Work extends Frame implements ActionListener, ItemListener {

	private Button btnAdd, btnDelete, btnUpdate, btnClose;
	private TextField tfName, tfAge, tfAddr;
	private List listDataView;

	public Work() {

		Label lblName = new Label("이름");
		Label lblAge = new Label("나이");
		Label lblAddr = new Label("주소");
		Label lblList = new Label("List");

		btnAdd = new Button("추가");
		btnDelete = new Button("삭제");
		btnUpdate = new Button("변경");
		btnClose = new Button("닫기");

		tfName = new TextField();
		tfAge = new TextField();
		tfAddr = new TextField();

		listDataView = new List();

		setLayout(null);

		lblName.setBounds(40, 65, 30, 20);
		add(lblName);
		lblAge.setBounds(40, 115, 30, 20);
		add(lblAge);
		lblAddr.setBounds(40, 165, 30, 20);
		add(lblAddr);
		lblList.setBounds(200, 45, 30, 20);
		add(lblList);
		listDataView.setBounds(200, 65, 200, 150);
		add(listDataView);
		tfName.setBounds(70, 65, 80, 20);
		add(tfName);
		tfAge.setBounds(70, 115, 80, 20);
		add(tfAge);
		tfAddr.setBounds(70, 165, 80, 20);
		add(tfAddr);
		btnAdd.setBounds(80, 230, 60, 25);
		add(btnAdd);
		btnDelete.setBounds(150, 230, 60, 25);
		add(btnDelete);
		btnUpdate.setBounds(220, 230, 60, 25);
		add(btnUpdate);
		btnClose.setBounds(290, 230, 60, 25);
		add(btnClose);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		btnAdd.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnClose.addActionListener(this);
		listDataView.addItemListener(this);

		setBounds(400, 300, 450, 300);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String[] str = listDataView.getSelectedItem().split(" / ");

		tfName.setText(str[0]);
		tfAge.setText(str[1]);
		tfAddr.setText(str[2]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			add();
		}
		if (e.getSource() == btnUpdate) {
			update();
		}
		if (e.getSource() == btnDelete) {
			remove();
		}
		if (e.getSource() == btnClose) {
			dispose();
		}
	}

	public void add() {
		String name = tfName.getText();
		String age = tfAge.getText();
		String addr = tfAddr.getText();

		if (!(name.isEmpty() || age.isEmpty() || addr.isEmpty())) {
			StringBuilder item = new StringBuilder();
			item.append(name).append(" / ").append(age).append(" / ").append(addr);
			listDataView.add(item.toString());

			tfName.setText("");
			tfAge.setText("");
			tfAddr.setText("");
		}
	}

	public void remove() {
		if (listDataView.getSelectedIndex() != -1) {
			listDataView.remove(listDataView.getSelectedIndex());

			tfName.setText("");
			tfAge.setText("");
			tfAddr.setText("");
		}
	}

	public void update() {
		if (listDataView.getSelectedIndex() != -1) {
			int selectedIdx = listDataView.getSelectedIndex();
			
			String name = tfName.getText();
			String age = tfAge.getText();
			String addr = tfAddr.getText();
			
			listDataView.remove(selectedIdx);
			
			StringBuilder item = new StringBuilder();
			item.append(name).append(" / ").append(age).append(" / ").append(addr);
			listDataView.add(item.toString(), selectedIdx);
			
			tfName.setText("");
			tfAge.setText("");
			tfAddr.setText("");
		}
	}

	public static void main(String[] args) {
		new Work();
	}
}
