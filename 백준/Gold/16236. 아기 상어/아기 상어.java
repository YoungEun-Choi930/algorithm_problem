import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	private static class Point implements Comparable<Point>{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			int c = Integer.compare(this.x, o.x);
			if(c == 0) {
				c = Integer.compare(this.y, o.y);
			}
			return c;
		}

	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 1.	input
		int[][] map = new int[N][N];
		int curx = -1, cury = -1;
		int fishcnt = 0;
		
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				
				// 2.	아기상어의 현재 위치 구하기
				if(map[i][j] == 9) {
					curx = i;
					cury = j;
					map[i][j] = 0;
				}
				else if(map[i][j] != 0) fishcnt++;
			}
		}
		// ====================================

		int sec = 0;
		int count = 0;
		int sharksize = 2;
		final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};


		// 3.	아기상어 출발
		boolean flag = true;
		while(flag) {
			Queue<Point> visit = new ArrayDeque<>();
			visit.offer(new Point(curx,cury));
			
			boolean[][] visited = new boolean[N][N];
			visited[curx][cury] = true;
			
			PriorityQueue<Point> find = new PriorityQueue<>();
			
			int distance = 0;
			while(!visit.isEmpty() && find.isEmpty()) {
				// 거리가 같은 물고기들
				int size = visit.size();
				distance++;
				for(int i = 0 ; i < size ; i++) {
					Point cur = visit.poll();
					for(int d = 0 ; d < 4; d++) {
						int dx = cur.x + delta[d][0];
						int dy = cur.y + delta[d][1];
						if(dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dx][dy]) {

							visited[dx][dy] = true;
							if(map[dx][dy] == 0 || map[dx][dy] == sharksize) {
								visit.offer(new Point(dx,dy));
							}
							else if(map[dx][dy] < sharksize) {
								find.offer(new Point(dx,dy));
							}
						}
					}// 방향
				}// size
			}
			
			if(find.isEmpty()) break;
			
			Point getfish = find.poll();
			map[getfish.x][getfish.y] = 0;
			curx = getfish.x;
			cury = getfish.y;
			
			sec += distance;
			

			if(--fishcnt == 0) break;
			
			if(++count == sharksize) {
				sharksize++;
				count = 0;
			}
			
		}

		System.out.println(sec);
	}
}
