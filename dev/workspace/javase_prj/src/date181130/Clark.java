package date181130;

/**
 * ����� ����Ư¡�� Person���� �����ٰ� 
 * ����ϰ� �ڽŸ��� Ư¡�� ������ Ŭ����
 * 
 * @author owner
 */
public final class Clark extends Person{
	
	public int power;

	/**
	 * �⺻ ������ : ��ü�� �����Ǹ� power�� 9�� ���� 
	 */
	public Clark() {
		super(3,1,1);
		power = 9;
	}
	
	/**
	 * �ԷµǴ� ���� ������ ���� ���� �ް��ϰ� ����
	 *  
	 * @param stone ���� ����
	 * @return ���
	 */
	public String power(String stone) {
		String result = "";
		
		if(stone.equals("ũ���䳪��Ʈ")) {
			power = 0;
			result="���� ���� ~(_-_)~";
		} else if(stone.equals("���̾Ƹ��")) {
			power = 10;
			result="�����մϴ�. ~m(^o^)m~";
		} else {
			power=12;
			result="������. �Ѥ�+";
		}
		
		return result;
	}
	
	@Override
	public String eat() {
		// Ŭ��ũ��(��) ������ ���� �Դ´�.
		return getName()+" is eating some food at home";
	}
	
	@Override
	public String eat(String menu, int price) {
		return getName()+" is eating "+menu+" which is "+price+"$";
	}
}
