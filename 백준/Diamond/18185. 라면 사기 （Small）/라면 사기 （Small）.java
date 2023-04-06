import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// solve
		int resultSum = 0;
		for(int i = 0 ; i < N; i++) {
			if(inputArr[i] == 0) continue;
			
			//1. 연속되는 부분 찾기
			int len = 1;
			for(int j = i+1 ; j < N && j < i+5; j++) {
				if(inputArr[j] == 0) break;
				len++;
			}
			
			if(len > 3) {
				// 1. 2-3 경우니까 2개 사기
				if(inputArr[i+1] > inputArr[i+2]) {
					int dif = inputArr[i+1] - inputArr[i+2];
					dif = dif < inputArr[i] ? dif : inputArr[i];
					
					resultSum += dif * 5;
					inputArr[i] -= dif;
					inputArr[i+1] -= dif;
					
					if(inputArr[i] != 0) len = 3;
				}
				// 2. 3-2 경우니까 그냥 3개 사는거랑 같음.
				else {
					len = 3;
				}
			}
			
			if(len == 3) {

				int min = inputArr[i] < inputArr[i+1] ? inputArr[i] : inputArr[i+1];
				min = min < inputArr[i+2] ? min : inputArr[i+2];
				
				resultSum += min * 7;
				inputArr[i] -= min;
				inputArr[i+1] -= min;
				inputArr[i+2] -= min;
				
				if(inputArr[i] != 0) {
					if(inputArr[i+1] != 0) len = 2;
					else len = 1;
				}
			}
			
			if(len == 2) {
				int min = inputArr[i] < inputArr[i+1] ? inputArr[i] : inputArr[i+1];
				
				resultSum += min * 5;
				inputArr[i] -= min;
				inputArr[i+1] -= min;
				
				if(inputArr[i] != 0) len = 1;
			}
			
			if(len == 1) {
				resultSum += inputArr[i] * 3;
			}
		}
		
		
		System.out.println(resultSum);
	}
}
