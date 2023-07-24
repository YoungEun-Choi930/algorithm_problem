import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	private static class Node {
		int n, bridge;
		Node link;
		public Node(int n, int bridge, Node link) {
			this.n = n;
			this.bridge = bridge;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);
		
		Node[] linkedList = new Node[N+1];
		for(int i = 0 ; i < M ; i++) {
			in = br.readLine().split(" ");
			int a = Integer.parseInt(in[0]);
			int b = Integer.parseInt(in[1]);
			int c = Integer.parseInt(in[2]);
			
			linkedList[a] = new Node(b, c, linkedList[a]);
			linkedList[b] = new Node(a, c, linkedList[b]);
		}
		
		in = br.readLine().split(" ");
		int sp = Integer.parseInt(in[0]);	// start point
		int ep = Integer.parseInt(in[1]);	// end point
		
		// solve
		System.out.println(getMaxWeight(N, linkedList, sp, ep));
		 
	}

	private static int getMaxWeight(int N, Node[] linkedList, int sp, int ep) {

		int[] maxWeight = new int[N+1];
		
		Queue<int[]> queue = new PriorityQueue<>((o1,o2)->o2[1]-o1[1]);
		queue.offer(new int[] {sp,Integer.MAX_VALUE});	//출발
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int num = cur[0];
			if(num == ep) break;
			int minweight = cur[1];
			
			for(Node node = linkedList[num] ; node != null ; node = node.link) {
				int min = Math.min(minweight, node.bridge);
				if(min > maxWeight[node.n] ) {
					maxWeight[node.n] = min;
					queue.offer(new int[] {node.n, min});
				}
			}
		}
		
		return maxWeight[ep];
	}
}
