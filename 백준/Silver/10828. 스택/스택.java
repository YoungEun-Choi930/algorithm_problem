import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(--N >= 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            if(s.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                stack.push(n);
            }
            else if(s.equals("pop")) {
                if(stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.pop()).append("\n");
            }
            else if(s.equals("size")) sb.append(stack.size()).append("\n");
            else if (s.equals("empty")) {
                if(stack.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }
            else {
                if(stack.isEmpty()) sb.append("-1\n");
                else sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);

    }
}
