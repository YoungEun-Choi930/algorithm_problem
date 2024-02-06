import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    private static int N;
    private static int[] arr;
    private static HashSet<Integer> checkNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] in = br.readLine().split(" ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }

        //solve
        checkNumber = new HashSet<>();
        selectNumber(0,0);

        int cnt = 0;
        while(true) {
            if(!checkNumber.contains(++cnt)) {
                break;
            }
        }

        System.out.println(cnt);
    }

    private static void selectNumber(int i, int sum) {
        if(i == N) {
            checkNumber.add(sum);
            return;
        }

        selectNumber(i+1, sum);
        selectNumber(i+1, sum+arr[i]);
    }
}
