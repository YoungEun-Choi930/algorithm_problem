import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private final static int[][] vec = {{-1,0},{0,1},{1,0},{0,-1}}; //상우하좌(시계)
    private final static int[] turn = {-1, 1};  // 방향을 회전하면 -1만큼, 1만큼 할 수 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int W = Integer.parseInt(in[0]);
        int H = Integer.parseInt(in[1]);
        char[][] map = new char[H][];
        for(int i = 0 ; i < H ; i++) map[i] = br.readLine().toCharArray();

        // C 찾기
        int[] p1 = null, p2 = null;
        for(int i = 0 ; i < H ; i++) {
            for(int j = 0 ; j < W ; j++) {
                if(map[i][j] == 'C') {
                    if(p1 == null) p1 = new int[]{i, j};
                    else p2 = new int[]{i, j};
                    map[i][j] = '.';
                }
            }
        }

        // 경로 찾기
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] check = new boolean[H][W][4];
        int[][][] checkMirror = new int[H][W][4];
        for(int d = 0; d < 4 ; d++) {
            queue.add(new int[]{p1[0], p1[1], d, 0});  //x,y,현재 방향,설치한 거울 개수
            check[p1[0]][p1[1]][d] = true;
        }

        int result = 100_000;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dir = cur[2];
            int mcnt = cur[3];

//            System.out.println(cur[0]+", "+cur[1]+", "+cur[2]+" ("+cur[3]+")");

            if(cur[0] == p2[0] && cur[1] == p2[1]) {
                if(mcnt < result) result = mcnt;
            }

            int[][] direc = new int[3][2];
            direc[0][0] = dir;  //현재방향
            direc[0][1] = mcnt;    //추가거울 X
            direc[1][0] = dir-1 < 0 ? 3 : dir-1;
            direc[1][1] = mcnt+1;    //추가거울 O
            direc[2][0] = dir+1 > 3 ? 0 : dir+1;
            direc[2][1] = mcnt+1;    //추가거울 O

            // 거울 설치 (방향전환)
            for(int[] cd : direc) {
                int d = cd[0];

                int nx = cur[0] + vec[d][0];
                int ny = cur[1] + vec[d][1];

                if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
                    if(checkMirror[nx][ny][d] > cd[1] || (checkMirror[nx][ny][d] == 0 && !check[nx][ny][d])) {
                        check[nx][ny][d] = true;
                        checkMirror[nx][ny][d] = cd[1];
                        queue.add(new int[]{nx, ny, d, cd[1]});
                    }
                }
            }
        }
        System.out.println(result);
    }
}
