package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463_S3_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int M = N+1;
		if(N < 6) M = 6;
		
		int[] array = new int[M];
		array[2] = 1;	//-1, %2
		array[3] = 1;	//%3
		array[4] = 2;	//%2%2
		array[5] = 3;	//-1%2%2, -1-1%3
		
		for(int i = 6 ; i <= N ; i++) {
			int n1 = Integer.MAX_VALUE;
			if(i%3 == 0) n1 = array[i/3];
			
			int n2 = Integer.MAX_VALUE;
			if(i%2 == 0) n2 = array[i/2];
			
			int n3 = array[i-1];	//-1
			
			n1 = Math.min(n1, n2);
			n1 = Math.min(n1, n3);
			
			array[i] = n1+1;
		}
		
		
		
		System.out.println(array[N]);
	}
	
}
