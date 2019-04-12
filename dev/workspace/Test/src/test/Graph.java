package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		
		Node(int data) {
			this.data = data;
			this.marked =false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	Node[] nodes;
	
	Graph(int size) {
		nodes = new Node[size];
		for(int i=0; i<size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void dfs() {
		dfs(0);
	}
	
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;
		
		while(!stack.isEmpty()) {
			Node r = stack.pop();
			for(Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	
	void bfs() {
		bfs(0);
	}
	
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		root.marked = true;
		while(!queue.isEmpty()) {
			Node r = queue.remove();
			for(Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					queue.add(n);
				}
			}
			visit(r);
		}
	}
	
	void dfsR() {
		dfsR(new Node(0));
	}
	
	void dfsR(Node r) {
		if (r == null) return;
		r.marked = true;
		
		visit(r);
		for(Node n : r.adjacent) {
			if (n.marked == false) {
				dfsR(n);
			}
		}
	}
	
	void visit(Node r) {
		System.out.print(r.data + " ");
	}
	
	public static void main(String[] args) {
		
	}
}
