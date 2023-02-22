package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14500_G4_테트로미노 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력파일 객체화
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);        //(4 ≤ N, M ≤ 500)
        int M = Integer.parseInt(input[1]);
        
        int[][] map = new int[N+1][M+1];
        for(int i = 1 ; i <= N ; i++ ) {
            input = br.readLine().split(" ");
            for(int j = 1 ; j <= M ; j++) {
                int n = Integer.parseInt(input[j-1]);
                map[i][j] = n;
            }
        }

        // solve
        int ans = 0;
        int n = 0;
        
        for(int i = 1; i <= N ; i++) {    //가로
            for(int j = 1 ; j <= M ; j++) {
                
                // 1. ㅁㅁㅁㅁ 가로 세로
                if(j > 3) {
                	n = map[i][j] + map[i][j-1] + map[i][j-2] + map[i][j-3];
                    ans = Math.max(ans, n);
                }
                if(i > 3) {
                	n = map[i][j] + map[i-1][j] + map[i-2][j] + map[i-3][j];
                    ans = Math.max(ans, n);
                }
                
                // ㅁㅁ
                // ㅁㅁ
                if(i > 1 && j > 1) {
                    n = map[i][j] + map[i][j-1] + map[i-1][j-1] + map[i-1][j];
                    ans = Math.max(ans, n);
                }
                
                // ㅁ           ㅁㅁ
                // ㅁㅁ        ㅁㅁ
                //  ㅁ
                if(i > 2 && j > 1) {
                    n = map[i-1][j-1] + map[i-1][j];
                    ans = Math.max(ans, n + map[i][j-1] + map[i-2][j]);
                    ans = Math.max(ans, n + map[i][j] + map[i-2][j-1]);
                }
                
                if(i > 1 && j > 2) {
                    n = map[i][j-1] + map[i-1][j-1];
                    ans = Math.max(ans, n + map[i][j] + map[i-1][j-2]);
                    ans = Math.max(ans, n + map[i][j-2] + map[i-1][j]);
                }
                
                // ㅁㅁㅁ        ㅁㅁㅁ
                //  ㅁ          ㅁ
                if(j > 2) {
                    n = map[i][j] + map[i][j-1] + map[i][j-2];
                    
                    if(i > 1) ans = Math.max(ans, n+map[i-1][j-1]);    	//위
                    if(i < N) ans = Math.max(ans, n+map[i+1][j-1]);    	//아래
                    
                    if(i > 1) ans = Math.max(ans, n+map[i-1][j]);    	//위
                    if(i > 1) ans = Math.max(ans, n+map[i-1][j-2]);    	//위
                    if(i < N) ans = Math.max(ans, n+map[i+1][j]);    	//아래
                    if(i < N) ans = Math.max(ans, n+map[i+1][j-2]);    	//아래
                }
                // ㅁ	ㅁ
                // ㅁㅁ	ㅁ
                // ㅁ	ㅁㅁ
                if(i > 2) {
                    n = map[i][j] + map[i-1][j] + map[i-2][j];
                    
                    if(j > 1) ans = Math.max(ans, n+map[i-1][j-1]);    	//좌
                    if(j < N) ans = Math.max(ans, n+map[i-1][j+1]);    	//우
                    
                    if(j > 1) ans = Math.max(ans, n+map[i-2][j-1]);    	//좌
                    if(j > 1) ans = Math.max(ans, n+map[i][j-1]);		//좌
                    if(j < N) ans = Math.max(ans, n+map[i-2][j+1]);    	//우
                    if(j < N) ans = Math.max(ans, n+map[i][j+1]);    	//우
                }
                
                
            }
        }
        

        // 출력
        System.out.println(ans);
    }
}