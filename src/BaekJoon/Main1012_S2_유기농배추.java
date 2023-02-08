package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1012_S2_유기농배추 {
	private static boolean[][] map;
	private static int M, N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]);
			N = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);
			
			map = new boolean[M][N];
			
			for(int i = 0 ; i < K ; i++) {
				input = br.readLine().split(" ");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				
				map[x][y] = true;
				
			}
			
			int count = 0;
			for(int i = 0 ; i < M ; i++) {
				for(int j = 0; j < N ; j++) {
					if(map[i][j]) {
						count++;
						map[i][j] = false;
						visit(i, j);
						
					}
				}
			}
			sb.append(count).append("\n");
				
		}
		System.out.println(sb);
	}
	
	private static int[][] delta = {{-1,0},{0,1}, {1,0}, {0,-1}};
	private static void visit(int x, int y) {
		
		for(int i = 0 ; i < delta.length ; i++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];
			
			if(dx < 0 || dy < 0 || dx >= M || dy >= N) continue;
			
			if(map[dx][dy]) {
				map[dx][dy] = false;
				visit(dx, dy);
			}
		}
	}
}
