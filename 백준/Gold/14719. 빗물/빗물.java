import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int h = Integer.parseInt(in[0]);
		int w = Integer.parseInt(in[1]);

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// solve
		int result = 0;
		
		int pre = arr[0];
		for(int i = 1 ; i < w ; i++) {
			if(arr[i] > pre) {
				pre = arr[i];

			}
			else {
				int right = arr[i];
				for(int j = i+1 ; j < w ; j++) {
					if(arr[j] > right) {
						right = arr[j];
					}
					if(right >= pre) {
						right = pre;
						break;
					}
				}
				result += right - arr[i];
				
			}
		}
		
		
		System.out.println(result);
	}
}
