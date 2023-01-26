package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		//solve
		
		Stack<Object> stack = new Stack<Object>();
		stack.push(input.charAt(0));

		boolean flag = false;
		int length = input.length();
		for(int i = 1 ; i < length ; i++) {
			char cur = input.charAt(i);
			if(cur == '(' || cur == '[') {
				stack.push(cur);
				continue;
			}
			
			//cur == ) , ] 인 경우
			int value = 0;
			if(stack.isEmpty()) {
				flag = true;
				break;
			}
			Object peek = stack.peek();
			
			while(peek instanceof Number) {
				int n = (int) stack.pop();
				value += n;
				if(stack.isEmpty()) {
					flag = true;
					break;
				}
				peek = stack.peek();
			}

			char peekc = '0';
			if(peek instanceof Character)
				peekc = (char) peek;
			
			if(peekc == '(' && cur == ')') {
				stack.pop();
				if(value == 0) value = 2;
				else value *= 2;
				stack.push(value);
			}
			else if(peekc == '[' && cur == ']') {
				stack.pop();
				if(value == 0) value = 3;
				else value *= 3;
				stack.push(value);
			}
			else {
				flag = true;
			}
			
			if(flag) break;
			
		}
		
		int result = 0;
		while(!stack.isEmpty()) {
			Object o = stack.pop();
			if(o instanceof Number) {
				result += (int) o;
			}
			else {
				result = 0;
				break;
			}
		}
		
		System.out.println(result);
		
		
		
	}
}
