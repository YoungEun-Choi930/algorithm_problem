package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2961_S2_도영이가만든맛있는음식 {

	private static int[][] list;
	private static int ans = Integer.MAX_VALUE;
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		N = Integer.parseInt(br.readLine());
		list = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			String[] input = br.readLine().split(" ");
			list[i][0] = Integer.parseInt(input[0]);
			list[i][1] = Integer.parseInt(input[1]);
		}

		// solve
		merge(0,1,0);

		// 출력
		System.out.println(ans);
	}
	
	private static void merge(int idx, int sour, int sweet) {
		if(idx == N) {
			if(sour != 0 && sweet != 0) {
				int value = Math.abs(sour-sweet);
				ans = Math.min(ans, value);
			}
			return;
		}
		
		// 재료 넣기
		merge(idx+1, sour * list[idx][0], sweet + list[idx][1]);
		
		// 재료 안넣기
		merge(idx+1, sour, sweet);
	}
}
