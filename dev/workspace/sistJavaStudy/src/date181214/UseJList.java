package date181214;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * MVC Pattern을 기반으로 한 Component의 사용
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame implements ActionListener, MouseListener /* , ListSelectionListener */ {

	private JList<String> jl; // View
	private DefaultListModel<String> dlm; // Model
	private JLabel jlOutput;
	private JButton jb;

	public UseJList() {
		super("JList 사용");

		dlm = new DefaultListModel<String>();
		dlm.addElement("Java SE");
		dlm.addElement("Oracle");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("JavaScript");
		dlm.addElement("CSS");

		jl = new JList<String>(dlm);
		// ScrollBar가 없는 JList에게 ScrollBar 설정
		JScrollPane jsp = new JScrollPane(jl);

		jlOutput = new JLabel("출력");
		jlOutput.setBorder(new TitledBorder("선택아이템"));

		jb = new JButton("입력");

		jb.addActionListener(this);
//		jl.addListSelectionListener(this);
		jl.addMouseListener(this);

		add(BorderLayout.NORTH, jb);
		// 컴포넌트를 가진 스크롤바 객체를 배치
		add(BorderLayout.CENTER, jsp);
		add(BorderLayout.SOUTH, jlOutput);

		setBounds(100, 100, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String lang = JOptionPane.showInputDialog("컴퓨터개발관련언어");
		System.out.println(lang);
		if (lang != null && !lang.isEmpty()) { // 순서가 바뀌면 에러발생
			// null에서 isEmpty메소드를 호출하게 되므로
			dlm.addElement(lang);
		}
	}

	public static void main(String[] args) {
		new UseJList();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
		int idx = jl.getSelectedIndex();
		String value = dlm.get(idx);
		System.out.println(value);
		jlOutput.setText(value);
		dlm.removeElementAt(idx);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}
}
