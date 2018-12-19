package date181219.hwrevision;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Hw2 {

	private String path;
	private File[] files;
	private File file;
	private int javaFiles;
	private List<Integer> listIdx;

	public Hw2() {

		getPath();

		file = new File(path);

		if (file.isFile()) {
			JOptionPane.showMessageDialog(null, "입력값은 경로가 아니라 파일입니다.");
		} else {
			
			checkJava();

			String msg = "java파일이 " + javaFiles + "개 존재합니다. 삭제하시겠습니까?";

			int select = JOptionPane.showConfirmDialog(null, msg);

			switch (select) {
			case JOptionPane.OK_OPTION: // OK
				for (int i = 0; i < listIdx.size(); i++) {
					files[listIdx.get(i)].delete();
				}
			}
		}
	}

	public void getPath() {
		path = JOptionPane.showInputDialog("경로를 입력하세요.\n예)c:/dev");
	}

	public void checkJava() {
		// 'java'란 파일이 존재하는지 여부판단
		files = file.listFiles();
		javaFiles = 0;
		listIdx = new ArrayList<Integer>();

		// 이렇게 배열의 요소인 File객체를 사용가능 files[0].getName()
		for (int i = 0; i < files.length; i++) {

			// for문을 돌면서 저장해야되는 것들 : 자바파일의 수, 삭제할 파일의 index
			if (files[i].getName().contains(".java")) {
				listIdx.add(i);
				javaFiles++;
			}
		}
	}

	public static void main(String[] args) {
		new Hw2();
	}
}
