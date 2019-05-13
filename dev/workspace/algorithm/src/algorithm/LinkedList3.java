package algorithm;

class Node2 {
	
	int data;
	Node2 next = null;
	
	Node2(int d) {
		this.data = d;
	}
	
	void append(int d) {
		Node2 end = new Node2(d);
		Node2 n = this;
		
		while(n.next != null) {
			n = n.next;
		}
		
		n.next = end;
	}
	
	void delete(int d) {
		Node2 n = this;
		
		while(n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		Node2 n = this;
		while(n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}
}

public class LinkedList3 {

	public static void main(String[] args) {
		Node2 n = new Node2(4);
		
		n.append(3);
		n.append(5);
		n.append(1);
		n.append(4);
		
		n.delete(5);
		n.retrieve();
	}
}
