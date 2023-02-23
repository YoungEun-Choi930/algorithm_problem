import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		// solve
		if(N == K) {
			System.out.println(0);
			return;
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[100_001];
		queue.offer(N);
		visited[N] = true;
		
		int time = 0;
		
		loop : while(!queue.isEmpty()) {
			int size = queue.size();
			time++;
			for(int i = 0 ; i < size; i++) {
				int point = queue.poll();
				
				// 이동하기
				if(point + 1 == K) break loop;
				else if(point+1 <= 100_000 && !visited[point+1]) {
					queue.offer(point+1);
					visited[point+1] = true;
				}
				
				if(point -1 == K) break loop;
				else if(point - 1 >= 0 && !visited[point-1]) {
					queue.offer(point -1);
					visited[point-1] = true;
				}
				
				if(point*2 == K) break loop;
				else if(point*2 <= 100_000 && !visited[point*2]) {
					queue.offer(point*2);
					visited[point*2] = true;
				}
				
			}
			
		}

		// 출력
		System.out.println(time);
	}
}