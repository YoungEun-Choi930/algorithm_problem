import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int[] numbers, D;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N+2];
		for(int i = 1 ; i <= N; i++) numbers[i] = Integer.parseInt(br.readLine());
		
		
		D = new int[N+2];
		D[1] = numbers[1];
		D[2] = D[1] + numbers[2];
		
		maxStair(N);
		
		System.out.println(D[N]);
	}

	private static int maxStair(int cur) {

		if(cur <= 2) {
			return D[cur];
		}
		
		
		if(D[cur] == 0) {
			D[cur] = Math.max(maxStair(cur-2) + numbers[cur], 
								maxStair(cur-3) + numbers[cur-1] +numbers[cur]);
		}
		return D[cur];
	}
}
