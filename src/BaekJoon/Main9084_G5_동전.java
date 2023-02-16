package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9084_G5_동전 {
	private static int N, M, count;
	private static int[] coins;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
StringTokenizer
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			//입력
			N = Integer.parseInt(br.readLine());
			coins = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
			M = Integer.parseInt(br.readLine());
			count = 0;
			
			//solve
			/*
			 * 그냥 조합으로 푸니까 시간초과가 났다.
			 * dp인가?
			 */
			//Combination(0, 0);
			
			//dp
			for(int i = 0 ; i < N ; i++) {
				
			}
			
			
			//출력
			sb.append(count).append("\n");
			
		}
		System.out.println(sb);
	}

	/*
	private static void Combination(int sum, int start) {
		if(sum >= M || start >= N) {
			if(sum == M) count++;
			return;
		}
		
		for(int i = start ; i < N ; i++) {
			Combination(sum + coins[i], i);
		}
	}
	*/
}
