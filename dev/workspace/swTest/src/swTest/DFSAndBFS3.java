package swTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSAndBFS3 {

	static class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		
		public Node(int data) {
			this.data = data;
			this.marked = false;
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
			
			if(!n1.adjacent.contains(n1)) {
				n1.adjacent.add(n2);
			}
			
			if(!n2.adjacent.contains(n2)) {
				n2.adjacent.add(n1);
			}
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
		
		void bfs(int index) {
			Node root = nodes[index];

			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			root.marked = true;
			
			while(!queue.isEmpty()) {
				Node r = queue.poll();
				for (Node n : r.adjacent) {
					if (n.marked == false) {
						n.marked = true;
						queue.add(n);
					}
				}
				visit(r);
			}
		}
		
		void dfsR(int index) {
			dfsR(nodes[index]);
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
		
		System.out.print("--dfs:stack : ");
		g.dfs(3);
		System.out.println();
		
		g = new Graph(9);
		
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
		
		System.out.print("--bfs:queue : ");
		g.bfs(3);
		System.out.println();
		
		g = new Graph(9);
		
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
		
		System.out.print("--dfs:recursion : ");
		g.dfsR(3);
		System.out.println();
	}
}
