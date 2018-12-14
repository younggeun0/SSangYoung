package date181214;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Icon class를 사용한 이미지 사용
 * @author owner
 */
public class UseImageIcon extends JFrame {
	
	public UseImageIcon() {
		super("ImageIcon사용");
		
		ImageIcon ii1 = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy/src/date181214/images/ebichuPng.png");
		ImageIcon ii2 = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy/src/date181214/images/ebichuPng2.png");
		ImageIcon ii3 = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy/src/date181214/images/ebichuPng3.png");
		
		ImageIcon ii4 = new ImageIcon("C:\\Users\\owner\\youngRepositories\\SSangYoung\\dev\\workspace\\sistJavaStudy\\src\\date181214\\images\\ebichuGif.gif");
		JButton btn1 = new JButton("버튼1", ii1);
		JButton btn2 = new JButton("버튼2", ii2);
		JButton btn3 = new JButton("버튼3", ii3);
		
		// JComponent클래스의 setTooltipText메소드로 tooltip text(풍선 도움말) 추가
		btn1.setToolTipText("버튼1");
		btn2.setToolTipText("버튼2");
		btn3.setToolTipText("버튼3");
		
		// RollOver icon (마우스 커서 올리면 이미지가 바뀌는 것)
		btn1.setRolloverIcon(ii4);
		
		// 버튼의 라벨(글자) 위치 변경
		// 가로 위치 변경 : LEFT, CENTER, RIGHT
		btn1.setHorizontalTextPosition(JButton.LEFT);
		btn2.setHorizontalTextPosition(JButton.RIGHT);
		btn3.setHorizontalTextPosition(JButton.CENTER);
		
		// 세로 위치 변경 : TOP, CENTER, BOTTOM
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
