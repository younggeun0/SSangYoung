package date181123;

/**
 * 사람을 추상화하여 만든 Person 클래스를 사용하는 클래스
 * @author owner
 */
public class UsePerson {

	public static void main(String[] args) {
		
		// 객체 생성 : heap에 생성되고 instance 변수는 자동 초기화
		Person young = new Person();
		
		/*young.setEye(2);
		young.setNose(1);
		young.setMouth(1);*/
		young.setName("영근");
		
		// 참조형 데이터형인 Person은 heap의 주소를 가지고 있다.
		System.out.println("객체를 출력하면 주소가 출력 :"+young);
		System.out.format("생성된 사람 객체 정보 눈[%d], 코[%d], 입[%d], 이름[%s]\n",
				young.getEye(), young.getNose(), young.getMouth(), young.getName());
		
		// 생성된 객체에 일을 시킴
		System.out.println(young.eat());;
		System.out.println(young.eat("냉면", 8000));;
		
		System.out.println("=======================================");
		
		Person jinban = new Person();
		jinban.setName("천진반");
		jinban.setEye(10);
		jinban.setNose(1);
		jinban.setMouth(1);

		System.out.format("생성된 사람 객체 정보 눈[%d], 코[%d], 입[%d], 이름[%s]\n",
				jinban.getEye(), jinban.getNose(), jinban.getMouth(), jinban.getName());
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("선두", 1));
		
		
	}
}
