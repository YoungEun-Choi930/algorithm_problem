import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static int[][] map;
    private static Point[][] wormhole;
    // 밑, < , 위, >
    private static final int DOWN = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int RIGHT = 3;

    private static int[][] delta = {{1,0},{0,-1},{-1,0},{0,1}};
    // 각 index 방향에서 왔을때 반사되서 나가는 방향
    private static int[] block1 = {RIGHT,UP,DOWN,LEFT};
    private static int[] block2 = {UP,DOWN,RIGHT,LEFT};
    private static int[] block3 = {UP,RIGHT,LEFT,DOWN};
    private static int[] block4 = {LEFT,RIGHT,DOWN,UP};
    private static int[] block5 = {UP,RIGHT,DOWN,LEFT};
    private static int[][] blockNum = {block1, block2, block3, block4, block5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for(int tc = 1; tc <= T ; tc++) {
            // input
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            String[] input;
            wormhole = new Point[5][];

            for(int i = 0 ; i < N ; i++) {
                input = br.readLine().trim().split(" ");

                for(int j = 0 ; j < N ; j++) {
                    map[i][j] = Integer.parseInt(input[j]);

                    // 웜홀 링크시켜주기
                    if(map[i][j] >= 6 && map[i][j] <= 10) {
                        Point[] hole = wormhole[map[i][j] - 6];
                        if(hole == null) {
                            hole = new Point[2];
                            hole[0] = new Point(i,j);
                        }
                        else {
                            hole[1] = new Point(i,j);
                        }
                        wormhole[map[i][j]-6] = hole;
                    }
                }
            }

            // ==================================
            // solve

            int result = 0;

            for(int i = 0 ; i < N ; i++) {
            	for(int j = 0 ; j < N; j++) {
            		if(map[i][j] == 0) {
            			
            			for(int d = 0 ; d < 4; d++) {
            				int score = playGame(i,j,d);
            				if(score > result) result = score;
            			}
            		}
            	}
            }

            sb.append('#').append(tc).append(' ').append(result).append('\n');

        }
        System.out.println(sb);
    }

    private static int playGame(int x, int y, int dir) {
        int startx = x;
        int starty = y;

        int score = 0;
        while(true) {
            // move
            x += delta[dir][0];
            y += delta[dir][1];

            // 벽을 만날 경우 똑같은 길로 돌아가니까 *2 해주고 끝.
            if(x < 0 || x >= N || y < 0 || y >= N) {
                 score *= 2;
                 score++;
                 break;
            }

            // 블랙홀을 만날 경우 게임 끝
            if(map[x][y] == -1) break;
            // 핀볼이 출발 위치로 돌아오면 게임 끝
            if(x == startx && y == starty) break;

            // 빈칸이면 앞으로
            if(map[x][y] == 0) continue;


            // 블록을 만난 경우 방향을 바꿔준다.
            // 1 2 3 4 5
            if(map[x][y] < 5) {
                score++;
                dir = blockNum[map[x][y] - 1][dir];

            }
            else if(map[x][y] == 5) {	// 똑같은 길로 돌아가니까 *2해주고 끝
            	score *= 2;
                score++;
                break;
            }
            else {  //웜 홀을 만난 경우 6 7 8 9 10
                Point[] holes = wormhole[map[x][y] - 6];
                if(holes[0].x == x && holes[0].y==y) {
                    x = holes[1].x;
                    y = holes[1].y;
                }
                else {
                    x = holes[0].x;
                    y = holes[0].y;
                }
            }

        }

        return score;
    }
}
