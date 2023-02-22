package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11057_S1_오르막수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		int N = Integer.parseInt(br.readLine());

		// solve
		int[] curNumCnt = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		int[] nextNumCnt = null;
		for(int n = 1 ; n < N ; n++) {
			
			nextNumCnt = new int[10];
			// 0부터 9까지 앞자리 숫자.
			int cnt = 0;
			for(int i = 0 ; i < 10; i++) {
				cnt += curNumCnt[i]; // 앞자리가 n인 경우가 몇개 인지.
				nextNumCnt[i] += cnt;
				nextNumCnt[i] %= 10_007;
			}
			curNumCnt = Arrays.copyOf(nextNumCnt, 10);
		}
		
		int ans = 0;
		for(int n : curNumCnt) {
			//System.out.print(n+" ");
			ans += n;
			ans %= 10_007;
		}
		//System.out.println();

		// 출력
		System.out.println(ans);
	}
}
