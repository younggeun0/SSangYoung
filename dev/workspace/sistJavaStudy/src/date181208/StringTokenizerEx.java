package date181208;

import java.util.StringTokenizer;

/* 2. �Ʒ� ���õ� ���ڿ��� ���� ���ڷ� �߶󳻾� ���ڿ� �迭�� �����ϰ� ��ȯ�ϴ� ���� �ϴ� method�� �ۼ��ϼ���.

"������,������.������,���ü�~������!������.����ö,������,������,���ü�.������"

���:
������ ������ ������ ���ü� ������ ������ ����ö ������ ������ ���ü� ������ */
public class StringTokenizerEx {

	public static void main(String[] args) {
		
		String str = "������,������.������,���ü�~������!������.����ö,������,������,���ü�.������";
		StringTokenizer stk = new StringTokenizer(str, ",.~!");
		
		while(stk.hasMoreTokens()) {
			System.out.print(stk.nextToken()+" ");
		}
		System.out.println();
	}
}
