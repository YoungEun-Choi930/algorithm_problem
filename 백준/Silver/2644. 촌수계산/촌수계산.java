import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		int M = Integer.parseInt(br.readLine());
		
		boolean[][] peoplemap = new boolean[N+1][N+1];
		for(int i = 0 ; i < M ; i++) {
			input = br.readLine().split(" ");
			
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			
			peoplemap[x][y] = true;
			peoplemap[y][x] = true;
		}
		
		// =========================================
		//solve
		boolean flag = false;
		int result = 0;
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(A);
		visited[A] = true;
		
		loop : while(!queue.isEmpty()) {
			int size = queue.size();
			result++;
			for(int i = 0 ; i < size ; i++) {
				int n = queue.poll();
				
				for(int idx = 1; idx <= N; idx++) {
					if(peoplemap[n][idx] && !visited[idx]) {
						if(idx == B) {
							flag = true;
							break loop;
						}
						
						visited[idx] = true;
						queue.offer(idx);
					}
				}
			}
		}
		
		if(!flag) result = -1;
		System.out.println(result);
	}
}
