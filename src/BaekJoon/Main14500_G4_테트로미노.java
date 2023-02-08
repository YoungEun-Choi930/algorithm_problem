package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14500_G4_테트로미노 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] map = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			input = br.readLine().split(" ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		// solve
		int[][][] tetromino1 = { {{1,0}, {0,1}, {1,1}} };
		int[][][] tetromino2 = { {{1,0}, {2,0}, {3,0}} , {{0,1}, {0,2}, {0,3}} };
		int[][][] tetromino3 = { {{1,0}, {1,1}, {2,1}} , {{0,1}, {-1,1}, {-1,2}} };
		int[][][] tetromino4 = { {{1,0}, {2,0}, {2,1}} , {{1,0}, {0,1}, {0,2}} ,
									{{0,1}, {1,1}, {2,1}} , {{0,1}, {0,2}, {-1,2}} };
		int[][][] tetromino5 = { {{0,1}, {0,2}, {1,1}} , {{0,1}, {-1,1}, {1,1}} ,
									{{0,1}, {0,2}, {-1,1}} , {{1,0}, {2,0}, {1,1}} };
		
		
		
	}
}
