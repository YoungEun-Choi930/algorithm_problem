package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15651_S3_N과M3 {
	private static StringBuilder sb = new StringBuilder();
	private static int[] result;
	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		result = new int[M];
		
		//solve
		Permutation(0, 1);
		System.out.println(sb);
	}

	private static void Permutation(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start ; i <= N ; i++) {
			result[cnt] = i;
			Permutation(cnt+1, i);
		}
	}
}
