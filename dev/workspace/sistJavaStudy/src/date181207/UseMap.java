package date181207;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Hashtable;

/**
 * Map : KVP�� �Ǿ��ִ� �ڷᱸ��, Ű�� ����Ͽ� ���� ��� ���� ��
 * 
 * @author owner
 */
public class UseMap {

	public UseMap() {
		// jdk 1.5������ ��� Generic ���Ұ�
		// 1.����
		Map<String, String> map = new HashMap<String, String>();

		// 2.���Ҵ� - Ű�� ����, ���� �ߺ� ����
		// �ԷµǴ� ������� ������� ����
		map.put("Oracle", "��뷮 �����ͺ��̽�");
		map.put("Java", "���α׷��� ���");
		map.put("Python", "���α׷��� ���"); // ���� �ߺ� ����
		// Ű�� �����Ѵٸ� �ش� Ű�� ���� ����.
		map.put("Java", "�Ϻ��� ��ü���� ���"); // upsert
		map.put("HTML", "Hyper Text Markup Language");
		System.out.println(map.size() + " " + map);

		// 3.����� - Ű�� ����Ͽ� ���� ��´�.
		// Ű�� �ش��ϴ� ���� ���ٸ� null
		System.out.println(map.get("Oracle"));
		System.out.println(map.get("JS"));

		String val = map.get("Java");
		System.out.println(val);

		// 4.Ű�� �����ϴ���?
		String key = "Java";
		boolean flag = map.containsKey(key);
		System.out.println(key + "�� �����ϳ�? : " + flag);

		// 5.������
		map.remove("Java");
		System.out.println("���� �� : " + map);

		// 6.��� Ű�� ���
		Set<String> allKeys = map.keySet();
		System.out.println("���� ���� ��� Ű : " + allKeys);

		// 7.��� �� ���
		Iterator<String> ita = allKeys.iterator();
		String value = "";
		while (ita.hasNext()) {
			// �� Ű�� ������ ���� ��´�.
			value = map.get(ita.next());
			System.out.println(value);
		}

		// 8.��� ����
		map.clear();
		System.out.println("��� ���� : " + map.size() + " / " + map);
	}
	
	/**
	 * �⺻�����ڸ� ����ϸ� 11���� ���� �ڵ�����
	 * MultiThread���� �������� �Ұ���
	 * �����Ͱ� ��ü ���� ������ �� 75% ä������ �� ���� �����˻��� �Ѵ�.
	 */
	public void Hashtable(String key) {
		// 1.����
		Map<String,String> bloodMap = new Hashtable<String,String>();
		
		// 2.���Ҵ�
		bloodMap.put("A", "�����ϴ�, ģ���ϴ�. ^o^b");
		bloodMap.put("B", "�����巴�� ��,.��");
		bloodMap.put("AB", "������ @,.@");
		bloodMap.put("O", "�����δ��ϴ� ~(^^~)(~^^)~");
		bloodMap.put("A", "�ҽ��ϴ�. ��^.^��");
		
		// �� ���
		String value = bloodMap.get(key);
		
		if (!bloodMap.containsKey(key)) { // Ű�� �����ϴ����� ���ؼ�
			System.out.println(key+" �������� ����� ���� �ƴմϴ�.");
		} else {
			System.out.println(key+"�� Ư¡�� "+value);
		}
	}
	
	/**
	 * �⺻�����ڸ� ����ϸ� 16�� ���� �ڵ�����
	 * MultiThread���� �������� ����
	 * �����Ͱ� ��ü ���� ������ �� 75% ä������ �� ���� �����˻��� �Ѵ�.
	 */
	public void HashMap(String key) {
		// 1.����)
		Map<String, String> map = new HashMap<String, String>();
		
		// 2.�� �Ҵ�)
		map.put("���ʺ���", "Ǯ�� ���� ������ ���´�.");
		map.put("��������", "ó���� �ٲپ� �����Ͽ� ��.");
		map.put("���乫��", "�ƹ��͵� ���� ������ �� �ݷ��ϰ� �ƹ��͵� ���� �ʰڴ�.");
		map.put("���γ���", "�����ϸ� �θǽ� �ϰ��ϸ� �ҷ�");
		map.put("�̺θ�õ", "������ ��ȥ�ϸ� ��õ���� ���ϸ� ��õ����");
		map.put("��������", "�� �� ���� �����");
		map.put("����ġ��", "�Լ��� ������ ¡�׷�����");
		map.put("���ü���", "���α��� �ڶ�");
		
		// 3.�� ���)
		if(map.containsKey(key)) { // �ʿ� Ű�� �����Ѵٸ�
			String value = map.get(key); // �� ���
			System.out.println(key+"�� ���� "+value);
		} else {
			System.out.println(key+"�� ���ڼ���� �غ���� �ʾҽ��ϴ�.");
		}
	}

	public static void main(String[] args) {
		UseMap um = new UseMap();
		
		System.out.println("-------------Hashtable���----------------");
		um.Hashtable("B".toUpperCase());
		System.out.println("-------------HashMap���------------------");
		um.HashMap("��������");
	}
}
