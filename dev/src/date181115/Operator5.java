/*
	�������� :
	 �Ϲݳ� 
		&&(AND) : ���װ� ������ ��� true�� ���� true��ȯ
		||(OR ) : ���װ� ������ ��� false�� ���� false ��ȯ
	 ��Ʈ��
	 	&(AND) : ������Ʈ�� ������Ʈ�� ��� 1�� ���� 1����
		|(OR ) : ������Ʈ�� ������Ʈ�� ��� 0�� ���� 0����
		^(XOR) : ������Ʈ�� ������Ʈ �� �� �ϳ��� 1�� ��� 1����
*/
class Operator5{
	public static void main(String[] args){

		boolean flag1 = true, flag2 = false, flag3 = true, flag4 = false;
		
		System.out.println("--------&&---------");
		// �������� ������꺸�� �켱������ ���� ������ ���η� ���´�
		System.out.println(flag1+"&&"+flag3+" = "+ (flag1&&flag3)); // true
		System.out.println(flag1+"&&"+flag2+" = "+ (flag1&&flag2)); // false
		System.out.println(flag2+"&&"+flag1+" = "+ (flag2&&flag1)); // false
		System.out.println(flag2+"&&"+flag4+" = "+ (flag2&&flag4)); // false
		// ������ false�� ������ ������� �ʰ� false�� ����� �����

		
		System.out.println("--------||---------");
		System.out.println(flag1+"||"+flag3+" = "+ (flag1||flag3)); // true
		System.out.println(flag1+"||"+flag2+" = "+ (flag1||flag2)); // true
		System.out.println(flag2+"||"+flag1+" = "+ (flag2||flag1)); // true
		System.out.println(flag2+"||"+flag4+" = "+ (flag2||flag4)); // false
		// ������ true�� ������ ������� �ʰ� true�� ����� �����


		System.out.println("-------------------------");
		flag1 = false;
		flag2 = false;
		flag3 = false;

		flag3 = (flag1=3>4)&&(flag2=5>4);
		// flag1������ �����ϰ� flag2�� ���� ����(false ������ ��������)
		System.out.println("����:"+flag1+", ����:"+flag2+", ����:"+flag3);


		System.out.println("-------------------------");
		int i=0, j=0;

		i = 28;	//   0001 1100
		j = 48; // & 0011 0000
				//   0001 0000 16
		System.out.println(i+" & "+j +" = "+(i&j));
		
		i = 16; //   0001 0000
		j = 3;  // | 0000 0011
				//   0001 0011 19
		System.out.println(i+" | "+j +" = "+(i|j));
		
		i = 10; //   0000 1010
		j = 12; // ^ 0000 1100
			    //   0000 0110 6
		System.out.println(i+" ^ "+j +" = "+(i^j));
	}
}
