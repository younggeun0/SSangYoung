/*
	���׿����� (Unary)
	~, !, +, -, ++, --
*/
class Operator1 {
	public static void main(String[] args) {
		int i = 11;
		int j = -11;
		
		// ~(tilde) : 1�� ��������
		// ~��� : ��ȣ���� 1����
		System.out.println("~"+i+" = "+ ~i); // -12

		// ~���� : ��ȣ���� 1����
		System.out.println("~"+j+"  "+ ~j); // 10

		// !(NOT) : true -> false, false -> true
		boolean b = true;
		boolean c = false;

		System.out.println("!b = "+!b);		// false
		System.out.println("!c = "+!c);		// true
		System.out.println(11>15);			// false
		// !�� boolean���� ��밡��
		System.out.println(!(11>15));		// true

		// + : ������ ����
		System.out.println("+"+i+" = "+ +i); // 11
		System.out.println("+"+j+" = "+ +j); // -11

		// - : 2�� ��������, ��ȣ�ٲ޿���(�� �״��)
		System.out.println("-"+i+" = "+ -i); // -11
		System.out.println("-"+j+" = "+ -j); // 11

		// ++ : ��������(���ü ���� 1�� ����)
		i=0;
		j=10;

		// �������� : ������ ���ü
		++i;	// 1
		--j;	// 9

		System.out.println("�������� �� i = "+i+", j = "+j);

		// �������� : ���ü ������
		i++;	// 2
		j--;	// 8
		
		System.out.println("�������� �� i = "+i+", j = "+j);

		// ���������ڿ� ���ҿ����ڴ� ���Կ����ڿ� �Բ� ���Ǹ�
		// ���� ������ �ٸ� ���� ����
		
		j = 0;
		// ���� : ���� ����
		j = ++i;	// 3
		System.out.println("�������� �� i = "+i+", ���Ե� �� j = "+j);
		
		// ���� : ���� �� ����
		j = 0;
		j = i++;	// i�� 4, j�� 3
		System.out.println("�������� �� i = "+i+", ���Ե� �� j = "+j);
	}
}
