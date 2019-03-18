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
		super("영쓰 자소서 글자수 카운터");
		
		JLabel label = new JLabel("자소서 복붙해 주세유.");
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		
		jbShowResult = new JButton("글자수 계산");
		
		jcbCnt = new JComboBox<String>();
		jcbCnt.addItem("===걍 세줘===");
		jcbCnt.addItem("===500자===");
		jcbCnt.addItem("===700자===");
		jcbCnt.addItem("===1000자===");
		jcbCnt.addItem("===1500자===");
		
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
