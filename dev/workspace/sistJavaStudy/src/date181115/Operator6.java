package date181115;
/*
	����(����)������
*/
class Operator6 {
	public static void main(String[] args) {
	
		int i = 9;

		// ������ �켱���� ������ ���η� ���´�
		System.out.println(i+"��(��) "+ (i>=0?"���":"����")); 
	
		// ���밪
		System.out.println(i+"�� ���밪 "+ (i>=0?i:-i) );
		
		// ������ ���� ¦������ Ȧ������ �Ǵ��ϴ� ���׿����ڸ� ���弼��
		System.out.println(i+"�� "+(i%2==0? "¦���Դϴ�.":"Ȧ���Դϴ�."));
	}
}
