package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1929_S3_소수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		boolean[] noprim = new boolean[M+1];	//false 로 초기화니까.
		noprim[1] = true;	//true면 아닌거임.
		
		int h = (int) Math.sqrt(M);
		for(int i = 2; i <= h ; i++) {
			
			for(int j = 2 ; i * j <= M ; j++) {
				noprim[i*j] = true;
			}
		}
		
		for(int n = N ; n <= M ; n++) {
			if(!noprim[n]) sb.append(n).append("\n");
		}
		
		System.out.println(sb);
	}
}
