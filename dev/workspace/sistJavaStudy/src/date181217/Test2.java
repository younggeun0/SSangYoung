package date181217;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test2 {
	
	public static void main(String[] args) {
		
		// Message Dialog에 JTextArea넣기
		// 1.JTextArea 생성(컬럼수, 행수 설정해서 만듦)
		JTextArea jta = new JTextArea(10,40);
		jta.setEditable(false);	// 편집막기
		jta.append("asdjflsjdklfjls"); // 값 덧붙여 넣기
		
		// 2. 
		JScrollPane jsp = new JScrollPane(jta);
		
		// 3. Message Dialog의 두번째 매개변수에 컴포넌트를 넣기
		JOptionPane.showMessageDialog(null, jsp);
	}

}
