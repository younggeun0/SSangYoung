package date181205;
/* 2. �Ʒ� ���õ� ���ڿ��� ���� ���ڷ� �߶󳻾� ���ڿ� �迭�� �����ϰ� ��ȯ�ϴ� ���� �ϴ� method�� �ۼ��ϼ���.

"������,������.������,���ü�~������!������.����ö,������,������,���ü�.������"

���:
������ ������ ������ ���ü� ������ ������ ����ö ������ ������ ���ü� ������ */
import java.util.StringTokenizer;

public class StringTokenizerHW {

	public static void main(String[] args) {
		
		String name = "������,������.������,���ü�~������!������.����ö,������,������,���ü�.������";
		
		StringTokenizer stk = new StringTokenizer(name, ",.~!");
		
		System.out.println("��� : ");
		while(stk.hasMoreTokens()) {
			System.out.print(stk.nextToken()+" ");
		}
		System.out.println();
	}
}
