package date181221;

public class Test {

	public static void main(String[] args) {
		
		String s = "C:/Users/owner/youngRepositories/SSangYoung/dev/temp/java_read.txt";
		StringBuilder sb = new StringBuilder(s);
		
		// 파일명에 '.'이 여러개 나올 수 있으므로 파일 확장자는 마지막 .뒤에 문자열이다.
		// 따라서 lastIndexOf를 사용해서 확장자를 잘라내야 한다.
		// StringBuilder에 삽입하는 insert method로 .있는 부분부터 "_bak"을 추가함
		System.out.println(sb.insert(s.lastIndexOf("."),"_bak"));
	}
}
