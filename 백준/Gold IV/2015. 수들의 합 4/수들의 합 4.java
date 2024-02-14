import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sum = new int[N+1];
        st = new StringTokenizer(br.readLine());

        long cnt = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1 ; i <= N ; i++) {

            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());

            if(sum[i] == K) cnt++;

            // 누적합 arr[오른쪽]-arr[왼쪽]이 k인 경우
            cnt += map.getOrDefault(sum[i]-K,0);
            map.put(sum[i], map.getOrDefault(sum[i],0)+1);

        }

        System.out.println(cnt);
    }
}
