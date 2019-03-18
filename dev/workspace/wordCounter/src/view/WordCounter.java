package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.WordCounterController;

@SuppressWarnings("serial")
public class WordCounter extends JFrame {
	
	private JButton jbShowResult;
	private JScrollPane jsp;
	private JTextArea jta;
	private JComboBox<String> jcbCnt;
	
	public WordCounter() {
		super("���� �ڼҼ� ���ڼ� ī����");
		
		JLabel label = new JLabel("�ڼҼ� ������ �ּ���.");
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		
		jbShowResult = new JButton("���ڼ� ���");
		
		jcbCnt = new JComboBox<String>();
		jcbCnt.addItem("===�� ����===");
		jcbCnt.addItem("===500��===");
		jcbCnt.addItem("===700��===");
		jcbCnt.addItem("===1000��===");
		jcbCnt.addItem("===1500��===");
		
		setLayout(null);
		
		label.setBounds(10,10, 150, 20);
		add(label);
		
		jcbCnt.setBounds(200, 10, 210, 20);
		add(jcbCnt);
		
		jsp.setBounds(10, 40, 400, 250);
		add(jsp);
		
		jbShowResult.setBounds(10, 300, 400, 50);
		add(jbShowResult);
		
		WordCounterController wcc = new WordCounterController(this);
		jbShowResult.addActionListener(wcc);
		
		setBounds(400, 300, 425, 390);
		setResizable(false);
		setVisible(true);
	}

	public JButton getJbShowResult() {
		return jbShowResult;
	}

	public JTextArea getJta() {
		return jta;
	}

	public JComboBox<String> getJcbCnt() {
		return jcbCnt;
	}
}
