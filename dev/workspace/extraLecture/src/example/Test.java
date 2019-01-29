package example;

import java.util.Random;

public class Test {
	
    public static void mathRandom() {
        Random rd=new Random();
        char[] math=new char[11];
        String random="123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i=0; i<math.length; i++) {
           math[i]=random.charAt(rd.nextInt(random.length()));
           System.out.print(math[i]);
        }//end for
     }
    
	public static void main(String[] args) {
		Test.mathRandom();
	}
}
