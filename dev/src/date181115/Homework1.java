/*
1. ������ �Ҵ�� ���� ����϶��� 2������ ����ϰ� ������� ~�� ����Ͽ�
    ����� �����ϰ� �Էµ� �״���� 10������ ���.
    ��� ��)  "��� �ΰ��"   10��  1010
              "���� �ΰ��"  -10��  10	
*/
class Homework1{
	public static void main(String[] args){
		
		int i = 10;
		int j = -11;

		System.out.println("����� ��� : " + (i>=0? Integer.toBinaryString(i) : ~i+1));
		System.out.println("������ ��� : " + (j>=0? Integer.toBinaryString(j) : ~j+1));
	}
}
