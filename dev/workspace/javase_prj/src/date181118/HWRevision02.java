/*
2. 기본형 데이터형에 대응되는 클래스를 Wrapper Class라고 한다. 
   Java Document에서 Wrapper클래스의 상수가 존재하는지 찾아보고 
   그에 대한 최소값과 최대값을 출력 한다. 
 
   출력 :  byte의 최소값 :  -128  최대값 : 127   
*/
package date181118;

public class HWRevision02 {

	public static void main(String[] args) {
		
		// byte
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		// short
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		
		// int
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		// long
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		
		// char
		System.out.println((int)Character.MAX_VALUE);
		System.out.println((int)Character.MIN_VALUE);
	}
}
