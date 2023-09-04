import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private final static int MOD = 1_000_000_003;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		

		int[][] dp = new int[N+1][K+1];
		for(int i = 2 ; i <= N ; i++) {
			dp[i][1] = i;
			for(int j = 2 ; j <= K ; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % MOD;
			}
		}
		System.out.println(dp[N][K]);
		
	}
}
