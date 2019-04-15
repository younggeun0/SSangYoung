package swTest;

import java.util.Scanner;

public class Ladder {
	
	static int N, M, H; // N 세로선, M 가로선, H가로선을 놓을 수 있는 위치의 개수
	static int[][] ladder = new int[30][10];
	static final int RIGHT = 1;
	static final int LEFT = 2;
	static final int INF = 987654321;
	
	static boolean check() {
		for(int i=0; i<N; i++) {
			int row = 0, col = i;
			do {
				if(ladder[row][col] == LEFT)
					--col;
				else if (ladder[row][col] == RIGHT)
					++col;
				
				++row;
			} while(row != H);
			
			if (col != i) return false;
		}
		
		return true;
	}
	
	static int solve(int pos, int cnt) { // 0부터 시작하는 인덱스, 추가하는 가로줄의 개수
		if (cnt == 3 || pos >= N*H) {
			if (check()) {
				return cnt;
			}
			return INF;
		}
		
		int ret = INF;
		
		// position 값을 컬럼 수로 나눴을때 몫이 row값이 됨, 
		// position 값을 컬럼 수로 나눴을 때 나머지가 column이 됨
		int row = pos / N, col = pos % N;
		
		if (col != N-1 && ladder[row][col] == 0 && ladder[row][col+1] == 0) { // 가로선을 넣고
			// 넣을 때 컬럼이 마지막 좌표면 그릴 수 없음, 사다리를 그릴 두 칸이 모두 0일때만 그릴 수 있다.
			ladder[row][col] = RIGHT;
			ladder[row][col+1] = LEFT;
			
			ret = Math.min(ret, solve(pos+2, cnt+1));// col+1을 LEFT로 바꿨기 때문에 두칸 이동한다 
			// 최소값을 찾기위해서 반복해서 최소값을 덮어씌운다
			ladder[row][col] = ladder[row][col+1] = 0;
		}
		ret = Math.min(ret, solve(pos+1, cnt)); // 않넣고
		return ret;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			
			ladder[a-1][b-1] = RIGHT;
			ladder[a-1][b] = LEFT;
		}
		
		int answer = solve(0, 0);
		
		if(answer == INF) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}
