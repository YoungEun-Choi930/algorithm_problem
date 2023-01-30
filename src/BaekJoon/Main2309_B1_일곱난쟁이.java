package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2309_B1_일곱난쟁이 {
	static int[] tall = new int[9];
	static boolean[] who = new boolean[9];
	static boolean[] result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0 ; i < tall.length; i++) {
			tall[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(tall);
		Arrays.fill(who, false);
		find(0,0,0);
		
		
		for(int i = 0 ; i < result.length; i++) {
			if(result[i])
				System.out.println(tall[i]);
		}
	}
	
	private static void find(int sum, int count, int index) {
		
		if(index == tall.length &&  count == 7 && sum == 100) {
			result = Arrays.copyOf(who, 9);
			return;
		}
		
		if(index < tall.length && count <= 7) {
		
			//no check
			who[index] = false;
			find(sum, count, index+1);
		
			//check
			who[index] = true;
			find(sum + tall[index], count+1, index+1);
		}
		
	}
}
