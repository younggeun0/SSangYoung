package swTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DfsAndBfs5 {
	
	static class Node {
		int data;
		boolean marked;
		LinkedList<Node> adjacent;
		
		Node(int data) {
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
				
				visit(r);
			}
		}
		
		void visit(Node r) {
			System.out.print(r.data+" ");
		}
		
		void bfs(int index) {
			Node root = nodes[index];
			
			Queue<Node> queue = new LinkedList<Node>();
			root.marked = true;
			queue.add(root);
			
			while(!queue.isEmpty()) {
				Node r = queue.poll();
				
				for(Node n : r.adjacent) {
					if(n.marked == false) {
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
		
		public static void main(String[] args) {
			Graph g = new Graph(9);
			
			g.addEdge(0, 3);
			g.addEdge(3, 2);
			g.addEdge(3, 4);
			g.addEdge(4, 1);
			g.addEdge(4, 5);
			g.addEdge(5, 8);
			g.addEdge(5, 6);
			g.addEdge(5, 7);
			g.addEdge(6, 7);
			g.addEdge(8, 7);
			
			System.out.print("dfsR : ");
			g.dfsR(4);
			//g.bfs(4);;
		}
	}
}
