package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9095_S3_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//11 보다 작다
		int[] resultarray = new int[11];
		resultarray[1] = 1;
		resultarray[2] = 2;
		resultarray[3] = 4;
		
		for(int i = 4; i < 11; i++) {
			int n = 0;
			n += resultarray[i-1];
			n += resultarray[i-2];
			n += resultarray[i-3];
			
			resultarray[i] = n;
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(resultarray[N]).append("\n");
		}
		System.out.println(sb);
	}
}
