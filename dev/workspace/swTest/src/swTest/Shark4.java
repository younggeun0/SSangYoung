package swTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Shark4 {
	
	static int N;
	static int map[][] = new int[20][20];
	static class Point {
		int r, c, d;
		
		Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	static int[] dr = { -1, 1, 0, 0};
	static int[] dc = { 0, 0, -1, 1};
	static final int INF = 987654321;
	
	static int solve(int r, int c) {
		int ret = 0;
		
		int size = 2;
		int cnt = 2;
	
		Point minP = new Point(r, c, 0);
		
		do {
			boolean visited[][] = new boolean[20][20];
			Queue<Point> queue = new LinkedList<Point>();
			
			visited[minP.r][minP.c] = true;
			queue.add(new Point(minP.r, minP.c, 0));
			minP.d = INF;
			
			while(!queue.isEmpty()) {
				Point currP = queue.poll();
				
				if (map[currP.r][currP.c] > size) continue;
				if (map[currP.r][currP.c] != 0
						&& map[currP.r][currP.c] < size ) {
					if (currP.d < minP.d) {
						minP = currP;
					} else if (currP.d == minP.d) {
						if (currP.r < minP.r) {
							minP = currP;
						} else if (currP.r == minP.r
								&& currP.c < minP.c) {
							minP = currP;
						}
					}
					continue;
				}
				
				for(int i=0; i<4; i++) {
					int newRow = currP.r + dr[i];
					int newCol = currP.c + dc[i];
					
					if (newRow < 0 || newRow > N-1 || newCol < 0 || newCol > N-1) continue;
					if (visited[newRow][newCol]) continue;
					
					visited[newRow][newCol] = true;
					queue.add(new Point(newRow, newCol, currP.d+1));
				}
			}
			
			if (minP.d != INF) {
				ret += minP.d;
				--cnt;
				if (cnt == 0) {
					++size;
					cnt = size;
				}
				map[minP.r][minP.c] = 0;
			}
			
		} while(minP.d != INF);
		
		return ret;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int srow = 0, scol = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					srow = i;
					scol = j;
					map[i][j] = 0;
				}
			}
		}
		
		System.out.println(solve(srow, scol));
	}
}
