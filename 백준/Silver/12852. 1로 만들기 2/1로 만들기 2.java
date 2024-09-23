import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		// solve
		// 0 : 이전 index
		// 1 : depth
		int[][] dp = new int[num+1][2];
		dp[0][1] = -1;
		
		for(int i = 1 ; i <= num ; i++) {
			// -1
			if(dp[i][0] == 0 || dp[i-1][1]+1 < dp[i][1]) {
				dp[i][0] = i-1;
				dp[i][1] = dp[i-1][1] + 1;
			}
			
			int n = i;
			int s = 1;
			
			// x2, x3
			while(++s <= 3) {
				n += i;
				// 방문하지 않았거나, 더 작은 횟수로 갈 수 있다면
				if(n <= num && (dp[n][0] == 0 ||dp[n][1] > dp[i][1]+1)) {
					dp[n][0] = i;
					dp[n][1] = dp[i][1]+1;
				}
			}
		}
		
		// print
		StringBuilder sb = new StringBuilder();
		sb.append(dp[num][1]+"\n");
		
		int next = num;
		while(next != 0) {
			sb.append(next+" ");
			next = dp[next][0];
		}
		
		System.out.println(sb);
	}
}
