package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main11047 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[] value = new int[N];
		for(int i = 0 ; i < N ; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		for(int i = N-1; i >= 0; i--) {
			if(K / value[i] > 0) {
				result += K / value[i];
				K = K % value[i];

				if(K == 0) break;
			}
		}
		
		System.out.println(result);
	}
}
