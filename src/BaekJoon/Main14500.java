package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14500 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);		//(4 ≤ N, M ≤ 500)
		int M = Integer.parseInt(input[1]);
		
		int[][] map = new int[N+1][M+1];
		int[][] rowsum = new int[N+1][M+1];	//가로로 더하기
		int[][] colsum = new int[N+1][M+1]; // 세로로 더하기
		for(int i = 1 ; i < N ; i++ ) {
			input = br.readLine().split(" ");
			for(int j = 1 ; j <= M ; j++) {
				int n = Integer.parseInt(input[j-1]);
				map[i][j] = n;
				rowsum[i][j] = rowsum[i][j-1] + n;
				colsum[i][j] = colsum[i-1][j] + n;
			}
		}

		// solve
		int ans = 0;
		
		for(int i = 1; i <= N ; i++) {	//가로
			for(int j = 1 ; j <= M ; j++) {
				
				// 1. ㅁㅁㅁㅁ 가로 세로
				if(j > 3) {
					ans = Math.max(ans, rowsum[i][j] - rowsum[i][j-4]);
				}
				if(i > 3) {
					ans = Math.max(ans, colsum[i][j] - colsum[i-4][j]);
				}
				
				// 2. 네모
				// ㅁㅁ
				// ㅁㅁ
				if(i > 1 && j > 1) {
					int n = rowsum[i][j] - rowsum[i][j-2] + rowsum[i-1][j] - rowsum[i-1][j-2];
					ans = Math.max(ans, n);
				}
				
				// 3. 가로
				// ㅁㅁㅁ		ㅁㅁㅁ
				//	 ㅁ		ㅁ
				if(j > 2 ) {
					int n = rowsum[i][j] - rowsum[i][j-3];
					
					if(i > 1) ans = Math.max(ans, n+map[i-1][j-1]);	//위
					if(i < N) ans = Math.max(ans, n+map[i+1][j-1]);	//아래
					
					if(i > 1) ans = Math.max(ans, n+map[i-1][j]);	//위
					if(i < N) ans = Math.max(ans, n+map[i+1][j-2]);	//아래
					
				}
				// ㅁ	ㅁ
				// ㅁㅁ	ㅁ
				// ㅁ	ㅁㅁ
				if(i > 2) {
					int n = colsum[i][j] - colsum[i-3][j];
					
					if(j > 1) ans = Math.max(ans, n+map[i-1][j-1]);	//좌
					if(j < N) ans = Math.max(ans, n+map[i-1][j+1]);	//우
					
					if(j > 1) ans = Math.max(ans, n+map[i-2][j-1]);	//좌
					if(j < N) ans = Math.max(ans, n+map[i][j+1]);	//우
				}
				
				
				// 4.
				// ㅁ		   ㅁㅁ
				// ㅁㅁ		ㅁㅁ
				//  ㅁ
				if(i > 2 && j > 1) {
					int n = colsum[i-1][j-1] - colsum[i-3][j-1] + colsum[i][j] - colsum[i-2][j];
					ans = Math.max(ans, n);
				}
				
				if(i > 1 && j > 2) {
					int n = map[i][j-1] + map[i][j-2] + map[i-1][j] + map[i-1][j-1];
					ans = Math.max(ans, n);
				}
			}
		}
		

		// 출력
		System.out.println(ans);
	}
}
