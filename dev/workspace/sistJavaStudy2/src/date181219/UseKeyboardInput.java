package date181219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ����ڰ� �Է��� Ű������ ���� ó���ϴ� System.in
 * 
 * @author owner
 */
public class UseKeyboardInput {

	public UseKeyboardInput() {

		System.out.println("�ƹ�Ű�� ������ ����");
		
		// 8bit Stream�� 16bit Stream�� ����
		BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
		
		try {
			// 16bit Stream�� ����Ͽ� �Էµ� �����͸� �ٴ����� �о� ���δ�.
			String s = br.readLine();
			System.out.println(s);

			/*// �Է� �� �� ���� �Է� ���� �ޱ�
			int input = System.in.read();
			System.out.println("�Է°� : " + input);*/
			
			/*// �Էµ� ��� ���ڿ� �ޱ� : �ѱ��� ���� �� ����.
			int input = 0;
			while(true) {
				input = System.in.read();
				
				System.out.print((char)input);
				
				// enter�� 13, 13������ ����
				if (input == 13) {
					break;
				}
			}*/
			
			// ��Ʈ�� ����� �������� ��Ʈ���� ������ �����ϴ�.
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
