package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1233_D4_사칙연산유효성검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		/*
		 * 식이 되기 위해서는 위에는 무조건 연산자만 오고
		 * leaf node에만 숫자가 와야 한다.
		 */

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int result = 1;
			String[] input;
			for(int i = 1; i <= N ; i++) {
				input = br.readLine().split(" ");
				if(result == 0) continue; //이미 false면 입력만 다 받게
				
				// 자식 노드가 있는데 숫자 이면
				if(input.length == 4) {
					char command = input[1].charAt(0);
					if(command != '+' && command != '-' && command != '*' && command != '/') {
						result = 0;
					}
				}
				
				// leaf노드인데 연산자이면
				else {
					char number = input[1].charAt(0);
					if(number == '+' || number == '-' || number == '*' || number == '/') {
						result = 0;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
