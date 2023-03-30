import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    private static char[][] map;
    private static List<Point> zerolist;
    private static int len;
    
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        input();
        len = zerolist.size();
        solve(0);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        map = new char[9][];
        zerolist = new ArrayList<>();
        for(int i = 0 ; i < 9 ; i++) {
            
            map[i] = br.readLine().toCharArray();
            for(int j = 0 ; j < 9 ; j++) {
                if((map[i][j]&15) == 0) zerolist.add(new Point(i,j));
            }
        }
    }
    
    private static void output() {
        StringBuilder sb = new StringBuilder();
        for(char[] line : map) {
            for(char c : line) {
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    
    private static void solve(int index) {
        if(index == len) {
        	output();
        	System.exit(0);
        }
        
        Point cur = zerolist.get(index);
        
        // 현재 자리에 올 수 있는 숫자를 구한다.
        // 가로, 세로, 3사각형
        boolean[] check = new boolean[10];
        for(int k = 0 ; k < 9 ; k++) {
            if(map[cur.x][k] != 48) check[(map[cur.x][k]&15)] = true;
            if(map[k][cur.y] != 48) check[(map[k][cur.y]&15)] = true;
            
        }
        
        int x = cur.x / 3 * 3, y = cur.y / 3 * 3, endx = x+3, endy = y+3;
        for(int dx = x ; dx < endx ; dx++) {
            for(int dy = y ; dy < endy; dy++) {
                if(map[dx][dy] != 48) check[(map[dx][dy]&15)] = true;
            }
        }
        
        
        // 가능한 경우에 대하여 탐색.(dfs)
        for(int k = 1 ; k <= 9 ; k++) {
            if(!check[k]) {
                map[cur.x][cur.y] = (char) (k+48);
                solve(index+1);
                map[cur.x][cur.y] = 48;
           }
        }
        
    }
    

}
