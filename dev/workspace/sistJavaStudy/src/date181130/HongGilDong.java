package date181130;

/**
 * ����� ���� Ư¡�� �θ�(Person)�� ���� ����ϰ� �ڽŸ��� Ư¡�� ����
 * ȫ�浿 - �ο� ���Ѵ�
 * 
 * @author owner
 */
public class HongGilDong extends Person{

	private int level;	// ȫ�浿�� �ο򷹺�
	
	/**
	 * ȫ�浿�� �ο��� ��κ��� ���ϹǷ� 7�� ����
	 */
	public HongGilDong() {
		super();
		level = 7;
	}
	
	/**
	 * �ο��ϴ� �� : �Էµ� �������� ���ٸ� �й�, 
	 * �Էµ� �������� ���ٸ� �¸�, �Էµ� ������ ���ٸ� ��� ��ȯ
	 * �¸��ϸ� ������ 1����, �й��ϸ� ���� 1����, ���� ���� ��ȭ����
	 * ������ �ִ� 10, �ּ� 0�� ������.
	 * @param enemyLevel �ο����� ����
	 * @return ���
	 */
	public String fight(int enemyLevel) {
		String result ="";
		
		if (level > enemyLevel) {
			result = "�̰��. s('.^)V";
			level++;
			if (level > 10) {
				level = 10;
			}
		} else if (level < enemyLevel) {
			result = "����. ~(_-_)~";
			level--;
			if (level < 0) {
				level = 0;
			}
		} else {
			result = "��� �Ѥ�+;; ";
		}
		
		return result;
	}
	
	@Override
	public String eat(String menu, int price) {
		return super.getName()+"��(��) �ָ����� "+menu
				+"�� ������ "+price+"�� ���� ��Դ´�.";
	}
	
	@Override
	public String toString() {
		return "ȫ�浿 ��ü�� �� : �� "+getEye()+", �� "+getNose()+", �� "+getMouth();
	}
}
