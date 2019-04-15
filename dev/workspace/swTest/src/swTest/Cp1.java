package swTest;

import java.util.Scanner;

public class Cp1 {
	
	static int N,L,R;
	static int map[][] = new int[50][50]; // 인구수를 담는 맵
	static int visited[][] = new int[50][50]; // 방문 플래그용 맵
	static int cnt; // 합칠 국가 수 
	
	static void move(int r, int c, int value) {
		// 맵을 벗어나면 return
		if (r < 0 || r> N-1 || c < 0 || c > N-1) return;
		// 방문하지 않았으면 return
		if (visited[r][c] != 1) return;
		
		// 인구이동을 끝낸 곳은 2로 설정
		visited[r][c] = 2;
		
		// 해당 국가에 인구수 변경
		map[r][c] = value;
		
		// 재귀적으로 상하좌우 인구수 변경
		move(r+1, c, value);
		move(r-1, c, value);
		move(r, c-1, value);
		move(r, c+1, value);
	}
	
	static int find(int r, int c, int value) {
		// map 범위 밖으로 나가면 return
		if (r < 0 || r > N-1 || c < 0 || c > N-1) return 0;
		// 방문 했다면 return
		if (visited[r][c] != 0) return 0;
		// 첫 시작이 아니라면 주변 인구수 차이를 위해 차를 구함
		if (value != -1) {
			int diff = Math.abs(value-map[r][c]);
			
			// 차이가 L보다 작고 R보다 크면 return
			if (diff < L || diff > R) return 0;
		}
		
		//위 검증을 충족시켰을 때 방문처리, 합칠 국가수 ++
		visited[r][c] = 1;
		cnt++;
		
		//평균을 구할 인구수 합을 구함
		int sum = map[r][c];
		// 상하좌우 재귀적으로 sum값을 구함
		sum += find(r+1, c, map[r][c]);
		sum += find(r-1, c, map[r][c]);
		sum += find(r, c-1, map[r][c]);
		sum += find(r, c+1, map[r][c]);
		
		return sum;
	}
	
	static int solve() {
		int ret = 0;// 인구이동 수 카운트변수
		
		boolean flag; // 인구 이동이 발생하는지 체크하는 플래그
		
		do {
			flag = false; // 처음엔 이동 안함
			
			// 인구이동 후 다시 인구이동을 할 수 있으므로 초기화
			for(int i=0; i<N; i++) {
				for(int j=0; j<N;j ++) {
					visited[i][j] = 0;
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (visited[i][j] == 0) {
						// 방문을 안했다면
						// 합칠 연합국가의 수를 카운트할 변수 선언
						cnt = 0;
						
						// -1은 첫 시작임을 의미, 재귀적으로 주변 국가 탐색
						int sum = find(i, j, -1);
						
						// 주변국가 탐색하면 합칠 주변국이 cnt되고
						// 한개 이상이면 연합국가로 인구수 이동이 일어남
						if (cnt > 1) {
							flag = true; // 인구 이동이 발생해서 true
							// 인구를 이동 시킴
							move(i, j, sum/cnt);
						} else {
							// 만약 합칠 주변국이 없다면 2로 한 국가로 설정
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
		
		// 사이즈(N), L최소차이값, R최대차이값 입력받고
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 일단 맵에 인구수 초기화
				map[i][j] = sc.nextInt();
			}
		}
		
		// 결과를 출력
		System.out.println(solve());
	}
}
