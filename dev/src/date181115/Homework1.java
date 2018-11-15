/*
1. 변수에 할당된 값이 양수일때만 2진수로 출력하고 음수라면 ~를 사용하여
    양수로 변경하고 입력된 그대로의 10진수로 출력.
    출력 예)  "양수 인경우"   10은  1010
              "음수 인경우"  -10은  10	
*/
class Homework1{
	public static void main(String[] args){
		
		int i = 10;
		int j = -11;

		System.out.println("양수인 경우 : " + (i>=0? Integer.toBinaryString(i) : ~i+1));
		System.out.println("음수인 경우 : " + (j>=0? Integer.toBinaryString(j) : ~j+1));
	}
}
