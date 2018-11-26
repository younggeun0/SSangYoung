package date181126;

import date181123.Person;

public class UsePerson {

	public static void main(String[] args) {
		
		Person young = new Person();
		young.setName("오영근");
		System.out.printf("%s은(는) 눈 %d개 코 %d개 입 %d개를 갖고 있습니다.\n",
				young.getName(), young.getEye(), young.getNose(), young.getMouth());
		
		Person captainOneEye = new Person(1,1,1);
		captainOneEye.setName("외눈선장");
		System.out.printf("%s은(는) 눈 %d개 코 %d개 입 %d개를 갖고 있습니다.\n",
				captainOneEye.getName(), captainOneEye.getEye(), captainOneEye.getNose(), captainOneEye.getMouth());
		
		Person jinban = new Person(3,1,1);
		jinban.setName("천진반");
		System.out.printf("%s은(는) 눈 %d개 코 %d개 입 %d개를 갖고 있습니다.\n",
				jinban.getName(), jinban.getEye(), jinban.getNose(), jinban.getMouth());
	}
}
