import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static mQueue queue;
	private final static int NON = 100_001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		queue = new mQueue();
		for (int i = 0; i < N; i++) {
			int result = run(br.readLine());
			
			if (result != NON) {
				sb.append(result).append('\n');
			}
		}
		
		System.out.println(sb);
	}

	private static int run(String cmd) {

		switch (cmd.charAt(0)) {
		case 'p':
			if (cmd.charAt(1) == 'u') {
				int n = Integer.parseInt(cmd.substring(5));
				queue.push(n);
				return NON;
			} else
				return queue.pop();
		case 's':
			return queue.size();
		case 'e':
			return queue.empty();
		case 'f':
			return queue.front();
		case 'b':
			return queue.back();
		}
		return 0;
	}

}

class Node {
	int n;
	Node left;
	Node right;

	public Node(int n) {
		this.n = n;
		left = null;
		right = null;
	}
}

class mQueue {
	Node start;
	Node end;
	

	public void push(int n) {
		if (isEmpty()) {
			Node node = new Node(n);
			start = end = node;
		} else {
			Node node = new Node(n);
			node.left = end;
			end.right = node;
			
			end = node;
		}
		
	}

	public int pop() {
		if (isEmpty()) return -1;
		
		Node s = start;
		int n = s.n;
		
		start = s.right;
		s = null;
		
		return n;
	}

	public int size() {
		int cnt = 0;
		for(Node no = start ; no != null; no = no.right) {
			++cnt;
		}
		return cnt;
	}

	private boolean isEmpty() {
		if(start == null) return true;
		else return false;
	}
	
	public int empty() {
		if (isEmpty()) return 1;
		else return 0;
	}

	public int front() {
		if (isEmpty())
			return -1;
		else
			return start.n;
	}

	public int back() {
		if (isEmpty())
			return -1;
		else
			return end.n;
	}
}