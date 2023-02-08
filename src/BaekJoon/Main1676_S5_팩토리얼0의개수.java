package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1676_S5_팩토리얼0의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ten = 0;
		int five = 0;
		int two = 0;
		for(int i = 2; i <= N ; i++) {
			int temp = i;
			while(temp % 10 == 0) {
				ten++;
				temp /= 10;
			}
			while(temp % 5 == 0) {
				five++;
				temp /= 5;
			}
			while(temp % 2 == 0) {
				two++;
				temp /= 2;
			}
			
		}
		
		int result = ten;
		
		result += Math.min(two, five);
		
		System.out.println(result);
	}
}
