import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int middle = n;
        sb.append(middle).append("\n");

        for(int i = 1; i < N ; i++) {
            n = Integer.parseInt(br.readLine());
            if(n >= middle) right.add(n);
            else left.add(n);

            if(i%2==0 && right.size() > left.size()) {
                left.add(middle);
                middle = right.poll();
            }
            else if(i%2==1 && right.size() -1 > left.size()){
                left.add(middle);
                middle = right.poll();
            }
            else if(left.size() > right.size()) {
                right.add(middle);
                middle = left.poll();
            }

            sb.append(middle).append("\n");
        }
        System.out.println(sb);
    }
}
