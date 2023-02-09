package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2023_G5_신기한소수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		int N = Integer.parseInt(br.readLine());	// N(1 ≤ N ≤ 8)

		// solve
		/*
		 * boolean배열로 소수인지 아닌지 체크하자.
		 */
		int end = 1;
		for(int i = 0; i < N; i++) 
			end *= 10;
		int start = end / 10;
		
		boolean[] arr = new boolean[100_000_000];
		for(int i = 2; i < end; i++) {
		}
		

		// 출력
		System.out.println(sb);
	}
}
