package date181122;

/**
 * Ư������ : ���ڿ� �� \�� �����ϴ� ����� ���� ����
 * 
 * @author owner
 */
public class EscapeCharacter {

	public static void main(String[] args) {
		// \t : tab
		System.out.println("��\t����");
		System.out.println("��\t\t����");

		// \n : new line
		System.out.println("��\n�ü�");

		// \r : carriage return ���� Ŀ���� ������ �̵��ε� ���� �ٲ�
		// \r\n : ������ �ٹٲ�
		System.out.println("��\r����");

		// \" : print "
		System.out.println("������ \"�޿���\" �Դϴ�.");
		// \' : print '
		System.out.println("������ \'�޿���\' �Դϴ�.");
		// \\ : print \
		System.out.println("c:\\users\\owner\\youngRepositories\\SSangYoung\\...");
	}
}
