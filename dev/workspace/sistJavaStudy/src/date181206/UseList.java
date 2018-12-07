package date181206;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.LinkedList;

/**
 * List<br>
 * �ߺ��� ����ϸ� �˻��� ����� �ְ�, ������� ���� �Է��ϴ� ����������
 * 
 * @author owner
 */
public class UseList {
	
	public UseList() {
		// jdk 1.4������ Generic�� �������� �ʰ� ��ü�� �����
		List list = new ArrayList();
		// �� �߰�
		// jdk 1.5���Ͽ����� ��ü�θ� ���� ���� �� ����
		list.add(new Integer(10));
		list.add(new Short((short)10));
		list.add(new String("������"));
		
		System.out.println("ũ�� "+list.size());
		System.out.println(((Integer)list.get(0)).intValue()+10);
		
		// jdk 1.5+ ��� : Generic, autoboxing, unboxing ��밡��
		// Generic�� ����
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(10); // autoboxing 
		list1.add(20);
		list1.add(new Integer(30));
		// Generic���� ������ ���� �ƴ� ���������� �߰��� �� ����.
		// list1.add("�����"); 
		
		System.out.println("ũ�� "+list1.size());
		for(int i=0; i<list1.size(); i++) {
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
	}
	
	/**
	 * ArrayList ��� : Multi Threadȯ�濡�� ���� ���� ����(����ȭ X)
	 * 
	 */
	public void useArrayList() {
		// 1. ����
		ArrayList<String> al = new ArrayList<String>(); // capacity X(�� 0��)
		List<String> al1 = new ArrayList<String>(100); // capacity O(�� 100��)
		
		System.out.println(al+" / "+al1);
		
		// �� �߰�
		// ���� ������� �߰���, �ߺ��� ���
		al.add("������"); al.add("������"); al.add("������"); al.add("������");
		al.add("������"); al.add("������");	al.add("������"); al.add("���ü�");
		System.out.println(al+" / "+al1);

		/*
		// size() : �������� ũ��(size != capacity )
		System.out.println("al ũ�� : "+al.size()+" / al1 ũ�� : "+al1.size());
		
		// �迭�� ����
		String[] names = new String[al.size()];
		al.toArray(names);
		
		// ����� �迭 ���
		System.out.println("---------- ����� �迭 ��� ----------");
		for(int i=0; i<names.length; i++) {
			System.out.printf("%s\t",names[i]);
		}
		System.out.println();
		System.out.println("--------------------------------------");
		
		// ���� �� ����
		// -�ε����� ����
		al.remove(5); 
		System.out.println(al+" / "+al1);
		// -������ ����
		// �ߺ��� ���� ���� �� L->R�� �����ϸ鼭 
		// ��ġ�ϴ� ù���� ���� ����
		al.remove("������"); 
		System.out.println(al+" / "+al1);

		// ���� for�� ���
		for(String name : al) {
			System.out.print(name+" ");
		}
		System.out.println();*/
		
		// iterator�� �̿��� ���
		Iterator<String> ita = al.iterator();
		
		while(ita.hasNext()) {
			System.out.println(ita.next());
		}
		
		// ��� ����
		al.clear();
		System.out.println("��ü ���� �� size : "+al.size()+" / "+al);
	}
	
	public void useVector() {
		// 1. ����
		Vector<String> vec = new Vector<String>(); // capacity X(�� 0��)
		List<String> vec1 = new Vector<String>(100); // capacity O(�� 100��)
		
		System.out.println(vec+" / "+vec1);
		
		// �� �߰�
		// ���� ������� �߰���, �ߺ��� ���
		vec.add("������"); vec.add("������"); vec.add("������"); vec.add("������");
		vec.add("������"); vec.add("������");	vec.add("������"); vec.add("���ü�");
		System.out.println(vec+" / "+vec1);

		// size() : �������� ũ��(size != capacity )
		System.out.println("vec ũ�� : "+vec.size()+" / vec1 ũ�� : "+vec1.size());
		
		// �迭�� ����
		String[] names = new String[vec.size()];
		vec.toArray(names);
		
		// ����� �迭 ���
		System.out.println("---------- ����� �迭 ��� ----------");
		for(int i=0; i<names.length; i++) {
			System.out.printf("%s\t",names[i]);
		}
		System.out.println();
		System.out.println("--------------------------------------");
		
		// ���� �� ����
		// -�ε����� ����
		vec.remove(5); 
		System.out.println(vec+" / "+vec1);
		// -������ ����
		// �ߺ��� ���� ���� �� L->R�� �����ϸ鼭 
		// ��ġ�ϴ� ù���� ���� ����
		vec.remove("������"); 
		System.out.println(vec+" / "+vec1);

		// ���� for�� ���
		for(String name : vec) {
			System.out.print(name+" ");
		}
		System.out.println();
		
		// ��� ����
		vec.clear();
		System.out.println("��ü ���� �� size : "+vec.size()+" / "+vec);
	}
	
	public void useLinkedList() {
		// 1. ����	
		LinkedList<String> ll = new LinkedList<String>(); 
		List<String> ll1 = new LinkedList<String>(); 
		
		System.out.println(ll+" / "+ll1);
		
		// �� �߰�
		// ���� ������� �߰���, �ߺ��� ���
		ll.add("������"); ll.add("������"); ll.add("������"); ll.add("������");
		ll.add("������"); ll.add("������");	ll.add("������"); ll.add("���ü�");
		System.out.println(ll+" / "+ll1);

		// size() : �������� ũ��(size != capacity )
		System.out.println("ll ũ�� : "+ll.size()+" / ll1 ũ�� : "+ll1.size());
		
		// �迭�� ����
		String[] names = new String[ll.size()];
		ll.toArray(names);
		
		// ����� �迭 ���
		System.out.println("---------- ����� �迭 ��� ----------");
		for(int i=0; i<names.length; i++) {
			System.out.printf("%s\t",names[i]);
		}
		System.out.println();
		System.out.println("--------------------------------------");
		
		// ���� �� ����
		// -�ε����� ����
		ll.remove(5); 
		System.out.println(ll+" / "+ll1);
		// -������ ����
		// �ߺ��� ���� ���� �� L->R�� �����ϸ鼭 
		// ��ġ�ϴ� ù���� ���� ����
		ll.remove("������"); 
		System.out.println(ll+" / "+ll1);

		// ���� for�� ���
		for(String name : ll) {
			System.out.print(name+" ");
		}
		System.out.println();
		
		// ��� ����
		ll.clear();
		System.out.println("��ü ���� �� size : "+ll.size()+" / "+ll);
	}
	
	public static void main(String[] args) {
		UseList ul = new UseList();
		
		System.out.println("************************ArrayList*************************");
		ul.useArrayList();
		//System.out.println("************************Vector****************************");
		//ul.useVector();
		//System.out.println("************************LinkedList************************");
		//ul.useLinkedList();
	}
}
