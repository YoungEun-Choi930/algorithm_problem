import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static class Node{
		int value;
		Node link;
		public Node(int value, Node link) {
			super();
			this.value = value;
			this.link = link;
		}
		
	}

	private static int N, result;
	private static Node[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);		// N (5 ≤ N ≤ 2000)
		int M = Integer.parseInt(input[1]);	// M (1 ≤ M ≤ 2000)
		
		list = new Node[N];
		for(int i = 0 ; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]); 
			list[a] = new Node(b,list[a]);
			list[b] = new Node(a,list[b]);
		}

		// solve
		result = 0;
		for(int i = 0 ; i < N ; i++) {
			dfs(i, 1, new boolean[N]);
			if(result == 1) break;
		}

		// 출력
		System.out.println(result);
	}

	private static void dfs(int index, int count, boolean[] visited) {
		if(count == 5) {
			result = 1;
			return;
		}
		
		visited[index] = true;
		
		for(Node temp = list[index]; temp != null; temp = temp.link) {
			if(!visited[temp.value]) {
				dfs(temp.value, count+1, visited);
			}
		}
		
		visited[index] = false;
	}
}
