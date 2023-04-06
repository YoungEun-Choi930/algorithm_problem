import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				int t1 = o1, t2 = o2;
				if(o1 < 0) t1 *= -1;
				if(o2 < 0) t2 *= -1;
				
				if(t1 == t2) {
					return o1 - o2;
				}
				else {
					return t1 - t2;
				}
			}
		});
		
		// solve
		
		for(int i = 0 ; i < N ; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) {
				int g;
				if(queue.isEmpty()) g = 0;
				else g = queue.poll();
				sb.append(g).append("\n");
			}
			else {
				queue.offer(n);
			}
		}
		
		// 출력
		System.out.println(sb);
	}
}
