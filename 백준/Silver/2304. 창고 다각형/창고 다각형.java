import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[p] = h;
        }

        int[] left = new int[1001];
        int[] right = new int[1001];
        left[0] = arr[0];
        right[1000] = arr[1000];
        for(int i = 1 ; i <= 1000 ; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
            right[1000-i] = Math.max(right[1001-i], arr[1000-i]);
        }

        long sum = 0;
        int pre = arr[0];
        int cnt = 1;
        for(int i = 1 ; i <= 1000 ; i++) {
            int cur = Math.min(left[i], right[i]);

            if(pre == cur) cnt++;
            else {
                sum += (long) cnt * pre;
                pre = cur;
                cnt = 1;
            }
        }

        if(cnt > 0 && pre > 0) sum += (long) cnt * pre;

        System.out.println(sum);
    }
}
