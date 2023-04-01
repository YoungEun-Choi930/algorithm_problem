import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] list = new int[N+1];
		int pre = Integer.parseInt(input[0]);
		int cur;
		for(int i = 1 ; i < N; i++) {
			cur = Integer.parseInt(input[i]);
			if(pre > cur) list[i] = list[i-1] + 1;
			else list[i] = list[i-1];
			pre = cur;
		}
		list[N] = list[N-1];
		
		// Question
		int Q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int q = 0 ; q < Q; q++) {
			
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			int count = list[end-1] - list[start-1];
			
			sb.append(count).append('\n');
			
		}
		System.out.println(sb);
		
	}
}
