package date181126;

import date181123.Person;

public class UsePerson {

	public static void main(String[] args) {
		
		Person young = new Person();
		young.setName("������");
		System.out.printf("%s��(��) �� %d�� �� %d�� �� %d���� ���� �ֽ��ϴ�.\n",
				young.getName(), young.getEye(), young.getNose(), young.getMouth());
		
		Person captainOneEye = new Person(1,1,1);
		captainOneEye.setName("�ܴ�����");
		System.out.printf("%s��(��) �� %d�� �� %d�� �� %d���� ���� �ֽ��ϴ�.\n",
				captainOneEye.getName(), captainOneEye.getEye(), captainOneEye.getNose(), captainOneEye.getMouth());
		
		Person jinban = new Person(3,1,1);
		jinban.setName("õ����");
		System.out.printf("%s��(��) �� %d�� �� %d�� �� %d���� ���� �ֽ��ϴ�.\n",
				jinban.getName(), jinban.getEye(), jinban.getNose(), jinban.getMouth());
	}
}
