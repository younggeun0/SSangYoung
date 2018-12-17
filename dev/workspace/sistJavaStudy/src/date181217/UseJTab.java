package date181217;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJTab extends JFrame {
	
	private UseJTab ujt;
	
	public UseJTab() {
		super("Tab");
		
		ujt = this;
		
		// 1. 탭을 추가할 수 있는 객체를 생성
		JTabbedPane jtp = new JTabbedPane();
		
		// 2. 각 탭에 들어갈 컴포넌트를 생성.
		ImageIcon ii = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy/src/date181214/images/ebichuGif.gif");
		JLabel jl = new JLabel(ii);
		ImageIcon ii2 = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy/src/date181214/images/ebichuPng3.png");
		JLabel jl2 = new JLabel(ii2);
		
		// 두번째 탭에 들어갈 컴포넌트
		JPanel jp = new JPanel();
		jp.add(new JLabel("이름"));
		jp.add(new JTextField(30));
		jp.add(new JButton("입력"));
		
		JPanel tab2 = new JPanel();
		tab2.setLayout(new BorderLayout());
		
		jp.setBorder(new TitledBorder("입력데이터"));
		
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("결과창"));
		
		tab2.add("North", jp);
		tab2.add("Center", jsp);
		
		jtp.add("처음탭", jl);
		jtp.add("두번째 탭", tab2);
		jtp.add("세번째 탭", new JButton("클릭"));
		jtp.add("네번째 탭", jl2);
		
		jtp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(jtp);
				if (jtp.getSelectedIndex() == 3) {
					String pw = JOptionPane.showInputDialog(ujt, "비밀번호를 입력하세요", "입력", JOptionPane.PLAIN_MESSAGE);

					if (pw != null) {
						if (!pw.equals("123")) 
							jtp.setSelectedIndex(0);						
					}
				}
			}
		});
		
		// 배치
		add("Center",jtp);
		
		setBounds(300, 200, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new UseJTab();
	}
}
