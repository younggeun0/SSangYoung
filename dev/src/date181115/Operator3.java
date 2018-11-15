/*
	����Ʈ������
	<<  (left shift)
	 - ��Ʈ�� �������� �а� �о ���� ��ĭ�� �׻� 0���� ä��  
	>>  (right shift)
	 - ��Ʈ�� ���������� �а� �о ���� ��ĭ�� 
	 - MSB�� ���� ����� 0, ������ 1�� ä��
	>>> (unsigned shift) 
	 - ��Ʈ�� ���������� �а� �о ���� ��ĭ�� �׻� 0���� ä��
*/
class Operator3 {
	public static void main(String[] args) 	{
	
		// method : static method ���
		// Ŭ������.method��(��)
		int i=11;

		System.out.println("i�� �������� : "+Integer.toBinaryString(i)); // 1011
		System.out.println("i�� 8������ : "+Integer.toOctalString(i));   // 013
		System.out.println("i�� 16������ : "+Integer.toHexString(i));    // 0xb
		
		i = 9; 
		//     0000 1001
		// <<3 0100 1000 - 72
		// ����Ʈ�����ڴ� ��������ں��� �켱������ ���� ������ ���� �ʿ�
		System.out.println(i+"<<3 = "+ (i<<3));

		i = 36;	
		//     0010 0010
		// >>3 0000 0100 - 4
		System.out.println(i+">>3 = "+ (i>>3));
		

		i = 120;
		//      0111 1000
		// >>>4 0000 0111 - 7
		System.out.println(i+">>>4 = "+ (i>>>4));

		i = 1;
		//      0000 ... 0001
		// <<31 1000 ... 0000
		// MSB�� ����Ǹ� ������ �ִ밪�� ��µ�
		System.out.println(i<<31);	// -2147483648
		
		// literal�� 4byte�̹Ƿ� 32ĭ �и� ���ڸ��� ���ƿ�
		System.out.println(i<<32);  // 1

		i = -1;
		// right shift�� �о���� �и� ������ 
		// 1�� ���� ������ ���� ������
		System.out.println(i>>100);	// -1

		i = -1;
		// 1111 ... 1111
		// 0111 ... 1111
		// MSB�� 0���� ����, ����� �ִ밪 ���
		System.out.println(i>>>1);	// 2147483647
	}
}
