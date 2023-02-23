package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579_S3_계단오르기 {
	private static int result, N;
	private static int[] array;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		result = 0;
		int[] sumarray = new int[N];
		sumarray[0] = array[0];
		for(int i = 1; i < N ; i++) {
			int n1 = array[i];
			if(i > 2) n1 += sumarray[i-2];
			
			int n2 = array[i] + array[i-1];
			if(i > 3) n2 += sumarray[i-3];
			
			sumarray[i] = Math.max(n1,n2);
		}
		
		System.out.println(sumarray[N-1]);
	}

}
