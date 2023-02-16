package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1218_D4_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {

			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			
			int result = isValid(N, s);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int isValid(int length, String str) {
		
		Stack<Character> stack = new Stack<>();
		for(int idx = 0 ; idx < length ; idx++) {
			char cur = str.charAt(idx);
			
			if(cur == '(' || cur == '[' || cur == '{' || cur == '<') {
				stack.push(cur);
				continue;
			}
			
			//닫힘괄호일때
			if(stack.isEmpty()) {
				return 0;
			}
			
			char pre = stack.pop();
			if(pre == '(' && cur == ')') {
				continue;
			}
			else if(pre == '[' && cur == ']') {
				continue;
			}
			else if(pre == '{' && cur == '}') {
				continue;
			}
			else if(pre == '<' && cur == '>') {
				continue;
			}
			else {
				return 0;
			}
		}
		
		//다 돌고 나와서
		if(!stack.isEmpty())
			return 0;
		
		return 1;
	}
}
