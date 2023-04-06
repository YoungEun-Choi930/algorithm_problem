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

class mQueue {
	int[] arr = new int[10_000];
	int front = 0;
	int back = 0;
	

	public void push(int n) {
		arr[back++] = n;
	}

	public int pop() {
		if(isEmpty()) return -1;
		int n = arr[front];
		front++;
		return n;
	}

	public int size() {
		return back - front;
	}

	private boolean isEmpty() {
		if(front == back) return true;
		else return false;
	}
	
	public int empty() {
		if (isEmpty()) return 1;
		else return 0;
	}

	public int front() {
		if (isEmpty()) return -1;
		else return arr[front];
	}

	public int back() {
		if (isEmpty()) return -1;
		else return arr[back-1];
	}
}