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
		
		// 1. ���� �߰��� �� �ִ� ��ü�� ����
		JTabbedPane jtp = new JTabbedPane();
		
		// 2. �� �ǿ� �� ������Ʈ�� ����.
		ImageIcon ii = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy/src/date181214/images/ebichuGif.gif");
		JLabel jl = new JLabel(ii);
		ImageIcon ii2 = new ImageIcon("C:/Users/owner/youngRepositories/SSangYoung/dev/workspace/sistJavaStudy/src/date181214/images/ebichuPng3.png");
		JLabel jl2 = new JLabel(ii2);
		
		// �ι�° �ǿ� �� ������Ʈ
		JPanel jp = new JPanel();
		jp.add(new JLabel("�̸�"));
		jp.add(new JTextField(30));
		jp.add(new JButton("�Է�"));
		
		JPanel tab2 = new JPanel();
		tab2.setLayout(new BorderLayout());
		
		jp.setBorder(new TitledBorder("�Էµ�����"));
		
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(new TitledBorder("���â"));
		
		tab2.add("North", jp);
		tab2.add("Center", jsp);
		
		jtp.add("ó����", jl);
		jtp.add("�ι�° ��", tab2);
		jtp.add("����° ��", new JButton("Ŭ��"));
		jtp.add("�׹�° ��", jl2);
		
		jtp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(jtp);
				if (jtp.getSelectedIndex() == 3) {
					String pw = JOptionPane.showInputDialog(ujt, "��й�ȣ�� �Է��ϼ���", "�Է�", JOptionPane.PLAIN_MESSAGE);

					if (pw != null) {
						if (!pw.equals("123")) 
							jtp.setSelectedIndex(0);						
					}
				}
			}
		});
		
		// ��ġ
		add("Center",jtp);
		
		setBounds(300, 200, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new UseJTab();
	}
}
