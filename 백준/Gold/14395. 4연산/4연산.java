import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Main {

    private static long S, T;
    private final static int MAX_LIMIT = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        S = Long.parseLong(input[0]);
        T = Long.parseLong(input[1]);

        // solve
        if (S == T) {
            System.out.println(0);
            return;
        }
        Queue<Long> queue = new ArrayDeque<>();
        HashMap<Long, String> map = new HashMap<>();

        // depth == 0
        queue.offer(S);
        map.put(S, "");

        // bfs
        while (!queue.isEmpty()) {
            long n = queue.poll();

            if (n == T) {
                System.out.println(map.get(n));
                return;
            }

            // *
            if (n*n <= MAX_LIMIT && !map.containsKey(n * n)) {
                queue.offer(n * n);
                map.put(n * n, map.get(n) + '*');
            }

            // +
            if (n+n <= MAX_LIMIT && !map.containsKey(n + n)) {
                queue.offer(n + n);
                map.put(n + n, map.get(n) + '+');
            }

            // -
            if (!map.containsKey(n-n)) {
                queue.offer(n-n);
                map.put(n-n, map.get(n) + '-');
            }

            // /
            if (n!= 0 && !map.containsKey(n/n)) {
                queue.offer(n/n);
                map.put(n/n, map.get(n) + '/');
            }
        }

        System.out.println(-1);
        return;

    }

}
