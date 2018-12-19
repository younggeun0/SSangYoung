package date181219.hw;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileHomework {

	public FileHomework() throws IOException {
		
		String path = getPath();
		showMessage(path);
	}
	
	public String getPath() throws IOException {
		System.out.print("���丮�� �Է� : ");
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String path = br.readLine();
		br.close();
	
		return path;
	}
	
	public void showMessage(String path) {
		StringBuilder content = new StringBuilder();
		content.append("�̸�\t\t\t����\tũ��\t���������� ������ ��¥\n");
		
		File file = new File(path);
		if (file.isDirectory()) {
			
			File[] files = file.listFiles();
			
			Date d = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
			
			for(int i=0; i<files.length; i++) {
				d = new Date(files[i].lastModified());
				
				content.append(files[i].getName()).append("\t\t\t")
				.append(files[i].isFile()?"����":"����").append("\t")
				.append(files[i].length()).append("byte\t")
				.append(sdf.format(d)).append("\n");
			}
			
			JTextArea jta = new JTextArea(10,60);
			JScrollPane jsp = new JScrollPane(jta);
			jta.setText(content.toString());
			jta.setEditable(false);
			
			System.out.println(jta.getText());
			JOptionPane.showMessageDialog(null, jsp);
		} else {
			System.out.println("������ ������� �ʽ��ϴ�.");
		}
	}
	
	public static void main(String[] args) {
		try {
			new FileHomework();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
