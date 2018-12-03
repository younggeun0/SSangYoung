package date181202;

public class Main {

	public static void main(String[] args) {
		
		PersonalInfo[] pplList = new PersonalInfo[7];
		int seoulPpl = 0;
		int sumOfAge = 0;
		int oldestAge = 0;
		String oldestName = "";
		String oldestGender = "";
		
		for(int i=0; i<pplList.length; i++) {
			pplList[i] = new PersonalInfo();
		}
		
		pplList[0].setPI(1, "������", "����� ������ ���ﵿ", 28, "����");
		pplList[1].setPI(2, "������", "����� ���빮�� ��ʸ���", 27, "����");
		pplList[2].setPI(3, "������", "������ ���뱸 ���뵿", 26, "����");
		pplList[3].setPI(4, "���ü�", "����� ���α� ���ε�", 27, "����");
		pplList[4].setPI(5, "���ü�", "����� ���۱� �󵵵�", 29, "����");
		pplList[5].setPI(6, "�����", "��⵵ ��õ�� ��õ��", 26, "����");
		pplList[6].setPI(7, "�����", "����� ������ �����絿", 27, "����");
		
		for(PersonalInfo pi : pplList) {
			pi.printPI();
			if(pi.getAddress().contains("����")) {
				seoulPpl++;
			}
			sumOfAge += pi.getAge();
			if(pi.getAge() > oldestAge) {
				oldestAge = pi.getAge();
				oldestName = pi.getName();
				oldestGender = pi.getGender();
			}
		}
		
		System.out.println("����� ������ "+seoulPpl+"��");
		System.out.println("���� �� "+sumOfAge+"��");
		System.out.printf("�ְ���� \"%s(%s)\"\n", oldestName, oldestGender);
	}
}
