package date181218;

import java.util.Random;

/**
 * ���ܸ� ������ �߻�
 * @author owner
 */
public class TestThrow {
	
	/**
	 * ���� ���ٰ� ��踦 �ǿ�� �л��� ���� ���ǻ�ȸ�� �����Ѵ�.
	 * @throws Exception 
	 */
	public void teacksung() throws Exception {
		String[] grade = { "�ʵ��л�", "���л�", "����л�" };
		String randomGd = grade[new Random().nextInt(grade.length)];
		
		if (randomGd.equals("�ʵ��л�")) {
			throw new Exception(randomGd
					+"��Ե� �ݿ��ؾ��ϴ� �κ�������?");
		} else {
			System.out.println(randomGd+"�� ��踦 �ǿ�� ��ô ��������. ('' )( '')");
		}
	}

	public void teacksung2() throws TobaccoException {
		String[] grade = { "�ʵ��л�", "���л�", "����л�" };
		String randomGd = grade[new Random().nextInt(grade.length)];
		
		if (randomGd.equals("�ʵ��л�")) {
			throw new TobaccoException();
		} else {
			System.out.println(randomGd+"�� ��踦 �ǿ�� ��ô ��������. ('' )( '')");
		}
	}

	public static void main(String[] args) {
		
		TestThrow tt = new TestThrow();
		
		try {
			tt.teacksung2();
		} catch (TobaccoException te) {
			te.printStackTrace();
		}
	}
}
