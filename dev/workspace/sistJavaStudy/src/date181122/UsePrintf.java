package date181122;

/**
 * ��� method
 *
 * @author owner
 */
public class UsePrintf {

	public static void main(String[] args) {
		
		System.out.printf("����  [%d][%5d][%-5d]\n",11,22,38);
		System.out.printf("����  [%c][%5c][%-5c]\n",'A','B','C');
		System.out.printf("���ڿ�[%s][%10s][%-10s]\n","�ڹ�","�ڹ�","���");
		System.out.printf("�Ǽ�  [%.2f][%5.2f][%-5.2f]\n",1.437,2.567,3.141592);
		
		System.out.printf("������ %d�� %d�� %d�� %c����, �µ��� %.1f���Դϴ�.\n"
				, 2018, 11, 22, '��', 1.5);
	}
}
