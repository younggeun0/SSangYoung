/*
	2. 2147483647�� ������ ���� 2byte�� ���� 2byte ���� �и��Ͽ� ����غ�����. 
	    ��� ��) ���� 2byte -> 32767
	             ���� 2byte -> 65535
 */
package date181116;

public class Homework2Review {
	public static void main(String[] args) {

		int i = Integer.MAX_VALUE; // 2147483647
		// 2147483647 - 4byte 01111111 11111111 11111111 11111111

		// ���� 2byte�� �и� Ǯ��<<

		// &�� mask ����
		// 01111111 11111111 11111111 11111111
		// 00000000 00000000 11111111 11111111 = 0x0000FFFF
		System.out.println(i & 0x0000FFFF);

	}
}
