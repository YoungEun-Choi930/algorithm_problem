package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main15650_S3_N과M2 {
	
	private static int N, M;
	private static int[] resultarray;
	private static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws NumberFormatException, IOException {
		/**
		 * 1. 입력파일 읽기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/**
		 * 2. 입력파일 객체화
		 */
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		/**
		 * 3. 알고리즘 풀기
		 */
		resultarray = new int[M];
		combination(0,1);

		/**
		 * 4. 정답 출력
		 */
		System.out.println(sb);
	}

	private static void combination(int cnt, int start) {
		
		if(cnt == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(resultarray[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int idx = start; idx <= N ; idx++) {
			resultarray[cnt] = idx;
			combination(cnt+1, idx+1);
		}
	}
}
