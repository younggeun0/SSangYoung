package date181205;
/* 2. �Ʒ� ���õ� ���ڿ��� ���� ���ڷ� �߶󳻾� ���ڿ� �迭�� �����ϰ� ��ȯ�ϴ� ���� �ϴ� method�� �ۼ��ϼ���.

"������,������.������,���ü�~������!������.����ö,������,������,���ü�.������"

���:
������ ������ ������ ���ü� ������ ������ ����ö ������ ������ ���ü� ������ */
import java.util.StringTokenizer;

public class StringTokenizerHW {
	
	public String[] getName(String str) {
		
		StringTokenizer stk = new StringTokenizer(str, ",.~!");
		String[] name = new String[stk.countTokens()];
		
		int idx = 0;
		while(stk.hasMoreTokens()) {
			name[idx] = stk.nextToken();
			idx++;
		}
		
		return name;
	}

	public static void main(String[] args) {
		
		String name = "������,������.������,���ü�~������!������.����ö,������,������,���ü�.������";
		
		StringTokenizerHW stkHW = new StringTokenizerHW();
		
		String[] names = stkHW.getName(name);
		
		for(int i=0; i<names.length; i++) {
			System.out.print(names[i]+" ");
		}
		
		/*StringTokenizer stk = new StringTokenizer(name, ",.~!");
		
		System.out.println("��� : ");
		while(stk.hasMoreTokens()) {
			System.out.print(stk.nextToken()+" ");
		}
		System.out.println();*/
	}
}
