package date0313;

/**
 * scope �Ӽ��� ���� �ٸ��� �����Ǵ� ��ü
 * @author owner
 */
public class CounterVO {

	private int cnt;
	
	public CounterVO() {
		System.out.println("CounterVO");
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt += cnt;
	}
}
