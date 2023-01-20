package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2225 {	//DP
	public static void main(String[] args) throws Exception{
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		N = Integer.parseInt(input.split(" ")[0]);
		K = Integer.parseInt(input.split(" ")[1]);
		
		//solve
		if(K==1) {
			System.out.println(1);
			return;
		}
		else if(K==2) {
			System.out.println(N+1);
			return;
		}
		
		solve();
		long result = arr[K][N];
		System.out.println(result%1000000000);
	}
	
	private static long[][] arr= new long[201][201];;	
	private static int N,K;
	
	private static void solve() {
		//1. 1개의 수로 N을 만드는 경우의 수 = 1;
		//   2개의 수로 N을 만드는 경우의 수 = N+1;
		for(int i = 0 ; i <N+1; i++) {
			//arr[1][i] = 1;	//굳이 필요는 없으니까
			arr[2][i] = i+1;
		}
		
		//2. K개의 수로 N을 만드는 경우의 수
		// [-1][]더하기
		//ex. [4][6] = [3][6]+[3][5]+[3][4]+[3][3]+[3][2]+[3][1]+[3][0]		[K][N]
		for(int i = 3; i < K+1; i++) { 			//k1
			long sum = 0;
			for(int j = 0 ; j < N+1; j++) {		//n
				sum += arr[i-1][j];
				sum %= 1000000000;
				arr[i][j] = sum;
			}
		}
	}
}
