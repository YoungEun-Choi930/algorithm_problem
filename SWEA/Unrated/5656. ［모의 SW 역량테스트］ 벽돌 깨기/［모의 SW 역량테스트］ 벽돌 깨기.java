import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	/*
	 * 1. 1 ≤ N ≤ 4
	 * 2. 2 ≤ W ≤ 12
	 * 3. 2 ≤ H ≤ 15
	 * 계획
	 * N은 4까지니까 DFS로 구해도 될 것 같음. 3초니까 괜찮지 않을까
	 * 현재 값이 더 크다고 해서 더 많은 양을 터트린다는 것은 보장되지 않음. (그리디X)
	 * 작은값에서 이어지는 수가 더 커서 더 많이 터트릴수도 있음.
	 * 최악의 경우 : 12^4
	 * map은 arraycopy만들어서 진행.
	 * 
	 * 흐름
	 * 1. 입력받기. 받으면서 벽돌 개수 count
	 * 2. dfs(-1,-1)호출
	 * 3. dfs(x,y, depth, count) {
	 * 		기저 : depth 가 N이면 깬 벽돌 수 count max값 업데이트
	 * 
	 * 		1. tempmap에 현재map 복사
	 * 		2. brike() 벽돌깨기.
	 * 		3. 떨어지는 벽돌 fallgravity() map 업데이트
	 * 		4. 출발 가능한 출발지에 대해 dfs() 호출
	 * 		5. 현재map에 다시 tempmap 돌려놓기
	 * 	}
	 * 4. brike(x,y) {
	 * 		for(4) delta 방향으로
	 * 			for(map(x,y)-1) 벽돌에 적힌 숫자만큼
	 * 				if(map[x,y] >1) brike()
	 * 				else if( == 1)  = 0;
	 * 	}
	 * 5. fallgravity() {
	 * 		for(왼쪽에서 오른쪽으로 이동)
	 * 			for(밑에서 위로이동)
	 * 				0인걸 찾으면 해당 인덱스 저장
	 * 				0이 아닌걸 찾으면 0인 인덱스로 복사, 현재는 0으로 저장
	 * 	}
	 * 		
	 */
	
	private static int N, W, H, max, brickcnt;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T  = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T; tc++) {
			//input
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			W = Integer.parseInt(input[1]);
			H = Integer.parseInt(input[2]);
			
			int count = 0;
			int[][] map = new int[H][W];
			for(int i = 0 ; i < H ; i++) {
				input = br.readLine().split(" ");
				for(int j = 0 ; j < W; j++) {
					map[i][j] = Integer.parseInt(input[j]);
					if(map[i][j] != 0) count++;
				}
			}
			
			// ============================================
			// solve
			max = 0;
			brickcnt = count;
			dfs(-1,-1,0,0, map);
			
			sb.append("#").append(tc).append(" ").append(count-max).append('\n');
		}
		System.out.println(sb);
	}


	private static void dfs(int x, int y, int depth, int count, int[][] curmap) {
		// 현재 지도 저장
		int[][] tempmap = arraycopy(curmap);

		// 첫번째 입력이 아니면
		if(depth > 0) {
			// 현재 좌표에 대해 벽돌 깨기
			count += breakebrick(x,y,tempmap);
			// 떨어지는 벽돌 map에 업데이트
			fallGravity(tempmap);
		}
		
		

		// 만약 N번째 벽돌을 깼거나 모든 벽돌을 다 깨면 끝
		if(depth == N || brickcnt == count) {
			if(count > max) max = count;
			return;
		}
		
		
		// 각 열에 대해 출발지 찾기
		int[] start = new int[W];
		Arrays.fill(start, -1);
		for(int i = 0 ; i < W; i++) {
			for(int j = 0 ; j < H; j++) {
				if(tempmap[j][i] != 0) {
					start[i] = j;
					break;
				}
			}
		}

		// 다음 벽돌 깨러가기
		for(int i = 0 ; i < W; i++) {
			if(start[i] != -1) dfs(start[i], i, depth+1, count, tempmap);
		}
		
	}


	private static int[][] arraycopy(int[][] map2) {
		int[][] array = new int[H][W];
		for(int i = 0 ; i < H ; i++) {
			array[i] = Arrays.copyOf(map2[i], W);
		}
		return array;
	}


	private static void fallGravity(int[][] curmap) {
		for(int i = 0 ; i < W ; i++) {
			int tempidx = -1;
			for(int j = H-1; j >= 0 ; j--) {
				if(curmap[j][i] == 0 && tempidx == -1) {	// 처음 나오는 0좌표 저장
					tempidx = j;
				}
				if(tempidx != -1 && curmap[j][i] != 0) {	// 0에다가 현재값 넣기
					while(j >= 0 && curmap[j][i] != 0) {
						curmap[tempidx--][i] = curmap[j][i];
						curmap[j--][i] = 0;
					}
				}
			}
		}
	}

	private static final int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}};
	private static int breakebrick(int x, int y, int[][] curmap) {
		
		// 자기자신 깨기
		int count = 1;
		
		int n = curmap[x][y];
		curmap[x][y] = 0;
		
		if(n-- == 1) return 1;
		
		
		// 사방으로
		for(int d = 0 ; d < 4; d++) {
			int dx = x;
			int dy = y;
			
			// n만큼
			for(int i = 0 ; i < n ; i++) {
				dx += delta[d][0];
				dy += delta[d][1];
				if(dx < 0 || dx >= H || dy < 0 || dy >= W) break;
				
				if(curmap[dx][dy] > 1) {
					count += breakebrick(dx,dy, curmap);
				}
				else if(curmap[dx][dy] == 1) {
					curmap[dx][dy] = 0;
					count++;
				}
			}
		}
		
		return count;
	}
}
