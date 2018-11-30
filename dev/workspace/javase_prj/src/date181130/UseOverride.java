package date181130;

public class UseOverride {

	public static void main(String[] args) {
		
		OverrideToString ots = new OverrideToString();
		String str = new String("문자열 저장소");
		HongGilDong gd = new HongGilDong();
		
//		System.out.println(ots.toString());
//		System.out.println(gd.toString());
//		System.out.println(str.toString());
		System.out.println(ots.toString());
		System.out.println(gd);
		System.out.println(str);
		System.out.println(gd.getClass());
	}
}
