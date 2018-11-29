package date181129;

public class UserPI {

	public static void main(String[] args) {
		PersonalInfo[] pi = new PersonalInfo[7];
		int cntSeoul = 0;
		int sumOfAge = 0;
		int oldestAge = 0;
		String oldestName="";
		String oldestGender="";
		
		
		for (int i = 0; i < pi.length; i++) {
			pi[i] = new PersonalInfo();
		}

		// 1.
		pi[0].setAllInfo(1, "������", "����� ������ ���ﵿ", 28, "����");
		pi[1].setAllInfo(2, "������", "����� ���빮�� ��ʸ���", 27, "����");
		pi[2].setAllInfo(3, "������", "������ ���뱸 ���뵿", 26, "����");
		pi[3].setAllInfo(4, "���ü�", "����� ���α� ���ε�", 27, "����");
		pi[4].setAllInfo(5, "���ü�", "����� ���۱� �󵵵�", 29, "����");
		pi[5].setAllInfo(6, "�����", "��⵵ ��õ�� ��õ��", 26, "����");
		pi[6].setAllInfo(7, "�����", "����� ������ �����絿", 27, "����");

		/*
		 * // ���� for�� for(int i=0; i<pi.length; i++) { PersonalInfo tmp = new
		 * PersonalInfo(); tmp = pi[i]; tmp.printPersonalInfo(); }
		 */

		// ���� for��
		for (PersonalInfo p : pi) {
			p.printPersonalInfo();
			sumOfAge += p.getAge();
			if(p.getAddress().contains("����")) {
				cntSeoul++;
			}
			if(p.getAge() > oldestAge) {
				oldestAge = p.getAge();
				oldestName = p.getName();
				oldestGender = p.getGender();
			}
		}
		
		System.out.println("����� ������ "+cntSeoul+"��");
		System.out.println("���� �� "+sumOfAge+"��");
		System.out.printf("�ְ���� \"%s(%s)\"\n",oldestName, oldestGender);
	}
}
