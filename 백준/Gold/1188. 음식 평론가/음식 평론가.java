import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);
		
		int result = 0;
		if(N % M != 0) {
			result = M-1 - (GCD(N,M) -1);
		}
		
		System.out.println(result);
	}

	private static int GCD(int n, int m) {

		while(m != 0) {
			int t = n % m;
			n = m;
			m = t;
		}
		return n;
	}
}
