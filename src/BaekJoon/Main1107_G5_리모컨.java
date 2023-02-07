package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1107_G5_리모컨 {
	private static boolean[] possible;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());	// (0 ≤ N ≤ 500,000)
		int M = Integer.parseInt(br.readLine());

		
		possible = new boolean[10];
		Arrays.fill(possible, true);
		
		if(M != 0) {	//여기 생각지도 못함
			String[] input = br.readLine().split(" ");
		
			for(int i = 0 ; i < M ; i++) {
				possible[Integer.parseInt(input[i])] = false;
			}
		}
		
		//solve
		/*
		 * 경우의 수
		 * 1. 100번에서 위아래만 누르고 가기
		 * 2. 숫자로 눌러서 가기
		 * 3. 숫자로 누르고 위로이동/ 아래로 이동
		 * 3풀이 bfs??
		 */
		
		//1.
		int result1 = Math.abs(N-100);
		System.out.println("11111111 "+result1);
		//2.
		int result2 = isPossible(N);
		System.out.println("22222222 "+result2);

		if(M != 10) {
		//3.
			if(result2 == Integer.MAX_VALUE) {
				System.out.println("----");
				int cnt =1;
				int n1 = 0;
				while(true) {
					if(N-cnt >= 0) n1 = isPossible(N-cnt);
					if(n1 != Integer.MAX_VALUE) {
						result2 = n1 + cnt;
						System.out.println(N-cnt+"-break");
						break;
					}
					n1 = isPossible(N+cnt);
					if(n1 != Integer.MAX_VALUE) {
						result2 = n1 + cnt;
						System.out.println(N+cnt+"-break");
						break;
					}
					
					if(cnt > result1) break;
					cnt++;
				}
			
			}
		}
		
		System.out.println(Math.min(result1, result2));
		
	}
	
	private static int isPossible(int num) {
		if(num == 0) {
			if(possible[0]) return 1;
			else return Integer.MAX_VALUE;
		}
		int result2 = 0;
		int tempN = num;
		while(tempN > 0) {
			int t = tempN % 10;
			if(possible[t]) {
				result2++;
				tempN = tempN / 10;
			}
			else {
				return Integer.MAX_VALUE;
			}
		}
		
		return result2;
	}
	
	
}
