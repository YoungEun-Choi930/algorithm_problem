import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// input
		Queue<Integer> manPlus = new PriorityQueue<>();
		Queue<Integer> manMinus = new PriorityQueue<>((o1,o2)->o2-o1);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n > 0) manPlus.offer(n);
			else manMinus.offer(n);
		}
		
		Queue<Integer> womanPlus = new PriorityQueue<>();
		Queue<Integer> womanMinus = new PriorityQueue<>((o1,o2)->o2-o1);
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N ; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n > 0) womanPlus.offer(n);
			else womanMinus.offer(n);
		}
		
		// solve
		int cnt = pair(manPlus, womanMinus);
		cnt += pair(womanPlus, manMinus);
		
		System.out.println(cnt);
	}

	private static int pair(Queue<Integer> plus, Queue<Integer> minus) {
		int cnt = 0;
		
		while(!plus.isEmpty() && !minus.isEmpty()) {
			int p = plus.poll();
			int m = minus.poll();
			m *= -1;
			
			if(p < m) cnt++;
			else {
				plus.offer(p);	// 다시 확인하도록 큐에 넣음.
			}
		}
		
		return cnt;
	}
} 
