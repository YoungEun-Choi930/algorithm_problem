import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private static class Node {
        int num, weight;
        Node next;

        public Node(int num, int weight, Node next) {
            this.num = num;
            this.weight = weight;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int Q = Integer.parseInt(in[1]);

        // init
        Node[] nodes = new Node[N+1];
        for(int i = 1 ; i < N ; i++) {
            in = br.readLine().split(" ");
            int p = Integer.parseInt(in[0]);
            int q = Integer.parseInt(in[1]);
            int r = Integer.parseInt(in[2]);

            nodes[p] = new Node(q, r, nodes[p]);
            nodes[q] = new Node(p, r, nodes[q]);
        }

        // solve
        StringBuilder sb = new StringBuilder();
        while(--Q >= 0) {
            in = br.readLine().split(" ");
            int k = Integer.parseInt(in[0]);
            int v = Integer.parseInt(in[1]);

            int cnt = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(v);
            boolean[] visited = new boolean[N+1];
            visited[v] = true;

            while(!queue.isEmpty()) {
                int cur = queue.poll();

                for(Node curNode = nodes[cur] ; curNode != null ; curNode = curNode.next) {
                    if(curNode.weight >= k && !visited[curNode.num]) {
                        cnt++;
                        visited[curNode.num] = true;
                        queue.add(curNode.num);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
