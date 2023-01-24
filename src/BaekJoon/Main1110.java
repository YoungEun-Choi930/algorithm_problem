package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1110 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int number = N;
		int count = 0;
		
		while(true) {
			int a = number / 10;
			int b = number % 10;
			
			int n = b * 10 + (a+b)%10;
			count++;
			
			if(n == N) break;
			else {
				number = n;
			}
		}
		
		System.out.println(count);
	}
}
