package date181115;
/*
	Java ���α׷� �ܺο��� Java ���α׷� ���η� ����
	������ �� main method�� Arguments ���
	����) java bytecode�� ��1 ��2 ��3 ... 
*/
class MainArguments {
	public static void main(String[] args) {
		System.out.println(args[0]);		 // 11
		System.out.println(args[1]);		 // 15
        System.out.println(args[0]+args[1]); // 1115, ���ڿ��� +�� ��������
		// System.out.println(args[0]*args[1]); // ���ڿ��� +������ ��������� �ȵ�

		// ���ڿ��� ������ �ٲٴ� ���
		// error
		// int i = args[0];
		// int i = (int)args[0];

		// java.lang ��Ű�� Integer Ŭ������ parseIntŬ������ ����ؼ�
		// String Ÿ���� int������ ��ȯ
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		System.out.println(i * j);

		System.out.println(args[2]+"�� �ȳ��ϼ���!");
	}
}
