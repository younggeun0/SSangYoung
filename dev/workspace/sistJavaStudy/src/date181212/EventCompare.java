package date181212;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ���� ������ �̺�Ʈ�� ������ �߻��ϸ�,
 * �� �̺�Ʈ�� ���Ͽ� ó���ϴ� ���<br>
 * 1. �̺�Ʈ�� �߻���Ų ��ü�� �ּҺ� - ��� �̺�Ʈ ��밡�� : getSource() <br>
 * 2. �̺�Ʈ �߻���Ų ��ü�� Label�� ���ϴ� ��� - ActionEvent�� ���� : 
 * 		getActionCommand() <br>
 * @author owner
 */
@SuppressWarnings("serial")
// 1. Window Component ���, Eventó�� Listener�� ����
public class EventCompare extends Frame implements ActionListener {

	// 2. �̺�Ʈ�� �����ִ� Component�� ����
	private Button btnOpen;
	private Button btnSave;
	private Label lblOutput;
	
	public EventCompare() {
		super("���ϴ��̾�α� ���");
		
		// 3. ����
		btnOpen = new Button("������");
		btnSave = new Button("������");
		lblOutput = new Label("���â : ");
		
		// 4. ��ġ
		Panel panel = new Panel(); // Container Component
		panel.add(btnOpen); panel.add(btnSave);
		add(BorderLayout.CENTER, panel);
		add(BorderLayout.SOUTH, lblOutput);
		
		// 5. �̺�Ʈ ���
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);
		
		// 6. ������ ũ�� ����
		setBounds(100, 100, 700, 100);
		// 7. ����ȭ
		setVisible(true);
		// ����ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/////////////////// �ּ� �� //////////////////////
		/*if (e.getSource() == btnOpen) {
			System.out.println("����");
		}
		if (e.getSource() == btnSave) {
			
			System.out.println("����");
		}*/
		////////////////////////////////////////////////////
		/////////////////// Label �� //////////////////////
		String label = e.getActionCommand();
		if (label.equals("������")) {
			System.out.println("����");
			FileDialog fdOpen = new FileDialog(this, "���� ����", FileDialog.LOAD);
			// ����ȭ
			fdOpen.setVisible(true);
			
			String path = fdOpen.getDirectory();
			String name = fdOpen.getFile();
			
			if (name != null) { // ������ ������ ���� �� 
				lblOutput.setText("���� ���� : "+path+name);
				// Ÿ��Ʋ���� ���� ����
				setTitle("���ϴ��̾�α� ��� - ���� : "+name);
			}
		}
		if (label.equals("������")) {
			System.out.println("����");
			FileDialog fdSave = new FileDialog(this, "���� ����", FileDialog.SAVE);
			// ����ȭ
			fdSave.setVisible(true);
			
			String path = fdSave.getDirectory();
			String name = fdSave.getFile();
			
			if (name != null) {
				lblOutput.setText("���� ���� : "+path+name);
				// Ÿ��Ʋ���� ���� ����
				setTitle("���ϴ��̾�α� ��� - ���� : "+name);
			}
		}
		////////////////////////////////////////////////////
	}
	public static void main(String[] args) {
		new EventCompare();
	}
}
