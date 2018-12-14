package date181214;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.memo.view.JavaMemo;

public class UseTitledBorder extends JFrame implements ActionListener {

	private JTextField jtfId;
	private JPasswordField jpfPw;
	private JLabel jlOutput;

	public UseTitledBorder() {
		super("Border 사용");

		jtfId = new JTextField();
		jpfPw = new JPasswordField();
		jlOutput = new JLabel();

		jtfId.setBorder(new TitledBorder("아이디"));
		jpfPw.setBorder(new TitledBorder("비밀번호"));
		jlOutput.setBorder(new TitledBorder("출력창"));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("로그인"));
		panel.setLayout(new GridLayout(3, 1));
		panel.add(jtfId);
		panel.add(jpfPw);
		panel.add(jlOutput);

		jtfId.addActionListener(this);
		jpfPw.addActionListener(this);

		add(BorderLayout.CENTER, panel);

		setBounds(100, 100, 250, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		String id = jtfId.getText().trim();
		
		// 아이디에서 이벤트가 발생하면
		if (ae.getSource() == jtfId) {
			// 아이디에 값이 들어있다면 커서를 비밀번호로 이동
			if (!id.equals("")) {
				jpfPw.requestFocus();
			}
		}
		// 비밀번호에서 이벤트가 발생하면
		if (ae.getSource() == jpfPw) {
			// 아이디에 값이 없다면 커서를 아이디로 이동,
			if (id.equals("")) {
				jtfId.requestFocus();
				jlOutput.setText("아이디를 입력해주세요.");
				
				// 반환형이 void인 메소드에서 코드의 실행을 멈추고
				// 호출한 곳으로 돌아가라는 의미
				return; 
			}

			String pw = new String(jpfPw.getPassword());

			// 비밀번호에 값이 없다면 출력창에 "비번입력"을 보여주고 커서를 비밀번호로 이동
			if(pw.trim().equals("")) {
				jlOutput.setText("비밀번호를 입력해주세요.");
				return;
			}
			// 비밀번호에 값이 있다면 아이디가 admin, 비밀번호가 123과 같은지 
			// 비교하여 같다면 자바메모장 클래스를 실행
			if(id.equals("admin") && pw.equals("123")) {
				new JavaMemo();
				dispose();
			} else {
				jlOutput.setText("아이디나 비밀번호를 확인해주세요.");
			}
		}
	}

	public static void main(String[] args) {
		new UseTitledBorder();
	}
}
