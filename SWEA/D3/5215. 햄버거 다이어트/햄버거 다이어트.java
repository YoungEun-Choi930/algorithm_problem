import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
 
public class Solution {
    private static int[][] table;
    private static int N, L, result;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // input
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            L = Integer.parseInt(input[1]);
 
            table = new int[N][2];
             
            for(int i = 0 ; i < N ; i++) {
                input = br.readLine().split(" ");
                table[i][0] = Integer.parseInt(input[0]);
                table[i][1] = Integer.parseInt(input[1]);
            }
             
            Arrays.sort(table, new Comparator<int[]>() {
 
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
 
            });
 
            // solve
            result = 0;
 
 
            for(int R = 1 ; R <= N ; R++) {
                //배열 초기화
                int[] p = new int[N];
                int cnt = 0;
                while(++cnt <= R) {
                    p[N-cnt] = 1;
                }
                //np돌기
                do {
                    int ssum = 0;
                    int ksum = 0;
                    for(int i = 0 ; i < N; i++) {
                        if(p[i] == 1) {
                            ssum += table[i][0];
                            ksum += table[i][1];
                        }
                    }
                    if(ksum <= L && ssum > result) result = ssum;
                }while(np(p));
            }
             
            // output
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    private static boolean np(int[] input) {
 
        // 1.
        int n = input.length;
        int i = n-1;
        while(i>0 && input[i-1]>=input[i]) i--;
 
        if(i == 0) {
            return false;
        }
 
        // 2.
        int j = n-1;
        while(input[i-1] >= input[j]) --j;
 
        // 3.
        swap(input, i-1,j);
 
        // 4.
        int k = n-1;
        while(i < k) {
            swap(input, i++, k--);
        }
 
        return true;
    }
 
    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
     
}