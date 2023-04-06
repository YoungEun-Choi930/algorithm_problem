import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int[] array;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(array);
		
		int M = Integer.parseInt(br.readLine());
		String[] input= br.readLine().split(" ");
		for(int i = 0 ; i < M ; i++) {
			int n = Integer.parseInt(input[i]);
			
			sb.append(find(n)).append(' ');
		}
		
		System.out.println(sb);
	}

	private static int find(int n) {
		
		int start = 0;
		int end = array.length;
		int idx;
		
		while(true) {
			idx = start + (end-start)/2;
			if(array[idx] == n) return 1;
			else if(array[idx] < n) {
				start = idx+1;
			}
			else {
				end = idx;
			}
			if(end == start) break;
		}
		
		return 0;
	}
}
