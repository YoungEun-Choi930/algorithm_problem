import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] sum = new int[N];
        sum[0] = arr[0];
        int maxSum = sum[0];
        for(int i = 1 ; i < N ; i++) {
            int max = 0;
            for(int j = 0 ; j < i ; j++) {
                if(arr[i] > arr[j]) max = max > sum[j] ? max : sum[j];
            }
            sum[i] = max + arr[i];
            maxSum = maxSum > sum[i] ? maxSum : sum[i];
        }

        System.out.println(maxSum);
    }
}
