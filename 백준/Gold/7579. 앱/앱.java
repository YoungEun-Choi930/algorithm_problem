import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N+1];
        int[] cost = new int[N+1];
        int sumCost = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) memory[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sumCost += cost[i];
        }

        //solve
        int[][] select = new int[N+1][sumCost+1];
        for(int item = 1; item <= N; item++) {
            for(int cst = 0; cst <= sumCost; cst++) {
                //선택하지 않는다
                int case1 = select[item-1][cst];
                //선택한다
                int case2 = 0;
                if(cst>=cost[item]) case2 = select[item-1][cst-cost[item]] + memory[item];

                select[item][cst] = Math.max(case1, case2);
            }
        }

        int minCost = 0;
        for(int i = 0 ; i <= sumCost ; i++) {
            if(select[N][i] >= M) {
                minCost = i;
                break;
            }
        }
        System.out.println(minCost);

    }
}
