import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int r = Integer.parseInt(in[0]);
		int c = Integer.parseInt(in[1]);
		
		int[][] map = new int[r+1][c+1];
		for(int i = 1 ; i <= r ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1 ; j <= c ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// solve
		for(int i = 1 ; i <= r ; i++) {
			for(int j = 1; j <= c ; j++) {
				int max = map[i-1][j] > map[i][j-1] ? map[i-1][j] : map[i][j-1];
				max = max > map[i-1][j-1] ? max : map[i-1][j-1];
				
				map[i][j] += max;
			}
		}
		
		System.out.println(map[r][c]);
	}
}
