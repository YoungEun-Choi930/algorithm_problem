package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution1861_D4_정사각형방 {
	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			//input
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
			}

			//solve
			int result = 0;
			int resultRumNum = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					int depth = dfs(i,j);
					if(depth > result) {
						result = depth;
						resultRumNum = map[i][j];
					}
					else if(depth == result && map[i][j] < resultRumNum) {
						result = depth;
						resultRumNum = map[i][j];
					}

				}
			}

			//output
			sb.append("#").append(tc).append(" ").append(resultRumNum).append(" ").append(result).append("\n");

		}
		System.out.println(sb);
	}
	private static int[][] delta = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};

	private static int dfs(int x, int y) {
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[]{x,y});

		int result = 1;

		while(!stack.isEmpty()) {
			int[] current = stack.pop();
			int curvalue = map[current[0]][current[1]];
			//move
			for(int d = 0 ; d < 4; d++) {
				int dx = current[0] + delta[d][0];
				int dy = current[1] + delta[d][1];

				if(dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] == curvalue+1) {
					result++;
					stack.push(new int[] {dx,dy});
				}
			}
		}

		return result;
	}
}
