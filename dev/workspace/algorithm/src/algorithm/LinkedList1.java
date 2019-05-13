package algorithm;

class Node {
	
	int data;
	Node next = null;
	Node(int d) {
		this.data = d;
	}
	
	void append(int d) {
		Node end = new Node(d);
		Node n = this;
		
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	void delete(int d) {
		Node n = this;
		while(n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		Node n = this;
		while(n.next != null) {
			System.out.print(n.data+"->");
			n = n.next;
		}
		System.out.print(n.data);
	}
}

public class LinkedList1 {
	
	public static void main(String[] args) {
		
		Node n = new Node(3);
		n.append(4);
		n.append(7);
		n.append(1);
		n.delete(7);
		n.retrieve();
		
		
	}
}
