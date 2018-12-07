package date181207;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Set : �˻��� ����� ������(get�� ����) �ߺ����� ������ �� ����. 
 * @author owner
 */
public class UseSet {
	
	public UseSet() {

		// jdk 1.5������ Generic�� �������� �ʰ� ��ü�� ����.
		// 1.����)
		Set<String> set = new HashSet<String>();
		
		// 2.�� �Ҵ�) �ߺ��� ���� ���� ������� ���� �ʴ´�.
		set.add("���ü�"); set.add("������");
		set.add("������"); set.add("������");
		set.add("������"); set.add("������");
		set.add("�̺���"); set.add("������");  // �ߺ��� ���� X
		
		System.out.println("ũ�� : "+set.size()+" / "+set);
		
		set.remove("������"); // ����������
		System.out.println("ũ�� : "+set.size()+" / "+set);
		
		// �迭�� ����
		String[] names = new String[set.size()];
		set.toArray(names);
		
		System.out.println("-------����� �迭�� ���-------");
		for(String name : names) {
			System.out.print(name+" ");
		}
		System.out.println();
		
		// set�� ��� ��(Elements)�� �� ���
		// Set ��ü�� �˻������ ����
		Iterator<String> ita = set.iterator();
		
		String name = ""; // "" - empty
		while(ita.hasNext()) { // iterator�� �����ϴ� Set�� ��Ұ� �����Ѵٸ�
			name = ita.next(); // �ش����� ���� ��� ���� �����ͷ� �̵�
			System.out.print(name+" ");
		}
		System.out.println();
		
		// �ӵ��� Iterator ����ϴ°� �� ����
		System.out.println("------------���� for----------------");
		for(String temp: set) {
			System.out.print(temp+" ");
		}
		System.out.println();
		
		// ��� ���� �� ����
		set.clear();
		System.out.println("clear �� : "+set.size()+"/"+set);
	}
	
	public static void main(String[] args) {
		new UseSet();
	}
}
