import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Name implements Comparable<Name>{
        String name;
        int max;

        public Name(String name, int max) {
            this.name = name;
            this.max = max;
        }

        @Override
        public int compareTo(Name o) {
            return this.max - o.max;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        Name[] names = new Name[N];

        for(int i = 0 ; i < N ; i++) {
            in = br.readLine().split(" ");
            Name n = new Name(in[0], Integer.parseInt(in[1]));
            names[i] = n;
            if(i!=0 && names[i].max == names[i-1].max) names[i].name = names[i-1].name;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < M ; i++) {
            int num = Integer.parseInt(br.readLine());
            Name comp = new Name("", num);
            int n = Arrays.binarySearch(names,comp);

            if(n < 0) {
                n *= (-1);
                n--;
            }
            sb.append(names[n].name).append("\n");
        }
        System.out.println(sb);
    }
}
