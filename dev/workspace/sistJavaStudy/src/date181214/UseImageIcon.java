package date181214;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Icon class�� ����� �̹��� ���
 * @author owner
 */
public class UseImageIcon extends JFrame {
	
	public UseImageIcon() {
		super("ImageIcon���");
		
		ImageIcon ii1 = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy/src/date181214/images/ebichuPng.png");
		ImageIcon ii2 = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy/src/date181214/images/ebichuPng2.png");
		ImageIcon ii3 = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy/src/date181214/images/ebichuPng3.png");
		
		ImageIcon ii4 = new ImageIcon("C:\\Users\\owner\\youngRepositories\\SSangYoung\\dev\\workspace\\sistJavaStudy\\src\\date181214\\images\\ebichuGif.gif");
		JButton btn1 = new JButton("��ư1", ii1);
		JButton btn2 = new JButton("��ư2", ii2);
		JButton btn3 = new JButton("��ư3", ii3);
		
		// JComponentŬ������ setTooltipText�޼ҵ�� tooltip text(ǳ�� ����) �߰�
		btn1.setToolTipText("��ư1");
		btn2.setToolTipText("��ư2");
		btn3.setToolTipText("��ư3");
		
		// RollOver icon (���콺 Ŀ�� �ø��� �̹����� �ٲ�� ��)
		btn1.setRolloverIcon(ii4);
		
		// ��ư�� ��(����) ��ġ ����
		// ���� ��ġ ���� : LEFT, CENTER, RIGHT
		btn1.setHorizontalTextPosition(JButton.LEFT);
		btn2.setHorizontalTextPosition(JButton.RIGHT);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		
		// ���� ��ġ ���� : TOP, CENTER, BOTTOM
		btn1.setVerticalTextPosition(JButton.TOP);
		btn2.setVerticalTextPosition(JButton.BOTTOM);
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		
		setLayout(new GridLayout(1,3));
		
		add(btn1); add(btn2); add(btn3);
		
		setBounds(150, 200, 800, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new UseImageIcon();
	}
}
