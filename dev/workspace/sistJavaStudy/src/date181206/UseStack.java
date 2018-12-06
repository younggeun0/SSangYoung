package date181206;

import java.util.Stack;

/**
 * STACK : LIFO(Last In First Out) �� ������ Ŭ����
 * @author owner
 */
public class UseStack {
	
	public UseStack() {

		// ����
		Stack<String> stk = new Stack<>();
		// �� �Ҵ�
		// Stack�� �θ�Ŭ������ �����ϴ� ����� ������� �ʴ´�.
		// stk.add("�θ�"); 
		stk.push("�ϼ̽��ϴ�."); // 1
		stk.push("����"); // 2
		stk.push("���õ�"); // 3
		
		System.out.println(stk);
		System.out.println("ũ�� : "+stk.size());
		System.out.println(stk.empty());
		
		// �θ�Ŭ������ �����ϴ� ����� ����ϸ� 
		// ������ ��������� ����� �� ���Եȴ�.(LIFO X)
		for(int i=0; i<stk.size(); i++) {
			System.out.println(stk.get(i));
		}
		
		while(!stk.empty()) {
			// stack���� �����͸� ������ ���������� 
			// �� �����͸� ����� �� ����.
			System.out.println(stk.pop());
		}
	}

	public static void main(String[] args) {
		new UseStack();
	}
}
