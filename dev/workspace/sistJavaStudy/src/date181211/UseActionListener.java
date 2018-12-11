package date181211;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ActionListener�� ����� �̺�Ʈ ó��<br>
 * is-a ����� �̺�Ʈ�� ó��
 * @author owner
 */
@SuppressWarnings("serial")
public class UseActionListener extends Frame implements ActionListener {

	// �ٸ� �޼ҵ忡�� ����ؾ� �ϹǷ� ������������ �ν��Ͻ������� �ű�
	private TextField tfName;
	private TextArea taDisplay;
	
	public UseActionListener() {

		super("ActionEvent ���");
		
		Label lblName = new Label("�̸�");
		Button btnAdd = new Button("�߰�");
		Button btnClose = new Button("����");
		Panel panelNorth = new Panel();
		tfName = new TextField(20);
		taDisplay = new TextArea();
		
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(btnAdd);
		panelNorth.add(btnClose);
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, panelNorth);
		add(BorderLayout.CENTER, taDisplay);
		
		// �̺�Ʈ ���
		btnAdd.addActionListener(this); // ��ư���� �̺�Ʈ�� ���(Ŭ��)
		tfName.addActionListener(this); // �ؽ�Ʈ�ʵ忡�� �̺�Ʈ�� ���(����)
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setBounds(200, 150, 400, 250);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		new UseActionListener();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TextField�� ���� �޾ƿͼ�, TextArea�� �߰�
		String name = tfName.getText();
		if (!name.isEmpty()) { // �Է¹��ڿ��� ������� �ʴٸ�
			taDisplay.append(name+"\n");
			
			// TextField�� ���� �ʱ�ȭ
			tfName.setText("");
		}
		// Ŀ���� TextField�� �缳��
		tfName.requestFocus();
	}
}
