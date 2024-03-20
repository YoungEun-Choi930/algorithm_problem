import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++) queue.add(Integer.parseInt(st.nextToken()));

        int cur = 0;
        int sum = 0;
        while(!queue.isEmpty()) {
            cur += queue.poll();
            sum += cur;
        }

        System.out.println(sum);
    }
}
