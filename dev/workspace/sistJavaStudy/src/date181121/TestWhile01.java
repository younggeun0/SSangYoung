package date181121;

public class TestWhile01 {
    public static void main(String[] args) {

        // 단을 입력받아 2~9단 사이라면 구구단을  출력
        int input = Integer.parseInt(args[0]);    // 단
        if (input>1 && input<10) {
            
            System.out.println(input + "단  출력하겠습니다.");
            
            int i = 1;          // 초기식
            while (i < 10) {    // 조건식
                System.out.println(input+" *  "+i+" = "+(input*i));
                
                i++;            // 증감식
            }
                
        } else {
            System.out.println("단은 2~9 사이  값만 입력가능합니다.");
        }
    }
}