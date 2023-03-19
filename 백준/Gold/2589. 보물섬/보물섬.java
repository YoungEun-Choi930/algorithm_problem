import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	private static int M,N,result;
	private static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		
		map = new char[M][];
		for(int i = 0 ; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// solve
		result = 0;
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] == 'L') {
					//System.out.println("===============");
					startVisite(i, j);
				}
			}
		}
		
		System.out.println(result);
	}
	
	private final static int[][] delta = {{-1,0},{1,0},{0,1},{0,-1}};
	private static void startVisite(int startx, int starty) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[M][N];
		
		queue.offer(new int[] {startx, starty});
		visited[startx][starty] = true;
		int timer = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			//System.out.println(timer+"-----------"+size);
		
			if(timer > result) result = timer;
			timer++;
			while(size-- > 0) {
				int[] cur = queue.poll();
				//System.out.println(cur[0]+", "+cur[1]);
				
				for(int i = 0 ; i < delta.length; i++) {
					int dx = cur[0] + delta[i][0];
					int dy = cur[1] + delta[i][1];
					
					if(dx >= 0 && dx < M && dy >= 0 && dy < N && map[dx][dy] == 'L' && !visited[dx][dy]) {
						queue.offer(new int[] {dx,dy});
						visited[dx][dy] = true;
					}
				}
			}
		}
	}
}
