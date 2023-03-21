import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

	private static class Link {
		int x,y;
		Link link;
		public Link(int x, int y, Link link) {
			super();
			this.x = x;
			this.y = y;
			this.link = link;
		}
	}
	
	private static int[][] map, visited;
	private static int N, L, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		int N2 = N * N;
		L = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);

		map = new int[N][];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// solve
		int time = 0;
		while (true) {

			visited = new int[N][N];

			// 1. 국경선 열기
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(visited[i][j] == 0) {
						findCountry(i,j,cnt);
						cnt++;
					}

				}
			}
			
			// 모두 각각이니까 인구이동이 발생하지 않는다.
			if(cnt-1 == N2) break;
			
			// 2. 연합 통합
			Link[] countries = new Link[cnt+1];
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N ; j++) {
					countries[visited[i][j]] = new Link(i,j,countries[visited[i][j]]);
				}
			}
			
			// sum, 평균
			for(int c = 1 ; c <= cnt; c++) {
				int sum = 0;
				int div = 0;
				for(Link node = countries[c] ; node != null; node = node.link) {
					sum += map[node.x][node.y];
					div++;
				}
				if(div == 0) continue;
				int avg = sum/div;
				for(Link node = countries[c] ; node != null; node = node.link) {
					map[node.x][node.y] = avg;
				}
			}

			time++;
		}

		System.out.println(time);
	}
	
	private static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	private static void findCountry(int x, int y, int n) {
		visited[x][y] = n;
		
		for(int i = 0 ; i < 4 ; i ++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];
			
			if(dx < 0 || dx >= N || dy < 0 || dy >= N || visited[dx][dy] == n) continue;
			int dif = Math.abs(map[x][y] - map[dx][dy]);
			if(dif >= L && dif <= R) {
				findCountry(dx, dy, n);
			}
		}
	}
}
