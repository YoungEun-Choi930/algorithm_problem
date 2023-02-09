package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11660_S1_구간합구하기5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력파일 객체화
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] map = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
		}
//		for(int i = 0 ; i < N ; i++) {
//			for(int j = 0 ; j < N ; j++) {
//				map[i][j] = map[i][j-1] + map[i-1][j] - map[i-1][j-1]+ map[i][j];
//			}
//		}
		
		// solve
		// dp. 누적합 배열을 만들어 놓는다.
		int[][] sumMap = new int[N][N];
		// 가로로 한번 누적합 구하기
		for(int i = 0 ; i < N ; i++) {
			int sum = 0;
			for(int j = 0 ; j < N ; j++) {
				sum += map[i][j];
				sumMap[i][j] = sum;
			}
		}
		// 가로로 구한 합에 세로로 누적합 구하기
		for(int i = 0 ; i < N ; i++) {
			int sum = 0;
			for(int j = 0 ; j < N ; j++) {
				sum += sumMap[j][i];
				sumMap[j][i] = sum;
			}
		}
		
		
		
		// (x1,y1) (x2,y2)
		for(int cntM = 0 ; cntM < M ; cntM++) {
			input = br.readLine().split(" ");
			int x1 = Integer.parseInt(input[0])-1;
			int y1 = Integer.parseInt(input[1])-1;
			int x2 = Integer.parseInt(input[2])-1;
			int y2 = Integer.parseInt(input[3])-1;
			
			int n = sumMap[x2][y2];
			if(x1 != 0) n -= sumMap[x1-1][y2];
			if(y1 != 0) n -= sumMap[x2][y1-1];
			
			if(x1 != 0 && y1 != 0) n += sumMap[x1-1][y1-1];
			
			
			sb.append(n).append("\n");
		}

		// 출력
		System.out.println(sb);
	}
}
