package swTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Shark3 {

	static int N;
	static int map[][] = new int[20][20];
	static final int INF = 987654321;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	
	static class Point {
		int r,c,d;
		Point(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	
	static int solve(int r, int c) {
		int ret = 0;
		
		int size = 2;
		int cnt = 2;
		
		Point minPt = new Point(r, c, 0);
		
		do {
			boolean visited[][] = new boolean[20][20];
			Queue<Point> q = new LinkedList<Point>();
			
			visited[minPt.r][minPt.c] = true;
			
			q.add(new Point(minPt.r, minPt.c, 0));
			minPt.d = INF;
			
			while(q.peek() != null) {
				Point curr = q.poll();
				
				if (map[curr.r][curr.c] > size) continue;
				if (map[curr.r][curr.c] != 0
						&& map[curr.r][curr.c] < size) {
					if (curr.d < minPt.d) {
						minPt = curr;
					} else if (curr.d == minPt.d) {
						if (curr.r < minPt.r) {
							minPt = curr;
						} else if (curr.r == minPt.r
								&& curr.c < minPt.c) {
							minPt = curr;
						}
					}
					continue;
				}
				
				for(int i=0; i<4; i++) {
					int nr = curr.r + dr[i], nc = curr.c+dc[i];
					if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;
					if (visited[nr][nc]) continue;
					visited[nr][nc] = true;
					q.add(new Point(nr, nc, curr.d+1));
				}
			}
					
			if (minPt.d != INF) {
				ret += minPt.d;
				--cnt;
				if (cnt == 0) {
					++size;
					cnt = size;
				}
				map[minPt.r][minPt.c]= 0; 
			}
			
		} while(minPt.d != INF);
		
		return ret;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int srow=0, scol=0;
		for (int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					srow=i;
					scol=j;
					map[i][j] = 0;
				}
			}
		}
		
		System.out.println(solve(srow, scol));
	}
}
