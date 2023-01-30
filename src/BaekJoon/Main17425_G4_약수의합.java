package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main17425_G4_약수의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// init array
		long[] funG = new long[1_000_001];
		funG[1] = 1;
		
        
//		/*
		// 열심히 머리 굴려본 코드 근데 틀림
		for(int idx = 2; idx < 1_000_001 ; idx++) {
			int funF = 0;
			double sqrt = Math.sqrt(idx);
			
			// 제곱근까지만 for문을 돌려 약수를 구한다.
			for(int cnt = 1; cnt <= sqrt ; cnt++) {	//cnt*cnt <= idx 이런식으로 써도 괜찮다!!
				if(idx % cnt != 0) continue;
				int d = idx / cnt;
				
				if(d == cnt) funF += d;
				else funF += d + cnt;
				//sb.append("("+cnt+","+d+"),");
			}
			
			// g(x) = g(x-1) + f(x)
			funG[idx] = funG[idx-1] + funF;
			//sb.append("\n g:").append(funG[idx]).append("\n f :").append(funF).append("\n");
		}
//		*/
		

		// 인터넷 코드
//		/*
		Arrays.fill(funG, 1);
		
		for (int i = 2; i < 1_000_001; i++){
            for (int j = 0; j * i < 1_000_001; j++){
            	funG[j * i] += i;
            }
            funG[i] += funG[i-1];
            if(i <100)
            	System.out.println(funG[i]);
        }
//		*/
		
		//input
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(funG[N]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
