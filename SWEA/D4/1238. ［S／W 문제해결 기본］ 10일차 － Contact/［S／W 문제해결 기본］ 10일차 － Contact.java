import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	private static class Node {
		int index;
		Node link;
		public Node(int index, Node link) {
			super();
			this.index = index;
			this.link = link;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	//100
			int start = Integer.parseInt(st.nextToken());
			
			Set<Integer> people = new HashSet<>();
			Node[] nodemap = new Node[101];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < N/2 ; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				nodemap[from] = new Node(to, nodemap[from]);
				
				people.add(from);
				people.add(to);
			}
			
			
			// ============================================
			Queue<Integer> queue = new ArrayDeque<Integer>();
			queue.offer(start);
			
			boolean[] visited = new boolean[101];
			visited[start] = true;
			int max = 0;
			
			while(!queue.isEmpty()) {
				int n = queue.poll();
				int tempmax = 0;
				
				for(Node node = nodemap[n]; node != null; node = node.link) {
					if(!visited[node.index]) {
						visited[node.index] = true;
						queue.offer(node.index);
						if(node.index > tempmax) tempmax = node.index;
					}
				}
				if(tempmax != 0) max = tempmax;
			}
			
			
			//가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하는 함수를 작성하시오.
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
 