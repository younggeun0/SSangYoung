/*
2. 2147483647�� ������ ���� 2byte�� ���� 2byte ���� �и��Ͽ� ����غ�����. 
    ��� ��) ���� 2byte -> 32767
             ���� 2byte -> 65535
*/
package date181118;

public class HWRevision04 {

	public static void main(String[] args) {
		
		int i = Integer.MAX_VALUE; // 2147483647
		// 01111111 11111111 11111111 11111111
		
		// ���� 2����Ʈ >>16
		System.out.println(i>>16);
		
		// ���� 2����Ʈ
		// mask ó��
		// 00000000 00000000 11111111 11111111
		// 16������ 4�ڸ��� ��� ���� = 0x0000FFFF
		
		System.out.println(i & 0x0000FFFF);
	}
}
