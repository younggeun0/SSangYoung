package date181218;

import java.util.Stack;

public class DataClone {

	private Stack<Data> historyStack;

	public DataClone() {
		historyStack = new Stack<Data>();
	}

	public void useData() throws CloneNotSupportedException {
		Data d = new Data("�ֿ���ġ��");
		
		if (d instanceof Cloneable) {
			d.setSchool("�ֿ��ʵ��б�");
			Data d1 = d.getData();
			historyStack.push(d1);
			
			d.setSchool("�ֿ����б�");
			Data d2 = d.getData();
			historyStack.push(d2);
			
			d.setSchool("�ֿ����б�");
			Data d3 = d.getData();
			historyStack.push(d3);
			
			d.setSchool("�ֿ���б�");
			Data d4 = d.getData();
			historyStack.push(d4);
			
			getHistoryData();
		} else {
			System.out.println("Cloneable�� ó���մϴ�.");
		}
	}

	public void getHistoryData() {
		Data temp = null;
		while (!historyStack.isEmpty()) {
			temp = historyStack.pop();
			System.out.println(temp); // temp�� ������ ��ü��, �� �ٸ���
			System.out.println(temp.getSchool());
		}
	}

	public static void main(String[] args) {
		try {
			new DataClone().useData();
		} catch (CloneNotSupportedException e) {
			System.err.println("�������� �ʽ��ϴ�.");
			e.printStackTrace();
		}
	}
}
