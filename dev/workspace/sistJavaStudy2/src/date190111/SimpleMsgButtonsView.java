package date190111;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SimpleMsgButtonsView extends JFrame {

	private JButton[] jbtName; 
	private String[] names;
	
	public SimpleMsgButtonsView() {

		jbtName = new JButton[10];
		names = new String[]{"±èÁ¤À±", "¹Ú¿µ¹Î", "³ëÁø°æ", 
				"±èÈñÃ¶", "±èÁ¤¿î", "ÀÌÀçÂù", "ÀÌÀçÇö", 
				"°ø¼±ÀÇ", "±è°ÇÇÏ", "¿À¿µ±Ù" };
		
		setLayout(new GridLayout(5, 2));

		SimpleMsgButtonsEvt smbe = new SimpleMsgButtonsEvt(this);
		addWindowListener(smbe);
		
		for (int i=0; i<jbtName.length; i++) {
			jbtName[i] = new JButton(names[i]);
			jbtName[i].addActionListener(smbe);
			add(jbtName[i]);
		}

		setBounds(400, 250, 400, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new SimpleMsgButtonsView();
	}

	public JButton[] getJbtName() {
		return jbtName;
	}
}
