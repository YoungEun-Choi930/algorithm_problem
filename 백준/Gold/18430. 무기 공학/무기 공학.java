import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int[][] strong;
	private static boolean[][] visited;
	private static int N, M, result;
	private static int[][][] dir = {
			{ {0,-1},{1,0} }, { {-1,0},{0,-1} },
			{ {-1,0},{0,1} }, { {0,1},{1,0} }
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		N = Integer.parseInt(in[0]);
		M = Integer.parseInt(in[1]);
		
		strong = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			in = br.readLine().split(" ");
			for(int j = 0 ; j < M ; j++) {
				strong[i][j] = Integer.parseInt(in[j]);
			}
		}
		
		// solve
		visited = new boolean[N][M];
		result = 0;
		dfs(0, 0);
		
		System.out.println(result);
	}

	private static void dfs(int index, int sum) {
		if(sum > result) result = sum;
		if(index == N*M) return;

		int i = index / M;
		int j = index % M;

		if(!visited[i][j]) {
			for(int d = 0 ; d < 4 ;d++) {
				
				int dx1 = i + dir[d][0][0];
				int dy1 = j + dir[d][0][1];
				int dx2 = i + dir[d][1][0];
				int dy2 = j + dir[d][1][1];
				
				if(dx1<0 | dx1>=N | dy1<0 | dy1>=M | dx2<0 | dx2>=N | dy2<0 | dy2 >=M) continue;
				if(visited[dx1][dy1] | visited[dx2][dy2]) continue;
				
				visited[i][j] = true;
				visited[dx1][dy1] = true;
				visited[dx2][dy2] = true;
				
				int s = strong[i][j]*2 + strong[dx1][dy1] + strong[dx2][dy2];
				dfs(index+1, sum+s);

				visited[i][j] = false;
				visited[dx1][dy1] = false;
				visited[dx2][dy2] = false;
			}
		}
		dfs(index+1, sum);
		
	}

}
