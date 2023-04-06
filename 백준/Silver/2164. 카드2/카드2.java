import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		int N = Integer.parseInt(br.readLine());	//(1 ≤ N ≤ 500,000)

		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		// 1이 아니면 큐를 만든다.
		Deque<Integer> queue = new ArrayDeque<>(N);
		for(int i = 2; i <= N ; i++) {	//1 이후부터
			queue.addLast(i);
		}
		
		// solve
		int size = N-1;
		while(size-- > 1) {
			queue.addLast(queue.pollFirst());
			queue.pollFirst();
		}
		
		// 출력
		System.out.println(queue.poll());
	}
}
