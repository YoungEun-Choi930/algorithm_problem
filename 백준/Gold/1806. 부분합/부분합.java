import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = -1;
        int right = 0;
        int sum = arr[0];
        int length = 1;
        int minLength = 100_001;

        while(true) {

            if(sum < S) {
                if(++right >= N) break;
                sum += arr[right];
                length++;
            }
            else {
                if(length < minLength) minLength = length;
                sum -= arr[++left];
                length--;
            }
        }

        if(minLength == 100_001) minLength = 0;
        System.out.println(minLength);
    }
}
