package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1010 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		dp();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			
			
			int result = bridgeCount[N][M];
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int[][] bridgeCount;
	private static void dp() {
		bridgeCount = new int[30][30];
		for(int m = 1; m < 30; m++) {
			bridgeCount[1][m] = m;
		}
		for(int n = 2 ; n < 30; n++) {
			for(int m = n ; m < 30; m++) {
				bridgeCount[n][m] = bridgeCount[n][m-1] + bridgeCount[n-1][m-1];
			}
		}
	}
	
	
}
