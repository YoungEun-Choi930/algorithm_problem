import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = N-1;
        int num1 =0 , num2 = 0;
        int dif = Integer.MAX_VALUE;

        while(left != right) {
            int d = arr[left] + arr[right];
            if(Math.abs(d) < dif) {
                dif = Math.abs(d);
                num1 = arr[left];
                num2 = arr[right];
            }
            else if(d < 0) {
                left++;
            }
            else right--;
        }

        System.out.println(num1+" "+num2);
    }
}
