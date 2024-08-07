import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] space = new int[N+1][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] history = new int[N][M][3];
		int[] direction = {-1, 0, 1};
		int[] reverse = {1, 0 ,-1};
		int max = 9999999;
		int N1 = N-1;
		
		// 1. 초기값 세팅
		for(int j = 0 ; j < M ; j++) {
			for(int d = 0 ; d < 3 ; d++) {
				history[0][j][d] = space[0][j];
			}
		}
		for(int i = 1 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				for(int d = 0 ; d < 3 ; d++) {
					history[i][j][d] = max;
				}
			}
		}
		
		// 2.dp
		int cur, ny, s;
		for(int i = 0 ; i < N1 ; i++) {
			for(int j = 0 ; j < M ; j++) {
				for(int d = 0 ; d < 3 ; d++) {
					ny = j + direction[d];
					if(ny >= 0 && ny < M) {
						
						cur = max;
						for(int pd = 0 ; pd < 3 ; pd++) {
							if(d != pd) {
								cur = Math.min(cur, history[i][j][pd]);
							}
						}
						
						history[i+1][ny][d] = cur+space[i+1][ny];
					}
				}
			}
		}

		// 3. 최소값
		int min = Integer.MAX_VALUE;
		for(int j = 0 ; j < M ; j++) {
			for(int d = 0 ; d < 3 ; d++) {
				min = Math.min(min, history[N1][j][d]);
			}
		}
		System.out.println(min);
	}
}
