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

        List<Name> names = new ArrayList<>();
        HashSet<Integer> checkduplicate = new HashSet<>();

        for(int i = 0 ; i < N ; i++) {
            in = br.readLine().split(" ");
            int m = Integer.parseInt(in[1]);
            if(!checkduplicate.contains(m)) {
                checkduplicate.add(m);
                Name n = new Name(in[0], m);
                names.add(n);
            }
        }

        Collections.sort(names);
        // list to arr
        int s = 0;
        Name[] arr = new Name[names.size()];
        for(Name n : names) {
            arr[s++] = n;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < M ; i++) {
            int num = Integer.parseInt(br.readLine());
            Name comp = new Name("", num);
            int n = Arrays.binarySearch(arr,comp);

            if(n < 0) {
                n *= (-1);
                n--;
            }
            sb.append(arr[n].name).append("\n");
        }
        System.out.println(sb);
    }
}
