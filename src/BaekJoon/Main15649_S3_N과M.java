package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main15649_S3_N과M {
	private static int N , M;
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		isChecked = new boolean[N];
		resultArray = new int[M];
		
		find(0);
		
		System.out.println(sb);
	}
	
	private static boolean[] isChecked;
	private static int[] resultArray;
	private static void find(int cnt) {
		
		if(cnt == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(resultArray[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < N ; i++) {
			if(isChecked[i]) continue;
			
			isChecked[i] = true;
			resultArray[cnt] = i+1;
			find(cnt+1);
			
			isChecked[i] = false;
		}
	}
}
