package date181128;

/**
 * ���� �迭�� �⺻�� ���� ���
 */
public class VariableArray2 {
	public void priType() {
		
		// ����) ��������[][] �迭�� = { {��,.}, {..}, ... };
		// �౸�� ��ȣ�� �������� ���� ������ �ٸ��� ����
		String[][] arr = { 
			{"����"},
			{"����","����", "������"},
			{"���","��", "��"},
			{"��"} 
		};
		
		String[] title = { "��","����","����","�ܿ�" };
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(title[i]+" : ");
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		new VariableArray2().priType();
	}
}
