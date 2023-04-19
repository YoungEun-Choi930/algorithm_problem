import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final int INF = 100_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);
		
		int[] D = new int[K+1];
		for(int i = 0 ; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n <= K) D[n] = 1;
		}

		for(int i = 1; i <= K ; i++) {
			int min = INF;
			if(D[i] == 1) continue;
			for(int j = 1 , h = i / 2; j <= h ; j++) {
				min = Math.min(min, D[j] + D[i-j]);
			}
			D[i] = min;
		}
		
		if(D[K] >= INF) System.out.println(-1);
		else System.out.println(D[K]);
	}
}
