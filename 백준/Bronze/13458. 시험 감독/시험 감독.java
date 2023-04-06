import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] people = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        input = br.readLine().split(" ");
        int B = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        // ====================================================

        long sum = N;
        for(int peoplecnt : people) {
            peoplecnt -= B;

            if(peoplecnt > 0){
                sum += peoplecnt / C;
                if(peoplecnt % C > 0) sum++;
            }
        }

        System.out.println(sum);
    }
}
