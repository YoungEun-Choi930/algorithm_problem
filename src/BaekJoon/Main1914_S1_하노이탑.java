package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main1914_S1_하노이탑 {
	private static StringBuilder sb = new StringBuilder();
	private static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/**
		 * 1. 입력파일 읽기
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		/**
		 * 2. 입력파일 객체화
		 */
		int N = Integer.parseInt(br.readLine());

		/**
		 * 3. 알고리즘 풀기
		 */
		if(N <= 20) {

			count = 0;
			hanoi(N,1,2,3);

			System.out.println(count);

			System.out.println(sb);
		}
		else {
			BigInteger count = new BigInteger("2");
	        System.out.println(count.pow(N).subtract(new BigInteger("1")));
		}
	}
	
	private static void hanoi(int cnt, int from, int middle, int to) {
		
		if(cnt == 1) {
			sb.append(from).append(" ").append(to).append("\n");
			count++;
			return;
		}
		
		
		hanoi(cnt-1, from, to, middle);
		sb.append(from).append(" ").append(to).append("\n");
		count++;
		hanoi(cnt-1, middle, from, to);
	}
}
