package algorithm;

public class LinkedList4 {
	
	Node header;
	
	static class Node {
		int data;
		Node next;
	}
	
	LinkedList4() {
		header = new Node();
	}
	
	void append(int d) {
		Node end = new Node();
		end.data = d;
		
		Node n = header;
		
		while(n.next != null) {
			n = n.next;
		}
		
		n.next = end;
	}
	
	void delete(int d) {
		Node n = header;
		
		while(n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		Node n = header.next;
		
		while(n.next != null) {
			System.out.print(n.data +"->");
			n = n.next;
		}
		
		System.out.println(n.data);
	}
	
	public static void main(String[] args) {
		LinkedList4 ll4 = new LinkedList4();
		
		ll4.append(1);
		ll4.append(2);
		ll4.append(3);
		ll4.append(4);
		
		ll4.retrieve();
		
		ll4.delete(2);
		ll4.retrieve();
		
		ll4.delete(1);
		ll4.retrieve();
	}
}
