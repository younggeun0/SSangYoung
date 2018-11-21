package date181121;

public class UseInstanceVariable {
    
    int i;      // 정수형 초기화값 0
    int j;
    double d;   // 실수형 초기화값 0.0
    char c;     // 문자형 초기화값 \u0000
    boolean b;  // 불형   초기화값 false
    String str; // 참조형 초기화값 null
    UseInstanceVariable someClass;
    
    public static void main(String[] args) {
        // static 영역은 가장 먼저 메모리(method 영역)에 로드됨
        // 생성될지도 모르는 instance 변수를 직접 사용할 수 없다.
        // 객체화를 하면 객체가 메모리(heap)에 생성되고,
        // 그 주소를 메모리(stack)에 저장
        UseInstanceVariable uiv1 = new  UseInstanceVariable();
        UseInstanceVariable uiv2 = new  UseInstanceVariable();
        
        System.out.println("객체출력(heap주소):"+uiv1);
        System.out.println("객체출력(heap주소):"+uiv2);
        
        // heap에 생성된 instance variable을 사용
        uiv1.i=11;
        uiv1.j=21;
        
        System.out.println("uiv1객체의 멤버변수  i="+uiv1.i);
        System.out.println("uiv1객체의  인스턴스변수 j="+uiv1.j);
        
        // instance(member)변수는 자동초기화됨
        System.out.println("============ 자동  초기화값 ===========");
        System.out.println("정수형 :"+uiv2.i);
        System.out.println("실수형 :"+uiv2.d);
        System.out.println("문자형 :"+uiv2.c); // white space 출력
        System.out.println("불형 :"+uiv2.b);
        System.out.println("참조형-String  :"+uiv2.str);
        System.out.println("참조형-class  :"+uiv2.someClass);
    }
}
