import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<int[]> homelist;
    private static List<int[]> chickenlist;
    private static int M, chickencnt, minresult;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        homelist = new ArrayList<>();
        chickenlist = new ArrayList<>();
        int n;
        for(int i = 0 ; i < N ; i++) {
            input = br.readLine().split(" ");
            for(int j = 0 ; j < N; j++) {
                n = Integer.parseInt(input[j]);
                if(n==1) {
                    homelist.add(new int[]{i,j});
                }
                else if(n==2) {
                    chickenlist.add(new int[]{i,j});
                }
            }
        }

        // =============================================
        // solve
        chickencnt = chickenlist.size();
        minresult = Integer.MAX_VALUE;
        combination(0,0, new int[M]);

        System.out.println(minresult);
    }

    private static void combination(int start, int cnt, int[] selected) {
        if(cnt == M) {

            int sum = 0;
            for(int[] home : homelist) {

                int mindis = Integer.MAX_VALUE;
                for(int idx : selected) {
                    int[] cur = chickenlist.get(idx);

                    int d = Math.abs(home[0] - cur[0])+ Math.abs(home[1] - cur[1]);
                    if(mindis > d) mindis = d;
                }
                sum += mindis;
            }
            if(minresult > sum) minresult = sum;
            return;

        }

        for(int i = start; i < chickencnt; i++) {
            selected[cnt] = i;
            combination(i+1, cnt+1, selected);
        }
    }
}
