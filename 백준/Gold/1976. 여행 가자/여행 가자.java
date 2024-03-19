import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        boolean[][] adjMatrix = new boolean[N+1][N+1];
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++) {
                adjMatrix[i][j] = st.nextToken().equals("1");
            }
        }

        int[] parent = new int[N+1];
        for(int i = 1; i <= N ; i++) parent[i] = i;

        for(int i = 1; i <= N ; i++) {
            int a = parent[i] = getParent(parent, i);

            for(int j = 1 ; j <= N ; j++) {
                if(adjMatrix[i][j]) {
                    int b = getParent(parent, j);

                    if(a != b) parent[b] = parent[j] = a;
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        int team = getParent(parent,t);
        boolean result = true;
        while(st.hasMoreTokens()) {
            t = Integer.parseInt(st.nextToken());
            if(team != getParent(parent,t)) {
                result = false;
                break;
            }
        }
        System.out.println(result?"YES":"NO");
    }

    private static int getParent(int[] parent, int i) {
        if(parent[i] == i) return i;
        return parent[i] = getParent(parent, parent[i]);
    }
}
