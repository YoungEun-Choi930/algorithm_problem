import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        while(--N >= 0) {
            String[] in = br.readLine().split(" ");
            int s = Integer.parseInt(in[0]);
            int e = Integer.parseInt(in[1]);
            queue.add(new int[]{s,e});
        }

        //solve
        int cur = 0, cnt = 0;
        while(!queue.isEmpty()) {
            int[] ar = queue.poll();
            if(ar[0] >= cur) {
                cur = ar[1];
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
