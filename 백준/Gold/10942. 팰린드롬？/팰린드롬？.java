import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N+1];
        for(int i = 1; i <= N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        // solve
        boolean[][] isPalindrom = new boolean[N+1][N+1];
        // 길이가 1일때
        for(int i = 1 ; i <= N ; i++) isPalindrom[i][i] = true;
        // 길이가 2일때
        for(int start = 1 ; start < N ; start++) {
            if(arr[start] == arr[start+1]) isPalindrom[start][start+1] = true;
        }
        // 길이가 len 일때
        for(int len = 3 ; len <= N ; len++) { // 문자열의 길이
            for(int start = 1 ; start+len-1 <= N ; start++) {    //시작점
                int end = start + len - 1;
                boolean isp = arr[start] == arr[end];

                if(isp && isPalindrom[start+1][end-1]) isPalindrom[start][end] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(isPalindrom[S][E]?'1':'0').append('\n');
        }
        System.out.println(sb);
    }
}
