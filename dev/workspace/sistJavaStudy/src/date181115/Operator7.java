package date181115;
/*
	���Կ�����
	=,
	+=,-=,*=,/=,%=
	<<=,>>=,>>>=
	&=, |=, ^=
*/
class Operator7{
	public static void main(String[] args){
	
		int i = 3;  // ����

		// �������
		i += 2;		// 5
		i -= 1;		// 4
		i *= 3;		// 12
		i /= 4;		// 3   �ڹٿ��� ����/���� = ����!(�Ǽ�X)
		i %= 2;		// 1

		// ����Ʈ ����
		i <<= 4;	// 0000 0001 -> 0001 0000 = 16
		i >>= 1;	// 0001 0000 -> 0000 1000 = 8
		i >>>= 2;	// 0000 0100 -> 0000 0010 = 1
		System.out.println(i); // ����� ����
		
		// ��Ʈ���� ����
		i &= 12;	// 0000 0001 & 0000 1100 = 0000 0000 = 0
		i |= 11;	// 0000 0000 | 0000 1011 = 0000 1011 = 11
		i ^= 7;		// 0000 1011 ^ 0000 0111 = 0000 1100 = 12

		System.out.println(i);

		// ���ڿ� �񱳽� equals method ���
		String s = "�ȳ�";
		System.out.println(s.equals("�ȳ�!"));
		System.out.println(s.equals("�ȳ�"));
	}
}