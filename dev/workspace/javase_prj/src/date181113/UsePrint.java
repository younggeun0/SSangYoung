// 자바 표준출력 method
package date181113;
class UsePrint{

  public static void main(String args[]) {

    /*
    System.out.println("안녕");
    System.out.print("하세요..");
    */

    System.out.println(11);	// 정수상수
    System.out.println(11.13);  // 실수상수
    System.out.println('A');    // 문자상수
    System.out.println("Hello Java"); // 문자열상수
  
    int i=11; // 지역변수
    String s="오늘은 화요일"; // 문자열 객체(변수)

    System.out.println(i); // 기본형 데이터형 변수
    System.out.println(s); // 참조형 데이터형 변수
    System.out.println(11 + 13); // 연산식   
    System.out.println("11 + 13 = " + 11+13); // 1113이 출력됨

    System.out.println("11 + 13 = " + (11+13)); // 1113이 출력됨
  }  

}