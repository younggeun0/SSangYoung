package example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class CheckTest extends JFrame implements ActionListener{

	JCheckBox jcb;
	JButton jb;
	JRadioButton jrb;
	
	public CheckTest() {
		
		jcb = new JCheckBox("dd");
		jb = new JButton("Å¬¸¯");
		jrb = new JRadioButton("¿ë");
		
		add("North",jrb);
		add(jcb);
		add("South",jb);
		
		jb.addActionListener(this);
		
		setBounds(400, 300, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(jcb.getText());
		System.out.println(jrb.getText());
	}
	
	public static void main(String[] args) {
		new CheckTest();
	}
}
