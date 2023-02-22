package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11052_S1_카드구매하기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		int[] price = new int[N+1];	// 입력받은 가격
		for(int i = 0 ; i < N ; i++) {
			price[i+1] = Integer.parseInt(input[i]);
		}
		
		
		// solve
		/*
		 * 한 장당 가격이 높은 순으로 그리디하게 접근했다.
		 * (10 / 1 100 160 1 1 1 1 1 1 1) 반례를 통해 아니라는것을 알았다.
		 */
		
		int[] dp = new int[N+1];
		dp[1] = price[1];
		
		for(int i = 2; i <= N; i++) {
			int max = price[i];
			
			for(int j = 1 ; j <= i/2 ; j++) {
				int count = dp[j] + dp[i-j];
				if(max < count) max = count;
			}
			
			dp[i] = max;
		}
		
		System.out.println(dp[N]);
	}
}
