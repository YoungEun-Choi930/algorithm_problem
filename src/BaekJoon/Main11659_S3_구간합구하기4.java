package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11659_S3_구간합구하기4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		
		// solve
		int[] arraysum = new int[N+1];
		for(int i = 0 ; i < N ; i++) {
			arraysum[i+1] = arraysum[i] + Integer.parseInt(input[i]);
		}
		
		for(int cntM = 0 ; cntM < M ; cntM ++) {
			input= br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			int result = arraysum[end] - arraysum[start-1];
			sb.append(result).append("\n");
		}

		// 출력
		System.out.println(sb);
	}
}
