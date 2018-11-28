package date181128;

public class SplitEx {
	
	public static void main(String[] args) {
		
		String data = "이재찬,이재현,정택성~공선의~김건하.최지우,노진경,김정운.김정윤";
		
		String[] splitedData = data.split("[.]");
		
		System.out.println("구분된 배열 방의 갯수 : " + splitedData.length);
		for(String name : splitedData) {
			System.out.println(name);
		}
	}
}
