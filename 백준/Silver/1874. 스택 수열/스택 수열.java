import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//solve
		StringBuilder result = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int counter = 1;
		int pointer = 0;
		boolean flag = true;
		
		while(pointer < N) {
			
			// 현재 출력할 값이 stack값보다 크다면 stack에 push
			if(arr[pointer] >= stack.peek()) {
				
				while(counter <= arr[pointer]) {
					stack.push(counter++);
					result.append("+\n");
				}
				
				// 같을땐 빼기
				stack.pop();
				result.append("-\n");
				pointer++;
				
			}
			
			// stack의 최상단보다 작은값을 출력해야한다면 불가능하다!
			else {
				flag = false;
				break;
			}
		}
		
		// output
		if(flag) System.out.println(result);
		else System.out.println("NO");
	}
}
