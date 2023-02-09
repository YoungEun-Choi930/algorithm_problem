package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2798_B2_블랙잭 {
	private static int N, M, result;
	private static int[] cards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		cards = Arrays.stream(input).mapToInt(s->Integer.parseInt(s)).toArray();
		
		// solve
		result = 0;
		blackjack(0,0,0);

		// 출력
		System.out.println(result);
	}

	private static void blackjack(int cnt, int sum, int start) {
		if(cnt == 3) {
			if(sum <= M)
				result = Math.max(result, sum);
			return;
		}
		
		for(int i = start ; i < N ; i++) {
			blackjack(cnt+1, sum+cards[i], i+1);
		}
		
	}
}
