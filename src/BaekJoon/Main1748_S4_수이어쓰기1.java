package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1748_S4_수이어쓰기1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		int c = 1;
		for (int t = 9; t <= N; t *= 10) { // c : 한자리수 두자리수 ...

			N -= t;
			result += t * c++;

		}
		result += c * N;

		System.out.println(result);
	}
}
