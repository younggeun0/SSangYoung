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

	public Hw2() throws NullPointerException {

		getPath();

		file = new File(path);

		if (file.isFile()) {
			JOptionPane.showMessageDialog(null, "�Է°��� ��ΰ� �ƴ϶� �����Դϴ�.");
		} else {
			checkJava();
			confirmDelete();
		}
	}

	public void getPath() throws NullPointerException {
		try {
			path = JOptionPane.showInputDialog("��θ� �Է��ϼ���.\n��)c:/dev");
		} catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "��ΰ� �ƴմϴ�. �ٽ� �Է����ּ���.");
		}
	}

	public void checkJava() {
		// 'java'�� ������ �����ϴ��� �����Ǵ�
		files = file.listFiles();
		javaFiles = 0;
		listIdx = new ArrayList<Integer>();

		// �̷��� �迭�� ����� File��ü�� ��밡�� files[0].getName()
		for (int i = 0; i < files.length; i++) {

			// for���� ���鼭 �����ؾߵǴ� �͵� : �ڹ������� ��, ������ ������ index
			if (files[i].getName().contains(".java")) {
				listIdx.add(i);
				javaFiles++;
			}
		}
	}

	public void confirmDelete() {
		String msg = "java������ " + javaFiles + "�� �����մϴ�. �����Ͻðڽ��ϱ�?";

		int select = JOptionPane.showConfirmDialog(null, msg);

		switch (select) {
		case JOptionPane.OK_OPTION: // OK
			for (int i = 0; i < listIdx.size(); i++) {
				files[listIdx.get(i)].delete();
			}
		}
	}

	public static void main(String[] args) {
		try {
			new Hw2();
		} catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "��ΰ� �ƴմϴ�. �ٽ� �Է����ּ���.");
		}
	}
}
