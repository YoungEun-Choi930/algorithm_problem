import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        arr[1] = Integer.parseInt(st.nextToken());
        for(int i = 2 ; i <= N ; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int maxSum = 0;
        int cnt = 0;
        for(int i = X ; i <= N ; i++) {
            int s = arr[i] - arr[i-X];
            if(s > maxSum) {
                cnt = 1;
                maxSum = s;
            }
            else if(s == maxSum) {
                cnt++;
            }
        }

        if(maxSum == 0) System.out.println("SAD");
        else {
            System.out.println(maxSum);
            System.out.println(cnt);
        }
    }
}
