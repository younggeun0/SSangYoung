package date181210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * �Ϲ� ������Ʈ�� Container ������Ʈ�� ������ �� �ִ�
 * @author owner
 */
// 1. Window Component ��� 
public class UsePanel extends Frame {

	public UsePanel() {

		super("Container Component ���");
		
		// 2. ������Ʈ ����
		// �̸��ο���� - �밡���� ǥ���(Hungarian notation)
		Label lblName = new Label("�̸�");
		
		// ������ : field
		lblName.setForeground(new Color(0x61AFEF));
		lblName.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		
		TextField tfName = new TextField(20);
		
		tfName.setBackground(Color.BLACK);
		tfName.setForeground(Color.GREEN);
		
		Button btnAdd = new Button("�߰�");
		Color back = new Color(0xFF5E00);
		Color fore = new Color(0x6BEC62);
		btnAdd.setBackground(back);
		btnAdd.setForeground(fore);
		
		Button btnClose = new Button("����");
		btnClose.setBackground(Color.DARK_GRAY);
		btnClose.setForeground(Color.GREEN);
		
		TextArea taDisplay = new TextArea();
		// ������ : RGB�� ����� ������ ���. -> �پ��� ���� ����� �� �ִ�.
		taDisplay.setBackground(Color.DARK_GRAY);
		taDisplay.setForeground(Color.GREEN);
		taDisplay.setFont(new Font(Font.SERIF, Font.BOLD|Font.ITALIC, 20));
		
		
		// �Ϲ�������Ʈ�� ��ġ�� �� �ִ� �����̳� ������Ʈ ����
		Panel panelNorth = new Panel();
		
		panelNorth.setBackground(new Color(0x282C34));
		
		// ������ �����̳� ������Ʈ�� �Ϲ� ������Ʈ�� ��ġ
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(btnAdd);
		panelNorth.add(btnClose);
		
		// 3. ��ġ������ ����
		setLayout(new BorderLayout());
		
		// 4. ��ġ BorderLayout�� Ư¡
		// �ϳ��� �������� �ϳ��� ������Ʈ�� ���尡��
		
		add(BorderLayout.NORTH, panelNorth);
		add(BorderLayout.CENTER, taDisplay);
		
		// 5. Window ��ġ,ũ�� ����
		setBounds(200, 150, 400, 250);
		
		// 6. ����ȭ
		setVisible(true);
		
		// 7. ����ó��
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new UsePanel();
	}
}
