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
 * MVC Pattern�� ������� �� Component�� ���
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame implements ActionListener, MouseListener /* , ListSelectionListener */ {

	private JList<String> jl; // View
	private DefaultListModel<String> dlm; // Model
	private JLabel jlOutput;
	private JButton jb;

	public UseJList() {
		super("JList ���");

		dlm = new DefaultListModel<String>();
		dlm.addElement("Java SE");
		dlm.addElement("Oracle");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("JavaScript");
		dlm.addElement("CSS");

		jl = new JList<String>(dlm);
		// ScrollBar�� ���� JList���� ScrollBar ����
		JScrollPane jsp = new JScrollPane(jl);

		jlOutput = new JLabel("���");
		jlOutput.setBorder(new TitledBorder("���þ�����"));

		jb = new JButton("�Է�");

		jb.addActionListener(this);
//		jl.addListSelectionListener(this);
		jl.addMouseListener(this);

		add(BorderLayout.NORTH, jb);
		// ������Ʈ�� ���� ��ũ�ѹ� ��ü�� ��ġ
		add(BorderLayout.CENTER, jsp);
		add(BorderLayout.SOUTH, jlOutput);

		setBounds(100, 100, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String lang = JOptionPane.showInputDialog("��ǻ�Ͱ��߰��þ��");
		System.out.println(lang);
		if (lang != null && !lang.isEmpty()) { // ������ �ٲ�� �����߻�
			// null���� isEmpty�޼ҵ带 ȣ���ϰ� �ǹǷ�
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
