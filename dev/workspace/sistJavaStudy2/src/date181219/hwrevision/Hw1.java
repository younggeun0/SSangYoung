package date181219.hwrevision;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Hw1 {

	public Hw1() {
		
		System.out.println("���丮�� �Է� : ");
		
		// �Է�
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is); // has-a
		BufferedReader br = new BufferedReader(isr);
		
		// BufferedReader�� �� ������ �ӵ����, readLine()���
		try {
			String path = br.readLine();
			
			File file = new File(path);
			
			if (file.isFile()) {
				System.out.println("������ ������� �ʽ��ϴ�.");
			} else {

				File[] files = file.listFiles();
				
				StringBuilder text = new StringBuilder();
				text.append("�̸�\t\t����\tũ��\t���������� ������ ��¥\n");

				Date d;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
				
				for(int i = 0; i < files.length; i++) {
					d = new Date(files[i].lastModified());
					
					text.append(files[i].getName()).append("\t\t")
					 .append(files[i].isFile() ? "����" : "����").append("\t")
					 .append(files[i].length()).append("byte\t")
					 .append(sdf.format(d)).append("\n");
				}
				
				JTextArea jta = new JTextArea(10, 60);
				jta.setText(text.toString());
				jta.setEditable(false);
				JScrollPane jsp = new JScrollPane(jta);
				
				JOptionPane.showMessageDialog(null, jsp);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Hw1();
	}
}
