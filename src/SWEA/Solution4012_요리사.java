package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution4012_요리사 {
	private static int N, R;
	private static int[][] map;
	private static boolean[] selected;
	private static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
			}
			
			// solve
			R = N/2;
			result = Integer.MAX_VALUE;
			selected = new boolean[N];
			
			combination(0,0);
			
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}
	
	private static void combination(int cnt, int idx) {
		
		if(cnt == R) {
			int[] arrayA = new int[R];
			int[] arrayB = new int[R];
			int ia = 0;
			int ib = 0;
			for(int i = 0 ; i < N ; i++) {
				if(selected[i]) arrayA[ia++] = i;
				else arrayB[ib++] = i;
			}
			
			ia = 0;
			ib = 0;
			for(int i = 0 ; i < R-1 ; i++) {
				for(int j = i ; j < R ; j++) {
					ia += map[arrayA[i]][arrayA[j]] + map[arrayA[j]][arrayA[i]];
					ib += map[arrayB[i]][arrayB[j]] + map[arrayB[j]][arrayB[i]];
				}
			}
			
			int abs = Math.abs(ia-ib);
			if(result > abs) result = abs;
			return;
		}
		
		
		for(int i = idx; i < N ; i++) {
			selected[i] = true;
			combination(cnt+1, i+1);
			selected[i] = false;
		}
		
	}
}
