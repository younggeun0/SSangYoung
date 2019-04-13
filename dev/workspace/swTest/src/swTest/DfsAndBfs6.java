package swTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DfsAndBfs6 {

	static class Node {
		int data;
		boolean marked;
		LinkedList<Node> adjacent;
		
		Node(int data) {
			this.data = data;
			marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	static class Graph {
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
		
		void dfs(int index) {
			Node root = nodes[index];
			
			Stack<Node> stack = new Stack<Node>();
			root.marked = true;
			stack.push(root);
			
			while(!stack.isEmpty()) {
				Node r = stack.pop();
				
				for(Node n : r.adjacent) {
					if (n.marked == false) {
						n.marked = true;
						stack.push(n);
					}
				}
				
				System.out.print(r.data+" ");
			}
		}
		
		void bfs(int index) {
			Node root = nodes[index];
			
			Queue<Node> queue = new LinkedList<Node>();
			root.marked = true;
			queue.add(root);
			
			while(!queue.isEmpty()) {
				Node r = queue.poll();
				
				for(Node n : r.adjacent) {
					if (n.marked == false) {
						n.marked = true;
						queue.add(n);
					}
				}
				
				System.out.print(r.data + " ");
			}
		}
		
		void dfsR(Node r) {
			if (r == null) return;
			
			r.marked = true;
			System.out.print(r.data + " ");
			
			for(Node n : r.adjacent) {
				if (n.marked == false) {
					dfsR(n);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {

		Graph g = new Graph(9);
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		g.bfs(0);
	}
}
