package date181121;

public class TestWhile02 {
    public static void main(String[] args) {
         
         // 무한 loop
         while(true) {
             System.out.println("무한 loop");
             // break가 없어야 무한 loop
             break;
         }
         
         int i = 0;
         while(true) {
             System.out.println("조건을 줘서 무한 loop  탈출");
             
             if(i==5) {
                  break;
             }
             i++;
         }
    }
}