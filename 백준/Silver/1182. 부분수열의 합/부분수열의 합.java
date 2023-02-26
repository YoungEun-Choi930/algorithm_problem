import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int[] array;
	private static int N, S, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);

		array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// solve
		result = 0;
		subset(0,0,0);

		System.out.println(result);
	}

	private static void subset(int count, int index, int sum) {
		if(index == N) return;


		if(sum + array[index] == S) {
			result++;
		}
		
		subset(count+1, index+1, sum + array[index]);
		subset(count,index+1, sum);

	}
}
