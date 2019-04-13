package swTest;

import java.util.Scanner;

public class Cp1 {
	
	static int N,L,R;
	static int map[][] = new int[50][50]; // �α����� ��� ��
	static int visited[][] = new int[50][50]; // �湮 �÷��׿� ��
	static int cnt; // ��ĥ ���� �� 
	
	static void move(int r, int c, int value) {
		// ���� ����� return
		if (r < 0 || r> N-1 || c < 0 || c > N-1) return;
		// �湮���� �ʾ����� return
		if (visited[r][c] != 1) return;
		
		// �α��̵��� ���� ���� 2�� ����
		visited[r][c] = 2;
		
		// �ش� ������ �α��� ����
		map[r][c] = value;
		
		// ��������� �����¿� �α��� ����
		move(r+1, c, value);
		move(r-1, c, value);
		move(r, c-1, value);
		move(r, c+1, value);
	}
	
	static int find(int r, int c, int value) {
		// map ���� ������ ������ return
		if (r < 0 || r > N-1 || c < 0 || c > N-1) return 0;
		// �湮 �ߴٸ� return
		if (visited[r][c] != 0) return 0;
		// ù ������ �ƴ϶�� �ֺ� �α��� ���̸� ���� ���� ����
		if (value != -1) {
			int diff = Math.abs(value-map[r][c]);
			
			// ���̰� L���� �۰� R���� ũ�� return
			if (diff < L || diff > R) return 0;
		}
		
		//�� ������ ���������� �� �湮ó��, ��ĥ ������ ++
		visited[r][c] = 1;
		cnt++;
		
		//����� ���� �α��� ���� ����
		int sum = map[r][c];
		// �����¿� ��������� sum���� ����
		sum += find(r+1, c, map[r][c]);
		sum += find(r-1, c, map[r][c]);
		sum += find(r, c-1, map[r][c]);
		sum += find(r, c+1, map[r][c]);
		
		return sum;
	}
	
	static int solve() {
		int ret = 0;// �α��̵� �� ī��Ʈ����
		
		boolean flag; // �α� �̵��� �߻��ϴ��� üũ�ϴ� �÷���
		
		do {
			flag = false; // ó���� �̵� ����
			
			// �α��̵� �� �ٽ� �α��̵��� �� �� �����Ƿ� �ʱ�ȭ
			for(int i=0; i<N; i++) {
				for(int j=0; j<N;j ++) {
					visited[i][j] = 0;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (visited[i][j] == 0) {
						// �湮�� ���ߴٸ�
						// ��ĥ ���ձ����� ���� ī��Ʈ�� ���� ����
						cnt = 0;
						
						// -1�� ù �������� �ǹ�, ��������� �ֺ� ���� Ž��
						int sum = find(i, j, -1);
						
						// �ֺ����� Ž���ϸ� ��ĥ �ֺ����� cnt�ǰ�
						// �Ѱ� �̻��̸� ���ձ����� �α��� �̵��� �Ͼ
						if (cnt > 1) {
							flag = true; // �α� �̵��� �߻��ؼ� true
							// �α��� �̵� ��Ŵ
							move(i, j, sum/cnt);
						} else {
							// ���� ��ĥ �ֺ����� ���ٸ� 2�� �� ������ ����
							visited[i][j] = 2;
						}
					}
				}
			}
			
			if(flag) ++ret;
		} while(flag);
		
		return ret;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// ������(N), L�ּ����̰�, R�ִ����̰� �Է¹ް�
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// �ϴ� �ʿ� �α��� �ʱ�ȭ
				map[i][j] = sc.nextInt();
			}
		}
		
		// ����� ���
		System.out.println(solve());
	}
}
