import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] numbers = new int[9];
    private static int[] result = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 9 ; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        find(0,0, 0,0);

    }

    private static void find(int index, int sum, int cnt, int uncheck) {
        if(cnt == 7) {
            if(sum == 100) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0 ; i < 7 ; i++) {
                    sb.append(result[i]).append("\n");
                }
                System.out.println(sb);
            }

            return;
        }

        if(sum > 100) return;

        result[cnt] = numbers[index];
        find(index+1, sum+ numbers[index], cnt+1, uncheck);

        if(uncheck < 2) {
            find(index+1, sum, cnt, uncheck+1);
        }
    }

}