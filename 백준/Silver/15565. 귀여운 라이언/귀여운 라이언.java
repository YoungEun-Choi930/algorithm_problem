import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// solve
		int lion = 1;
		Queue<Integer> apeach = new ArrayDeque<>();
		int cnt = 0;
		int minSetSize = Integer.MAX_VALUE;
		int curSetSize = 1;
		
		// 첫번째 1 찾기. 그 앞에 2는 쓸모없으니까.
		int i = 0;
		for( ; i < N ; i++) 
			if(arr[i] == 1) break;
		
		// 해당 1 다음 부터 계산.
		// 만약 1이 존재하는데 K가 1인경우
		if(++i <= N && K == 1) minSetSize = 1;
		
		for( ; i < N ; i++) {
			cnt++;
			if(arr[i] == 1 && ++lion < K) {	//K개의 라이언을 만드는 중
				apeach.offer(cnt);
				curSetSize += cnt;
				cnt = 0;
			}
			else if(arr[i] == 1) {
				apeach.offer(cnt);
				curSetSize += cnt;
				cnt = 0;
				
				// 검사
				if(curSetSize < minSetSize) minSetSize = curSetSize;
				curSetSize -= apeach.poll();
			}
			
		}
		
		if(minSetSize == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minSetSize);
	}
}
