import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] dp = new boolean[N<5 ? 5 : N+1];
		dp[1] = true;
		dp[3] = true;
		dp[4] = true;
		
		for(int i = 5 ; i <= N ; i++) {
			if(!dp[i-4] || !dp[i-3] || !dp[i-1]) {
				//false가 하나라도 있으면
				dp[i] = true;
			}
		}
		
		System.out.println(dp[N]? "SK" : "CY");
	}

}
