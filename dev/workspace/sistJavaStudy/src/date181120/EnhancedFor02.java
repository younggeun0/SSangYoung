package date181120;

/**
 * ������ for�� : �迭�̳� Collection���� ��� ����� ����<br>
 * 				  ó������ ������ ���������� ����ϱ� ���� ����<br>
 * 
 * ����) for(�������� ����: �迭��(Collection��)) {<br>
 * 			������;(�迭(Collection)����� ���� ����� �� �ִ�.)<br>	
 * 		 }
 * 
 * @author owner
 */
public class EnhancedFor02 {

	public static void main(String[] args) {
		
		int[] tempArr = {2018, 11, 20, 16, 5};
		
		// ������ for�� ��� ����� ���� ���
		for(int i=0;i<tempArr.length;i++) {
			System.out.println(tempArr[i]);
		}
		
		System.out.println("------ ������ for -------");
		
		// ���� for�� ��� ����� ���� ���
		for(int i:tempArr) {
			System.out.println(i);
		}
		
	}
}
