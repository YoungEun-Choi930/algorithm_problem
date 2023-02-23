import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	private static char[][] map;
	private static final char[] train = {'^', '<', 'v', '>'};
	private static final int[][] delta = {{-1,0},{0,-1},{1,0},{0,1}};
	private static final char[] move = {'U','L','D','R'};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			// input
			String[] input = br.readLine().split(" ");
			int H = Integer.parseInt(input[0]);
			int W = Integer.parseInt(input[1]);
			
			map = new char[H][W];
			for(int i = 0 ; i < H ; i++) map[i] = br.readLine().toCharArray();
			
			int N = Integer.parseInt(br.readLine());
			char[] command = br.readLine().toCharArray();
			// ===============================================================
			// solve
			
			// 1. 전차의 위치 구하기.
			int curx = -1;
			int cury = -1;
			int curdirection = -1;
            find:
			for(int i = 0 ; i < H ; i++) {
				for(int j = 0 ; j < W ; j++) {
					for(int t = 0 ; t < 4 ; t++) {
						if(map[i][j] == train[t]) {
							curx = i;
							cury = j;
							curdirection = t;
                            break find;
						}
					}
				}
			}
			
			// 2. 명령 실행
			for(int c = 0; c < N ; c++) {
				
				char com = command[c];
				
				// 만약 U D L R 라면
				for(int t = 0 ; t < 4 ; t++) {
					if(com == move[t]) {
						// 2-1. 방향바꾸기
						curdirection = t;
                        map[curx][cury] = train[t];
						// 2-2. 평지라면 이동
						int dx = curx + delta[t][0];
						int dy = cury + delta[t][1];
						if(dx>= 0 && dy >= 0 && dx < H && dy < W && map[dx][dy] == '.') {
							
							//현재 땅은 평지로 만들고
							map[curx][cury] = '.';
							
							// 이동한 곳에 전차 놓기
							map[dx][dy] = train[t];
							curx = dx;
							cury = dy;
						}
						
						break;
					}
				}
				
				// 만약 S 라면 
				if(com == 'S') {
					int tx = curx;
					int ty = cury;
					while(true) {
						tx += delta[curdirection][0];
						ty += delta[curdirection][1];
						
						// 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다.
						// 강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다.
						// 게임 맵 밖으로 포탄이 나가면 아무런 일도 일어나지 않는다.
						if(tx < 0 || ty < 0 || tx >= H || ty >= W || map[tx][ty] == '#')
							break;
						
						// 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다.
						if(map[tx][ty] == '*') {
							map[tx][ty] = '.';
                            break;
						}
					}
				}
				
				
			}
			// 명령 실행 끝
			
			// 출력
			sb.append("#").append(tc).append(" ");
			for(int i = 0 ; i < H ; i++) {
				for(int j = 0 ; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
			
			
		}	// tc 끝
		
		System.out.println(sb);
	}
	
	
}
