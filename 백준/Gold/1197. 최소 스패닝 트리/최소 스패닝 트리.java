import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static class Node implements Comparable<Node>{
        int a, b, value;

        public Node(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
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

        int[] parent = new int[V+1];
        for(int i = 1; i <= V ; i++) parent[i] = i;

        Queue<Node> ordered = new PriorityQueue<>();
        for(int i = 0 ; i < E ; i++) {
            in = br.readLine().split(" ");
            ordered.add(new Node(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2])));
        }

        //solve
        int cnt = 0;
        int sumValue = 0;
        while(cnt < V-1) {
            Node cur = ordered.poll();
            if(union(parent, cur.a, cur.b)) {
                cnt++;
                sumValue += cur.value;
            }
        }

        System.out.println(sumValue);
    }

    private static int findP(int[] parent, int n) {
        if(parent[n] == n) return n;
        return parent[n] = findP(parent, parent[n]);
    }

    private static boolean union(int[] parent, int a, int b) {
        int pa = findP(parent, a);
        int pb = findP(parent, b);
        if(pa == pb) return false;
        else if(pa < pb) parent[pb] = parent[b] = pa;
        else parent[pa] = parent[a] = pb;
        return true;
    }
}
