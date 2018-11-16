package date181115;
/*
2. 2147483647�� ������ ���� 2byte�� ���� 2byte ���� �и��Ͽ� ����غ�����. 
    ��� ��) ���� 2byte -> 32767
             ���� 2byte -> 65535
*/
class Homework2 {
	public static void main(String[] args) {
		
		int i = Integer.MAX_VALUE;	// 2147483647
		// 2147483647 - 4byte 01111111 11111111 11111111 11111111

		// ���� 2byte�� �и��ϱ� ���� right shift ������ ��� >> 16
		// ����Ʈ���Կ����ڷ� 16ĭ ���������� ��Ʈ�̵��� ���� �ٷ� ���
		System.out.println(i>>16);

		// ���� 2byte�� �и��ϱ� ���� left shift ������ ��� << 16
		// �� �� ���� 2byte�� 0���� ä��� ���� unsigned right shift ������ ���
		
		// &�� mask ����
		// 01111111 11111111 11111111 11111111
		// 00000000	00000000 11111111 11111111 = 0x0000FFFF
		System.out.println(i & 0x0000FFFF);
		
		i<<=16;
		System.out.println(i>>>16);
	}
}