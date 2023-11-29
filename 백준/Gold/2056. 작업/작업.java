import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static class Node {
        int n;
        Node link;

        public Node(int n, Node link) {
            this.n = n;
            this.link = link;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] times = new int[N+1];
        int[] startTime = new int[N+1];
        int[] cnt = new int[N+1];
        Node[] next = new Node[N+1];
        Queue<Integer> queue = new ArrayDeque<>();

        // input
        for(int i = 1 ; i <= N ; i++) {
            String[] in = br.readLine().split(" ");

            times[i] = Integer.parseInt(in[0]);
            cnt[i] = Integer.parseInt(in[1]);

            if(cnt[i] == 0) queue.offer(i);

            for(int j = 0 ; j < cnt[i] ; j++) {
                int n = Integer.parseInt(in[2+j]);

                next[n] = new Node(i, next[n]);
            }
        }

        // solve
        int maxTime = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            int successTime = startTime[cur] + times[cur];
            maxTime = maxTime > successTime ? maxTime : successTime;

//            System.out.println(cur+" : "+successTime);

            // 현재 번호를 이전실행으로 가지는 것들 cnt 줄이기
            for(Node node = next[cur] ; node != null ; node = node.link) {
                startTime[node.n] = startTime[node.n] > successTime ? startTime[node.n] : successTime;
                if(--cnt[node.n] == 0) {
                    queue.offer(node.n);
                }
            }
        }

        System.out.println(maxTime);

    }
}
