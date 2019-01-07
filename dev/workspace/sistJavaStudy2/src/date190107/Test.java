package date190107;

public class Test {

	public static void main(String[] args) {
		StringBuilder selectName = new StringBuilder();
		String id = "영근";
		String pass = "비번";
		selectName
		.append("SELECT name ")
		.append("FROM test_login ")
		.append("WHERE id='").append(id).append("' AND ")
		.append("pass='").append(pass).append("'");
		
		System.out.println(selectName.toString());
	}
}
