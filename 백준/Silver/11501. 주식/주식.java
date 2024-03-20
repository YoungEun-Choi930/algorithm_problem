import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1_000_001];
        while(--T >= 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cur = arr[N-1];
            long sum = 0;
            for(int i = N-2 ; i >= 0 ; i--) {
                if(arr[i] < cur) {
                    sum += cur-arr[i];
                }
                else {
                    cur = arr[i];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}