package swTest;

import java.util.Scanner;

public class PeopleMovement2 {
	
	static int N,L,R;
	static int map[][] = new int[50][50];
	static int visited[][] = new int[50][50];
	static int cnt;
	
	static void move(int r, int c, int value) {
		if (r < 0 || r > N-1 || c < 0 || c > N-1) return;
		if (visited[r][c] != 1) return;
		
		visited[r][c] = 2;
		map[r][c] = value;
		
		move(r-1, c, value);
		move(r+1, c, value);
		move(r, c-1, value);
		move(r, c+1, value);
	}
	
	static int find(int r, int c, int value) {
		if (r < 0 || r > N-1 || c < 0 || c > N-1) return 0;
		if (visited[r][c] != 0) return 0;
		if (value != -1) {
			int diff = Math.abs(value - map[r][c]);
			if (diff < L || diff > R) return 0;
		}
		
		visited[r][c] = 1;
		cnt++;
		
		int sum = map[r][c];
		sum += find(r-1, c, map[r][c]);
		sum += find(r+1, c, map[r][c]);
		sum += find(r, c-1, map[r][c]);
		sum += find(r, c+1, map[r][c]);
		
		return sum;
	}
	
	static int solve() {
		int ret = 0;
		boolean moveFlag;
		
		do {
			moveFlag = false;
			
			for (int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited[i][j] = 0;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (visited[i][j] == 0) {
						cnt = 0; // 한 연합을 만들 국가 수
						
						int sum = find(i, j, -1);
						if (cnt > 1) {
							moveFlag = true;
							move(i, j, sum/cnt);
						} else {
							visited[i][j] = 2;
						}
					}
				}
			}
			
			if (moveFlag) ++ret;
		} while(moveFlag); // 이동을 안할때까지 반복
		
		return ret; 
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(solve());
	}
}
