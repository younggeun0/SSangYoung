package swTest;

import java.util.Scanner;

public class Ladder {
	
	static int N, M, H; // N ���μ�, M ���μ�, H���μ��� ���� �� �ִ� ��ġ�� ����
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
	
	static int solve(int pos, int cnt) { // 0���� �����ϴ� �ε���, �߰��ϴ� �������� ����
		if (cnt == 3 || pos >= N*H) {
			if (check()) {
				return cnt;
			}
			return INF;
		}
		
		int ret = INF;
		
		// position ���� �÷� ���� �������� ���� row���� ��, 
		// position ���� �÷� ���� ������ �� �������� column�� ��
		int row = pos / N, col = pos % N;
		
		if (col != N-1 && ladder[row][col] == 0 && ladder[row][col+1] == 0) { // ���μ��� �ְ�
			// ���� �� �÷��� ������ ��ǥ�� �׸� �� ����, ��ٸ��� �׸� �� ĭ�� ��� 0�϶��� �׸� �� �ִ�.
			ladder[row][col] = RIGHT;
			ladder[row][col+1] = LEFT;
			
			ret = Math.min(ret, solve(pos+2, cnt+1));// col+1�� LEFT�� �ٲ�� ������ ��ĭ �̵��Ѵ� 
			// �ּҰ��� ã�����ؼ� �ݺ��ؼ� �ּҰ��� ������
			ladder[row][col] = ladder[row][col+1] = 0;
		}
		ret = Math.min(ret, solve(pos+1, cnt)); // �ʳְ�
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
