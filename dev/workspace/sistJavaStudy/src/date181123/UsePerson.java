package date181123;

/**
 * ����� �߻�ȭ�Ͽ� ���� Person Ŭ������ ����ϴ� Ŭ����
 * @author owner
 */
public class UsePerson {

	public static void main(String[] args) {
		
		// ��ü ���� : heap�� �����ǰ� instance ������ �ڵ� �ʱ�ȭ
		Person young = new Person();
		
		/*young.setEye(2);
		young.setNose(1);
		young.setMouth(1);*/
		young.setName("����");
		
		// ������ ���������� Person�� heap�� �ּҸ� ������ �ִ�.
		System.out.println("��ü�� ����ϸ� �ּҰ� ��� :"+young);
		System.out.format("������ ��� ��ü ���� ��[%d], ��[%d], ��[%d], �̸�[%s]\n",
				young.getEye(), young.getNose(), young.getMouth(), young.getName());
		
		// ������ ��ü�� ���� ��Ŵ
		System.out.println(young.eat());;
		System.out.println(young.eat("�ø�", 8000));;
		
		System.out.println("=======================================");
		
		Person jinban = new Person();
		jinban.setName("õ����");
		jinban.setEye(10);
		jinban.setNose(1);
		jinban.setMouth(1);

		System.out.format("������ ��� ��ü ���� ��[%d], ��[%d], ��[%d], �̸�[%s]\n",
				jinban.getEye(), jinban.getNose(), jinban.getMouth(), jinban.getName());
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("����", 1));
		
		
	}
}
