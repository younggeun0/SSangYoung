package date181128;

public class SplitEx {
	
	public static void main(String[] args) {
		
		String data = "������,������,���ü�~������~�����.������,������,������.������";
		
		String[] splitedData = data.split("[.]");
		
		System.out.println("���е� �迭 ���� ���� : " + splitedData.length);
		for(String name : splitedData) {
			System.out.println(name);
		}
	}
}
