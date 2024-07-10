import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	
	private final static int NOTVISIT = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		// 입력
		int F = Integer.parseInt(input[0]);
		int S = Integer.parseInt(input[1]);
		int G = Integer.parseInt(input[2]);
		int[] upDown = new int[2];
		upDown[0] = Integer.parseInt(input[3]);
		upDown[1] = Integer.parseInt(input[4]) * (-1);
		
		// 초기화
		int[] visited = new int[F+1];
		Arrays.fill(visited, NOTVISIT);
		visited[S] = 0;
		
		// BFS
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {S,0}); // 위치, 횟수
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(visited[cur[0]] < cur[1]) continue;
			
			for(int ud : upDown) {
				int next = cur[0] + ud;
				if(next > 0 && next <= F && visited[next] > cur[1]+1) {
					visited[next] = cur[1] + 1;
					queue.add(new int[] {next, cur[1]+1});
				}
			}
		}
		
		// result
		if(visited[G] == NOTVISIT) System.out.println("use the stairs");
		else System.out.println(visited[G]);
		
	}
}
