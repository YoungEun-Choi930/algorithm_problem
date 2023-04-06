import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int N, result;
	private static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //N(3 ≤ N ≤ 16)
		
		map = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		// =======================
		// solve
		
		map[0][0] = 2;
		map[0][1] = 2;
		
		result = 0;
		dfs(0,1,0);
		
		System.out.println(result);
	}

	private static void dfs(int x, int y, int pip) {
		
		if(x == N-1 && y == N-1) {
			result++;
			return;
		}
		
		if(pip == 0 || pip == 2) {
			//1. 오른쪽
			if(y+1 < N && map[x][y+1] == 0) {
				map[x][y+1] = 2;
				dfs(x,y+1,0);
				map[x][y+1] = 0;
			}
			
		}
		
		if(pip == 1 || pip == 2) {
			// 아래
			if(x+1 < N && map[x+1][y] == 0) {
				map[x+1][y] = 2;
				dfs(x+1,y,1);
				map[x+1][y] = 0;
			}
		}
		
		
		// 3. 우하
		if(x+1 < N && y+1 < N && map[x][y+1] == 0 && map[x+1][y] == 0 && map[x+1][y+1] == 0) {
			map[x][y+1] = 2;
			map[x+1][y] = 2;
			map[x+1][y+1] = 2;
			dfs(x+1,y+1,2);
			map[x][y+1] = 0;
			map[x+1][y] = 0;
			map[x+1][y+1] = 0;
		}
	}
}
