import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	private static class Node {
		int weight, no;
		Node link;
		public Node(int weight, int no, Node link) {
			super();
			this.weight = weight;
			this.no = no;
			this.link = link;
		}
		
	}
	
	private static class Vertex implements Comparable<Vertex>{
		int no, mindis;

		public Vertex(int no, int mindis) {
			super();
			this.no = no;
			this.mindis = mindis;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.mindis, o.mindis);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" "); // (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		
		int start = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[V+1];
		for(int i = 0 ; i < E ; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			
			nodes[u] = new Node(w,v,nodes[u]);
		}
		
		// ========================================
		// solve
		boolean[] visited = new boolean[V+1];
		int[] minDistance = new int[V+1];
		Arrays.fill(minDistance, Integer.MAX_VALUE);
		minDistance[start] = 0;
		
		Queue<Vertex> queue = new PriorityQueue<>();
		queue.offer(new Vertex(start,0));
		
		while(true) {
			
			if(queue.isEmpty()) break;

			// 1. 방문 안한 것 중 가장 거리가 작은 값 선택
			Vertex cur = queue.poll();
			if(visited[cur.no]) continue;
			
			// 방문처리
			visited[cur.no] = true;
			minDistance[cur.no] = cur.mindis;
			
			// 2. 최소값 갱신
			for(Node node = nodes[cur.no]; node != null; node = node.link) {
				if(!visited[node.no]) {
					queue.offer(new Vertex(node.no, cur.mindis + node.weight));
				}
			}
			
		}
		
		// =======================================
		// output
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V ; i++) {
			if(minDistance[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(minDistance[i]).append('\n');
		}
		System.out.println(sb);
	}
}
