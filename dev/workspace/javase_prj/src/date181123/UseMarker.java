package date181123;

/**
 * ��ī���� ������ Ŭ������ ����ϴ� Ŭ����<br>
 * 4. ��ü ����
 * 5. ������ ��ü ���
 * @author owner
 */
public class UseMarker {

	/**
	 * �⺻�����ڸ� ����Ͽ� ��ü�� ������ �� setter method�� 
	 * ȣ���Ͽ� ������ ������ �� ���<br>
	 * Maker m = new Maker();
	 * ms.setXxx(��);<br>
	 * 
	 * @param args ���θ޼ҵ��μ�
	 */
	public static void main(String[] args) {

		// ������ ��ī�� 1�� ����
		Marker black = new Marker();

		black.setColor("������");
		black.setCap(1);
		black.setBody(1);
		
		System.out.printf("������ ��ī�� ��[%s], �Ѳ�[%d], ��ü[%d]"
				,black.getColor(), black.getCap(), black.getBody());
		
		System.out.println();
		// ������ ��ü�� ���
		System.out.println(black.write("�ȳ��ϼ���"));
		
		System.out.println("==========================================");
		
		// ������ ��ī�� ��ü�� 5�� ���� �� ���
		Marker red = new Marker();
		
		red.setColor("������");
		red.setBody(5);
		red.setCap(5);
		
		System.out.printf("������ ��ī�� ��[%s], �Ѳ�[%d], ��ü[%d]"
				,red.getColor(), red.getCap(), red.getBody());
		
		
		
	}
}
