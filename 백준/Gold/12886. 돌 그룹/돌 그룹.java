import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int a = Integer.parseInt(in[0]);
        int b = Integer.parseInt(in[1]);
        int c = Integer.parseInt(in[2]);

        System.out.println(solve(a,b,c)? 1 : 0);
    }

    private static boolean solve(int a, int b, int c) {
        if((a+b+c)%3 != 0) return false;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{a,b,c});

        boolean[][] visited = new boolean[1501][1501];
        visited[a][b] = true;
        visited[b][a] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            //System.out.println(cur[0] +" : "+cur[1]+ " : "+cur[2]);

            if(cur[0] == cur[1] && cur[1] == cur[2]) return true;

            if(cur[0] != cur[1]) {
                int na = cur[0] > cur[1] ? cur[0] - cur[1] : cur[0] + cur[0];
                int nb = cur[0] > cur[1] ? cur[1] + cur[1] : cur[1] - cur[0];

                if(!visited[na][nb]) {
                    visited[na][nb] = true;
                    visited[nb][na] = true;
                    queue.offer(new int[]{na,nb,cur[2]});
                }
            }

            if(cur[1] != cur[2]) {
                int nb = cur[1] > cur[2] ? cur[1] - cur[2] : cur[1] + cur[1];
                int nc = cur[1] > cur[2] ? cur[2] + cur[2] : cur[2] - cur[1];

                if(!visited[nb][nc]) {
                    visited[nb][nc] = true;
                    visited[nc][nb] = true;
                    queue.offer(new int[]{cur[0],nb,nc});
                }
            }


            if(cur[0] != cur[2]) {
                int na = cur[0] > cur[2] ? cur[0] - cur[2] : cur[0] + cur[0];
                int nc = cur[0] > cur[2] ? cur[2] + cur[2] : cur[2] - cur[0];

                if(!visited[na][nc]) {
                    visited[na][nc] = true;
                    visited[nc][na] = true;
                    queue.offer(new int[]{na,cur[1],nc});
                }
            }
        }

        return false;
    }
}
