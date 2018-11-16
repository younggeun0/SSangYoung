package date181115;
/*
	Java 프로그램 외부에서 Java 프로그램 내부로 값을
	전달할 때 main method의 Arguments 사용
	실행) java bytecode명 값1 값2 값3 ... 
*/
class MainArguments {
	public static void main(String[] args) {
		System.out.println(args[0]);		 // 11
		System.out.println(args[1]);		 // 15
        System.out.println(args[0]+args[1]); // 1115, 문자열은 +로 합쳐진다
		// System.out.println(args[0]*args[1]); // 문자열은 +제외한 산술연산이 안됨

		// 문자열을 정수로 바꾸는 방법
		// error
		// int i = args[0];
		// int i = (int)args[0];

		// java.lang 패키지 Integer 클래스의 parseInt클래스를 사용해서
		// String 타입을 int형으로 변환
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		System.out.println(i * j);

		System.out.println(args[2]+"님 안녕하세요!");
	}
}
