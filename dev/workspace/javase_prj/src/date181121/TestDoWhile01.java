package date181121;

/**
 * do~while : ���۰� ���� �� �� ����ϴ� �ݺ���<br>
 * �ּ� 1�� ���� �ִ� ���Ǳ��� ����<br>
 * ����) do{ <br>
 * �ݺ����๮���;<br>
 * }while(���ǽ�);
 * 
 * @author owner
 */
public class TestDoWhile01 {

	public static void main(String[] args) {
		int i = 1000;// �ʱⰪ
		do {
			System.out.println("i=" + i);// �ݺ����๮��
			i++;// ������
		} while (i < 10);// ���ǽ�
	}// main
}// class
