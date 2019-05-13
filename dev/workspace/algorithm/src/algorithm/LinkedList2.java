package algorithm;

public class LinkedList2 {
	
	public static void main(String[] args) {
		
		Node n = new Node(5);
		n.append(3);
		n.append(6);
		n.append(1);
		
		n.delete(3);
		n.retrieve();
	}
}
