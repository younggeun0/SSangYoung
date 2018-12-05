package date181127;

public class UseString1 {
	
	public static void main(String[] args) {
		
		String s = "abcDef";
		System.out.println(s.length());
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		
		System.out.println(s.indexOf("c"));
		System.out.println(s.indexOf("k"));
		
		s = "aCbdCe";
		
		// lastIndexOf�� �ڿ�������(<-) ã�Ƴ���
		System.out.println(s.indexOf("C"));
		System.out.println(s.lastIndexOf("C"));
		
		System.out.println(s.charAt(0));
		
		s = "abcdef";
		System.out.println(s.substring(3));		// def
		System.out.println(s.substring(1, 4));	// bcd 
		
		s = "    abc     ";
		System.out.println(s.trim());			// abc
		
		s = "    a   b   c     ";
		System.out.println(s.trim());			// a   b   c
		
		s = "hello";
		System.out.println(s.concat(" world"));
		
		System.out.println(s + " world");
		
		// ���ڿ����� +�� ���̴� �ǹ�
		System.out.println("3+4="+3+4);
		
		s = "abcdefg";
		// c�� k�� ����
		System.out.println(s.replace("c", "k"));		// abkdefg
		System.out.println(s.replaceAll("cde", "kkk")); // abkkkfg
		
		s = "   AAA BBB   ";
		System.out.println(s.replace(" ", ""));
		
		// empty, ���ͷ��� �ּҴ� ������ ���� ���� ����
		s ="";
		System.out.println(s);
		
//		// null, ���ͷ��� �ּҵ� heap�� �ּҵ� ���� ����
//		s = null;
//		System.out.println(s);
		
		System.out.println(s.isEmpty());
		
		s = "ABC";
		System.out.println(s.equals("ABC"));
		
		System.out.println(s.startsWith("abc"));
		System.out.println(s.startsWith("A"));
		
		System.out.println(s.endsWith("C"));
		System.out.println(s.contains("B"));
		
		int i = 10;
		s = String.valueOf(i);
		
		System.out.println(s);
		
		s = "1,2,3,4,5,6,7";
		String[] str_arr = s.split(",");
		
		for(String str : str_arr) {
			System.out.print(str+" ");
		}
	}	
}
