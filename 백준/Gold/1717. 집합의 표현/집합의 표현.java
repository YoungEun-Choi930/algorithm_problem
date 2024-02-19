import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int findParent(int n, int[] arr) {
        if(arr[n] == n) return n;
        else return arr[n] = findParent(arr[n], arr);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        // init
        int[] arr = new int[N+1];
        for(int i = 1 ; i <= N ; i++) arr[i] = i;

        // solve
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[1]);
            int b = Integer.parseInt(in[2]);
            if(in[0].charAt(0) == '0') {
                int pa = findParent(a,arr);
                int pb = findParent(b,arr);

                arr[pb] = arr[b] = pa;
            }
            else {
                int pa = findParent(a,arr);
                int pb = findParent(b,arr);

                if(pa == pb) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
