package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3109_G2_빵집 {
	
	private static int R, C, result;
	private static char[][] map;
	private static final int[][] delta = {{-1,1}, {0,1}, {1,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		// input
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		map = new char[R][C];
		for(int i = 0 ; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// solve
		for(int i = 0 ; i < R ; i++) {
			connectpip(i,0);
		}
		
		System.out.println(result);
		
	}
	
	private static boolean connectpip(int curx, int cury) {
		
		if(cury == C-1) {
			result++;
			return true;
		}
		
		for(int i = 0 ; i < 3; i++) {
			int dx = curx + delta[i][0];
			int dy = cury + delta[i][1];
			
			if(dx < 0 || dy < 0 || dx >= R || dy >= C) continue;
			
			if(map[dx][dy] == '.') {
				map[dx][dy] = '-';
				if(connectpip(dx,dy)) return true;
			}
		}
		
		return false;
	}
}
 