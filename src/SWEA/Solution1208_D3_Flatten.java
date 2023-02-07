package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1208_D3_Flatten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {

			// 입력 객체화
			int dump = Integer.parseInt(br.readLine());
			int[] map = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0 ; i < 100 ; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			// 시뮬레이션. 구현
			
			Arrays.sort(map);
			for(int dumpcnt = 0 ; dumpcnt < dump ; dumpcnt++) {
				
				map[0]++;
				map[map.length-1]--;
				
				int idx = 0;
				while(map[idx] > map[idx+1]) {
					int temp = map[idx];
					map[idx] = map[idx+1];
					map[idx+1] = temp;
					idx++;
				}
				idx = map.length-1;
				while(map[idx] < map[idx-1]) {
					int temp = map[idx];
					map[idx] = map[idx-1];
					map[idx-1] = temp;
					idx--;
				}

			}

			int result = map[map.length-1] - map[0];
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}
}
