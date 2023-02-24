package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10844_S1_쉬운계단수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		int N = Integer.parseInt(br.readLine()); // 1<= N <= 100

		// solve
		int[] numberOfCases = { 1, 2, 2, 2, 2, 2, 2, 2, 1 };
		int[] curCount = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		// 1. 첫번째자리는 0으로 시작할 수 없다. 경우의 수 1~9.
		int cases = 9;
		// 2. N자리 수만큼 경우의 수를 구한다.
		for(int i = 2 ; i <= N ;i++) {
			// 앞의 자리에따라 -1 또는 +1 숫자가 올 수 있다. 0, 9 는 하나만.
			int[] nextCount = new int[10];
			for(int j = 0 ; j < 10 ; j++) {
				if(j-1>0) nextCount[j-1] += curCount[j];
				if(j+1 < 10) nextCount[j+1] += curCount[j];
			} 
			cases = cases*2 -1;
			cases %= 1_000_000_000;
		}
		

		// 출력
		System.out.println(sb);
	}
}
