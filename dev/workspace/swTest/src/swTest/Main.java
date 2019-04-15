package swTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	class Point {
		int x,y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	class CntVO {
		int count, sum;
	}
	
	static int n, l, r;
	static int map[][] = new int[50][50];
	
	void createArea(int sy, int sx, int status[][], int index, CntVO vo) {
		int visited[][] = new int[50][50];
		
		final int dy[] = { 0, 0, -1, +1 };
		final int dx[] = { -1, +1, 0, 0 };
		
		Queue<Point> q = new LinkedList<>();
		
		Point head = new Point(sy, sx);
		
		visited[sy][sx] = 1;
		q.add(head);
		
		while(!q.isEmpty()) {
			Point curr = q.remove();
			
			status[curr.y][curr.x]= index;
			++vo.count;
			System.out.println(vo.count);
			vo.sum += map[curr.y][curr.x];
			
			for(int dir=0; dir<4; ++dir) {
				Point next = new Point(curr.y+dy[dir], curr.x+dx[dir]);
				
				if (next.y < 0 || next.y >= n || next.x < 0 || next.x >= n) {
					continue;
				}
				
				int delta = Math.abs(map[curr.y][curr.x]- map[next.y][next.x]);
				if (visited[next.y][next.x]== 0 && l <= delta && delta <= r) {
					visited[next.y][next.x] = 1;
					q.add(next);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		CntVO vo = m.new CntVO(); 
		
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		
		for(int y=0; y<n; y++) {
			for(int x=0; x<n; x++) {
				map[y][x] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		boolean isUpdate = true;
		while(isUpdate) {
			
			isUpdate = false;
			int status[][] = new int[50][50];
			int areaIndex = 0;
			int count[]  = new int[2501];
			int sum[] = new int[2501];
			
			for(int y=0; y<n; y++) {
				for(int x=0; x<n; x++) {
					if (status[y][x] == 0) {
						++areaIndex;
						m.createArea(y, x, status, areaIndex, vo);
					}
				}
			}
			
			
			for(int y=0; y<n; y++) {
				for(int x=0; x<n; x++) {
					int index = status[y][x];
					System.out.println(index+" "+count[index]+" "+sum[index]);
					/*int avg = sum[index] / count[index];
					if (map[y][x] != avg) {
						map[y][x] = avg;
						isUpdate = true;
					}*/
				}
			}
			
			if(isUpdate) {
				++cnt;
			}
		}
		
		System.out.println(cnt);
	}
	
}
