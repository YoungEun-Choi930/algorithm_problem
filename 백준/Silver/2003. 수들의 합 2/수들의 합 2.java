import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// solve
		// 투포인터
		int p1 = 0;
		int p2 = 1;
		int sum = arr[0];
		int result = sum == M ? 1 : 0; 	//경우의수
		
		while(true) {

			// sum이 M보다 큰 경우
			if(sum > M) {
				// p1 값을 뺀다.
				sum -= arr[p1++];
			}
			// 작은 경우
			else {
				if(p2 == N) break;
				// p2 값을 더한다.
				sum += arr[p2++];
			}
			
			if(sum == M) result++;
		}
		
		System.out.println(result);
	}
}
