package date181127;
/* 
���� 1.
�ֹι�ȣ�� �Է¹޾� ó���ϴ� ���α׷��� �ۼ�
�� �۾��� method�� �����ϰ� ȣ���Ͽ� ����� �޾Ƽ� ó��
1-1)
  �����ڴ� �ֹι�ȣ�� �޾� instance������ �Ҵ�
  1-2)���� instance ������ ���� ���
1-2)
  �ֹι�ȣ�� ���̸� üũ�Ͽ� 14�ڰ� �ƴϸ� false�� ��ȯ
1-3)
  �ֹι�ȣ�� 6��° �ڸ��� '-'�ƴϸ� false�� ��ȯ
1-4)
  �ֹι�ȣ�� ��ȿ�� ������ �ϴ� method�ۼ��Ͽ� ��ȿ�ϸ� true/false ��ȯ
  - ���ڸ��� 234567-892345 �� ���� ���� ���Ͽ� 11�� ���� ������ ���� ���
    11���� �� ���� ���� 10���� ���� �������� �ֹι�ȣ�� ���ڸ��� ���ٸ� true
1-5)
  ��������� ��ȯ�ϴ� ��. ��) 1988-11-11 
1-6)
  ���̸� ��ȯ�ϴ� ��. ��) 31
1-7)
  ������ ��ȯ. ��) ��|��
1-8)
  ������/�ܱ��� ��ȯ 
  - 1,2,3,4 : ������ (1,2 - 1900����, 3,4 - 2000����)
  - 5,6,7,8 : �ܱ��� (5,6 - 1900����, 7,8 - 2000����)
1-9) 
  �츦 ��ȯ ��)���
*/
public class ValidateSSN {

	String ssn;
	
	// 1-1 �����ڴ� �ֹι�ȣ�� �޾� instance������ �Ҵ�
	public ValidateSSN(String ssn) {
		this.ssn = ssn;
	}

	// 1-2 �ֹι�ȣ�� ���̸� üũ�Ͽ� 14�ڰ� �ƴϸ� false�� ��ȯ
	private boolean checkLength() {
		if (ssn.length() == 14)
			return true;
		else 
			return false;
	}
	
	// 1-3 �ֹι�ȣ�� 6��° �ڸ��� '-'�ƴϸ� false�� ��ȯ
	private boolean checkHyphen() {
		if (ssn.charAt(6) == '-')
			return true;
		else 
			return false;
	}
	
	// 1-4
	private boolean validateSSN() {
		
		int checkNum = 0;
		
		int j = 2;
		// ��6�ڸ�
		for(int i=0; i<6; i++) {
			checkNum += Integer.parseInt(ssn.substring(i, i+1))*j;
			j++;
		}
		// ��6�ڸ�
		for(int i=7; i<ssn.length()-1; i++) {
			checkNum += Integer.parseInt(ssn.substring(i, i+1))*j;
			j++;
			if (j > 9) j=2;
		}
		
		checkNum %= 11;
		checkNum = 11-checkNum;
		checkNum %= 10;
		
		if (Integer.parseInt(ssn.substring(13))==checkNum)
			return true;
		else
			return false;
	}
	
	// 1-5 ��������� ��ȯ�ϴ� ��. ��) 1988-11-11 
	private String getBirthDate() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		String birthdate;
		
		if (flag == 1 || flag == 2 || flag == 5 || flag == 6) {
			birthdate = 19+ssn.substring(0,2)+"-"+ssn.substring(2,4)+"-"+ssn.substring(4,6);
		} else {
			birthdate = 20+ssn.substring(0,2)+"-"+ssn.substring(2,4)+"-"+ssn.substring(4,6);
		}
		
		return birthdate;
	}
	
	// 1-6 ���̸� ��ȯ�ϴ� ��. ��) 31
	private int getAge() {
		int flag = Integer.parseInt(ssn.substring(7,8));
		String birthYear;
		int age;
		
		if (flag == 1 || flag == 2 || flag == 5 || flag == 6) {
			birthYear = 19+ssn.substring(0,2); 
			age = 2018-Integer.parseInt(birthYear)+1;
		} else {
			birthYear = 20+ssn.substring(0,2); 
			age = 2018-Integer.parseInt(birthYear)+1;
		}
		
		return age;
	}
	
	// 1-7 ������ ��ȯ. ��) ��|��
	private char getGender() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		
		if (flag == 1 || flag == 3 || flag == 5 || flag == 7) {
			return '��';
		} else {
			return '��';
		}
	}
	
	// 1-8 ������/�ܱ��� ��ȯ 
	private String checkNation() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		
		if (flag == 0 || flag == 1 || flag == 2 || flag == 3 || flag == 4 || flag == 9) {
			return "������";
		} else {
			return "�ܱ���";
		}
	}
	
	// 1-9 �츦 ��ȯ 
	// �¾�ظ� �Է¹޾� ��(12) ���ϱ�
	// 11-��, 10-��, 9-��, 8-��, 7-�䳢, 6-ȣ����,  5-��, 4-��, 3-����,
	// 2-��, 1-��, 0-������
	private String getChineseZodiac() {
		
		int flag = Integer.parseInt(ssn.substring(7,8));
		String birthYear;
		
		if (flag == 1 || flag == 2 || flag == 5 || flag == 6) {
			birthYear = 19+ssn.substring(0,2); 
		} else {
			birthYear = 20+ssn.substring(0,2); 
		}
		
		int i = Integer.parseInt(birthYear);
		
		if (i%12 == 11) {
			return "��";
		} else if (i%12 == 10) {
			return "��";
		} else if (i%12 == 9) {
			return "��";
		} else if (i%12 == 8) {
			return "��";
		} else if (i%12 == 7) {
			return "�䳢";
		} else if (i%12 == 6) {
			return "ȣ����";
		} else if (i%12 == 5) {
			return "��";
		} else if (i%12 == 4) {
			return "��";
		} else if (i%12 == 3) {
			return "����";
		} else if (i%12 == 2) {
			return "��";
		} else if (i%12 == 1) {
			return "��";
		} else {
			return "������";
		}
	}
	
	public static void main(String[] args) {
		String ssn = "901206-2344599";
		//            01234567890123
		ValidateSSN vs = new ValidateSSN(ssn);
		
		if (vs.checkLength()) {
			if(vs.checkHyphen()) {
				if(vs.validateSSN()) {
					System.out.println("������� : " + vs.getBirthDate());
					System.out.println("���� : " + vs.getAge());
					System.out.println("���� : " + vs.getGender());
					System.out.println("���� : " + vs.checkNation());
					System.out.println("�� : "+vs.getChineseZodiac());
				} else {
					System.out.println("������ �ȵǴ� �ֹι�ȣ�Դϴ�..");
				}
			} else {
				System.out.println("6��° �ڸ��� '-'�� �����ϴ�..");
			}
		} else {
			System.out.println("�ֹι�ȣ ���̰� 14�ڰ� �ƴմϴ�..");
		}
	}
}
