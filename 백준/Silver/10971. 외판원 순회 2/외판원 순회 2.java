import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static int N, result;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][];
		for(int i = 0 ; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		// solve
		result = Integer.MAX_VALUE;
		
		getRoute(0, 1, 0, new int[N]);
		
		System.out.println(result);
	}

	private static void getRoute(int cur, int cnt, int flag, int[] visited) {
		
		if(cnt == N) {
			// 마지막에서 0으로 갈 수 있는가.
			if(map[visited[cnt-1]][0] == 0) return;
			
			// 0 -> visited -> 0 비용 계산
			int sumCost = 0;
			for(int i = 1 ; i < visited.length; i++) {
				sumCost += map[visited[i-1]][visited[i]];
			}
			sumCost += map[visited[visited.length-1]][0];
			
			result = sumCost < result ? sumCost : result;
			return;
		}
		
		for(int i = 1 ; i < N ; i++) {
			if((flag & (1<<i)) > 0) continue;
			if(map[visited[cnt-1]][i] == 0) continue;
			
			visited[cnt] = i;
			getRoute(i, cnt+1, (flag | (1<<i)), visited);
		}
	}

	
}
