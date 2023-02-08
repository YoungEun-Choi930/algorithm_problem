package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2805_D3_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			char[][] map = new char[N][N];
			
			for(int i = 0 ; i < N ; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int middle = N / 2;
			int result = 0;
			
			for(int i = 0 ; i < N ; i++) {
				int start = middle - i;
				int end = middle + i;
				
				if(i > middle) {
					start = i - middle;
					end = N -1 -i + middle;
				}
				
				//System.out.println(start+","+end);
				for(int j = start ; j <= end ; j++) {
					result += map[i][j]-'0';
				}
				//System.out.println(result);
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
