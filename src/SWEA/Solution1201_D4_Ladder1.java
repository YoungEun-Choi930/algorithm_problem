package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1201_D4_Ladder1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {

			// 입력 객체화
			br.readLine();	//tc번호
			char[][] map = new char[100][100];
			for(int i = 0 ; i < 100 ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0 ; j < 100 ; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			// 알고리즘
			
			//1. 도착지 찾기
			int endpoint = 0;
			for(int i = 0 ; i < 100 ; i++) {
				if(map[99][i] == '2') {
					endpoint = i;
					break;
				}
			}
			
			
			//2. 위로 올라가면서 좌 우로 갈수 있으면 간다.
			
			int curx = endpoint;
			for(int cury = 99 ; cury >= 0 ; cury--) {
				map[cury][curx] = '3';
				
				// 좌
				while(curx > 0 && map[cury][curx-1] == '1') {
					curx--;
					map[cury][curx] = '3';
				}
				// 우
				while(curx < 99 && map[cury][curx+1] == '1') {
					curx++;
					map[cury][curx] = '3';
				}
			
				//다시 위로 한칸 
			}
			
			sb.append("#").append(tc).append(" ").append(curx).append("\n");
			
		}
		System.out.println(sb);
	}	
}
