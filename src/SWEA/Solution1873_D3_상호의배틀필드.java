package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1873_D3_상호의배틀필드 {

	private static final char[] rotation = {'<','>','^','v'};
	private static final int[][] delta = {{0,-1},{0,1},{-1,0},{1,0}};
	private static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// input
			String[] input = br.readLine().split(" ");
			int H = Integer.parseInt(input[0]);
			int W = Integer.parseInt(input[1]);
			
			map = new char[H][W];
			for(int i = 0 ; i < H ; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int N = Integer.parseInt(br.readLine());
			char[] command = br.readLine().toCharArray();
			// ==========================================
			// solve
			
			int curx = -1, cury = -1;
			// 1. 전차 찾기
			for(int i = 0 ; i < H ; i++) {
				for(int j = 0 ; j < W ; j++) {
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						curx = i;
						cury = j;
						
						
						break;
					}
						
				}
			}
			
			
			
			
			
			
		}
		System.out.println(sb);
	}
}
