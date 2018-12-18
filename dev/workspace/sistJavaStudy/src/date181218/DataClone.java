package date181218;

import java.util.Stack;

public class DataClone {

	private Stack<Data> historyStack;

	public DataClone() {
		historyStack = new Stack<Data>();
	}

	public void useData() throws CloneNotSupportedException {
		Data d = new Data("쌍용유치원");
		
		if (d instanceof Cloneable) {
			d.setSchool("쌍용초등학교");
			Data d1 = d.getData();
			historyStack.push(d1);
			
			d.setSchool("쌍용중학교");
			Data d2 = d.getData();
			historyStack.push(d2);
			
			d.setSchool("쌍용고등학교");
			Data d3 = d.getData();
			historyStack.push(d3);
			
			d.setSchool("쌍용대학교");
			Data d4 = d.getData();
			historyStack.push(d4);
			
			getHistoryData();
		} else {
			System.out.println("Cloneable만 처리합니다.");
		}
	}

	public void getHistoryData() {
		Data temp = null;
		while (!historyStack.isEmpty()) {
			temp = historyStack.pop();
			System.out.println(temp); // temp는 복제된 객체들, 다 다르다
			System.out.println(temp.getSchool());
		}
	}

	public static void main(String[] args) {
		try {
			new DataClone().useData();
		} catch (CloneNotSupportedException e) {
			System.err.println("복제되지 않습니다.");
			e.printStackTrace();
		}
	}
}
