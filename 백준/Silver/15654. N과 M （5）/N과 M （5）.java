import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int[] arr;
	private static int N, M;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		combi(0, 0, new int[M]);
		
		System.out.println(sb);
	}

	private static void combi(int flag, int cnt, int[] selected) {
		if(cnt == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
			
			return;
		}
		
		for(int i = 0; i < N ; i++) {
			if((flag & (1<<i)) != 0) continue;
			selected[cnt] = arr[i];
			combi(flag | (1<<i) , cnt+1, selected);
		}
	}
}
