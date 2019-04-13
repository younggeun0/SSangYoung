package swTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Shark2 {

	static int N;
	static int map[][] = new int[20][20];
	static int INF = 987654321;
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
		
		// 현재 상어 Point
		Point minPt = new Point(r, c, 0);
		
		// BFS탐색으로 주변에 가장 가까운 생선을 찾아 가능한만큼 계속 잡아먹음
		do {
			boolean visited[][] = new boolean[20][20]; // false로 초기화
			Queue<Point> myqueue = new LinkedList<Point>();
			
			visited[minPt.r][minPt.c] = true;
			
			// 첫번째에 먼저 상어의 위치를 넣음, 다음부턴 잡아먹은 후 위치를 넣음
			myqueue.add(new Point(minPt.r, minPt.c, 0));
			minPt.d = INF;
			
			while(!myqueue.isEmpty()) {
				Point curr = myqueue.poll(); // 큐에서 하나 꺼내서
				
				// 먼저 다음에 이동할 최단거리, 먹을 수 있는 포인트 찾기
				// 해당 위치에 물고기의 사이즈가 더 크면 스킵
				if (map[curr.r][curr.c] > size) continue; 
				// 물고기가 있고 현재 물고기 사이즈보다 작을 때
				if (map[curr.r][curr.c] != 0 && 
						map[curr.r][curr.c] < size) {
					if (curr.d < minPt.d) {
						minPt = curr; // 현재 포인트가 최단포인트면 덮어씌움
					} else if (curr.d == minPt.d) { // 거리가 같다면
						if (curr.r < minPt.r) { // 현재 로우가 최단 로우보다 작은지(아랜지)
							minPt = curr;
						} else if (curr.r == minPt.r 
								&& curr.c < minPt.c) {
							minPt = curr;
						}
					}
					continue;
				} // 다음 으로 갈 최단 포인트 curr == minPt 정해진 거(minPt)
				
				// 주변 이동할 수 있는 포인트 넣기
				for(int i=0; i<4; i++) {
					// 새로운 포인트를 찾아 조건을 만족시키는 위치를 발견하면 방문처리하고 큐에 넣기
					int nr = curr.r + dr[i], nc = curr.c+dc[i];
					if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;
					if (visited[nr][nc]) continue;
					visited[nr][nc] = true;
					
					myqueue.add(new Point(nr, nc, curr.d+1));
				}
			}
				
			// 만약 이동할 포인트를 찾아 물고기를 찾았다면
			if (minPt.d != INF) {
				ret += minPt.d; // 이동한 시간(거리)을 더하고
				--cnt; // 성장을 위한 cnt를 줄이고
				if (cnt == 0) { // 만약 0보다 작아지면 몸집을 키우고
					++size;
					cnt = size; // 다시 몸집크기로 cnt 시작
				}
				map[minPt.r][minPt.c] = 0; // 먹은 위치는 0으로 변경
			}
			
		} while(minPt.d != INF);
		
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
