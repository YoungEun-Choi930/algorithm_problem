package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1289_D3_원재의메모리복구하기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T ; tc++) {
			String input = br.readLine();
			
			int result = 0;
			int length = input.length();
			char cur = '0';
			for(int index = 0 ; index < length; index++) {
				if(input.charAt(index) == cur) {
					continue;
				}
				else {
					result++;
					if(cur == '0') cur = '1';
					else cur = '0';
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}
	
}
