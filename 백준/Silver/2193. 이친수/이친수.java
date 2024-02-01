import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] zero = new long[N];
        long[] one = new long[N];
        one[0] = 1;

        for(int i = 1 ; i < N ; i++) {
            zero[i] = one[i-1];
            one[i] = zero[i-1];
            zero[i] += zero[i-1];
        }

        long result = zero[N-1] + one[N-1];
        System.out.println(result);
    }
}
