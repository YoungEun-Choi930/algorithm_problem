import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static final int INF = 1001;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] D = new int[N];
		Arrays.fill(D, INF);
		D[0] = arr[0];
		int result = 0;
		
		for(int i = 1 ; i < N; i++) {

			int n = Arrays.binarySearch(D, arr[i]);
			if(n < 0) n = n * -1 - 1;
			D[n] = arr[i];
			result = n > result ? n : result;
		}
		System.out.println(result+1);
	}
}
