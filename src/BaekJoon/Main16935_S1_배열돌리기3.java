package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16935_S1_배열돌리기3 {
	private static int[][] array;
	private static StringBuilder sb;
	private static int N,M,R;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);

		array = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			input = br.readLine().split(" ");
			for(int j = 0 ; j < M ; j++) {
				array[i][j] = Integer.parseInt(input[j]);
			}
		}

		input = br.readLine().split(" ");
		for(int cnt = 0 ; cnt < R ; cnt++) {
			int command = Integer.parseInt(input[cnt]);


			if(command < 5) spinArray(command);
			else moveArray(command);
		}


		// solve

		// 출력
		for(int i = 0 ; i < array.length ; i++) {

			for(int j = 0 ; j < array[i].length ; j++) {
				sb.append(array[i][j]).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}

	private static void moveArray(int command) {
		int[][] result = new int[N][M];

		int n2 = N/2;
		int m2 = M/2;

		int[][] arraydelta = null;
		if(command == 5) arraydelta = new int[][] {{n2,0},{0,0},{n2,m2},{0,m2}};
		else if(command == 6) arraydelta = new int[][] {{0,m2},{n2,m2},{0,0},{n2,0}};

		int[][] startIdx = new int[][] {{0,0},{0,m2},{n2,0},{n2,m2}};
		
		for(int d = 0 ; d < 4 ; d++) {
			int curx = arraydelta[d][0];
			int cury = arraydelta[d][1];
			int startx = startIdx[d][0];
			int starty = startIdx[d][1];
			
			for(int i = startx ; i < startx+n2; i++) {
				int tempy = cury;
				for(int j = starty ; j < starty+m2; j++) {
					result[i][j] = array[curx][tempy++];
				}
				curx++;
			}
		}
		
		array = result;

	}

	private static void spinArray(int command) {
		int[][] result = null;
		switch(command) {
		case 1:
			result  = new int[N][M];
			for(int i = 0; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					result[i][j] = array[N-1-i][j];
				}
			}
			break;
		case 2:
			result  = new int[N][M];
			for(int i = 0; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					result[i][j] = array[i][M-1-j];
				}
			}
			break;
		case 3:
			result  = new int[M][N];
			for(int i = 0; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					result[j][N-i-1] = array[i][j];
				}
			}
			int t = N;
			N = M;
			M = t;
			break;
		case 4:
			result  = new int[M][N];
			for(int i = 0; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					result[M-1-j][i] = array[i][j];
				}
			}
			t = N;
			N = M;
			M = t;
			break;
		}

		array = result;
	}
}
