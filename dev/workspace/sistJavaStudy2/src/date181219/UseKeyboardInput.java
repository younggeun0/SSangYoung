package date181219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사용자가 입력한 키보드의 값을 처리하는 System.in
 * 
 * @author owner
 */
public class UseKeyboardInput {

	public UseKeyboardInput() {

		System.out.println("아무키나 누르고 엔터");
		
		// 8bit Stream과 16bit Stream을 연결
		BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
		
		try {
			// 16bit Stream을 사용하여 입력된 데이터를 줄단위로 읽어 들인다.
			String s = br.readLine();
			System.out.println(s);

			/*// 입력 값 중 최초 입력 문자 받기
			int input = System.in.read();
			System.out.println("입력값 : " + input);*/
			
			/*// 입력된 모든 문자열 받기 : 한글은 받을 수 없다.
			int input = 0;
			while(true) {
				input = System.in.read();
				
				System.out.print((char)input);
				
				// enter는 13, 13나오면 종료
				if (input == 13) {
					break;
				}
			}*/
			
			// 스트림 사용이 끝났으면 스트림의 연결을 끊습니다.
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	public static void main(String[] args) {
		new UseKeyboardInput();
	}
}
