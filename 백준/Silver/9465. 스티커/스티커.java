import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static int[][] scores, D;
	private static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc < T ; tc++) {
			n = Integer.parseInt(br.readLine());
			
			scores = new int[2][];
			scores[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			scores[1] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			D = new int[2][n+1];
			D[0][1] = scores[0][0];
			D[1][1] = scores[1][0];
			if(n != 1) {
				D[0][2] = D[1][1] + scores[0][1];
				D[1][2] = D[0][1] + scores[1][1];
			}
			
			int r1, r2;
			for(int i = 3 ; i <= n ; i++) {

				r1 = D[0][i-2] > D[0][i-3] ? D[0][i-2] : D[0][i-3];
				r2 = D[1][i-1] > D[1][i-2] ? D[1][i-1] : D[1][i-2];
				D[0][i] = (r1 > r2 ? r1 : r2) + scores[0][i-1];

				r1 = D[1][i-2] > D[1][i-3] ? D[1][i-2] : D[1][i-3];
				r2 = D[0][i-1] > D[0][i-2] ? D[0][i-1] : D[0][i-2];
				D[1][i] = (r1 > r2 ? r1 : r2) + scores[1][i-1];
			}
			
			int max = 0;
			for(int i = 0 ; i < 2; i++) {
				for(int j = n-1; j <= n ; j++) {
					max = max > D[i][j] ? max : D[i][j];
				}
			}
			
			sb.append(max).append('\n');
		}
		System.out.println(sb);
	}

}
