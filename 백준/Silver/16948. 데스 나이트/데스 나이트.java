import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	private final static int[][] delta = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] in = br.readLine().split(" ");
		
		int r1 = Integer.parseInt(in[0]);
		int c1 = Integer.parseInt(in[1]);
		int r2 = Integer.parseInt(in[2]);
		int c2 = Integer.parseInt(in[3]);
		
		System.out.println(solve(N, r1,c1,r2,c2));
	}
	
	private static int solve(int N, int r1, int c1, int r2, int c2) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r1,c1});
		boolean[][] visited = new boolean[N][N];
		visited[r1][c1] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			cnt++;
			while(--size >= 0) {
				int[] cur = queue.poll();
				int r = cur[0];
				int c = cur[1];
				
				for(int d = 0 ; d < delta.length; d++) {
					int dr = r + delta[d][0];
					int dc = c + delta[d][1];
					
					if(dr >= 0 && dr < N && dc >= 0 && dc < N && !visited[dr][dc]) {
						if(dr == r2 && dc == c2) return cnt;	//도착
						queue.offer(new int[] {dr,dc});
						visited[dr][dc] = true;
					}
				}
				
			}
		}
		
		return -1;
	}
}
