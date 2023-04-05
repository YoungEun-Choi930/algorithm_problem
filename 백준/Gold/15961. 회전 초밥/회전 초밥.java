import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    private static int N, D, K, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        
        N = Integer.parseInt(in[0]);    // 접시의 수
        D = Integer.parseInt(in[1]);    // 초밥의 가짓수
        K = Integer.parseInt(in[2]);    // 연속해서 먹는 접시의 수
        C = Integer.parseInt(in[3]);    // 쿠폰 번호
        
        int[] arr = new int[N];
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // solve
        int[] check = new int[D+1];
        int difCnt = 0;
        
        // 처음 K개 
        for(int i = 0 ; i < K ; i++) {
            if(check[arr[i]]++ == 0) difCnt++;
        }
        
        int maxCnt = difCnt;
        boolean rC = check[C] == 0 ? true : false;
        
        for(int i = K; i < N; i++) {
            // 앞에 것 빼기
            if(--check[arr[i-K]] == 0) --difCnt;
            
            // 현재 것 넣기
            if(++check[arr[i]] == 1) ++difCnt;
            
            // 최대값 갱신
            if(difCnt == maxCnt && !rC) rC = check[C] == 0 ? true : false;
            if(difCnt > maxCnt) {
            	maxCnt = difCnt;
            	rC = check[C] == 0 ? true : false;
            }
            
        }
        
        for(int i = 0 ; i < K; i++) {
            // 앞에 것 빼기
            if(--check[arr[N-K+i]] == 0) --difCnt;
            
            // 현재 것 넣기
            if(++check[arr[i]] == 1) ++difCnt;

            // 최대값 갱신
            if(difCnt == maxCnt && !rC) rC = check[C] == 0 ? true : false;
            if(difCnt > maxCnt) {
            	maxCnt = difCnt;
            	rC = check[C] == 0 ? true : false;
            }
        }
        
        if(rC) System.out.println(maxCnt+1);
        else System.out.println(maxCnt);
    }
}