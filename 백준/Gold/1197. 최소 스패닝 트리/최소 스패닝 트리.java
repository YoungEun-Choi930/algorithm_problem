import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static class Node implements Comparable<Node>{
        int a, b, value;
        Node next;

        public Node(int a, int b, int value, Node next) {
            this.a = a;
            this.b = b;
            this.value = value;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int V = Integer.parseInt(in[0]);
        int E = Integer.parseInt(in[1]);

        Node[] lines = new Node[V+1];

        int a, b, c;
        for(int i = 0 ; i < E ; i++) {
            in = br.readLine().split(" ");
            a = Integer.parseInt(in[0]);
            b = Integer.parseInt(in[1]);
            c = Integer.parseInt(in[2]);

            lines[a] = new Node(a, b, c, lines[a]);
            lines[b] = new Node(b, a, c, lines[b]);
        }

        // solve
        int cnt = 1;
        int sumValue = 0;
        boolean[] selected = new boolean[V+1];
        Queue<Node> ordered = new PriorityQueue<>();

        selected[1] = true;
        Node node1 = lines[1];
        while(node1 != null) {
            ordered.offer(node1);
            node1 = node1.next;
        }

        while(!ordered.isEmpty()) {
            Node cur = ordered.poll();
            if(selected[cur.b]) continue;

            sumValue += cur.value;
            selected[cur.b] = true;
            if(++cnt == V) break;

            node1 = lines[cur.b];
            while(node1 != null) {
                if(!selected[node1.b]) ordered.offer(node1);
                node1 = node1.next;
            }
        }

        System.out.println(sumValue);
    }

}
