import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);	//트럭수
		int W = Integer.parseInt(in[1]);	//다리길이
		int L = Integer.parseInt(in[2]);	//다리 최대 하중
		
		in = br.readLine().split(" ");
		int[] truck = new int[N];
		for(int i = 0 ; i < N ; i++) truck[i] = Integer.parseInt(in[i]);
		
		System.out.println(minTime(N,W,L,truck));		
	}

	private static int minTime(int n, int w, int l, int[] truck) {

		Queue<int[]> queue = new ArrayDeque<>();	// 트럭 무게, 위치
		int waitting = 0;	//기다리고 있는 트럭의 idx
		int cnt = 0;	// 통과 완료한 트럭의 개수
		int time = 1;
		
		queue.offer(new int[] {truck[waitting++], 0});
		
		while(cnt < n) {
			
			// 1. 이동
			// 위치를 한 칸씩 이동시킨다. 현재 다리 위에 있는 트럭의 무게를 계산한다.
			int wsum = 0;
			Queue<int[]> cur = new ArrayDeque<>();
			while(!queue.isEmpty()) {
				int[] tr = queue.poll();
				if(++tr[1] == w) {	// 다리를 도착했음
					cnt++;
				}
				else {
					wsum += tr[0];
					cur.offer(tr);
				}
			}
			
			// 2. 추가
			// 다음 트럭이 다리에 올라도 최대하중보다 작다면 출발한다.
			if(waitting < n && wsum + truck[waitting] <= l) {
				cur.offer(new int[] {truck[waitting++], 0});
			}
			
			// 다음 초
			time++;
			queue = cur;
		}
		
		
		return time;
	}
}
