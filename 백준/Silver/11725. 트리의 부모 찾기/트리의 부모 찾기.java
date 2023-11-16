import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static class Node {
		int num;
		Node link;
		
		public Node(int num, Node node) {
			this.num = num;
			this.link = node;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// input
		// 링크드리스트로 노드를 연결
		Node[] linkedList = new Node[N+1];
		for(int i = 1 ; i < N ; i++) {
			String[] in = br.readLine().split(" ");
			
			int n1 = Integer.parseInt(in[0]);
			int n2 = Integer.parseInt(in[1]);
			
			linkedList[n1] = new Node(n2, linkedList[n1]);
			linkedList[n2] = new Node(n1, linkedList[n2]);
		}
		
		// solve
		
		// 1번노드에서 시작하여 visited를 기록
		// n의 부모는 parent[n]
		int[] parent = new int[N+1];
		
		// 큐 (현재 노드 번호)
		Queue<Integer> queue = new ArrayDeque<>(); 
		
		// 1번 노드에 대한 자식 queue에 삽입
		for(Node node = linkedList[1] ; node != null ; node = node.link) {
			parent[node.num] = 1;
			queue.offer(node.num);
		}
		
		// 큐로 visited 기록
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(Node node = linkedList[current] ; node != null ; node = node.link) {
				if(parent[node.num] == 0) {
					parent[node.num] = current;
					queue.offer(node.num);
				}
			}
		}
		
		// output
		// 각 노드의 부모 노드 번호 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N ; i++) {
			sb.append(parent[i]+"\n");
		}
		
		System.out.println(sb);
	}
}
