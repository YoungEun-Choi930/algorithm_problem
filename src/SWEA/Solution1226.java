package SWEA;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution1226 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
//        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= 10; tc++) {
            //tc
            br.readLine();
 
            input = new char[16][16];
            int starti = 0;
            int startj = 0;
            for(int i = 0 ; i < 100 ;i++) {
                String s = br.readLine();
                input[i] = s.toCharArray();
                if(s.contains("2")) {
                    starti = i;
                    startj = s.indexOf("2");
                }
            }
            check = new boolean[16][16];
 
            boolean result = solve(starti, startj);
 
 
            if(result)
                bw.write("#"+tc+" 1\n");
            else
                bw.write("#"+tc+" 0\n");
            bw.flush();
        }
 
        bw.close();
    }
    static char[][] input;
    static boolean[][] check;
 
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
 
 
    public static boolean solve(int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x,y));
        check[x][y] = true;
 
        while(!queue.isEmpty()) {
            Coordinate cd = queue.poll();
 
            for(int i = 0 ; i < 4 ; i++) {
                int nx = cd.x + dx[i];
                int ny = cd.y + dy[i];
 
                if(nx < 0 || ny < 0 || nx > 15 || ny > 15) continue;
 
                if(input[nx][ny] == '1') continue;  //벽이면 못감
                else if(input[nx][ny] == '3') return true;  //도착
 
                if(!check[nx][ny]){ //안 간 길이면
                    check[nx][ny] = true;
                    queue.offer(new Coordinate(nx,ny));
                }
 
            }
        }
 
        return false;
 
    }
 
 
 
}
 
class Coordinate {
    int x;
    int y;
    Coordinate(int i, int j) {
        x = i;
        y = j;
    }
}