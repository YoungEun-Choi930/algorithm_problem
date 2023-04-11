import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] D = new int[N];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        
        for(int i = 1 ; i < N ; i++) {
        	while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        		D[stack.pop()] = arr[i];
        	}
        	
        	stack.push(i);
        }
        
        for(int j = 0 ; j < N; j++) {
        	sb.append(D[j]==0 ? -1 : D[j]).append(' ');
        }
        System.out.println(sb);
    }
}