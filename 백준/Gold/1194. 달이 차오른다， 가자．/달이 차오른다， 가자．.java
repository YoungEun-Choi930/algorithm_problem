import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

	private static int N, M;
	private static char[][] map;
	private static final int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	private static class Point {
		int x, y;
		int key;
		public Point(int x, int y, int key) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
		}
		
	}


	public static void main(String[] args) throws IOException {
		input();
		
		// solve
		// 1. 출발지 구하기
		Point start = getStartPoint();

		// 2. 탈출시작
		int result = start(start);
		System.out.println(result);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

	}

	private static Point getStartPoint() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					return new Point(i,j,0);
				}
			}
		}
		return null;
	}
	
	private static int start(Point start) {

		boolean[][][] visited = new boolean[N][M][64];

		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		map[start.x][start.y] = '.';
		visited[start.x][start.y][0] = true;

		int time = 0;
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			while (--size >= 0) {
				Point cur = queue.poll();
				
				if(map[cur.x][cur.y] == '1') return time;

				for (int d = 0; d < 4; d++) {
					int dx = cur.x + delta[d][0];
					int dy = cur.y + delta[d][1];

					if (dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
					if (map[dx][dy] == '#' || visited[dx][dy][cur.key]) continue;
					
					// 이동 
					if (map[dx][dy] == '.' || map[dx][dy] == '1') {
						visited[dx][dy][cur.key] = true;
						queue.offer(new Point(dx,dy,cur.key));
						
					} else if (map[dx][dy] >= 'a') {	// 열쇠
						int newkey = cur.key | (1 << (map[dx][dy] - 'a'));

						if(!visited[dx][dy][newkey]) {
							visited[dx][dy][cur.key] = true;
							visited[dx][dy][newkey] = true;
						}

						queue.offer(new Point(dx,dy,newkey));
						
					} else if (map[dx][dy] <= 'F') {	// 문
						int door = 1 << (map[dx][dy] - 'A');
						
						if((cur.key & door) > 0) {	// 열쇠가 있으면
							visited[dx][dy][cur.key] = true;
							queue.offer(new Point(dx,dy,cur.key));
						}
					}
				}
			}

			time++;
		}

		return -1;
	}

}
