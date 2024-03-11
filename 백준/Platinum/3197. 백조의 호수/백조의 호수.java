import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static final int[][] vec = {{-1,0},{1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int R = Integer.parseInt(in[0]);
        int C = Integer.parseInt(in[1]);
        char[][] map = new char[R][];
        for(int i = 0 ; i < R ; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // solve
        // 백조
        Point swan1 = null, swan2 = null;
        // 빙판
        Queue<Point> ice = new ArrayDeque<>();
        int[][] whenIceMelt = new int[R][C]; // 빙판이 언제 녹는가

        // 전처리
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if(map[i][j] == 'L') {
                    if(swan1 == null) swan1 = new Point(i,j);
                    else swan2 = new Point(i,j);
                    map[i][j] = '.';
                }
            }
        }
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if(map[i][j] == 'X') {
                    if((i>0 && map[i-1][j]=='.')||(i<R-1 && map[i+1][j]=='.')||(j>0 && map[i][j-1]=='.')||(j<C-1 && map[i][j+1]=='.')) {
                        ice.add(new Point(i, j));
                        whenIceMelt[i][j] = 1;
                    }
                }
            }
        }

        // 빙판이 언제 녹는지 계산
        int time = 2;
        while(!ice.isEmpty()) {
            int size = ice.size();
            while(--size >= 0) {
                Point cur = ice.poll();
                for(int[] v : vec) {
                    int nx = cur.x + v[0];
                    int ny = cur.y + v[1];
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny]== 'X' && whenIceMelt[nx][ny] == 0) {
                        ice.add(new Point(nx, ny));
                        whenIceMelt[nx][ny] = time;
                    }
                }
            }
            time++;
        }

        // 백조 움직이기
        Queue<Point> canGo = new ArrayDeque<>();
        Queue<Point> willGo = new ArrayDeque<>();
        boolean[][] check = new boolean[R][C];
        canGo.add(swan1);
        check[swan1.x][swan1.y] = true;


        // 턴
        int turn = 0;
        while(true) {

            // 백조가 만나는지 확인
            boolean isSwanMet = false;

            // 이동
            while(!canGo.isEmpty()) {
                Point cur = canGo.poll();
                if(whenIceMelt[cur.x][cur.y] > turn) {
                    willGo.add(cur);
                    continue;
                }
                if(cur.x == swan2.x && cur.y == swan2.y) {
                    isSwanMet = true;
                    break;
                }
                for(int[] v : vec) {
                    int nx = cur.x + v[0];
                    int ny = cur.y + v[1];
                    // 현재 턴에 녹아있는 빙산까지 이동가능.
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C && !check[nx][ny]) {
                        check[nx][ny] = true;
                        if(whenIceMelt[nx][ny] <= turn) canGo.add(new Point(nx, ny));
                        else willGo.add(new Point(nx, ny));
                    }
                }
            }

            if(isSwanMet) break;

            canGo = willGo;
            willGo = new ArrayDeque<>();
            turn++;
        }

        System.out.println(turn);
    }
}
