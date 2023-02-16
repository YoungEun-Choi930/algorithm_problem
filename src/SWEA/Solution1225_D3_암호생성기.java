package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1225_D3_암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {

			br.readLine();	//tc번호
			String[] input = br.readLine().split(" ");
			
			int[] array = new int[8];
			for(int i = 0; i < 8; i++) {
				array[i] = Integer.parseInt(input[i]);
			}
			
			// solve
			int cnt = 1;
			int idx = 0;
			while(true)  {
				int get = array[idx] - cnt++;
				
				if(get <= 0) {
					array[idx] = 0;
					break;
				}
				
				array[idx++] = get;
				if(idx == 8) idx = 0;
				if(cnt == 6) cnt = 1; 
			}
			
			
			// 출력
			sb.append("#").append(tc);
			for(int i = idx+1 ; i < 8 ; i++) {
				sb.append(" ").append(array[i]);
			}
			for(int i = 0 ; i <= idx ; i++) {
				sb.append(" ").append(array[i]);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
