package date181203;

public class IsARelation {

	public static void main(String[] args) {
		
		Sub s = new Sub();
		
		s.i = 10;
		s.printI();
		
		Super s2 = new Sub();
		
		s2.i = 100;
		s2.printI();
	}
}

class Super{
    int i;
    public Super() { }
    public void printI() { System.out.println("�θ� i="+i); }
}

class Sub extends Super {
	int i;
    int j;
    @Override
    public void printI() { System.out.println("�ڽ� i="+i+", �θ� i="+super.i); }
    public void printJ() { System.out.println("�ڽ� j="+j); }
}