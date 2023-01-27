package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14888 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		br.readLine(); //N
		String[] input = br.readLine().split(" ");
		String[] oper = br.readLine().split(" ");
		
		number = new int[input.length];
		used = new boolean[input.length];
		for(int i = 0 ; i < input.length; i++) {
			number[i] = Integer.parseInt(input[i]);
		}
		
		for(int i = 0 ; i < 4 ; i++) {
			operator[i] = Integer.parseInt(oper[i]);
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		//solve
//		for(int idx = 0 ; idx < number.length; idx++) {
//			 calculate(idx, number[idx], 1);
//		}
		calculate(1, number[0], 1);
		
		System.out.println(min);
		System.out.println(max);
	}
	
	private static int[] number;
	private static boolean[] used;
	
	private static int[] operator = new int[4];		// + - * /
	
	private static int min, max;
	
	private static void calculate(int index, int sum, int depth) {
		
		if(depth == number.length) {
			if(sum < min) min = sum;
			if(sum > max) max = sum;
			return;
		}
		//연산자 
		for(int op = 0 ; op < 4; op++) {
			if(operator[op] == 0) continue;
			operator[op]--;
			
			int s = sum;
			switch(op) {
			case 0 : s += number[index]; break;
			case 1 : s -= number[index]; break; 
			case 2 : s *= number[index]; break;
			case 3 : s /= number[index]; break;
			}
			
			calculate(index+1, s, depth+1);
			operator[op]++;
		} //end
		/*
		//dfs
		for(int i = 0 ; i < number.length ; i++) {
			if(used[i])
				continue;
			else {
				used[i] = true;
				
				//연산자 
				for(int op = 0 ; op < 4; op++) {
					if(operator[op] == 0) continue;
					operator[op]--;
					
					int s = sum;
					switch(op) {
					case 0 : s += number[i]; break;
					case 1 : s -= number[i]; break; 
					case 2 : s *= number[i]; break;
					case 3 : s /= number[i]; break;
					}
					
					calculate(i, sum + number[i], depth+1);
					operator[i]++;
				} //end
				
				used[i] = false;
			} //else
		} //for
		*/
		
	}
}
