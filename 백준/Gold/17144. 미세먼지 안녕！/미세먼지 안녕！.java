import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		int T = Integer.parseInt(input[2]);
		
		int[][] map = new int[R][C];
		int air = -1;
		for(int i = 0 ; i < R; i++) {
			input = br.readLine().split(" ");
			
			for(int j = 0 ; j < C; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
			if(map[i][0] == -1) air = i;
		}
		
		// ============================================
		// solve
		final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
		
		for(int t = 0 ; t < T; t++) {
			
			int[][] newMap = new int[R][C];
			// 1. 미세먼지 확산
			for(int i = 0 ; i < R; i++) {
				for(int j = 0 ; j < C; j++) {
					// 미세먼지가 있다면
					if(map[i][j] != 0) {
						
						// 확산
						int count = 0;
						for(int d = 0 ; d < 4; d++) {
							int dx = i + delta[d][0];
							int dy = j + delta[d][1];
							// 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
							if(dx<0 || dx>=R || dy<0 || dy>=C) continue;
							if(map[dx][dy] == -1) continue;
							
							//확산
							newMap[dx][dy] += (int) map[i][j]/5;
							count++;
						}
						newMap[i][j] += map[i][j] - (map[i][j]/5)*count;
					}
					
					
				}
			}
			
//			for(int i = 0 ; i < R; i++) {
//				System.out.println(Arrays.toString(newMap[i]));
//			}
			
			// 2. 공기청정기 작동
			for(int i = air-2; i > 0 ; i--) {
				newMap[i][0] = newMap[i-1][0];
			}
			for(int j = 0 ; j < C -1 ; j++) {
				newMap[0][j] = newMap[0][j+1];
			}
			for(int i = 0 ; i < air; i++) {
				newMap[i][C-1] = newMap[i+1][C-1];
			}
			for(int j = C-1 ; j > 0 ; j--) {
				newMap[air-1][j] = newMap[air-1][j-1];
			}
			newMap[air-1][1] = 0;
			
			// 아래부분
			for(int i = air+1 ; i < R-1; i++) {
				newMap[i][0] = newMap[i+1][0];
			}
			for(int j = 0 ; j < C -1 ; j++) {
				newMap[R-1][j] = newMap[R-1][j+1];
			}
			for(int i = R-1; i > air ; i--) {
				newMap[i][C-1] = newMap[i-1][C-1];
			}
			for(int j = C-1 ; j > 0 ; j--) {
				newMap[air][j] = newMap[air][j-1];
			}
			newMap[air][1] = 0;
			
			
			map = newMap;
		}
		
//		for(int i = 0 ; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		int count = 0;
		for(int i = 0 ; i < R; i++) {
			for(int j = 0 ; j < C; j++) {
				if(map[i][j] > 0) count+= map[i][j];
			}
		}
		
		System.out.println(count);
	}
}