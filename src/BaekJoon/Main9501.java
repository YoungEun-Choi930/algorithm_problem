package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main9501 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int D = Integer.parseInt(input[1]);
			
			int count = 0;
			for(int i = 0 ; i < N ; i ++) {
				input = br.readLine().split(" ");
				
				int v = Integer.parseInt(input[0]);
				int f = Integer.parseInt(input[1]);
				int c = Integer.parseInt(input[2]);
				
				//System.out.println("d*v: "+ (D/(double)v) +" / f/c: "+(f/(double)c));
				
				if((D/(double)v) <= f/(double)c) count++;
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb);
	}
}
