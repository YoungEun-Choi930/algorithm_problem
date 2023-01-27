package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14888 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		String[] input = br.readLine().split(" ");
		String[] oper = br.readLine().split(" ");
		
		int[] number = new int[input.length];
		for(int i = 0 ; i < input.length; i++) {
			number[i] = Integer.parseInt(input[i]);
		}
		
		int[] operator = new int[4]; // + - x / 
		for(int i = 0 ; i < 4 ; i++) {
			operator[i] = Integer.parseInt(oper[i]);
		}
		
		//solve
		
	}
}
