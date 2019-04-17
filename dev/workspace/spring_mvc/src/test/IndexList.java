package test;

public class IndexList {
	// ���� �Խ����� ������ �ε��� ����
	public static String indexList(int current_page, int total_page) {
		int pagenumber; // ȭ�鿡 ������ ������ �ε��� ��
		
		int startpage; // ȭ�鿡 ������ ���������� ��ȣ
		int endpage; // ȭ�鿡 ������ ������������ ��ȣ
		int curpage; // �̵��ϰ��� �ϴ� ������ ��ȣ
		String strList = ""; // ���ϵ� ������ �ε��� ����Ʈ
		
		pagenumber = 10; // �� ȭ���� ������ �ε��� ��

		// ���� ��������ȣ ���ϱ�
		startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

		// ������ ��������ȣ ���ϱ�
		endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

		// �� ������ ���� ���� ������������ ��ȣ���� �������
		// �� ������ ���� ������������ ��ȣ�� ��
		if (total_page <= endpage) {
			endpage = total_page;
		}

		// ù��° ������ �ε��� ȭ���� �ƴѰ��
		if (current_page > pagenumber) {
			curpage = startpage - 1; // ���������� ��ȣ���� 1 ���� �������� �̵�
			strList = strList + "[<<]";
		} else {
			strList = strList + "[<<]";
		}
		strList = strList + " ... ";
		
		// ���������� ��ȣ���� ������������ ��ȣ���� ȭ�鿡 ǥ��
		curpage = startpage;
		while (curpage <= endpage) {
			if (curpage == current_page) {
				strList = strList + "[" + current_page + "]";
			} else {
				strList = strList + "[" + curpage + "]";
			}
			curpage++;
		}

		strList = strList + " ... ";
		// �ڿ� �������� �� �ִ°��
		if (total_page > endpage) {
			curpage = endpage + 1;
			strList = strList + "[>>]";
		} else {
			strList = strList + "[>>]";
		}

		return strList;
	}
	
	public static void main(String[] args) {
		System.out.println(indexList(1, 55));
	}
}
