import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] cntLen = new int[N];
        int maxLen = 1;
        for(int i = 0 ; i < N ; i++) {
            int len = 1;
            for(int j = 0 ; j < i ; j++) {
                if(input[i] > input[j]) {
                    len = Math.max(len, cntLen[j]+1);
                }
            }
            cntLen[i] = len;
            maxLen = Math.max(cntLen[i], maxLen);
        }

        System.out.println(maxLen);
    }
}
