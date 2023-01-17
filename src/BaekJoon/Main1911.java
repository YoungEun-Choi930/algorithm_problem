package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main1911 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int L = Integer.parseInt(in[1]);
		
	
		int[][] input = new int[N][2];
		
		
		for(int i = 0 ; i < N; i++) {
			in = br.readLine().split(" ");
			int start = Integer.parseInt(in[0]);
			int end = Integer.parseInt(in[1]);
			input[i][0] = start;
			input[i][1] = end;
			
		}
		
		//정렬
		Arrays.sort(input, (a, b) -> {
			return a[0] - b[0];
		});

		
		//필요한 널빤지
		
		int curIndex= input[0][0];
		int countResult = 0;
		for(int i = 0 ; i < N; i++) {
			int start = input[i][0];
			int end = input[i][1];
			
			if(curIndex < start) curIndex = start;
			
			while(curIndex >= start && curIndex < end) {
				curIndex += L;
				countResult++;
			}
		}
		
		System.out.println(countResult);
		
		
		
	}
	
	
}
