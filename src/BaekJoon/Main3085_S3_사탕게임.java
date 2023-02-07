package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3085_S3_사탕게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		for(int i = 0 ; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		//solve
		/*
		 * 아이디어
		 * 모든자리에서 상하좌우로 바꾸고 해당하는 행,렬 에서 반복되는 문자열 길이 저장.
		 */
		int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				
				char cur = map[i][j];
				//상하좌우 확인
				
				
			}
		}
		
	}
}
