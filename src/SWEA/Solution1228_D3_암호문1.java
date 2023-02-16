package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1228_D3_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			// 1
			int N = Integer.parseInt(br.readLine());	//10 ≤ N ≤ 20
			// 2
			List<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			// 3
			int M = Integer.parseInt(br.readLine());	//5 ≤ N ≤ 10
			//4
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				st.nextToken();	// I
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				//solve
				List<Integer> insertlist = new LinkedList<>();
				for(int i = 0 ; i < y ; i++) {
					insertlist.add(Integer.parseInt(st.nextToken()));
				}
				
				
				list.addAll(x,insertlist);
				
			}
			
			// 출력
			sb.append("#").append(tc).append(" ");
			int cnt = 1;
			for(int num : list) {
				sb.append(num).append(" ");
				if(cnt++ == 10) break;
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
