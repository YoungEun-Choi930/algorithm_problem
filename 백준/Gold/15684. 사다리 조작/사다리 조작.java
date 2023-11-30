import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N, M, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        N = Integer.parseInt(in[0]);
        M = Integer.parseInt(in[1]);
        H = Integer.parseInt(in[2]);

        boolean[][] map = new boolean[H+1][N+2];

        for(int i = 0 ; i < M ; i++) {
            in = br.readLine().split(" ");

            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);

            map[a][b] = true;
        }


        System.out.println(addLine(map, 0, 1));
    }

    private static int addLine(boolean[][] map, int n, int start) {
        if(n > 3) return -1;

        // 1. check
        boolean flag = true;
        for(int i = 1 ; i <= N ; i++) {
            int position = i;
            for(int j = 1 ; j <= H ; j++) {
                if(map[j][position]) {
                    position++;
                }
                else if(map[j][position-1]) {
                    position--;
                }
            }
            if(i != position) {
                flag = false;
                break;
            }
        }
        if(flag) return n;

        // 2. add
        int min = 100;
        for(int i = start; i <= H ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                if(!map[i][j] & !map[i][j-1] & !map[i][j+1]) {
                    map[i][j] = true;
                    int r = addLine(map, n+1, i);
                    if(r!= -1) min = min > r ? r : min;
                    map[i][j] = false;
                }
            }
        }

        return min == 100? -1 : min;
    }
}
