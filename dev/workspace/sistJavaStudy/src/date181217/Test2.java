package date181217;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test2 {
	
	public static void main(String[] args) {
		
		// Message Dialog�� JTextArea�ֱ�
		// 1.JTextArea ����(�÷���, ��� �����ؼ� ����)
		JTextArea jta = new JTextArea(10,40);
		jta.setEditable(false);	// ��������
		jta.append("asdjflsjdklfjls"); // �� ���ٿ� �ֱ�
		
		// 2. 
		JScrollPane jsp = new JScrollPane(jta);
		
		// 3. Message Dialog�� �ι�° �Ű������� ������Ʈ�� �ֱ�
		JOptionPane.showMessageDialog(null, jsp);
	}

}
