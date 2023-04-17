import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] D = new long[101];
		D[1] = 1;
		D[2] = 1;
		D[3] = 1;
		D[4] = 2;
		
		for(int i = 5; i <= 100 ; i++) {
			D[i] = D[i-5] + D[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 0 ; tc < T ; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(D[n]).append('\n');
		}
		System.out.println(sb);
	}
}
