/*
3. ||�� ������� �� ������ true��� ������ �������� �ʴ� ���� ������ �� �ִ�
     �ڵ带 �ۼ��ϼ���.
*/
class Homework3{
	public static void main(String[] args){
		
		boolean b1 = true;
		boolean b2 = false;

		// ������ true�� ������ ������ ���� ���Ծ��� ������ false(���� ����)
		System.out.println((b1=true)||(b2=true));
		System.out.println(b1+" / "+b2);	// true / false
	
		// ������ false�� ���׵� ������ �ؼ� ���� �ٲ�
		System.out.println((b1=false)||(b2=true));
		System.out.println(b1+" / "+b2);	// false / true
	
	}
}
